package sistMovie.main;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

import sistMovie.dao.LikeMovieDAO;
import sistMovie.dao.MovieDAO;
import sistMovie.dao.ReviewDAO;
import sistMovie.dao.SurveyDAO;
import sistMovie.dao.VoteDAO;
import sistMovie.util.DBCon;
import sistMovie.util.Pub;
import sistMovie.vo.ReviewVO;
import sistMovie.vo.SurveyVO;

public class ReviewMain {

	private ReviewDAO rdao = new ReviewDAO();
	private MovieMain movieMain = new MovieMain(Pub.scan, "aaaa");
	private int reviewNo;
	private int movieNo = 0;
	private int listNum = 5;

	ReviewMain() {}
	
//	ReviewMain(String id) {
//		Pub.id = id;
//	}
	
	// 리뷰 관리 -- 관리자 메뉴에서 올 때
	public void reviewAdmin() throws IOException {
		System.out.println("============리뷰 관리===========");

		reviewAllList();

		System.out.println("-----------------------------");
		System.out.println("1. 리뷰 정렬   2.리뷰 자세히    3. 메인 메뉴로 이동");
		System.out.print("선택 : ");
		
		int input = Pub.scan.nextInt();
		Pub.scan.nextLine();
		
		switch (input) {
		case 1 :
			reviewSort();
			break;
		case 2 :
			System.out.println("보기 원하는 리뷰 번호를 입력해주세요");
			
			System.out.print("선택 : ");
			int inputreno = Pub.scan.nextInt();
			Pub.scan.nextLine();
			reviewDetail(inputreno);
			break;
		case 3 :
			new MemberMain().adminMenu();
			break;
		default:
			System.out.println("올바른 번호를 입력해주세요");
			break;
		}

	}

	// 리뷰 관리 -- 관리자 메뉴에서 + 정렬
	public void reviewAdmin(String sort) throws IOException {
		System.out.println("============리뷰 관리===========");

		reviewAllList(sort);

		System.out.println("-----------------------------");
		System.out.println("1. 리뷰 정렬   2.리뷰 자세히    3. 메인 메뉴로 이동");
		System.out.print("선택 : ");
		
		int input = Pub.scan.nextInt();
		Pub.scan.nextLine();
		
		switch (input) {
		case 1 :
			reviewSort();
			break;
		case 2 :
			System.out.println("보기 원하는 리뷰 번호를 입력해주세요");
			
			System.out.print("선택 : ");
			int inputreno = Pub.scan.nextInt();
			Pub.scan.nextLine();
			reviewDetail(inputreno);
			break;
		case 3 :
			new MemberMain().adminMenu();
			break;
		default:
			System.out.println("올바른 번호를 입력해주세요");
			break;
		}
	}
	
	// 리뷰 파트 --> 영화 자세히 보기에서
	public void reviewMember(int movieNo) throws IOException {
		this.movieNo = movieNo;
		System.out.println("============이 작품의 리뷰 목록===========");

		reviewAllList(movieNo, listNum);
		
		if (Pub.id.equals("guest")) {
			System.out.println("-----------------------------");
			System.out.println("1.리뷰 더보기   2.리뷰 정렬하기    3.메인 메뉴로 이동"); 
			System.out.println("자세히 보고 싶은 리뷰가 있다면 숫자를 입력해주세요");
			System.out.print(" 입력 : ");
			int input = Pub.scan.nextInt();
			Pub.scan.nextLine();
			
			switch (input) {
			case 1 : // 더보기 구현하기
				System.out.println("------------------------");
				System.out.println("보고싶은 갯수를 입력해주세요");
				
				System.out.print("선택 : ");
				int inputlistNum = Pub.scan.nextInt();
				Pub.scan.nextLine();
				this.listNum = inputlistNum;
				reviewMember(movieNo);
				break;
			case 2 :
				reviewSort();
				break;
			case 3 :
				if (Pub.id.equals("guest")) {
					new MemberMain().guestMain();
				} else {
					new MemberMain().memberMenu();
				}
				break;
			default:
				reviewDetail(input);
				break;
			}
			
		} else {
		
		System.out.println("-----------------------------");
		System.out.println("1.리뷰 더보기   2.리뷰 정렬하기    3.메인 메뉴로 이동"); 
		System.out.println("4.내 관심영화로 등록하기     5.리뷰쓰기");
		System.out.println("자세히 보고 싶은 리뷰가 있다면 숫자를 입력해주세요");
		System.out.print(" 입력 : ");
		int input = Pub.scan.nextInt();
		Pub.scan.nextLine();
		
		switch (input) {
		case 1 : // 더보기 구현하기
			System.out.println("------------------------");
			System.out.println("보고싶은 갯수를 입력해주세요");
			
			System.out.print("선택 : ");
			int inputlistNum = Pub.scan.nextInt();
			Pub.scan.nextLine();
			this.listNum = inputlistNum;
			reviewMember(movieNo);
			break;
		case 2 :
			reviewSort();
			break;
		case 3 :
			if (Pub.id.equals("guest")) {
				new MemberMain().guestMain();
			} else {
				new MemberMain().memberMenu();
			}
			break;
		case 4 :
			new LikeMovieDAO().insertLikeMovie(Pub.id, movieNo);
//			new MovieMain().adminMenu(); // 관심영화 메소드 호출
			break;
		case 5 :
			reviewadd(movieNo);
			break;
		default:
			reviewDetail(input);
			break;
		}
		}

	}
	
