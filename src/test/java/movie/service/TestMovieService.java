package movie.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.mb.movie.entity.Movie;
import cn.tedu.mb.movie.service.MovieService;
import cn.tedu.mb.movie.service.impl.MovieServiceImpl;

public class TestMovieService {
	ClassPathXmlApplicationContext ctx;
	MovieService MovieService;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mybatis.xml");
		MovieService=ctx.getBean("MovieServiceImpl",MovieServiceImpl.class);
	}
	
	@After
	public void destory(){
		ctx.close();
	}
	
	
	@Test
	public void TestaddMovie(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Movie movie=new Movie();
		movie.setMovieName("六年，六天");
		movie.setDirector("沈东");
		movie.setStar("王骁,姜瑞佳,吴刚,高云翔");
		movie.setCountry("中国大陆");
		movie.setMovieLong(96);
		try {
			movie.setReleaseTime(sdf.parse("2017-10-17"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		movie.setPlayType("");
		movie.setMovieType("剧情,爱情");
		movie.setInfo("本片讲述的是一对年轻人的爱情故事展开，路远（王骁 饰）与小朵（姜瑞佳 饰）因奥运会期间担任志愿者而结识，"
				+ "两人互生情愫但却未来得及表达。多年后，路远被父亲安排到京郊担任大学生村官，在报到的途中与准备出国留学的小朵在鸟巢意外相遇，"
				+ "并相约每年的 8 月 8 日在鸟巢相见。自此，二人的故事展开了全新篇章。随着时代飞速发展，再次重逢的两人也都发生了变化，"
				+ "面对被安排好的人生，在追求人生信仰的道路上，路远多次遇到阻碍，致使两人的爱情也十分坎坷，但路远最终突破了自己，"
				+ "蜕变成了一名优秀的基层党员，而小朵则回国成为了一带一路的项目负责人，两人实现了人生价值的同时也收获了美好的爱情。");
		movie.setBoxOffice(0);
		movie.setPopularity("");
		movie.setCoverRoute("");
		int count=MovieService.addMovie(movie);
		System.out.println(count);
	}
	
	@Test
	public void TesfindMovies(){
		Map<String, Object> map=MovieService.findPageMovies("",1);
		System.out.println(map);
	}
	
	@Test
	public void TesGetTodayBoxOffice(){
		List<Map<String, Object>> list=MovieService.GetTodayBoxOffice();
		System.out.println(list);
	}
	
	
}
