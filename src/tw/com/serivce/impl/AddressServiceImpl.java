package tw.com.serivce.impl;

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

}
