package tw.com.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.dao.IUserDao;
import tw.com.domain.User;
import tw.com.util.UUIDUtil;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
		System.out.println("Dao層 : addUser()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		user.setID(UUIDUtil.getRandomByUUID());
		user.setRegTime(new Date());
		user.setRole("u");
		session.save(user);
		ts.commit();
	}

	@Override
	public User getUserByNameAndPwd(String name, String password) {
		System.out.println("Dao層 : getUserByNameAndPwd()...");
		Session session = null;
		Transaction ts = null;
		User u = null;

		session = getCurrentSession();
		ts = session.beginTransaction();

		String hql = "select id,name,role from User where name=:name and password=:password";

		List<Object[]> list = session.createQuery(hql).setParameter("name", name).setParameter("password", password)
				.list();

		for (Object[] objs : list) {
			u = new User();
			u.setID(objs[0].toString());
			u.setName(objs[1].toString());
			u.setRole(objs[2].toString());
		}
		System.out.println("匹配會員:" + u);
		ts.commit();
		return u;
	}

	@Override
	public void updateAvatar(String id, String avatar) {
		System.out.println("Dao層 : updateAvatar()...");

	}

	@Override
	public int getNumByName(String name) {
		System.out.println("Dao層 : getNumByName()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();

		int count = Integer.parseInt(session.createQuery("select count(*) from User where name=:name")
				.setParameter("name", name).uniqueResult().toString());
		System.out.println("count:" + count);
		ts.commit();

		return count;
	}

}
