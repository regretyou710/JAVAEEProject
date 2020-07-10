package tw.com.test;


import static org.junit.Assert.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import tw.com.domain.User;
import tw.com.util.HibernateUtil;

public class Testing {

	@Test
	public void test1() {

		Session session = null;
		Transaction ts = null;

		try {
			session = HibernateUtil.getCurrentSession();
			ts = session.beginTransaction();
			User u1 = new User();
			u1.setID("4978");
			u1.setName("eason");
			u1.setPassword("eason1234");
			u1.setPhoneNum("0960000000");
			u1.setMoney(553.56F);
			u1.setRegTime(new java.util.Date());
			u1.setRole("1");
			session.save(u1);
			ts.commit();
		} catch (Exception e) {
			if (ts != null)
				ts.rollback();
			throw new RuntimeException(e.getMessage());
		} finally {
			session.close();
		}

	}

	@Test
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ComboPooledDataSource dataSource = ac.getBean("dataSource",ComboPooledDataSource.class);
		System.out.println(dataSource.getDataSourceName());
		SessionFactoryImpl sessionFactory =  ac.getBean("sessionFactory",SessionFactoryImpl.class);
		System.out.println(sessionFactory.getCurrentSession().getSessionFactory());
	
	}
}