	// 리뷰 파트 --> 영화 자세히 보기에서
	public void reviewMember(int movieNo, String sort) throws IOException {
		System.out.println("============이 작품의 리뷰 목록===========");

		reviewAllList(movieNo, sort, listNum);

		if (Pub.id.equals("guest")) {
			System.out.println("-----------------------------");
			System.out.println("1.리뷰 더보기   2.리뷰 정렬하기    3.메인 메뉴로 이동"); 
			System.out.println("자세히 보고 싶은 리뷰가 있다면 숫자를 입력해주세요");
			System.out.print(" 입력 : ");
			int input = Pub.scan.nextInt();
			Pub.scan.nextLine();
			
			switch (input) {
			case 1 : // 더보기 구현하기
				System.out.println("------------------------");
				System.out.println("보고싶은 갯수를 입력해주세요");
				
				System.out.print("선택 : ");
				int inputlistNum = Pub.scan.nextInt();
				Pub.scan.nextLine();
				this.listNum = inputlistNum;
				reviewMember(movieNo);
				break;
			case 2 :
				reviewSort();
				break;
			case 3 :
				if (Pub.id.equals("guest")) {
					new MemberMain().guestMain();
				} else {
					new MemberMain().memberMenu();
				}
				break;
			default:
				reviewDetail(input);
				break;
			}
			
		} else {
		
		
		System.out.println("-----------------------------");
		System.out.println("1.리뷰 더보기   2.리뷰 정렬하기    3.메인 메뉴로"); 
		System.out.println("4.내 관심영화로 등록하기     5.리뷰쓰기");
		System.out.println("(자세히 보고 싶은 리뷰가 있다면 번호를 입력해주세요)");
		System.out.print(" 입력 : ");
		int input = Pub.scan.nextInt();
		Pub.scan.nextLine();
		
		switch (input) {
		case 1 : // 더보기 구현하기
			System.out.println("------------------------");
			System.out.println("보고싶은 갯수를 입력해주세요");
			
			System.out.print("선택 : ");
			int inputlistNum = Pub.scan.nextInt();
			Pub.scan.nextLine();
			this.listNum = inputlistNum;
			reviewMember(movieNo, sort);
			break;
		case 2 :
			reviewSort();
			break;
		case 3 :
			if (!Pub.id.equals("guest")) {
				new MemberMain().memberMenu();
			} else {
			new MemberMain().guestMain();
			}
			break;
		case 4 :
			new LikeMovieDAO().insertLikeMovie(Pub.id, movieNo); // 관심영화 메소드 호출
			break;
		case 5 :
			reviewadd(movieNo);
			break;
		default:
			reviewDetail(input);
			break;
		}
		}

	}
	
