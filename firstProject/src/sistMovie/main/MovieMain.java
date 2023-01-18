package sistMovie.main;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sistMovie.main.MemberMain;
import sistMovie.dao.ReviewDAO;
import sistMovie.main.ReviewMain;
import sistMovie.vo.ReviewVO;
import sistMovie.dao.LikeMovieDAO;
import sistMovie.dao.MovieDAO;
import sistMovie.util.DBCon;
import sistMovie.util.Pub;
import sistMovie.vo.LikeMovieVO;
import sistMovie.vo.MovieVO;
import sistMovie.vo.SurveyVO;

public class MovieMain extends Pub{
	private int input;
	private Scanner scan = new Scanner(System.in);
	private String id; /* 수정란 */
	private MovieDAO mvdao = new MovieDAO();
	private LikeMovieDAO lmdao = new LikeMovieDAO();
	private ReviewDAO rdao = new ReviewDAO();
	private int movieNo;

	private List<MovieVO> Movies = new ArrayList<>();
	private String query;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 영화 메뉴
	public MovieMain(Scanner scan, String id) {
		this.scan = scan;
		this.id = id;
	}

	// 영화보기
	public void movieMenu() {
		System.out.println();
		System.out.println();
		System.out.println("=========================== 영화보기 ===========================");
		System.out.println();
		System.out.println("1.오늘의 영화 2.TOP10 3.전체목록 4.장르별 보기 5.이전으로");
		try {
			System.out.print("선택 : ");
			input = scan.nextInt();

			if (input == 1) {
				todaysMovie();
			} else if (input == 2) {
				movieTopTen();
			} else if (input == 3) {
				movieAllList();
			} else if (input == 4) {
				movieGenre();
			} else if (input == 5) {
				if (id == null) {
					new MemberMain().guestMain();
				} else {
					if (id.equals("admin")) {

						new MemberMain().adminMenu();

					} else if (!id.equals("guest")) {
						new MemberMain().memberMenu();
					} else {
						new MemberMain().guestMain();
					}
				}
			} else {
				System.out.println("올바른 번호를 입력해 주세요.");
				System.out.println();
				movieMenu();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 오늘의 영화
	public void todaysMovie() { /* 수정란 */
		query = "SELECT MOVIENO FROM MOVIE";
		List<Integer> list = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			rs = pstmt.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getInt("MOVIENO"));
			}
			int random = (int) (Math.random() * list.size());
			movieDetail(list.get(random));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}

	}

