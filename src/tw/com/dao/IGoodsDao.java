package tw.com.dao;

import java.util.List;
import java.util.Map;

import tw.com.domain.Goods;

public interface IGoodsDao {
	// 添加商品
	public void addGoods(Goods goods);

	// 顯示商品列表 (Goods用來封裝條件查詢的屬性)
	public List<Object[]> getGoods(Object[] params);

	// 按照頁面查詢商品(第幾頁，每一頁多少條紀錄，Goods)
	//public List<Goods> getGoodsByPage(Map<String, Object> params);

	// 返回商品筆數
	//public int getGoodsNum(Goods goods);
}