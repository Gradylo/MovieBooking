package cn.tedu.mb.movie.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.mb.movie.entity.Movie;
@Repository("MovieDao")
public interface MovieDao {
	/**分页查询电影*/
	List<Map<String, Object>> findMovies(@Param("MovieName") String MovieName,
					@Param("startIndex") Integer startIndex,
					@Param("pageSize") Integer pageSize);
	/**获得分页信息*/
	int getRowCount(@Param("MovieName") String MovieName);
	/**添加电影*/
	int addMovie(@Param("movie") Movie movie);
	/**今日票房*/
	List<Movie> GetTodayBoxOffice();
	/**正在热映*/
	List<Movie> hotLineMovie();
	
}
