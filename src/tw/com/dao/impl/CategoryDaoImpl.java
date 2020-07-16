package tw.com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.dao.ICategoryDao;
import tw.com.domain.Category;

@Repository
public class CategoryDaoImpl implements ICategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCategory(Category category) {
		System.out.println("Dao層: addCategory()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		System.out.println("Dao層: " + category);
		session.save(category);
		ts.commit();
	}

	@Override
	public List<Category> getCategories() {
		System.out.println("Dao層: getCategories()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		String hql = "from Category";
		List<Category> list = session.createQuery(hql).list();
		ts.commit();
		return list;
	}

	@Override
	public boolean delCategory(String id) {
		System.out.println("Dao層: delCategory()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		String hql = "delete from Category where id=:id";
		int rs = session.createQuery(hql).setParameter("id", id).executeUpdate();		
		ts.commit();
		return rs!=0;
	}

	@Override
	public boolean updateCategory(Category category) {
		System.out.println("Dao層: updateCategory()...");
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		String hql = "update Category set name=:name,goodsNum=:goodsNum where id=:id";
		int rs = session.createQuery(hql).setParameter("id", category.getId())
				.setParameter("name", category.getName())
				.setParameter("goodsNum", category.getGoodsNum()).executeUpdate();		
		ts.commit();
		return rs!=0;
	}

}