	// 영화 관리
	public void movieAdmin() {
		try {
			System.out.println();
			System.out.println();
			System.out.println("=========================== 영화관리 ===========================");
			System.out.println();
			System.out.println("1.영화 목록	\t2.영화 등록 \t3.메인 메뉴로 이동");
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			System.out.print("선택 : ");
			input = scan.nextInt();

			if (input == 1) {
				movieAllList();
			} else if (input == 2) {
				movieAdd();
			} else if (input == 3) {

				new MemberMain().adminMenu();

			} else {
				System.out.println("올바른 번호를 입력해 주세요.");
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 영화 등록
	public void movieAdd() {
		MovieVO mvvo = new MovieVO();
		System.out.println();
		System.out.println();
		System.out.println("=========================== 영화 등록 ===========================");
		System.out.println("등록할 영화의 정보를 입력해 주세요.");
		scan.nextLine();
		System.out.print("영화 제목: ");
		String title = scan.nextLine();
		mvvo.setMovieName(title);

		System.out.print("대표 이미지: ");
		String img = scan.nextLine();
		mvvo.setImage(img);

		System.out.print("개봉 일자: ");
		String startDate = scan.nextLine();
		mvvo.setReleaseDate(startDate);

		System.out.print("감독: ");
		String director = scan.nextLine();
		mvvo.setDirector(director);

		System.out.print("출연진1: ");
		String actorOne = scan.nextLine();
		mvvo.setActor1(actorOne);

		System.out.print("출연진2: ");
		String actorTwo = scan.nextLine();
		mvvo.setActor2(actorTwo);

		System.out.print("출연진3: ");
		String actorThr = scan.nextLine();
		mvvo.setActor3(actorThr);

		System.out.println("영화 장르: ");
		System.out.println("액션 / SF / 모험 / 판타지 / 애니메이션 / 드라마 / 코미디");
		System.out.println("로맨스 / 뮤지컬 / 미스터리 / 스릴러 / 기타");
		System.out.print("입력: ");
		String genre = scan.nextLine();
		mvvo.setGenre(genre);

		System.out.println("---------------------------------------------------------------");
		System.out.println("1.저장 2.이전으로");
		System.out.print("선택: ");
		input = scan.nextInt();

		if (input == 1) {
			boolean result = mvdao.insertMovie(mvvo);
			if (result == true) {
				System.out.println("등록이 완료되었습니다. 이전 메뉴로 돌아갑니다.");
				System.out.println();
				movieAdmin();
			} else {
				System.out.println("입력하지 않은 정보가 있어 등록이 완료되지 않았습니다.");
				System.out.println("이전 메뉴로 돌아갑니다.");
				System.out.println();
				movieAdmin();
			}
		} else if (input == 2) {
			System.out.println("이전 메뉴로 돌아갑니다.");
			System.out.println();
			movieAdmin();
		} else {
			System.out.println("입력하지 않은 정보가 있어 등록이 완료되지 않았습니다.");
			System.out.println("이전 메뉴로 돌아갑니다.");
			System.out.println();
			movieAdmin();
		}
	}

	// 영화 수정
	public void movieModify() {
		MovieVO mvvo = new MovieVO();
		System.out.println();
		System.out.println();
		System.out.println("=========================== 영화 수정 ===========================");
		System.out.println("수정할 영화의 정보를 입력해 주세요.");
		scan.nextLine();
		System.out.print("영화 제목: ");
		String title = scan.nextLine();
		mvvo.setMovieName(title);

		System.out.println("영화 장르: ");
		String genre = scan.nextLine();
		mvvo.setGenre(genre);

		System.out.print("대표 이미지: ");
		String img = scan.nextLine();
		mvvo.setImage(img);

		System.out.print("개봉 일자: ");
		String startDate = scan.next();
		mvvo.setReleaseDate(startDate);

		System.out.print("감독: ");
		String director = scan.nextLine();
		mvvo.setDirector(director);

		System.out.print("출연진1: ");
		String actorOne = scan.nextLine();
		mvvo.setActor1(actorOne);

		System.out.print("출연진2: ");
		String actorTwo = scan.nextLine();
		mvvo.setActor2(actorTwo);

		System.out.print("출연진3: ");
		String actorThr = scan.nextLine();
		mvvo.setActor3(actorThr);

		System.out.println("---------------------------------------------------------------");
		System.out.println("1.저장 2.이전으로");
		System.out.print("선택: ");
		input = scan.nextInt();

		if (input == 1) {
			boolean result = mvdao.updateMovie(mvvo);
			if (result == true) {
				System.out.println("수정이 완료되었습니다. 이전 메뉴로 돌아갑니다.");
				System.out.println();
				movieAdmin();
			} else {
				System.out.println("입력하지 않은 정보가 있어 수정이 완료되지 않았습니다.");
				System.out.println("이전 메뉴로 돌아갑니다.");
				System.out.println();
				movieAdmin();
			}
		} else if (input == 2) {
			System.out.println("이전 메뉴로 돌아갑니다.");
			System.out.println();
			movieAdmin();
		} else {
			System.out.println("입력하지 않은 정보가 있어 수정이 완료되지 않았습니다.");
			System.out.println("이전 메뉴로 돌아갑니다.");
			System.out.println();
			movieAdmin();
		}

	}

	// 영화 삭제
	public void movieRemove() { /* 수정란 */
		MovieVO mvvo = new MovieVO();
		System.out.println();
		System.out.println();
		System.out.println("=========================== 영화 삭제 ===========================");
		System.out.println("해당 영화를 삭제하시겠습니까? (Y)");
		System.out.println("---------------------------------------------------------------");
		System.out.print("선택: ");
		String input = scan.nextLine();

		if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Y")) {
			boolean result = mvdao.deleteMovie(movieNo);
			if (result == true) {
				System.out.println("영화 삭제가 완료되었습니다. 이전 메뉴로 돌아갑니다.");
				System.out.println();
				movieAllList();
			}
		} else {
			System.out.println("영화 삭제가 취소되었습니다. 이전 메뉴로 돌아갑니다.");
			System.out.println();
			movieAllList();
		}
	}

	// 영화 전체 목록
	public void movieAllList() { /* 수정란 */
		System.out.println();
		System.out.println();
		System.out.println("=========================== 영화 목록 ===========================");
		try {
			List<MovieVO> movieList = mvdao.selectMovieRelease();
			if (movieList == null || movieList.size() < 1) {
				System.out.println("등록된 영화가 없습니다.");
			} else {// 그렇지 않다면
				System.out.println("영화번호|영화제목|개봉일자");
				System.out.println("---------------------------------------------------------------");
				for (MovieVO mvvo : movieList) {
					System.out.println(mvvo.getMovieNo() + "|" + mvvo.getMovieName() + "|" + mvvo.getReleaseDate());

				}
			}

			System.out.println();
			System.out.println("1.정렬하기 2.이전으로 3.메인 메뉴로 이동");
			System.out.println();
			System.out.println("영화를 자세히 보려면 해당 영화번호를 입력해주세요.");
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			System.out.print("선택: ");
			input = scan.nextInt();

			if (input == 1) {
				movieSort();
			} else if (input == 2) {
				movieMenu();
			} else if (input == 3){
				if (id == null) {
					new MemberMain().guestMain();
				} else {
					if (id.equals("admin")) {

						new MemberMain().adminMenu();

					} else if (!id.equals("guest")) {
						new MemberMain().memberMenu();
					} else {
						new MemberMain().guestMain();
					}
				}
			} else {
				if (101 <= input) {
					movieDetail(input);
				} else {
					System.out.println("올바른 번호를 입력해 주세요.");
					System.out.println();
					movieAllList();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 영화 TOP 10
	public void movieTopTen() { /* 수정란 */
		System.out.println();
		System.out.println();
		System.out.println("===========================TOP10 영화보기===========================");

		List<MovieVO> movieList = mvdao.selectMovieTopTen();
		if (movieList == null || movieList.size() < 1) {
			System.out.println("등록된 영화가 없습니다.");
		} else {// 그렇지 않다면
			System.out.println("영화번호|영화제목|개봉일자");
			System.out.println("---------------------------------------------------------------");
			for (MovieVO mvvo : movieList) {
				System.out.println(mvvo.getMovieNo() + "|" + mvvo.getMovieName() + "|" + mvvo.getReleaseDate());

			}
		}

		System.out.println();
		System.out.println("1.정렬하기 2.이전으로");
		System.out.println();
		System.out.println("영화를 자세히 보려면 해당 영화번호를 입력해주세요.");
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.print("선택: ");
		input = scan.nextInt();

		if (input == 1) {
			movieSort();
		} else if (input == 2) {
			movieMenu();
		} else {
			if (101 <= input && input <= 110) {
				movieDetail(input);
			} else {
				System.out.println("올바른 번호를 입력해 주세요.");
				System.out.println();
				movieTopTen();
			}
		}

	}

	// 영화 장르별 보기
	public void movieGenre() { /* 수정란 */
		try {
			String genre = null;
			System.out.println("===========================장르별 보기===========================");
			System.out.println("장르를 선택해주세요.");
			System.out.println("1. 액션   2. SF  3. 모험   4.판타지   5.애니메이션   6.드라마   7.코미디    8.로맨스");
			System.out.println("9.뮤지컬  10.미스터리 11.스릴러 12.기타");
			System.out.println();
			System.out.println("0. 이전으로");
			System.out.println("---------------------------------------------------------------");
			System.out.print("선택: ");
			input = scan.nextInt();

			if (input == 1) {
				genre = "액션";
			} else if (input == 0) {
				if (id == null) {
					new MemberMain().guestMain();
				} else {
					if (id.equals("admin")) {

						new MemberMain().adminMenu();

					} else if (!id.equals("guest")) {
						new MemberMain().memberMenu();
					} else {
						new MemberMain().guestMain();
					}
				}
			} else if (input == 2) {
				genre = "SF";
			} else if (input == 3) {
				genre = "모험";
			} else if (input == 4) {
				genre = "판타지";
			} else if (input == 5) {
				genre = "애니메이션";
			} else if (input == 6) {
				genre = "드라마";
			} else if (input == 7) {
				genre = "코미디";
			} else if (input == 8) {
				genre = "로맨스";
			} else if (input == 9) {
				genre = "뮤지컬";
			} else if (input == 10) {
				genre = "미스터리";
			} else if (input == 11) {
				genre = "스릴러";
			} else if (input == 12) {
				genre = "기타";
			}

			if (1 <= input && input <= 12) {
				List<MovieVO> movieList = mvdao.selectMovieGenre(input);
				if (movieList == null || movieList.size() < 1) {
					System.out.println("등록된 영화가 없습니다.");
				} else {// 그렇지 않다면
					System.out.println();
					System.out.println("===========================[" + genre + "] 영화 모음===========================");
					System.out.println("영화번호|영화제목|개봉일자");
					System.out.println("---------------------------------------------------------------");
					for (MovieVO mvvo : movieList) {
						System.out.println(mvvo.getMovieNo() + "|" + mvvo.getMovieName() + "|" + mvvo.getReleaseDate());

					}
				}
			} else {
				System.out.println("올바른 번호를 입력해 주세요.");
				System.out.println();
				movieGenre();
			}

			System.out.println();
			System.out.println("1.다른 장르 보기 2.이전으로");
			System.out.println();
			System.out.println("영화를 자세히 보려면 해당 영화번호를 입력해주세요.");
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			System.out.print("선택: ");
			input = scan.nextInt();

			if (input == 1) {
				movieGenre();
			} else if (input == 2) {
				movieMenu();
			} else {
				if (101 <= input) {
					movieDetail(input);
				} else {
					System.out.println("올바른 번호를 입력해 주세요.");
					System.out.println();
					movieGenre();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 영화 자세히 보기

	public void movieDetail(int movieNo) {
		this.movieNo = movieNo;
		try {
			System.out.println();
			System.out.println();
			MovieVO mvvo = mvdao.selectMovieOne(movieNo);
			System.out.println("=========================== [" + mvvo.getMovieName() + "] ===========================");

			System.out.println("[" + mvvo.getGenre() + "]" + "[" + mvvo.getReleaseDate() + "]");
			System.out.println("[" + mvvo.getDirector() + "]" + "[" + mvvo.getActor1() + "]" + "[" + mvvo.getActor2()
					+ "]" + "[" + mvvo.getActor3() + "]");
			
			if(id.equals("admin")) {
				new ReviewMain().reviewMemberAdmin(movieNo);
			} else {
				new ReviewMain().reviewMember(movieNo);
			}
			
			
//			System.out.println(rdao.selectAllReview()); /* 수정란 */
//			System.out.println("----------------------------------------------------------------------");
//			if (id.equals("admin")) {
//				System.out.println("1.리뷰 더보기 2.리뷰 정렬하기 3.메인메뉴"); /* 수정란 */
//				System.out.print("입력: ");
//				input = scan.nextInt();
//
//				if (input == 1) {
//					rdao.selectAllReview(); /* 수정란 */
//				} else if (input == 2) {
//					new ReviewMain().reviewSort(); /* 수정란 */
//				} else if (input == 3) {
//					if (id == null) {
//						new MemberMain().guestMain();
//					} else {
//						if (id.equals("admin")) {
//
//							new MemberMain().adminMenu();
//
//						} else if (!id.equals("guest")) {
//							new MemberMain().memberMenu();
//						} else {
//							new MemberMain().guestMain();
//						}
//					}
//				} else {
//					System.out.println("올바른 번호를 입력해주세요.");
//					movieDetail(movieNo);
//				}
//			} else {
//				System.out.println("1.리뷰 더보기 2.리뷰 정렬하기 3.이전으로 4.내 관심영화로 등록하기 5.리뷰쓰기");
//				System.out.print("입력: ");
//				input = scan.nextInt();
//
//				if (input == 1) {
//					rdao.selectAllReview(); /* 수정란 */
//				} else if (input == 2) {
//					new ReviewMain().reviewSort(); /* 수정란 */
//				} else if (input == 3) {
//					if (id == null) {
//						new MemberMain().guestMain();
//					} else {
//						if (id.equals("admin")) {
//
//							new MemberMain().adminMenu();
//
//						} else if (!id.equals("guest")) {
//							new MemberMain().memberMenu();
//						} else {
//							new MemberMain().guestMain();
//						}
//					}
//				} else if (input == 4) {
//					lmdao.insertLikeMovie(id, movieNo);
//					new MemberMain().memberMenu();
//				} else if (input == 5) {
//					new ReviewMain().reviewadd(movieNo);
//					new MemberMain().memberMenu();
//				} else {
//					System.out.println("올바른 번호를 입력해주세요.");
//					movieDetail(movieNo);
//				}
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 영화 정렬하기

	public void movieSort() {
		System.out.println("------------------------------------------------");
		System.out.println("어떤 순서로 정렬하시겠습니까?");
		System.out.println();
		System.out.println("1. 개봉일자순(최신순) 2. 평점순(오름차순) 3. 평점순(내림차순)");
		System.out.println("4. 가나다순 5. 가나다순(역순)  6. 돌아가기");
		System.out.println("------------------------------------------------");
		System.out.print("선택 : ");
		input = scan.nextInt();

		if (input == 1) {

			System.out.println();
			System.out.println();
			System.out.println("=========================== 영화 목록 ===========================");
			try {
				List<MovieVO> movieList = mvdao.selectMovieRelease();
				if (movieList == null || movieList.size() < 1) {
					System.out.println("등록된 영화가 없습니다.");
				} else {// 그렇지 않다면
					System.out.println("영화번호|영화제목|개봉일자");
					System.out.println("---------------------------------------------------------------");
					for (MovieVO mvvo : movieList) {
						System.out.println(
								mvvo.getMovieNo() + "|" + mvvo.getMovieName() + "|" + "|" + mvvo.getReleaseDate());

					}
				}

				System.out.println();
				System.out.println("1.정렬하기 2.이전으로 3.메인 메뉴로 이동");
				System.out.println();
				System.out.println("영화를 자세히 보려면 해당 영화번호를 입력해주세요.");
				System.out.println();
				System.out.println("---------------------------------------------------------------");
				System.out.print("선택: ");
				input = scan.nextInt();

				if (input == 1) {
					movieSort();
				} else if (input == 2) {
					movieMenu();
				} else if (input == 3) {
					if (id == null) {
						new MemberMain().guestMain();
					} else {
						if (id.equals("admin")) {

							new MemberMain().adminMenu();

						} else if (!id.equals("guest")) {
							new MemberMain().memberMenu();
						} else {
							new MemberMain().guestMain();
						}
					}
				} else {
					if (101 <= input) {
						movieDetail(input);
					} else {
						System.out.println("올바른 번호를 입력해 주세요.");
						System.out.println();
						movieAllList();
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

//		else if (input == 2) {
//			mvdao.selectMovieScore(true);
//		} else if (input == 3) {
//			mvdao.selectMovieScore(false);
//		} 
		else if (input == 4) {
			System.out.println();
			System.out.println();
			System.out.println("=========================== 영화 목록 ===========================");
			try {
				List<MovieVO> movieList = mvdao.selectMovieGanada(true);
				if (movieList == null || movieList.size() < 1) {
					System.out.println("등록된 영화가 없습니다.");
				} else {// 그렇지 않다면
					System.out.println("영화번호|영화제목|개봉일자");
					System.out.println("---------------------------------------------------------------");
					for (MovieVO mvvo : movieList) {
						System.out.println(
								mvvo.getMovieNo() + "|" + mvvo.getMovieName() + "|" + "|" + mvvo.getReleaseDate());

					}
				}

				System.out.println();
				System.out.println("1.정렬하기 2.이전으로 3.메인 메뉴로 이동");
				System.out.println();
				System.out.println("영화를 자세히 보려면 해당 영화번호를 입력해주세요.");
				System.out.println();
				System.out.println("---------------------------------------------------------------");
				System.out.print("선택: ");
				input = scan.nextInt();

				if (input == 1) {
					movieSort();
				} else if (input == 2) {
					movieMenu();
				} else if (input == 3) {
					if (id == null) {
						new MemberMain().guestMain();
					} else {
						if (id.equals("admin")) {

							new MemberMain().adminMenu();

						} else if (!id.equals("guest")) {
							new MemberMain().memberMenu();
						} else {
							new MemberMain().guestMain();
						}
					}
				} else {
					if (101 <= input) {
						movieDetail(input);
					} else {
						System.out.println("올바른 번호를 입력해 주세요.");
						System.out.println();
						movieAllList();
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (input == 5) {

			System.out.println();
			System.out.println();
			System.out.println("=========================== 영화 목록 ===========================");
			try {
				List<MovieVO> movieList = mvdao.selectMovieGanada(false);
				if (movieList == null || movieList.size() < 1) {
					System.out.println("등록된 영화가 없습니다.");
				} else {// 그렇지 않다면
					System.out.println("영화번호|영화제목|개봉일자");
					System.out.println("---------------------------------------------------------------");
					for (MovieVO mvvo : movieList) {
						System.out.println(
								mvvo.getMovieNo() + "|" + mvvo.getMovieName() + "|" + "|" + mvvo.getReleaseDate());

					}
				}

				System.out.println();
				System.out.println("1.정렬하기 2.이전으로 3.메인 메뉴로 이동");
				System.out.println();
				System.out.println("영화를 자세히 보려면 해당 영화번호를 입력해주세요.");
				System.out.println();
				System.out.println("---------------------------------------------------------------");
				System.out.print("선택: ");
				input = scan.nextInt();

				if (input == 1) {
					movieSort();
				} else if (input == 2) {
					movieMenu();
				} else if (input == 3) {
					if (id == null) {
						new MemberMain().guestMain();
					} else {
						if (id.equals("admin")) {

							new MemberMain().adminMenu();

						} else if (!id.equals("guest")) {
							new MemberMain().memberMenu();
						} else {
							new MemberMain().guestMain();
						}
					}
				} else {
					if (101 <= input) {
						movieDetail(input);
					} else {
						System.out.println("올바른 번호를 입력해 주세요.");
						System.out.println();
						movieAllList();
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (input == 6) {
			movieAllList();
		} else {
			System.out.println("올바른 번호를 입력해 주세요.");
			System.out.println();
			movieDetail(movieNo);
		}

	}

	// 관심영화 보기 화면
	public void likeMovieList() {
		try {
			List<LikeMovieVO> movieList = lmdao.selectAllLikeMovie();
			if (movieList == null || movieList.size() < 1) {
				System.out.println("등록된 영화가 없습니다.");
			} else {// 그렇지 않다면
				System.out.println("영화번호|영화제목|개봉일자");
				System.out.println("---------------------------------------------------------------");
				for (LikeMovieVO mvvo : movieList) {
					System.out.println(mvvo.getLikeMovieNo() + "|" + mvvo.getId() + "|" + "|" + mvvo.getMovieNo());

				}
			}

			System.out.println();
			System.out.println("1.정렬하기 2.이전으로 3.메인 메뉴로 이동");
			System.out.println();
			System.out.println("영화를 자세히 보려면 해당 영화번호를 입력해주세요.");
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			System.out.print("선택: ");
			input = scan.nextInt();

			if (input == 1) {
				movieSort();
			} else if (input == 2) {
				movieMenu();
			} else if (input == 3) {
				if (id == null) {
					new MemberMain().guestMain();
				} else {
					if (id.equals("admin")) {

						new MemberMain().adminMenu();

					} else if (!id.equals("guest")) {
						new MemberMain().memberMenu();
					} else {
						new MemberMain().guestMain();
					}
				}
			} else {
				if (101 <= input) {
					movieDetail(input);
				} else {
					System.out.println("올바른 번호를 입력해 주세요.");
					System.out.println();
					movieAllList();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 관심영화 등록

//	public void addLikeMovie() { /* 수정란 */
//		SurveyVO svo = new SurveyVO();
//		System.out.println();
//		System.out.println();
//		System.out.println("=======================================================");
//		System.out.println(">> 설문 등록 --------");
//		scan.nextLine();
//		System.out.println();
//		System.out.print("   설문 제목 : ");
//		String title = scan.nextLine();
//		svo.setTitle(title);
//
//		System.out.print("   선택 항목1 : ");
//		String one = scan.nextLine();
//		svo.setOne(one);
//
//		System.out.print("   선택 항목2 : ");
//		String two = scan.nextLine();
//		svo.setTwo(two);
//
//		System.out.print("   설문시작일 : ");
//		String startDate = scan.nextLine();
//		svo.setStartDate(startDate);
//
////			설문 시작일이 이미 등록되어 있는 설문의 조사기간과 중복되면
////			불가 안내 및 설문 등록 재요청 메시지를 출력하고 관리자 메뉴 표시
//
//		String endDate = startDate;
//		svo.setEndDate(endDate);
//
//		boolean result = sdao.insert(svo);
//		if (result == true) {
//			System.out.println("설문 등록이 완료되었습니다.");
//			System.out.println();
//			adminmenu();
//		}
//
//	}

	// 관심영화 취소

//	public void removeLikeMovie() { /* 수정란 */
//		List<SurveyVO> surveyList = sdao.selectAllList();
//		System.out.println();
//		System.out.println();
//		System.out.println("=======================================================");
//		System.out.println(">> 설문 삭제 --------");
//		System.out.println();
//		if (surveyList == null || surveyList.size() < 1) {
//			System.out.println(">> 등록된 설문이 없습니다.");
//		} else {// 그렇지 않다면
//			System.out.println("설문번호|설문시작일 - 설문종료일|참여자 수|설문 제목");
//			System.out.println("------------------------------------------------");
//			for (SurveyVO svo : surveyList) {
//				System.out.println(svo.getSurveyNo() + "|" + svo.getStartDate() + "~" + svo.getEndDate() + "|"
//						+ (svo.getOneCnt() + svo.getTwoCnt()) + "|" + svo.getTitle());
//
//			}
//		}
//		System.out.println();
//		System.out.print(">> 삭제하실 설문번호를 선택해주세요. : ");
//		int survey_no = scan.nextInt();
//		for (SurveyVO svo : surveyList) {
//			if (survey_no == svo.getSurveyNo()) {
//				System.out.print(survey_no + "번 설문을 삭제하시겠습니까?(y/n)");
//				scan.nextLine();
//				String input = scan.nextLine();
//				if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Y")) {
//					boolean result = sdao.delete(survey_no);
//					if (result == true) {
//						System.out.println(">>선택하신 설문이 삭제되었습니다.");
//						adminmenu();
//						System.out.println();
//					}
//				} else {
//					System.out.println(">> 설문 삭제가 취소되었습니다.");
//					adminmenu();
//					System.out.println();
//
//					break;
//				}
//			} else {
//
//			}
//		}
//
//	}

	public static void main(String[] args) throws IOException {
		DBCon.getConnection();
		new MovieMain(scan, id).movieMenu();

	}
}
