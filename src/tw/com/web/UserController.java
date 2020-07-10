package tw.com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.domain.User;
import tw.com.serivce.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/register")
	public String register(User user){
		System.out.println("控制層: register()...");
		System.out.println(user);
		userService.register(user);
		return "redirect:/login/html/login.html";
	}
	
	
}
