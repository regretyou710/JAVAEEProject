package tw.com.web;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tw.com.domain.User;
import tw.com.serivce.IUserService;
import tw.com.util.UUIDUtil;

@Controller
@SessionAttributes(value = { "user", "vCode", "admin","msg"})
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private ServletContext context;

	@RequestMapping("/register")
	public String register(User user) {
		System.out.println("控制層: register()...");
		System.out.println(user);
		userService.register(user);
		return "redirect:/login/html/login.html";
	}

	@RequestMapping("/isExist")
	public @ResponseBody boolean isExist(@RequestBody User user) {
		System.out.println("控制層: isExit()...");
		System.out.println("ajax:" + user);
		boolean result = userService.isExist(user.getName());
		return result;

	}

	@RequestMapping("/login")
	public String login(User user, Model model) {
		System.out.println("控制層: login()...");
		System.out.println(user);
		User u = userService.login(user.getName(), user.getPassword());

		if (u != null) {
			model.addAttribute("user", u);
			return "redirect:../mall/html/index.jsp";

		} else {
			System.out.println(context.getContextPath());
			return "redirect:/login/html/login.html";
		}

	}

	@RequestMapping("/logout")
	public String logout(SessionStatus status) {
		System.out.println("控制層: logout()...");

		status.setComplete();
		return "redirect:/mall/html/index.jsp";
	}

	@RequestMapping("/uploadAvatar")
	public String uploadAvatar(HttpServletRequest request, MultipartFile avatar) throws Exception {
		System.out.println("控制層: uploadAvatar()...");
		// 封裝上傳物件後，使用Request物件解析物件內容

		// 1.指定上傳文件的存放路徑
		Path path = Paths.get(request.getServletContext().getRealPath("/useravatar/"));
		System.out.println("上傳文件的存放路徑:" + path);

		// 2.判斷路徑是否存在
		if (Files.notExists(path))
			// 如果目錄(路徑)不存在，則建立
			Files.createDirectory(path);

		// 3.解析Request物件，獲取上傳文件項目
		String uid = ((User) request.getSession().getAttribute("user")).getID();
		String suffix = "";// (前綴)檔案名稱由用戶id命名
		try {
			if (avatar != null) {
				if (!avatar.getOriginalFilename().equals("")) {
					// 取得上傳文件項目名稱
					String fileName = avatar.getOriginalFilename();
					// 把文件名稱設為唯一值
					suffix = uid + fileName.substring(fileName.lastIndexOf("."));
					// 完成文件上傳
					// 將上傳路徑加上檔案名稱透過File建立成物件，文件項目寫出目的地
					avatar.transferTo(new File(path.toString(), suffix));
				} else {
					throw new RuntimeException("上傳頭像異常");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/membercenter/member-add.jsp";
		}
		userService.updateAvatar(uid, "useravatar/" + suffix);// 將上傳圖片存到DB

		// 上傳後將session中的頭像更新
		User user = (User) request.getSession().getAttribute("user");
		user.setAvatar("useravatar/" + suffix);
		request.getSession().setAttribute("user", user);
		return "redirect:/membercenter/member-add.jsp";
	}

	@RequestMapping("/adminLogin")
	public String adminLogin(String validCode, String name, String password, Model model) {
		System.out.println("控制層: adminLogin()...");
		// 超級管理員登入判斷:
		// 1.驗證碼是否正確 2.有無匹配對象 3.有無權限
		String msg = "";
		String flag = "redirect:../valid/createRandom";
		String vCode = model.getAttribute("vCode").toString();
		if (!validCode.equals(vCode)) {
			msg = "驗證碼不正確";
			model.addAttribute("msg", msg);
			return flag;
		}

		User u = userService.login(name, password);
		if (u == null) {
			msg = "帳號或密碼不正確";
			model.addAttribute("msg", msg);
			return flag;
		}

		if (!u.getRole().equals("a")) {
			msg = "權限不足";
			model.addAttribute("msg", msg);
			return flag;
		}

		model.addAttribute("admin", u);		
		return "redirect:/admincenter/index.jsp";
	}
}
