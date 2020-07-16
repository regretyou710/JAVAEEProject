package tw.com.serivce.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.dao.ICategoryDao;
import tw.com.domain.Category;
import tw.com.serivce.ICategoryService;
import tw.com.util.UUIDUtil;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;

	@Override
	public void addCategory(Category category) {
		System.out.println("邏輯層: addCategory()...");		

		category.setId(UUIDUtil.getRandomByUUID());
		if (category.getGoodsNum() == null)
			category.setGoodsNum(0);
		categoryDao.addCategory(category);
	}

	@Override
	public List<Category> getCategories() {
		System.out.println("邏輯層: getCategories()...");
		return categoryDao.getCategories();
	}

	@Override
	public boolean delCategory(String id) {
		System.out.println("邏輯層: delCategory()...");
		return categoryDao.delCategory(id);
	}

	@Override
	public boolean updateCategory(Category category) {
		System.out.println("邏輯層: updateCategory()...");
		return categoryDao.updateCategory(category);
	}

}
