package sistMovie.main;

import java.io.IOException;
import java.security.DrbgParameters.NextBytes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import sistMovie.main.ReviewMain;
import sistMovie.main.SurveyMain;
import sistMovie.dao.LikeMovieDAO;
import sistMovie.dao.MemberDAO;
import sistMovie.util.DBCon;
import sistMovie.util.Pub;
import sistMovie.vo.LikeMovieVO;
import sistMovie.vo.MemberVO;


public class MemberMain extends Pub{
	
	private String id = "guest";
	private String pw;
	private String name, email;
	private int input;
	private Scanner scan = new Scanner(System.in);
	private MemberDAO mdao = new MemberDAO();
	private LikeMovieDAO lmdao = new LikeMovieDAO();
	

	//메인메뉴
	public void menu() throws IOException {

		do {
			System.out.println("=========== SIST MOVIE REVIEW SYSTEM ===========");
			System.out.println("=================== 메인 페이지 ===================");
			System.out.println("1. 회원 가입     2.로그인         3. 비회원 모드로 시작");
			System.out.println("4. 아이디 찾기    5. 비밀번호 찾기  6. 종료 ");
			System.out.println("------------------------------------------------");
			System.out.print("선택 : ");
			input = scan.nextInt();
			scan.nextLine(); 

			switch (input) {
			case 1: join(); break;
			case 2: login(); break; 
			case 3: guestMain(); break; 
			case 4: findId(); break; 
			case 5: findPw(); break; 
			case 6:
				System.out.println("=================== 시스템 종료 ===================");
				System.out.println("시스템을 종료합니다");
				System.out.println("이용해 주셔서 감사합니다.");
				System.out.println("------------------------------------------------");
				scan.close();
				System.exit(0);
			default:
				System.out.println("올바른 번호를 입력해 주세요"); 
				
			}
		} while (true);

	}

	// 회원가입
	public void join() throws IOException {
		MemberVO mvo = new MemberVO();
		System.out.println("============= 회원 가입 페이지 =============");
		System.out.print("아이디    : ");
		String id = scan.nextLine();
		System.out.print("비밀번호  : ");
		String pw = scan.nextLine();
		System.out.print("이름     : ");
		String name = scan.nextLine();
		System.out.print("이메일    : ");
		String email = scan.nextLine();
		System.out.print("성별(M/F) : ");
		String gender = scan.nextLine();

		mvo.setId(id);
		mvo.setPw(pw);
		mvo.setName(name);
		mvo.setEmail(email);
		mvo.setGender(gender);

		boolean idCheck = mdao.idOverlapCheck(mvo);

		boolean result = mdao.insertmember(mvo);

		if (idCheck == true) { // id check 오류 뜨는지 확인
			System.out.println("중복되는 아이디입니다");
			System.out.println("회원 정보를 다시 입력해주세요");
			join();
		} else {
			if (result == true) {
				System.out.println("회원가입이 완료되었습니다");
				menu();
			} else {
				System.out.println("일부 정보가 누락되어 회원 가입에 실패하였습니다.");
				System.out.println("1. 다시 가입하기");
				System.out.println("2. 메인 메뉴로 이동하기");
				System.out.println("선택 : ");
				input = scan.nextInt();
				scan.nextLine();
				if(input == 1) {
						join();
					} else if(input == 2) {
						menu();
					} else {
						System.out.println("올바른 번호를 입력해 주세요");
						join(); // 올바른 번호 입력 다음에 어떤 창을 띄울지 모르겠어서 일단 join으로
					}
			
			}
		}

	}

	//로그인
	public void login() throws IOException {
		System.out.println("============== 로그인 페이지 ==============");
		System.out.print("    아이디 : ");
		id = scan.nextLine();
		System.out.print("    패스워드 : ");
		pw = scan.nextLine();
		Pub.id = id;
		boolean result = mdao.loginCheck(id, pw);

		// 로그인 체크 메소드 호출
		if (result == true) {
			System.out.println("로그인에 성공하셨습니다");
			if (id.equals("admin")) {
				adminMenu();
			} else {
				memberMenu();
			}
		} else {
			System.out.println("로그인에 실패하셨습니다");
			menu();

		}

	}
	
