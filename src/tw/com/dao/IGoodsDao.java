package tw.com.dao;

import java.util.List;

import tw.com.domain.Goods;

public interface IGoodsDao {
	// 添加商品
	public void addGoods(Goods goods);

	// 顯示商品列表 (Goods用來封裝條件查詢的屬性)
	public List<Object[]> getGoods(Object[] params);
}