	// 리뷰 파트 --> 영화 자세히 보기에서, 관리자
	public void reviewMemberAdmin (int movieNo) throws IOException {
		this.movieNo = movieNo;
		System.out.println("============이 작품의 리뷰 목록===========");

		MovieDAO mvdao = new MovieDAO();
		reviewAllList(movieNo, listNum);
		
		
		System.out.println("-----------------------------");
		System.out.println("1.리뷰 더보기   2.리뷰 정렬하기  3.영화 삭제하기 4.메인메뉴"); 
		System.out.println("자세히 보고 싶은 리뷰가 있다면 숫자를 입력해주세요");
		System.out.print(" 입력 : ");
		int input = Pub.scan.nextInt();
		Pub.scan.nextLine();
		
		switch (input) {
		case 1 : // 더보기 구현하기
			System.out.println("------------------------");
			System.out.println("보고싶은 갯수를 입력해주세요");
			
			System.out.print("선택 : ");
			int inputlistNum = Pub.scan.nextInt();
			Pub.scan.nextLine();
			this.listNum = inputlistNum;
			reviewMember(movieNo);
			break;
		case 2 :
			reviewSort();
			break;
		case 3 :
			if (Pub.id.equals("admin")) {
				mvdao.deleteMovie(movieNo);
			}
			break;
		case 4 :
			if (Pub.id.equals("admin")) {
				new MemberMain().adminMenu();
			}
			break;
		default:
			reviewDetail(input);
			break;
		}
		
	}
	
	// 리뷰 파트 --> 영화 자세히 보기에서, 관리자.
	public void reviewMemberAdmin (int movieNo, String sort) throws IOException {
		this.movieNo = movieNo;
		System.out.println("============이 작품의 리뷰 목록===========");

		reviewAllList(movieNo, sort, listNum);
		
		System.out.println("-----------------------------");
		System.out.println("1.리뷰 더보기   2.리뷰 정렬하기    3.메인메뉴"); 
		System.out.println("자세히 보고 싶은 리뷰가 있다면 숫자를 입력해주세요");
		System.out.print(" 입력 : ");
		int input = Pub.scan.nextInt();
		Pub.scan.nextLine();
		
		switch (input) {
		case 1 : // 더보기 구현하기
			System.out.println("------------------------");
			System.out.println("보고싶은 갯수를 입력해주세요");
			
			System.out.print("선택 : ");
			int inputlistNum = Pub.scan.nextInt();
			Pub.scan.nextLine();
			this.listNum = inputlistNum;
			reviewMember(movieNo);
			break;
		case 2 :
			reviewSort();
			break;
		case 3 :
			new MovieMain(Pub.scan, Pub.id).movieAllList();;
			break;
		default:
			reviewDetail(input);
			break;
		}
	}
	
	// 리뷰 목록보기 -> 관리자에서 처음 띄울 때
	public void reviewAllList() {
		
		List<ReviewVO> rvoList = rdao.selectAllReview();

		if (rvoList == null || rvoList.size() == 0) { // 만약에 회원 목록이 없다면
			System.out.println(" 등록된 리뷰가 없습니다");

		} else {// 그렇지 않다면
			System.out.println();
			System.out.println("리뷰번호 | 작성자 | 영화제목 | 평점 | 내용");
			System.out.println("-------------------------------------");

			for (ReviewVO rvo : rvoList) {

				System.out.print(rvo.getReviewNo() + " | ");
				System.out.print(rvo.getMemberid() + " | ");
				System.out.print(rvo.getMovieName() + " | ");
				// 별표로 뜨게 하자
				
				int reviewScore = rvo.getReviewScore();
				String reviewStar = "☆☆☆☆☆";
				switch (reviewScore) {
				
				case 1 : 
					reviewStar = "★☆☆☆☆";
					break;
				case 2 : 
					reviewStar = "★★☆☆☆";
					break;
				case 3 : 
					reviewStar = "★★★☆☆";
					break;
				case 4 : 
					reviewStar = "★★★★☆";
					break;
				case 5 : 
					reviewStar = "★★★★★";
					break;
				default :
					reviewStar = "☆☆☆☆☆";
					break;
				}
				
				System.out.print(reviewStar + " | ");
				
				if (rvo.getReviewContent().length() >= 11) { // 글자가 11자가 되는 순간부터 10자까지만!
					System.out.println(rvo.getReviewContent().substring(0,10) + "...");
				} else {
					System.out.println(rvo.getReviewContent());
				}
				
				
				
			}

	}
	}

