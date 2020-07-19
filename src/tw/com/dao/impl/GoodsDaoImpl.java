package tw.com.dao.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Map;

import org.aspectj.weaver.ast.And;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.dao.IGoodsDao;
import tw.com.domain.Address;
import tw.com.domain.Category;
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

	@Override
	public List<Object[]> getGoods(Object[] params) {
		System.out.println("Dao層 : getGoods()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();

		Category category = (Category) params[1];
		// 分類為空，商品名為空
		String hql = "select g.name, g.category, g.price2, g.stock from Goods g where 1=1";
		Query<Object[]> query = session.createQuery(hql);

		if (category != null) {
			if (category.getId() != null && !(category.getId().equals(""))) {
				// 分類不為空，商品名為空
				hql = hql + " and g.category.id=:categoryid";
				query = session.createQuery(hql).setParameter("categoryid", category.getId());
			}
		}
		if (params[0] != null) {
			if (params[0].toString() != null && !params[0].toString().equals("")) {
				if (!(category.getId().equals(""))) {
					// 分類不為空，商品名不為空
					hql = hql + " and g.name like:name";
					query = session.createQuery(hql).setParameter("categoryid", category.getId()).setParameter("name",
							"%" + params[0].toString() + "%");
				} else {
					// 分類為空，商品名不為空
					hql = hql + " and g.name like:name";
					query = session.createQuery(hql).setParameter("name", "%" + params[0].toString() + "%");

				}
			}
		}
		List<Object[]> list = query.list();
		for (Object[] objs : list) {
			Hibernate.initialize((Category) objs[1]);
		}
		ts.commit();
		return list;
	}

//	@Override
//	public List<Goods> getGoodsByPage(Map<String, Object> params) {
//		System.out.println("Dao層 : getGoodsByPage()...");
//		return null;
//	}
//
//	@Override
//	public int getGoodsNum(Goods goods) {
//		System.out.println("Dao層 : getGoodsNum()...");
//		Session session = getCurrentSession();
//		Transaction ts = session.beginTransaction();
//
//		String hql = "select count(*) from Goods g,Categoey c where g.categoryid=c.id";
//		Category category = (Category) goods.getCategory();
//		String name = goods.getName();
//		Query query = session.createQuery(hql);
//
//		if (category != null) {
//			if (category.getId() != null && !(category.getId().equals(""))) {
//				// 分類不為空，商品名為空
//				hql = hql + " and g.category.id=:categoryid";
//				query = session.createQuery(hql).setParameter("categoryid", category.getId());
//			}
//		}
//		if (name != null) {
//			if (name != null && name.equals("")) {
//				if (!(category.getId().equals(""))) {
//					// 分類不為空，商品名不為空
//					hql = hql + " and g.name like:name";
//					query = session.createQuery(hql).setParameter("categoryid", category.getId()).setParameter("name",
//							"%" + name + "%");
//				} else {
//					// 分類為空，商品名不為空
//					hql = hql + " and g.name like:name";
//					query = session.createQuery(hql).setParameter("name", "%" + name + "%");
//
//				}
//			}
//		}
//		
//		int count = (int) query.uniqueResult();
//		Hibernate.initialize(goods.getCategory());
//		ts.commit();
//		return count;
//	}

}
