package tw.com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//在使用hibernate開發，保證只有一個SessionFactory(一個DB配置一個SessionFactory)
final public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	// 使用線程(執行緒)局部模式
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();

	private HibernateUtil() {

	}

	static {

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		// System.out.println("sessionFactory類型:" + sessionFactory);
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// 取得全新的session
	public static Session getOpenSession() {
		return sessionFactory.openSession();
	}
	

	// 取得和執行緒相關的session
	// 使用此方式設定CurrentSession則hibernate.cfg.xml可以不用配置
	public static Session getCurrentSession() {
		Session session = threadLocal.get();

		// 判斷是否得到
		if (session == null) {
			session = sessionFactory.openSession();
			// 把session物件設置到threadLocal，相當於session已經和執行緒綁定
			threadLocal.set(session);
		}
		return session;
	}
}
