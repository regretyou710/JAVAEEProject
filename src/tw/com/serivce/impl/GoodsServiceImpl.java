package tw.com.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.dao.ICategoryDao;
import tw.com.dao.IGoodsDao;
import tw.com.domain.Category;
import tw.com.domain.Goods;
import tw.com.serivce.IGoodsService;
import tw.com.util.UUIDUtil;

@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private IGoodsDao goodsDao;
	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	public void addGoods(Goods goods) {
		System.out.println("邏輯層: addGoods()...");
		goods.setId(UUIDUtil.getRandomByUUID());
		goodsDao.addGoods(goods);
		//當新增一筆商品歸類到所屬分類，該分類就加1
		categoryDao.updateGoodsNum(goods.getCategory().getId(), 1);
	}

	@Override
	public List<Object[]> getGoods(Object[] params) {
		System.out.println("邏輯層: getGoods()...");
		return goodsDao.getGoods(params);
	}

}