	// 리뷰 목록보기 -> 관리자 정렬 후
	// 리뷰 목록보기 -> 관리자에서 정렬했을 때
	public void reviewAllList(String sort) {

		List<ReviewVO> rvoList;
		
		if (sort == "ScoreTop") {
			rvoList = rdao.selectReviewScore(false);
		} else if (sort == "scoreBottom") {
			rvoList = rdao.selectReviewScore(true);
		} else {
			rvoList = rdao.selectAllReview();
		}

		if (rvoList == null || rvoList.size() == 0) { // 만약에 회원 목록이 없다면
			System.out.println(" 등록된 리뷰가 없습니다");

		} else {// 그렇지 않다면
			System.out.println();
			System.out.println("리뷰번호 | 작성자 | 영화제목 | 평점 | 내용");
			System.out.println("-------------------------------------");

			for (ReviewVO rvo : rvoList) {

				System.out.print(rvo.getReviewNo() + " | ");
				System.out.print(rvo.getMemberid() + " | ");
				System.out.print(rvo.getMovieName() + " | ");
				int reviewScore = rvo.getReviewScore();
				String reviewStar = "☆☆☆☆☆";
				switch (reviewScore) {
				
				case 1 : 
					reviewStar = "★☆☆☆☆";
					break;
				case 2 : 
					reviewStar = "★★☆☆☆";
					break;
				case 3 : 
					reviewStar = "★★★☆☆";
					break;
				case 4 : 
					reviewStar = "★★★★☆";
					break;
				case 5 : 
					reviewStar = "★★★★★";
					break;
				default :
					reviewStar = "☆☆☆☆☆";
					break;
				}
				
				System.out.print(reviewStar + " | ");
				
				if (rvo.getReviewContent().length() >= 11) { // 글자가 11자가 되는 순간부터 10자까지만!
					System.out.println(rvo.getReviewContent().substring(0,10) + "...");
				} else {
					System.out.println(rvo.getReviewContent());
				}
				
			}

	}
	}
	
	// 리뷰 목록보기 -> 영화 자세히 보기 
	// 리뷰목록보기 -> 영화 자세히보기에서 왔을 때
	public void reviewAllList(int movieNo, int listNum) {
		List<ReviewVO> rvoList = rdao.selectAllReview(movieNo, listNum);

		if (rvoList == null || rvoList.size() == 0) { // 만약에 회원 목록이 없다면
			System.out.println(" 등록된 리뷰가 없습니다");

		} else {// 그렇지 않다면
			System.out.println();
			System.out.println("리뷰번호 | 작성자 | 영화제목 | 평점 | 내용");
			System.out.println("-------------------------------------");

			for (ReviewVO rvo : rvoList) {

				System.out.print(rvo.getReviewNo() + " | ");
				System.out.print(rvo.getMemberid() + " | ");
				System.out.print(rvo.getMovieName() + " | ");
				int reviewScore = rvo.getReviewScore();
				String reviewStar = "☆☆☆☆☆";
				switch (reviewScore) {
				
				case 1 : 
					reviewStar = "★☆☆☆☆";
					break;
				case 2 : 
					reviewStar = "★★☆☆☆";
					break;
				case 3 : 
					reviewStar = "★★★☆☆";
					break;
				case 4 : 
					reviewStar = "★★★★☆";
					break;
				case 5 : 
					reviewStar = "★★★★★";
					break;
				default :
					reviewStar = "☆☆☆☆☆";
					break;
				}
				
				System.out.print(reviewStar + " | ");
				
				if (rvo.getReviewContent().length() >= 11) { // 글자가 11자가 되는 순간부터 10자까지만!
					System.out.println(rvo.getReviewContent().substring(0,10) + "...");
				} else {
					System.out.println(rvo.getReviewContent());
				}
				
				
				
			}

	}
		
	}
	
