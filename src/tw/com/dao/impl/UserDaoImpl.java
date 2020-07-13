package tw.com.dao.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.StyleSheet.ListPainter;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.dao.IUserDao;
import tw.com.domain.User;
import tw.com.util.DateTimeUtil;
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
		user.setRegTime(DateTimeUtil.getNow());
		user.setRole("u");
		session.save(user);
		ts.commit();
	}

	@Override
	public User getUserByNameAndPwd(String name, String password) {
		System.out.println("Dao層 : getUserByNameAndPwd()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();

		String hql = "from User where name=:name and password=:password";

		Query<User> query = session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("password", password);
		Optional<User> op = query.stream().findFirst();
		//Hibernate.initialize(op.get().getAddresses());//解決延遲加載方式
		op.orElse(null);
		
		System.out.println("匹配會員:" + op.orElse(null));
		ts.commit();	
		
		return op.orElse(null);
	}

	@Override
	public void updateAvatar(String id, String avatar) {
		System.out.println("Dao層 : updateAvatar()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		String hql = "update User set avatar=:avatar where id=:id";
		session.createQuery(hql).setParameter("avatar", avatar).setParameter("id", id).executeUpdate();
		ts.commit();
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
