package cn.tedu.mb.user.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.mb.common.exception.ServiceException;
import cn.tedu.mb.user.dao.UserDao;
import cn.tedu.mb.user.entity.User;
import cn.tedu.mb.user.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
	@Resource(name="UserDao")
	private UserDao UserDao;
	
	public int regUser(User Reguser) {
		//检验是否有相同用户名或手机重复
		User UsernameUser=UserDao.findUser(Reguser.getUsername());
		if(UsernameUser!=null)
			throw new ServiceException("用户名已存在");
		User PhoneUser=UserDao.findUser(Reguser.getPhone());
		if(PhoneUser!=null)
			throw new ServiceException("手机号已被注册");
		int result=0;
		if(PhoneUser==null&&UsernameUser==null){
			result=UserDao.addUser(Reguser);
		}
		return result;
	}


	public User doLogin(String PhoneOrUserName, String password) {
		if(PhoneOrUserName==null||password==null)
			throw new ServiceException("用户名或密码不能为空");
		User user=UserDao.checkLogin(PhoneOrUserName, password);
		if(user==null)
			throw new ServiceException("用户名或密码错误");
		return user;
	}

	

}
