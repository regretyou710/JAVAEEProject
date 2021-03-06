package tw.com.dao;

import java.util.List;

import tw.com.domain.Address;
import tw.com.domain.Category;

public interface IAddressDao {
	// 增加收貨地址
	public void addAddress(Address address);

	// 在登入後只有自己能查到收貨地址，使用自己的ID當參數
	public List<Address> getAddresses(String userID);

	// 透過收貨地址id來設置默認
	public void setDefault(String id);

	// 透過會員ID和已經是默認地址當作條件，將地址取消默認(默認地址只會有一條)
	public void setNotDefault(String userID);

	// 刪除收貨地址，刪除筆數=1返回true
	public boolean delAddress(String id);

	// 修改收貨地址清單，修改筆數=1返回true
	public boolean updateAddress(Address address);

}
