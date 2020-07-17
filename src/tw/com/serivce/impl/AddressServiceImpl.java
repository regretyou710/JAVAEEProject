package tw.com.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.dao.IAddressDao;
import tw.com.domain.Address;
import tw.com.serivce.IAddressService;
import tw.com.util.UUIDUtil;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressDao addressDao;

	@Override
	public void addAddress(Address address) {
		System.out.println("邏輯層: addAddress()...");
		address.setId(UUIDUtil.getRandomByUUID());
		if (address.getIsdefault() == null) {
			// 如果沒有勾選，則為非默認
			address.setIsdefault("2");
		} else {
			// 如果有勾選，設置當前地址為默認
			// 將已存在的默認地址改為非默認
			addressDao.setNotDefault(address.getUser().getID());
		}
		addressDao.addAddress(address);
	}

	@Override
	public List<Address> getAddresses(String userID) {
		System.out.println("邏輯層: userID()...");

		return addressDao.getAddresses(userID);
	}

	@Override
	public void setDefault(Address address) {
		System.out.println("邏輯層: setDefault()...");
		// 設定選中的地址為默認前，先將其他的默認改為非默認
		addressDao.setNotDefault(address.getUser().getID());
		// 將非默認改為默認 2->1
		if (address.getIsdefault().equals("2"))
			addressDao.setDefault(address.getId());
	}

	@Override
	public boolean delAddress(String id) {
		System.out.println("邏輯層: delAddress()...");
		return addressDao.delAddress(id);
	}

	@Override
	public boolean updateAddress(Address address) {
		System.out.println("邏輯層: updateAddress()...");
		return addressDao.updateAddress(address);
	}

}