	//로그아웃
		public void logout() throws IOException {
			id = pw = null;
			System.out.println("================ 로그아웃 ================");
			System.out.println("로그아웃이 완료되었습니다.");
			System.out.println("메인 메뉴로 이동합니다.");
			System.out.println("----------------------------------------");
			menu();
		}

	// 회원 전용 모드
	public void memberMenu() throws IOException {
		System.out.println("================ 회원 메뉴 ===============");
		System.out.println("1. 영화 보기    2. 설문 이벤트   3. 마이 페이지");
		System.out.println("4. 로그아웃     5. 종료");
		System.out.print("선택 : ");
		input = scan.nextInt();
		scan.nextLine();

		System.out.println();
		switch (input) {
		case 1: new MovieMain(scan, id).movieMenu(); System.out.println(); break;
		case 2: new SurveyMain(scan, id).surveyMemberMenu(); System.out.println(); break;
		case 3: myPage(); System.out.println(); break;
		case 4: logout(); System.out.println(); break;
		case 5: 
			System.out.println("================ 시스템 종료 ================");
			System.out.println("시스템을 종료합니다.");
			System.out.println("이용해 주셔서 감사합니다.");
			System.out.println("----------------------------------------");
			System.out.println();
			scan.close(); System.exit(0); break;
		default:
			System.out.println("올바른 번호를 입력해 주세요");
			break;
		}
	}
	
	// 마이페이지
	public void myPage() throws IOException {
		System.out.println("================ 마이 페이지 ==============");		
		System.out.println("1. 내 정보 보기 2. 내 관심 영화 보기 3. 이전으로");
		System.out.print("선택 : ");
		input = scan.nextInt();
		scan.nextLine();
		
		switch (input) {
		case 1: memberInfo(); break; 
		case 2: showMyLikeMovie(); break;
		case 3: memberMenu(); break;
		default: System.out.println("올바른 번호를 입력해 주세요."); myPage(); break;
		}
		
	}
	
	// 내 관심영화보기 // 미완성
	public void showMyLikeMovie() throws IOException {
		List<LikeMovieVO> likeMovieList = lmdao.selectAllLikeMovie();
		
		if(likeMovieList == null || likeMovieList.size() < 1) {
			System.out.println();
			System.out.println("등록한 관심 영화가 없습니다.");
			myPage();
			
		} else {
			for (LikeMovieVO lmvo : likeMovieList) {
				System.out.println("============= 내 관심 영화 리스트 ===========");	
				new MovieMain(scan, id).likeMovieList();// get 확인
				System.out.println("0. 메인 메뉴");
				System.out.println("자세히 보고 싶은 영화를 선택해 주세요.");
				System.out.println("----------------------------------------");
				System.out.print("선택 : ");
				input = scan.nextInt();
				scan.nextLine(); 
					if(input == 0) {
						System.out.println("올바른 번호를 입력해 주세요");
						showMyLikeMovie();
					} else {
						new MovieMain(scan, id).movieDetail(input);
					}
			}
		}
		
		
		
		
	}
	
	// 회원탈퇴 페이지(회원)
	public void memberRemove() throws IOException {
		System.out.println("================= 회원 탈퇴 ===============");	
			System.out.print("회원 탈퇴를 원하시면 y를 입력해 주세요 : ");
			String yesNo = scan.nextLine();

			if (yesNo.equalsIgnoreCase("y")) {
				boolean result = mdao.delete(id);
				if (result == true) {
					System.out.println("회원 탈퇴가 완료되었습니다.");
				}
			} else {
				System.out.println("회원탈퇴가 취소되었습니다. 이전 메뉴로 돌아갑니다.");
				
			}
			System.out.println();
			menu();

		}

