package cn.tedu.mb.user.service;



import cn.tedu.mb.user.entity.User;

public interface UserService {
	/**注册*/
	int regUser(User user);
	/**登录*/
	User doLogin(String PhoneOrUserName,String password);
	
}
