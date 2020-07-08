package tw.com.serivce;

import tw.com.domain.User;

public interface IUserService {
	// 用戶註冊
	public void register(User user);

	// 用戶登入
	public User login(String name, String password);
}
