package tw.com.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.domain.User;
import tw.com.serivce.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

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
}