	//회원 정보 자세히 보기(관리자)
	public void memberInfoadmin(String searchid) throws IOException {
		if(searchid == null || searchid.equals("")) {
			searchid = id;
		}
		
		MemberVO mvo = mdao.select(searchid);
		System.out.println("============ 회원 정보 상세 보기 ===========");
		System.out.println("이름    : " + mvo.getName());
		System.out.println("아이디   : " + mvo.getId());
		System.out.println("비밀번호 : " + mvo.getPw());
		System.out.println("성별    : " + mvo.getGender());
		System.out.println("이메일   : " + mvo.getEmail());
		System.out.println("가입일자 : " + mvo.getJoinDate());
		System.out.println("----------------------------------------");
		System.out.println("1. 회원 정보 수정 2. 삭제 3. 이전 화면으로 돌아가기");
		System.out.print("선택 : ");
		input = scan.nextInt();
		scan.nextLine();
		switch (input) {
		case 1: updateMemberinfo(searchid); break;
		case 2: memberRemoveAdmin(searchid); break;
		case 3: adminMenu(); break;
		default: System.out.println("올바른 번호를 입력해 주세요. "); memberInfoadmin(""); break;
		}

	}
	
	// 회원 정보 자세히 보기(회원)
	public void memberInfo() throws IOException {
		MemberVO mvo = mdao.select(id);
		System.out.println("============ 회원 정보 상세 보기 ===========");
		System.out.println("이름    : " + mvo.getName());
		System.out.println("아이디   : " + mvo.getId());
		System.out.println("비밀번호 : " + mvo.getPw());
		System.out.println("성별    : " + mvo.getGender());
		System.out.println("이메일   : " + mvo.getEmail());
		System.out.println("가입일자 : " + mvo.getJoinDate());
		System.out.println("----------------------------------------");
		System.out.println("1. 회원 정보 수정 2. 탈퇴 3. 이전 화면으로 돌아가기");
		System.out.print("선택 : ");
		input = scan.nextInt();
		scan.nextLine();
		switch (input) {
		case 1: updateMyinfo(id); break;
		case 2: memberRemove(); break;
		case 3: memberMenu(); break;
		default: System.out.println("올바른 번호를 입력해 주세요. "); myPage(); break;
		}

	}
	
	// 아이디 찾기
	public void findId() throws IOException { 
		System.out.println("=============== 아이디 찾기 ===============");
		System.out.print("이름  : ");
		name = scan.nextLine();
		System.out.print("이메일 : ");
		email = scan.nextLine();
		MemberVO searchmvo = new MemberVO();
		searchmvo.setName(name);
		searchmvo.setEmail(email);
		MemberVO mvo = mdao.selectId(searchmvo);
		
		if(mvo == null) {
			System.out.println("가입되지 않은 회원입니다.");
		} else {
			if( mvo.getName().equals(name) && mvo.getEmail().equals(email)) {
				System.out.println("회원님의 아이디는 " + mvo.getId() + "입니다.");
			} else {
				System.out.println("일치하는 회원 아이디가 없습니다.");
				System.out.println("1. 다시 시도하기");
				System.out.println("2. 메인 메뉴로 이동하기");
				System.out.print("선택 : ");
				input = scan.nextInt();
				scan.nextLine();
				switch (input) {
				case 1: findId(); break;
				case 2: menu(); break;
				default: System.out.println("올바른 번호를 입력해 주세요."); findId(); break;
				}
			}
		}
			
		
		
	}
	
