package cn.tedu.mb.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.mb.user.entity.User;

@Repository("UserDao")
public interface UserDao {
	/**用户进行注册*/
	int addUser(@Param("user") User user);
	/**查找用户*/
	User findUser(String PhoneOrUserName);
	/**验证账号密码*/
	User checkLogin(@Param("PhoneOrUserName") String PhoneOrUserName,@Param("password")String password);
	
	
}
