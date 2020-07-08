package tw.com.dao;

import tw.com.domain.User;

public interface IUserDao {

	// 新增用戶
	public void addUser(User user);

	// 透過帳密取得用戶
	public User getUserByNameAndPwd(String name, String password);

	// 更新頭像
	public void updateAvatar(String id, String avatar);
}
