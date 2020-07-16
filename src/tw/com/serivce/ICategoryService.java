package tw.com.serivce;

import java.util.List;

import tw.com.domain.Category;

public interface ICategoryService {
	// 新增商品分類
	public void addCategory(Category category);

	// 查詢商品分類列表
	public List<Category> getCategories();

	// 刪除分類，刪除筆數=1返回true
	public boolean delCategory(String id);

	// 修改分類，修改筆數=1返回true
	public boolean updateCategory(Category category);
}
