package cn.tedu.mb.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@RequestMapping("admin")
	public String admin(){
		return "admin";
	}
	
	
}