	// 비밀번호 찾기
	public void findPw() throws IOException {
		System.out.println("=============== 비밀번호 찾기 ===============");
		System.out.print("이름   : ");
		name = scan.nextLine();
		System.out.print("아이디  : ");
		id = scan.nextLine();
		System.out.print("이메일 : ");
		email = scan.nextLine();
		
		MemberVO searchmvo = new MemberVO();
		searchmvo.setName(name);
		searchmvo.setId(id);
		searchmvo.setEmail(email);
		
		MemberVO mvo = mdao.selectPw(searchmvo);
		
		if(mvo == null) {
			System.out.println("가입되지 않은 회원입니다.");
		} else {
			if( mvo.getName().equals(name) && mvo.getId().equals(id) && mvo.getEmail().equals(email)) {
				System.out.println("회원님의 비밀번호는 " + mvo.getPw() + "입니다."); 
			} else {
				System.out.println("일치하는 회원 비밀번호가 없습니다.");
				System.out.println("1. 다시 시도하기");
				System.out.println("2. 메인 메뉴로 이동하기");
				System.out.print("선택 : ");
				input = scan.nextInt();
				scan.nextLine();
				switch (input) {
				case 1: findPw(); break;
				case 2: menu(); break;
				default: System.out.println("올바른 번호를 입력해 주세요."); findPw(); break;
				}
			}
		}
		 
	}

	// 관리자 전용 모드
	public void adminMenu() throws IOException {
		System.out.println("================ 관리자 메뉴 ===============");
		System.out.println("1. 회원 목록     2. 영화 관리      3. 리뷰 관리");
		System.out.println("4. 설문 관리     5. 로그아웃       6. 종료");
		System.out.print("선택 : ");
		input = scan.nextInt();
		scan.nextLine();

		switch (input) {
		case 1: showAllMember(); break;
		case 2: new MovieMain(scan, id).movieAdmin(); break;
		case 3: new ReviewMain().reviewAdmin(); break;
		case 4: new SurveyMain(scan, id).surveyAdminMenu(); break;
		case 5: logout(); break;
		case 6: 
			System.out.println("================ 시스템 종료 ================");
			System.out.println("시스템을 종료합니다.");
			System.out.println("이용해 주셔서 감사합니다.");
			System.out.println("----------------------------------------");
			System.out.println();
			scan.close(); System.exit(0); break;
		default:
			System.out.println("올바른 번호를 입력해 주세요");
			adminMenu();
			break;
		}

	}
	
	// 회원목록 페이지
	public void showAllMember() throws IOException {
			List<MemberVO> mdaoList = mdao.selectAllmember();
				if (mdaoList == null || mdaoList.size() == 0) {
					System.out.println("가입된 회원이 없습니다.");
	
				} else {
					System.out.println();
					System.out.println("================ 회원 목록 ===============");
					System.out.println("아이디|이름|가입일자");
					SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy년 MM월 dd일");
					for (MemberVO mvo : mdaoList) {
						Date date = mvo.getJoinDate();
						String dateStr = dateFmt.format(date);
						System.out.print(mvo.getId() + "|");
						System.out.print(mvo.getName() + "|");
						System.out.println(dateStr);
	
					} 
				}
				System.out.println("회원 정보를 볼 회원 아이디를 입력하세요");
				System.out.println("관리자 메뉴로 돌아가고 싶을 시 0을 입력하세요");
				System.out.print("입력 : ");
				String searchid = "";
				searchid = scan.nextLine();
				if(searchid == null || searchid.equals("")) {
					System.out.println("올바른 정보를 입력해 주세요.");
					showAllMember();
				} else if(searchid.equals("0")) {
					adminMenu();
				} else {
					memberInfoadmin(searchid);
				}
				
				
		} 
		
	
	// 회원삭제(관리자)
	public void memberRemoveAdmin(String searchid) throws IOException {
		if(searchid == null || searchid.equals("")) {
			searchid = id;
		}

		List<MemberVO> mdaoList = mdao.selectAllmember();

		if (mdaoList == null || mdaoList.size() == 0) { 
			System.out.println("가입된 회원이 없습니다");
			adminMenu();
		} else {
			System.out.println();
			System.out.println("================ 회원 삭제 ===============");
			System.out.print("회원 삭제를 원하시면 y를 입력해 주세요. : ");
			String yesNo = scan.nextLine();

			if (yesNo.equalsIgnoreCase("y")) {
				boolean result = mdao.delete(searchid);
				if (result == true) {
					System.out.println("회원 삭제가 완료되었습니다.");
					showAllMember();
				}
			} else {
				System.out.println("회원 삭제가 취소되었습니다. 이전 메뉴로 이동합니다.");
				showAllMember();
			}
		}

		System.out.println();
		adminMenu();

	}
	
