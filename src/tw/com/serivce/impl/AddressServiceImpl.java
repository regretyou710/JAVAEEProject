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
		if(address.getIsdefault()==null)
			address.setIsdefault("2");
		addressDao.addAddress(address);
	}

	@Override
	public List<Address> getAddresses(String userID) {
		System.out.println("邏輯層: userID()...");
		
		return addressDao.getAddresses(userID);
	}

}
