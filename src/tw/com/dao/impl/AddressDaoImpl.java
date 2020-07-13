package tw.com.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.dao.IAddressDao;
import tw.com.domain.Address;
import tw.com.domain.User;

@Repository
public class AddressDaoImpl implements IAddressDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addAddress(Address address) {
		System.out.println("Dao層: addAddress()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		System.out.println("Dao層: "+address);
		session.save(address);
		ts.commit();
	}

	@Override
	public List<Address> getAddresses(String userID) {
		//由會員ID查詢地址
		System.out.println("Dao層: getAddresses()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		//方式一:地址表查詢，會員ID當條件
		String hql = "from Address where user.ID=:uid";
		List<Address> list = session.createQuery(hql).setParameter("uid", userID).list();
		ts.commit();
		
		//方式二:會員表查詢，使用會員ID唯一值，在地址表查出所有符合會員ID的地址
//		User user = session.get(User.class, userID);
//		Set<Address> address = user.getAddresses();
//		ts.commit();
		return list;
	}

	@Override
	public void setDefault(String id) {
		System.out.println("Dao層: setDefault()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		String hql = "update Address set isdefault=1 where id=:id";
		session.createQuery(hql).setParameter("id", id).executeUpdate();
		ts.commit();
	}

	@Override
	public void setNotDefault(String userID) {
		System.out.println("Dao層: setNotDefault()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();		
		String hql = "update Address set isdefault=2 where user.ID=:uid and isdefault=1";
		session.createQuery(hql).setParameter("uid", userID).executeUpdate();
		ts.commit();
	}

}