	// 내 정보 수정(회원) 
	public void updateMyinfo(String id) throws IOException {
		MemberVO mvo = new MemberVO();

		System.out.println("============ 회원 정보 상세 보기 ===========");
		System.out.println("수정하실 정보를 입력해 주세요.");
		System.out.print("아이디 : ");
		String newid = scan.nextLine(); 
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("이메일 : ");
		String email = scan.nextLine();
		System.out.print("성별(F/M) : ");
		String gender = scan.nextLine();

		mvo.setId(newid);
		mvo.setPw(pw);
		mvo.setName(name);
		mvo.setEmail(email);
		mvo.setGender(gender);

		boolean result = mdao.update(mvo);
		
		if (result == false) {
			System.out.println("올바른 정보를 모두 입력해 주세요."); 
		}
		
		System.out.println("1. 저장");
		System.out.println("2. 다시 작성하기");
		System.out.println("3. 이전으로 이동하기");
		System.out.print("선택 : ");
		input = scan.nextInt();
		scan.nextLine();
		
		switch(input) {
		case 1 : 
			if(result == true) {
				myPage(); break;
			}
		case 2 : updateMyinfo(id); break;
		case 3 : myPage(); break;
		default : System.out.println("올바른 번호를 입력해 주세요.");
		  		  updateMyinfo(id); break;
		}
		
		
		
	}
	
	// 회원 정보 수정(관리자)
	public void updateMemberinfo(String searchid) throws IOException {
		
		if(searchid == null || searchid.equals("")) {
			searchid = id;
		}
		
		MemberVO mvo = new MemberVO();

		System.out.println("============ 회원 정보 상세 보기 ===========");
		System.out.println("수정하실 정보를 입력해 주세요.");
		System.out.print("아이디 : ");
		String newid = scan.nextLine(); 
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		System.out.print("이름 : ");
		String name = scan.nextLine();
		System.out.print("이메일 : ");
		String email = scan.nextLine();
		System.out.print("성별(F/M) : ");
		String gender = scan.nextLine();

		mvo.setId(newid);
		mvo.setPw(pw);
		mvo.setName(name);
		mvo.setEmail(email);
		mvo.setGender(gender);

		boolean result = mdao.update(mvo);
		
		if (result == false) {
			System.out.println("올바른 정보를 모두 입력해 주세요.");
		}
		
		System.out.println("1. 저장");
		System.out.println("2. 다시 작성하기");
		System.out.println("3. 이전으로 이동하기");
		System.out.print("선택 : ");
		input = scan.nextInt();
		scan.nextLine();
		
		switch(input) {
		case 1 : 
			if(result == true) {
				showAllMember(); break;
			}
		case 2 : updateMyinfo(searchid); break;
		case 3 : showAllMember(); break;
		default : System.out.println("올바른 번호를 입력해 주세요.");
		  		  updateMyinfo(id); break;
		}

	}

	// 비회원 메뉴
	public void guestMain() throws IOException {
		System.out.println("=================== 비회원 메뉴 ===================");
		System.out.println("1. 영화 보기     2.로그인 하기      3. 종료");
		System.out.println("------------------------------------------------");
		System.out.print("선택 :");
		input = scan.nextInt();
		scan.nextLine();
		
		switch (input) {
		case 1: new MovieMain(scan, id).movieMenu(); break;
		case 2: login(); break;
		case 3: 
			System.out.println("=================== 시스템 종료 ===================");
			System.out.println("시스템을 종료합니다");
			System.out.println("이용해 주셔서 감사합니다.");
			System.out.println("------------------------------------------------");
			scan.close();
			System.exit(0);
		default:
			break;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		new MemberMain().menu();

	}

}
