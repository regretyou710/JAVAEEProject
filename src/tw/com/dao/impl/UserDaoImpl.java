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
		return null;
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
		
		int	count = Integer.parseInt(session.createQuery("select count(*) from User where name=:name")
					.setParameter("name", name).uniqueResult().toString());
			System.out.println("count:" + count);
			ts.commit();
	
		return count;
	}

}
