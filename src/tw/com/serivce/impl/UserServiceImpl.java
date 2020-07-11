package tw.com.serivce.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.dao.IUserDao;
import tw.com.domain.User;
import tw.com.serivce.IUserService;
import tw.com.util.UUIDUtil;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public void register(User user) {
		System.out.println("業務層: register()..");
		userDao.addUser(user);
	}

	@Override
	public User login(String name, String password) {
		System.out.println("業務層: login()..");
		String tname = name.trim();
		String tpwd = password.trim();
		return userDao.getUserByNameAndPwd(tname, tpwd);
	}

	@Override
	public boolean isExist(String name) {
		System.out.println("業務層: isExist()..");
		String tname = name.trim();
		Optional<String> op = Optional.ofNullable(tname);
		int count = 0;
		
		if (op.isPresent())
			count = userDao.getNumByName(tname);

		return count != 0;
	}

}
