package tw.com.listener;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import tw.com.util.ValidateCode;
import tw.com.web.RandomController;

public class ApplicationHandler implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent arg) {
		System.out.println("tomcat啟動");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("tomcat卸載");

	}

}
