package tw.com.dao;

import java.util.List;

import tw.com.domain.Address;

public interface IAddressDao {
	//增加收貨地址
	public void addAddress(Address address);
	
	//在登入後只有自己能查到收貨地址，使用自己的ID當參數
	public List<Address> getAddresses(String userID);
}