	// 리뷰 목록보기 -> 영화 자세히 보기 정렬 후
	// 리뷰목록보기 -> 영화 자세히보기에서 왔을 때 + 정렬
	public void reviewAllList(int movieNo, String sort, int listNum) {
		List<ReviewVO> rvoList;
		
		if (sort == "ScoreTop") {
			rvoList = rdao.selectReviewScore(movieNo, false, listNum);
		} else if (sort == "scoreBottom") {
			rvoList = rdao.selectReviewScore(movieNo, true, listNum);
		} else {
			rvoList = rdao.selectAllReview(movieNo, listNum);
		}

		if (rvoList == null || rvoList.size() == 0) { // 만약에 회원 목록이 없다면
			System.out.println(" 등록된 리뷰가 없습니다");

		} else {// 그렇지 않다면
			System.out.println();
			System.out.println("리뷰번호 | 작성자 | 영화제목 | 평점 | 내용");
			System.out.println("-------------------------------------");

			for (ReviewVO rvo : rvoList) {

				System.out.print(rvo.getReviewNo() + " | ");
				System.out.print(rvo.getMemberid() + " | ");
				System.out.print(rvo.getMovieName() + " | ");
				int reviewScore = rvo.getReviewScore();
				String reviewStar = "☆☆☆☆☆";
				switch (reviewScore) {
				
				case 1 : 
					reviewStar = "★☆☆☆☆";
					break;
				case 2 : 
					reviewStar = "★★☆☆☆";
					break;
				case 3 : 
					reviewStar = "★★★☆☆";
					break;
				case 4 : 
					reviewStar = "★★★★☆";
					break;
				case 5 : 
					reviewStar = "★★★★★";
					break;
				default :
					reviewStar = "☆☆☆☆☆";
					break;
				}
				
				System.out.print(reviewStar + " | ");
				
				if (rvo.getReviewContent().length() >= 11) { // 글자가 11자가 되는 순간부터 10자까지만!
					System.out.println(rvo.getReviewContent().substring(0,10) + "...");
				} else {
					System.out.println(rvo.getReviewContent());
				}
				
			}

	}
	}
	
	
	// 리뷰 정렬
	public void reviewSort() throws IOException {
		listNum = 5;
		
		System.out.println("-----------------------");
		System.out.println("어떤 순서로 정렬하시겠습니까?");
		System.out.println("1. 등록일자순(최신)   2.평점순(높은 것부터)   3.평점순(낮은 것부터)");
		System.out.println("4. 돌아가기");
		
		System.out.print("입력 : ");
		
		int input = Pub.scan.nextInt();
		Pub.scan.nextLine();
		
		switch (input) {
		case 1 :
			System.out.println("등록일자순(최신)으로 정렬합니다");
			if (movieNo == 0) {
				reviewAdmin();
			} else {
				if (Pub.id.equals("admin")) {
					reviewMemberAdmin(movieNo);
				} else {
				reviewMember(movieNo);
				}
			}
			break;
		case 2 :
			System.out.println("평점순(높은 것부터)으로 정렬합니다");
			if (movieNo == 0) {
				reviewAdmin("ScoreTop");
			} else {
				if (Pub.id.equals("admin")) {
					reviewMemberAdmin(movieNo, "ScoreTop");
				} else {
					reviewMember(movieNo, "ScoreTop");
				}
			}
			break;
		case 3 :
			System.out.println("평점순(낮은 것부터)으로 정렬합니다");
			if (movieNo == 0) {
				reviewAdmin("scoreBottom");
			} else {
				if (Pub.id.equals("admin")) {
					reviewMemberAdmin(movieNo, "scoreBottom");
				} else {
					reviewMember(movieNo, "scoreBottom");
				}
			}
			break;
		case 4 :
			if (movieNo == 0) {
				reviewAllList();
			} else {
				movieMain.movieDetail(movieNo);;
			}
			break;
			
		default:
			System.out.println("올바른 번호를 입력해주세요");
			break;
		}
		
		System.out.println("-----------------------");
		
	}

