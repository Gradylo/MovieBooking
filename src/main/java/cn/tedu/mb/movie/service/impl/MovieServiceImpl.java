package cn.tedu.mb.movie.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.mb.common.web.PageObejct;
import cn.tedu.mb.movie.dao.MovieDao;
import cn.tedu.mb.movie.entity.Movie;
import cn.tedu.mb.movie.service.MovieService;

@Service("MovieServiceImpl")
public class MovieServiceImpl implements MovieService{
	@Resource(name="MovieDao")
	private MovieDao MovieDao;
	

	@Override
	public int addMovie(Movie movie) {
		int count=MovieDao.addMovie(movie);
		return count;
	}
	
	/**分页查询*/
	public Map<String, Object> findPageMovies(String MovieName,Integer pageCurrent) {
		int pageSize=8;
		int startIndex=(pageCurrent-1)*pageSize;
		List<Map<String, Object>> list=MovieDao.findMovies(MovieName, startIndex, pageSize);
		int rowCount=MovieDao.getRowCount(MovieName);
		PageObejct pageObject=new PageObejct();
		pageObject.setPageCurrent(pageCurrent);//当前页
		pageObject.setPageSize(pageSize);//页面数据数量
		pageObject.setRowCount(rowCount);//按条件搜索总数
		pageObject.setStartIndex(startIndex);//开始下标
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("list", list);
		map.put("PageObejct", pageObject);
		return map;
	}

	/**今日票房*/
	public List<Map<String, Object>> GetTodayBoxOffice() {
		List<Movie> list=MovieDao.GetTodayBoxOffice();
		List<Map<String, Object>> li=new ArrayList<Map<String, Object>>();
		for(Movie m:list){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", m.getId());
			double tbo=(double)m.getTodayBoxOffice()/10000;
			map.put("boxOffice",String.format("%.2f", tbo));
			map.put("name", m.getMovieName());
			li.add(map);
		}
		return li;
	}

	/**正在热映*/
	public List<Map<String, Object>> GetHotLineMovie() {
		List<Movie> list=MovieDao.hotLineMovie();
		List<Map<String, Object>> li=new ArrayList<Map<String, Object>>();
		for(Movie m:list){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("id", m.getId());
			map.put("name", m.getMovieName());
			map.put("score",m.getScore());
			map.put("playType", m.getPlayType());
			li.add(map);
		}
		return li;
	}
	
	
	
	
	
}
