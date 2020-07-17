package tw.com.web;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import tw.com.util.ImgFontByte;
import tw.com.util.ValidateCode;


@RequestMapping("/valid")
@Controller
public class RandomController {

	@Autowired()
	private ValidateCode validateCode;
	
	public void createRandom(HttpSession session,ValidateCode validateCode) throws IOException {
		System.out.println("控制層: createRandom()...");

		File file = new File(session.getServletContext().getRealPath("/images/vCode.jpg"));// 建立檔案物件
		Path path = Paths.get(session.getServletContext().getRealPath("/images/"));
		// 判斷路徑是否存在
		if (Files.notExists(path)) {
			// 如果目錄(路徑)不存在，則建立
			Files.createDirectory(path);

		} else {
			// 如果目錄存在，則判斷有無存在檔案
			// 只需存在一張驗證圖
			if (file.exists()) {
				file.delete();
			}
		}

		String vCode = validateCode.getCode();// 驗證數字
		String newPath = path.toString() + "/vCode.jpg";
		System.out.println("上傳文件的存放路徑:" + newPath + "_" + vCode);
		validateCode.write(newPath);// 圖片存到路徑
		// 驗證數字存到session
		session.setAttribute("vCode", vCode);

	}

	@RequestMapping(value = "/resetRandom")
	public String resetRandom(HttpServletRequest request) {
		String flag = "";
		try {
			createRandom(request.getSession(),validateCode);
			Thread.sleep(2000);
			flag = "redirect:/adminlogin/html/index.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
