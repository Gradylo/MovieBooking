package cn.tedu.mb.movie.entity;

import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4613817872716434891L;
	/**id*/
	private Integer id;
	/**电影名字*/
	private String MovieName;
	/**导演*/
	private String director;
	/**主演*/
	private String star;
	/**国家*/
	private String country;
	/**时长*/
	private Integer MovieLong;
	/**上映时间*/
	private Date ReleaseTime;
	/**播放类型*/
	private String PlayType;
	/**电影类型*/
	private String MovieType;
	/**简介*/
	private String info;
	/**票房*/
	private Integer BoxOffice;
	/**热门度*/
	private String popularity;
	/**电影图片路径*/
	private String CoverRoute;
	/**电影评分*/
	private Double score;
	/**今日票房*/
	private Integer TodayBoxOffice;
	
	
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getReleaseTime() {
		return ReleaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		ReleaseTime = releaseTime;
	}
	public String getPlayType() {
		return PlayType;
	}
	public void setPlayType(String playType) {
		PlayType = playType;
	}
	public String getMovieType() {
		return MovieType;
	}
	public void setMovieType(String movieType) {
		MovieType = movieType;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public String getCoverRoute() {
		return CoverRoute;
	}
	public void setCoverRoute(String coverRoute) {
		CoverRoute = coverRoute;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBoxOffice() {
		return BoxOffice;
	}
	public void setBoxOffice(Integer boxOffice) {
		BoxOffice = boxOffice;
	}
	public Integer getMovieLong() {
		return MovieLong;
	}
	public void setMovieLong(Integer movieLong) {
		MovieLong = movieLong;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", MovieName=" + MovieName + ", director=" + director + ", star=" + star
				+ ", country=" + country + ", MovieLong=" + MovieLong + ", ReleaseTime=" + ReleaseTime + ", PlayType="
				+ PlayType + ", MovieType=" + MovieType + ", info=" + info + ", BoxOffice=" + BoxOffice
				+ ", popularity=" + popularity + ", CoverRoute=" + CoverRoute + ", score=" + score + ", TodayBoxOffice="
				+ TodayBoxOffice + "]";
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getTodayBoxOffice() {
		return TodayBoxOffice;
	}
	public void setTodayBoxOffice(Integer todayBoxOffice) {
		TodayBoxOffice = todayBoxOffice;
	}
	
}
