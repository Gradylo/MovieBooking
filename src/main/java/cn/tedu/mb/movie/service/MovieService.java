package cn.tedu.mb.movie.service;



import java.util.List;
import java.util.Map;

import cn.tedu.mb.movie.entity.Movie;


public interface MovieService {
	
	
	int addMovie(Movie movie);
	
	Map<String, Object> findPageMovies(String MovieName,Integer pageSize);
	/**今日票房*/
	List<Map<String, Object>> GetTodayBoxOffice();
	/**正在热映*/
	List<Map<String, Object>> GetHotLineMovie();
	
}