	// 리뷰 자세히 보기
	public void reviewDetail(int reviewNo) throws IOException {

		this.reviewNo = reviewNo;
		ReviewVO rvo = rdao.selectReviewOne(reviewNo);

		if (rvo == null) {
			System.out.println("올바른 번호를 입력해주세요");
			reviewMember(movieNo);
			
		} else {
			System.out.println("======= 리뷰 자세히 보기 ========");
			movieNo = rvo.getMovieNo();

			System.out.println("영화제목 : " + rvo.getMovieName());
			System.out.println("작성자 아이디 : " + rvo.getMemberid());
			System.out.println("등록일자 : " + rvo.getRegiDate());
			System.out.println("수정일자 : " + rvo.getModDate());
			
			int reviewScore = rvo.getReviewScore();
			String reviewStar = "☆☆☆☆☆";
			switch (reviewScore) {
			
			case 1 : 
				reviewStar = "★☆☆☆☆";
				break;
			case 2 : 
				reviewStar = "★★☆☆☆";
				break;
			case 3 : 
				reviewStar = "★★★☆☆";
				break;
			case 4 : 
				reviewStar = "★★★★☆";
				break;
			case 5 : 
				reviewStar = "★★★★★";
				break;
			default :
				reviewStar = "☆☆☆☆☆";
				break;
			}
			
			System.out.println("평점 : " + reviewStar);
			System.out.println("리뷰 :" + rvo.getReviewContent());

			if (Pub.id.equals("admin")) {
			
			System.out.println("---------------------------");
			System.out.println("1. 리뷰수정    2.리뷰 삭제   3. 메인 메뉴 이동");
			System.out.print("입력 : ");

			int input = Pub.scan.nextInt();
			Pub.scan.nextLine();

			switch (input) {
			case 1:
				modReview();
				break;

			case 2:
				removeReview();
				break;

			case 3:
				new MemberMain().adminMenu();
				break;
			}
				
			} else {
				
				System.out.println("---------------------------");
				System.out.println("1. 메인 메뉴 이동");
				System.out.print("입력 : ");

				int input = Pub.scan.nextInt();
				Pub.scan.nextLine();
				
				switch (input) {
				case 1:
					
					if (Pub.id.equals("guest")) {
						new MemberMain().guestMain();
					} else {
					new MemberMain().memberMenu();
					}
					break;

					}
			}
			}

	}

	// 내가 쓴 리뷰 목록보기 - 어.. 흐름도에도 화면구성에도 없어서 일단생략
//	public void myReview() {}

	// 리뷰 쓰기
	public void reviewadd(int movieNo) throws IOException {
		
	
		System.out.println("==========리뷰 등록==========");
		
		//리뷰 중복 체크
		boolean existReview = rdao.reviewCheck(movieNo, Pub.id);
		
		if ( existReview ) {
			System.out.println("이 영화에는 이미 리뷰를 달았습니다");
			System.out.println("내가 단 리뷰로 갑니다");
			int myReviewNo = rdao.selectMyReviewNo(movieNo, Pub.id);
			reviewDetail(myReviewNo);
		} else {
		
		System.out.println("리뷰를 등록해주세요");
		System.out.print("평점(1~5) : ");
		int score = Pub.scan.nextInt();
		Pub.scan.nextLine();
		
		if (score > 5 || score < 1) {
			System.out.println("평점은 1~5중 하나여야합니다");
			System.out.println("----------------------");
			System.out.print("평점(1~5) : ");
			score = Pub.scan.nextInt();
			Pub.scan.nextLine();
		}
		
		System.out.print("리뷰내용 : ");
		String content = Pub.scan.nextLine();
	
		// 저장 혹은 이전으로
		System.out.println("----------------------------");
		System.out.println("1. 저장		2. 이전으로");
		int input = Pub.scan.nextInt();
		Pub.scan.nextLine();
	
		if (input == 1) {
			System.out.println("리뷰를 등록합니다");
	
			ReviewVO rvo = new ReviewVO();
			
			rvo.setReviewScore(score);
			rvo.setReviewContent(content);
			rvo.setMovieNo(movieNo);
			rvo.setMemberid(Pub.id);
	
			boolean insertCheck = rdao.insertReview(rvo);
	
			if (insertCheck) {
				System.out.println("리뷰 등록이 완료되었습니다");
			} else {
				System.out.println("리뷰 등록에 실패하셨습니다.");
			}
	
//			movieMain.movieDetail(movieNo);// 원래는 영화 자세히로 가는게 맞음
			reviewMember(movieNo); // 일단은 멤버리뷰로
			
		} else if (input == 2) {
			System.out.println("이전으로 돌아갑니다");
			reviewadd(movieNo);
		} else {
			System.out.println("올바른 번호를 입력해주세요");
			System.out.println("이전 메뉴로 돌아갑니다");
			movieMain.movieDetail(movieNo);
		}
		
		}
	}

