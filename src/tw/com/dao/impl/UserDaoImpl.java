package tw.com.dao.impl;

import org.springframework.stereotype.Repository;

import tw.com.dao.IUserDao;
import tw.com.domain.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Override
	public void addUser(User user) {
		System.out.println("Dao層 : addUser()...");

	}

	@Override
	public User getUserByNameAndPwd(String name, String password) {
		System.out.println("Dao層 : getUserByNameAndPwd()...");
		return null;
	}

	@Override
	public void updateAvatar(String id, String avatar) {
		System.out.println("Dao層 : updateAvatar()...");

	}

}
