package cn.tedu.mb.user.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.mb.common.web.JsonResult;
import cn.tedu.mb.user.entity.User;
import cn.tedu.mb.user.service.UserService;

@Controller
@RequestMapping("/User/")
public class UserController {
	@Resource(name="UserServiceImpl")
	private UserService UserService;
	
	@RequestMapping("login")
	public String Login(){
		return "login";
	}
	
	
	//注册操作
	@RequestMapping("doRsegister")
	@ResponseBody
	public JsonResult doRsegister(User user){
		int result=UserService.regUser(user);
		return new JsonResult(result);
	}
	
	//登录操作
	@RequestMapping("doLogin") 
    public Map<String,Object> doLogin(String username,String password){  
        return null;
    } 
	
}
