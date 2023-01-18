package sistMovie.vo;

public class MovieVO {
	private int movieNo;
	private String movieName;
	private String genre;
	private int score;
	private String image;
	private String releaseDate;
	private String director;
	private String actor1;
	private String actor2;
	private String actor3;
	
	

	
	public MovieVO() {
	}
	






	public MovieVO(int movieNo, String movieName, String releaseDate) {
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
	}









	public MovieVO(int movieNo, String movieName, String genre, String releaseDate, String director, String actor1,
			String actor2, String actor3) {
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.director = director;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.actor3 = actor3;
	}







	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor1() {
		return actor1;
	}
	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}
	public String getActor2() {
		return actor2;
	}
	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}
	public String getActor3() {
		return actor3;
	}
	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}
	
	
	
}
