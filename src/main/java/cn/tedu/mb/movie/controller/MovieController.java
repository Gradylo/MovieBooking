package cn.tedu.mb.movie.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.mb.common.web.JsonResult;
import cn.tedu.mb.movie.service.MovieService;

@Controller
@RequestMapping("/movie/")
public class MovieController {
	//http://localhost:8081/MovieBooking/movie/index.do
	@Resource(name="MovieServiceImpl")
	private MovieService movieService;
	
	@RequestMapping("index")
	public String indexUI(){
		return "index";
	}
	
	@RequestMapping("getPageObjects")
	@ResponseBody
	public JsonResult getPageObjects(){
		return new JsonResult(movieService.findPageMovies("",1));
	}
	
	/**今日票房*/
	@RequestMapping("getTodayBoxOffice")
	@ResponseBody
	public List<Map<String, Object>> getTodayBoxOffice(){
		return movieService.GetTodayBoxOffice();
	}
	
	
	
	
	
}
