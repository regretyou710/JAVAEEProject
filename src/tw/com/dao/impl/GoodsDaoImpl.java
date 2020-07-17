package tw.com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.dao.IGoodsDao;
import tw.com.domain.Goods;
import tw.com.util.DateTimeUtil;
import tw.com.util.UUIDUtil;

@Repository
public class GoodsDaoImpl implements IGoodsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addGoods(Goods goods) {
		System.out.println("Dao層 : addGoods()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();		
		session.save(goods);
		ts.commit();
	}

}
