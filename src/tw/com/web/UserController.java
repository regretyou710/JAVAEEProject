package tw.com.web;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import tw.com.domain.User;
import tw.com.serivce.IUserService;

@Controller
@SessionAttributes(value = { "user" })
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
		Boolean result = userService.isExist(user.getName());
		return result;

	}

	@RequestMapping("/login")
	public String login(User user,Model model) {
		System.out.println("控制層: login()...");
		System.out.println(user);
		User u =  userService.login(user.getName(), user.getPassword());
		Optional<User> op = Optional.ofNullable(u);
		
		if(op.isPresent()){
			model.addAttribute("user", u);			
			return "redirect:../mall/html/index.jsp";
			
		}else {	
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

}
