package tw.com.listener;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.com.util.ValidateCode;
import tw.com.web.RandomController;

public class SessionHandler implements HttpSessionListener {

	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("啟動session監聽器");
		
		HttpSession	session = se.getSession();
		RandomController randomController = new RandomController();
		//ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		ValidateCode validateCode = webApplicationContext.getBean("validateCode",ValidateCode.class);		
		
		try {
			randomController.createRandom(session,validateCode);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("卸載session監聽器");		
	}

}
