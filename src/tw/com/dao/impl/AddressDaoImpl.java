package tw.com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.dao.IAddressDao;
import tw.com.domain.Address;

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

}
