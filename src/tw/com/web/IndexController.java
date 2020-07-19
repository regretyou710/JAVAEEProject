package tw.com.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

	@RequestMapping("/page")
	public ModelAndView goToMallIndex(HttpServletRequest req){
		String path = req.getServletContext().getContextPath();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:../mall/html/index.jsp");		
		return mv ;
	}
}