	// 리뷰 수정
	public void modReview() throws IOException {
		System.out.println("======= 리뷰 수정 ========");
		System.out.println("수정할 리뷰의 정보를 입력해주세요");
		ReviewVO rvo = new ReviewVO();

		System.out.print("평점(1~5중 하나를 입력해주세요) : ");
		int score = Pub.scan.nextInt();
		Pub.scan.nextLine();

		if (score > 5 || score < 1) {
			System.out.println("평점은 1~5중 하나여야합니다");
			System.out.println("----------------------");
			System.out.print("평점(1~5중 하나를 입력해주세요) : ");
			score = Pub.scan.nextInt();
			Pub.scan.nextLine();
		}

		if (score > 5 || score < 1) {
			System.out.println("평점은 1~5중 하나여야합니다");
			System.out.print("평점(1~5중 하나를 입력해주세요) : ");
			score = Pub.scan.nextInt();
			Pub.scan.nextLine();
		}

		System.out.print("리뷰 내용 : ");
		String content = Pub.scan.nextLine();

		System.out.println("----------------------------");
		System.out.println("1. 저장		2. 이전으로");
		System.out.println("입력 : ");
		int input = Pub.scan.nextInt();
		Pub.scan.nextLine();

		if (input == 1) {
			System.out.println("리뷰를 수정합니다");

			rvo.setReviewNo(reviewNo);
			rvo.setReviewScore(score);
			rvo.setReviewContent(content);

			boolean updateCheck = rdao.updateReview(rvo);

			if (updateCheck) {
				System.out.println("리뷰 수정이 완료되었습니다.");
				reviewDetail(reviewNo);
			} else {
				System.out.println("수정이 완료되지 않았습니다.");
				System.out.println("이전 메뉴로 돌아갑니다");
				reviewDetail(reviewNo);
			}

		} else if (input == 2) {
			System.out.println("이전으로 돌아갑니다");
			modReview();
		} else {
			System.out.println("올바른 번호를 입력해주세요");
			System.out.println("이전 메뉴로 돌아갑니다");
			reviewDetail(reviewNo);
		}

	}

	// 내가 쓴 리뷰 수정 -> 굳이 나눌필요 없으니 제외
	// modReview()로 써주세요~~
	// 대신 내 리뷰를 찾아서 modReivew로 보내는 걸로 구현함!

	// 리뷰 삭제
	public void removeReview() throws IOException {
		System.out.println("--------------------------");
		System.out.println("해당 리뷰를 삭제하시겠습니까?(Y/N)");
		System.out.print("선택 : ");

		String yesNo = Pub.scan.nextLine();

		if (yesNo.equalsIgnoreCase("y")) {
			System.out.println("---------------------");
			System.out.println("리뷰를 삭제합니다");
			boolean result = rdao.deleteReview(reviewNo);

			if (result == true) {
				System.out.println("리뷰 삭제가 완료되었습니다");

				// 관리자면 리뷰관리로
				if (Pub.id.equals("admin")) {
					System.out.println("리뷰 관리 화면으로 돌아갑니다");
					reviewAdmin();
				} else { // 회원이면 영화자세히로, 
					System.out.println("영화 자세히 보기 화면으로 돌아갑니다");
//					movieMain.movieDetail(movieNo); // 영화 자세히보기로 가는 게 맞음
					//그러나 임시로 리뷰 목록으로 가겠음.
					reviewMember(movieNo);
				}
			} else {
				System.out.println("리뷰 삭제에 실패하였습니다");
				System.out.println("이전 메뉴로 돌아갑니다");
				reviewDetail(movieNo);
			}

		} else {
			System.out.println("리뷰 삭제가 취소되었습니다");
			System.out.println("이전 메뉴로 돌아갑니다");
			reviewDetail(movieNo);
		}

	}

//	// 디버깅용 메인
//	public static void main(String[] args) throws IOException {
////		new ReviewMain().reviewDetail(101);
//		ReviewMain reviewMain = new ReviewMain();
//		Pub.id = "dddd"; // 디버깅용 임시 아이디
//		
//		System.out.println("1.리뷰 관리  2.리뷰목록(영화번호)");
//		System.out.print("입력 : ");
//		int input = Pub.scan.nextInt();
//		Pub.scan.nextLine();
//		
//		switch (input) {
//		case 1 : 
//			reviewMain.reviewAdmin();
//			break;
//		case 2 : 
//			reviewMain.reviewMember(102);
//			break;
//		default : 
//			System.out.println("이상한 번호네.. 다시 하세욧!");
//			main(args);
//			break;
//		}
//	}
//
}
