package sistMovie.main;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import sistMovie.dao.MemberDAO;
import sistMovie.dao.SurveyDAO;
import sistMovie.dao.VoteDAO;
import sistMovie.util.DBCon;
import sistMovie.vo.MemberVO;
import sistMovie.vo.MovieVO;
import sistMovie.vo.SurveyVO;
import sistMovie.vo.VoteVO;

//메서드 내부에 있는 건 모두 SurveyMain 이전 것 그대로 썼음
//구체적인 메서드 구현은 참고만 하고 새롭게 만들 것.

public class SurveyMain {
	private static String id;
	private static Scanner scan = new Scanner(System.in);
	private SurveyDAO sdao = new SurveyDAO();
	private VoteDAO vdao = new VoteDAO();
	private int surveyNo;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public SurveyMain(Scanner scan, String id) {
		this.scan = scan;
		this.id = id;
	}

	// 설문 이벤트
	public void surveyMemberMenu() throws IOException {
		System.out.println("===================== 설문 이벤트 ====================");
		System.out.println("1. 설문 목록보기 2. 지난 설문 보기 3. 내가 응모한 설문 보기 ");
		System.out.println("4. 이번주 당첨자  5. 이전으로");
		System.out.println("---------------------------------------------------");
		System.out.print("선택 : ");
		int input = scan.nextInt();
		scan.nextLine();

		switch (input) {
		case 1:
			surveyList();
			break;

		case 2:
			presurveyList();
			break;

		case 3:
			surveyMyList();
			break;

		case 4:
			weeklyWinner();
			break;

		case 5:
			new MemberMain().memberMenu();
			break;

		default:
			System.out.println("올바른 번호를 입력해주세요 : ");
			surveyMemberMenu();
			break;
		}
	}

	// 설문 이벤트 관리(관리자)
	public void surveyAdminMenu() throws IOException {
		System.out.println("===================== 설문 관리 ========================");
		System.out.println("1. 설문 목록　2. 설문 등록 3.이벤트 당첨자 등록 4.메인 메뉴로 이동 ");
		System.out.println("-----------------------------------------------------");
		System.out.print("선택 : ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		switch (input) {
		case 1:
			surveyList();
			break;
		case 2:
			surveyAdd();
			break;
		case 3:
//			surveyWinnerAdd();
			break;
		case 4:
			new MemberMain().adminMenu();
			break;
		default:
			System.out.println("올바른 번호를 입력해 주세요. ");
			surveyAdminMenu();
			break;
		}

	}

	// 설문 목록 출력
	public void surveyList() throws IOException {
		System.out.println("==================== 진행중인 설문조사 목록 =================");
		List<SurveyVO> sdaoList = sdao.selectAllSurvey();

		if (sdaoList == null || sdaoList.size() == 0) { // 만약에 회원 목록이 없다면
			System.out.println("등록된 설문이 없습니다. 이전으로 돌아갑니다.");
			if (id.equalsIgnoreCase("admin")) {
				surveyAdminMenu();
			} else {
				surveyMemberMenu();
			}

		} else {// 그렇지 않다면
			System.out.println();
			System.out.println("설문번호  |  설문 제목  |  참여자수  |  설문 시작일 | 설문종료일");
			System.out.println("--------------------------------------------------------");

			ArrayList<Object> surveyNoList = new ArrayList<>();
			for (SurveyVO svo : sdaoList) {
				System.out.print("[" + svo.getSurveyNo() + "] " + "|");
				System.out.print("[" + svo.getsurveyTitle() + "] " + " | ");
				System.out.print("[" + (svo.getOneCnt() + svo.getTwoCnt()) + "] " + " | ");
				System.out.print("[" + svo.getStartDate() + " ~ ");
				System.out.println(svo.getEndDate() + "] ");
				surveyNoList.add(svo.getSurveyNo());
			}
			System.out.println();
			System.out.println("1. 이전으로	            2. 메인메뉴로 이동");
			System.out.println("설문을 자세히 보기 원하신다면 설문 번호를 입력해주세요.");
			System.out.println("--------------------------------------------------------");
			System.out.print("선택 : ");
			int input = scan.nextInt();
			scan.nextLine();

			if (surveyNoList.contains(input)) {
				int surveyNoNow = input;
				surveyDetail(surveyNoNow);
			}

			else if (input == 1) {
				if (id.equalsIgnoreCase("admin")) {
					surveyAdminMenu();
				} else {
					surveyMemberMenu();
				}
			} else if (input == 2) {
				if (id.equalsIgnoreCase("admin")) {
					new MemberMain().adminMenu();
				} else if (id != null) { // 회원인 경우
					new MemberMain().memberMenu();
				} else {
					new MemberMain().guestMain();
				}

			} else {
				System.out.println("올바른 번호를 입력해주세요.");
				surveyList();
			}

		}
	}

	// 지난 설문 보기
	public void presurveyList() throws IOException {

		System.out.println("======================= 지난 설문 목록 ====================");
		List<SurveyVO> sdaoList = sdao.selectPreSurvey();
		ArrayList<Object> presurveyNoList = new ArrayList<>();

		if (sdaoList == null || sdaoList.size() == 0) { // 만약에 회원 목록이 없다면
			System.out.println("지난 설문이 없습니다.이전 메뉴로 돌아갑니다.");
			surveyMemberMenu();

		} else {// 그렇지 않다면
			System.out.println();
			for (SurveyVO svo : sdaoList) {
				System.out.print(svo.getSurveyNo() + ". ");
				System.out.print(svo.getsurveyTitle() + " ");
				System.out.print("[" + svo.getOne() + ", ");
				System.out.print(svo.getTwo() + "]");
				presurveyNoList.add(svo.getSurveyNo());
			}

			System.out.println();
			System.out.println("1. 이전으로	            2. 메인메뉴로 이동");
			System.out.println("설문을 자세히 보기 원하신다면 설문 번호를 입력해주세요.");
			System.out.println("--------------------------------------------------------");
			System.out.print("선택 : ");
			int input = scan.nextInt();
			if (presurveyNoList.contains(input)) {
				int surveyNoNow = input;
				surveyDetail(surveyNoNow);
			} else if (input == 1) {
				surveyMemberMenu();
			} else {
				System.out.println("올바른 번호를 입력해주세요.");
				presurveyList();
			}
		}

	}

	/*
	 * 설문 하나 보기 (선택) // 1. 설문 목록 2. 설문 등록 3. 메인메뉴 가기 4. 종료 1.1 설문 하나 보기(선택) (이거 선택하면
	 * 댓글 나오게)
	 */
	public void surveyView(int surveyNo) throws IOException {
	};

	// 설문 자세히 보기
	public void surveyDetail(int surveyNoNow) throws IOException {
		SurveyVO svo = sdao.selectSurvey(surveyNoNow);
		System.out.println();
		System.out.println("============ [" + svo.getsurveyTitle() + "] ===========");
		System.out.println("[전체 참여자 수 : " + (svo.getOneCnt() + svo.getTwoCnt()) + "]");
		System.out.println("[" + svo.getOne() + "] : [" + svo.getOneCnt() + "] VS [" + svo.getTwo() + "] : +["
				+ svo.getTwoCnt() + "]");
		System.out.println("[" + svo.getStartDate() + "] | [" + svo.getEndDate() + "]");

		if (id.equals("admin")) { // 관리자의 경우 - 수정 삭제 메뉴 표시
			System.out.println("1. 설문 수정     2. 설문 삭제    3.이전으로");
			System.out.println("-------------------------------------------------------------");
			System.out.print(" 선택 : ");
			int input = scan.nextInt();
			scan.nextLine();

			if (input == 1) {
				surveyModify(surveyNoNow);
			} else if (input == 2) {
				surveyRemove(surveyNoNow);
			} else if (input == 3) {
				surveyList();
			} else {
				System.out.println("올바른 번호를 입력해주세요.");
				System.out.println();
				surveyDetail(surveyNoNow);
			}

		} else if (id != null) { // ★
			// 회원인 경우
			VoteVO vvo = new VoteVO();

			if (sdao.surveyCheckId(id) == true) {
				System.out.println("1. 돌아가기");
				System.out.println("-------------------------------------------------------------");
				System.out.print("입력 : ");
				int input = scan.nextInt();
				scan.nextLine();

				if (input == 1) { // 돌아가기
					surveyList();
				} else {
					System.out.println("올바른 번호를 입력해주세요.");
					surveyDetail(surveyNoNow);
				}
			}

			else { // 설문에 미참여한 회원
				System.out.println("1. 설문 참여하기	2.돌아가기");
				System.out.println("-------------------------------------------------------------");
				System.out.print("입력 : ");
				Scanner scan = new Scanner(System.in);
				int input = scan.nextInt();
				scan.nextLine();

				if (input == 1) { // 참여하기
					surveyAttend(surveyNoNow);
				} else if (input == 2) {
					surveyList();
				} else {
					System.out.println("올바른 번호를 입력해주세요.");
					surveyDetail(surveyNoNow);
				}
			}
		}

		else { // 비회원인 경우
			System.out.println("1. 돌아가기");
			System.out.println("-------------------------------------------------------------");
			System.out.print("입력 : ");
			int input = scan.nextInt();
			scan.nextLine();

			if (input == 1) { // 돌아가기
				new MemberMain().guestMain();
			} else {
				System.out.println("올바른 번호를 입력해주세요.");

			}

		}

	}

	// 이번주 당첨자 ★이거 쿼리만들때 vote에서 설문일 종료된사람 중 랜덤으로 뽑는듯?? 나중에 다시..
	public void weeklyWinner() throws IOException {
		
		
		System.out.println();
		System.out.println("=========================이번 달 당첨자 확인 =========================");
		System.out.println("                       ★ 당첨을 축하드립니다 ★");
		List<VO> surveyList = sdao.drawWinner();
		// dao에서 selectwinnerlist에서 이름만 가져오기
		if (movieList == null || movieList.size() < 1) {
			System.out.println("당첨을 완료한 설문이 없습니다.");
		} else {// 그렇지 않다면
			System.out.println("영화번호|영화제목|평점|개봉일자");
			System.out.println("---------------------------------------------------------------");
			for (MovieVO mvvo : movieList) {
				System.out.println(mvvo.getMovieNo() + "|" + mvvo.getMovieName() + "|" + mvvo.getScore() + "|"
						+ mvvo.getReleaseDate());

			}
		}

		System.out.println("0. 메인 메뉴");

		System.out.println("-----------------------------------------------------------------");
		System.out.print("선택 : ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		scan.nextLine();

		if (input == 0) {
			surveyMemberMenu();
		} else {
			System.out.println("올바른 번호를 입력해주세요.");
			weeklyWinner();
		}

	}

	// 내가 응모한 설문
	public void surveyMyList() throws IOException {
		System.out.println();
		System.out.println("=======================내가 응모한 설문 목록==========================");
		List<SurveyVO> sdaoList = sdao.selectMySurvey(id); // ★id 받아오는거
		List<VoteVO> vdaoList = vdao.selectMyVote(id);
		ArrayList<Object> mysurveyNoList = new ArrayList<>();

		if ((sdaoList == null || sdaoList.size() == 0) || (vdaoList == null || vdaoList.size() == 0)) { // 만약에 회원 목록이
																										// 없다면
			System.out.println("참여한 설문이 없습니다. 이전으로 돌아갑니다.");
			surveyMemberMenu();

		} else {// 참여한 설문이 있으면

			for (int i = 0; i < sdaoList.size(); i++) {
				SurveyVO svo = sdaoList.get(i);
				VoteVO vvo = vdaoList.get(i);

				System.out.println(svo.getSurveyNo());
				System.out.print(svo.getsurveyTitle() + " ");
				System.out.print("[ " + svo.getOne() + " vs " + svo.getTwo() + " ] ->");
				System.out.print("나의 선택 : " + vvo.getOneTwo() + ", ");
				System.out.println("등록일자 : " + vvo.getVoteDate());
				mysurveyNoList.add(svo.getSurveyNo());
			}

			System.out.println();
			System.out.println("0. 메인 메뉴");
			System.out.println("자세히 보고 싶은 설문을 선택해주세요.");
			System.out.println("-----------------------------------------------------------------");
			System.out.println("선택 : ");
			int input = scan.nextInt();
			scan.nextLine();

			if (mysurveyNoList.contains(input)) {
				int surveyNoNow = input;
				surveyDetail(surveyNoNow);
			} else if (input == 0) {
				surveyMemberMenu();
			} else {
				System.out.println("올바른 번호를 입력해주세요.");
				surveyMyList();
			}
		}
	}

	// 설문 등록
	public void surveyAdd() throws IOException {
		// 설문번호, 설문제목, 참여자 수, 진행기간
		// 2022.10.31 ~ 진행 중
		// 2022.10.24 ~ 2022.10.30

		SurveyVO svo = new SurveyVO();

		System.out.println("================= 설문 등록 ====================");
		System.out.println("등록하실 설문의 정보를 입력해 주세요.");
		System.out.print("설문 제목 : ");
		String title = scan.nextLine();
		System.out.print("설문 항목 1 : ");
		String one = scan.nextLine();
		System.out.print("설문 항목 2 : ");
		String two = scan.nextLine();
		System.out.print("설문 시작일 : ");
		String startDate = scan.nextLine();

		svo.setsurveyTitle(title);
		svo.setOne(one);
		svo.setTwo(two);
		svo.setStartDate(startDate);

		boolean insertCheck = sdao.insertSurvey(svo);
		try {
			if (insertCheck == true) {
				System.out.println("------------------------------------------------------------------------");
				System.out.println("1. 저장	2. 이전으로");
				System.out.println("선택 : ");
				int inputt = scan.nextInt();
				scan.nextLine();

				if (inputt == 1) {
					System.out.println("설문 등록이 완료되었습니다. 이전 메뉴로 돌아갑니다.");
					surveyAdminMenu();
				} else if (inputt == 2) {
					System.out.println("이전 메뉴로 돌아갑니다.");
					surveyAdminMenu();
				} else {
					System.out.println("올바른 번호를 입력해주세요.");
					surveyAdd();
				}

			} else {
				System.out.println("입력하지 않은 정보가 있어 등록이 완료되지 않았습니다. 이전 메뉴로 돌아갑니다.");
				surveyAdminMenu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ★설문 이벤트 당첨자 등록
	public void surveyWinnerAdd() throws IOException, SQLException {
		List<SurveyVO> sdaoList = sdao.selectPreSurvey();
		System.out.println("================= 설문 이벤트 당첨자 등록 ====================");
		System.out.println("설문에 참여한 인원 중 당첨자를 랜덤으로 추첨합니다.");
		System.out.println("당첨자를 추첨할 설문 번호를 선택해주세요.");
		System.out.println();
		System.out.println("설문번호  |  설문 제목  |  참여자수  |  설문 시작일 | 설문종료일");
		System.out.println("--------------------------------------------------------");

		ArrayList<Object> surveyNoList = new ArrayList<>();
		for (SurveyVO svo : sdaoList) {
			System.out.print("[" + svo.getSurveyNo() + "] " + "|");
			System.out.print("[" + svo.getsurveyTitle() + "] " + " | ");
			System.out.print("[" + (svo.getOneCnt() + svo.getTwoCnt()) + "] " + " | ");
			System.out.print("[" + svo.getStartDate() + " ~ ");
			System.out.println(svo.getEndDate() + "] ");
			surveyNoList.add(svo.getSurveyNo());
		}
		System.out.println();
		System.out.println("1. 이전으로");
		System.out.println("--------------------------------------------------------");
		System.out.print("선택 : ");
		int input = scan.nextInt();
		scan.nextLine();

		if (surveyNoList.contains(input)) {
			int surveyNoNow = input;
			System.out.println("<<< 추첨 결과>>>");
			String winner = sdao.drawWinner(surveyNoNow);
			System.out.println("설문번호 " + surveyNoNow + "의 당첨자 ID : " + winner);
		}

		else if (input == 1) {
			System.out.println("이전으로 돌아갑니다.");
			surveyAdminMenu();
		} else {
			System.out.println("올바른 번호를 입력해주세요.");
			surveyWinnerAdd();
		}
	}

	// 설문 수정
	public void surveyModify(int surveyNoNow) throws IOException {
		System.out.println("================= 설문 수정 ====================");
		SurveyVO svo = new SurveyVO();
		int input = scan.nextInt();
		scan.nextLine();

		System.out.println("수정하실 정보를 입력해주세요.");
		System.out.print("새로운 제목을 입력해주세요 : ");
		String title = scan.nextLine();
		System.out.print("새로운[설문 항목1]을 입력해주세요 : ");
		String one = scan.nextLine();
		System.out.print("새로운[설문 항목2]를 입력해주세요 : ");
		String two = scan.nextLine();
		System.out.println("새로운 시작일자를 입력해주세요 [yyyy.mm.dd]:");
		String startDate = scan.nextLine();

		svo.setsurveyTitle(title);
		svo.setOne(one);
		svo.setTwo(two);
		svo.setStartDate(startDate);

		boolean result = sdao.updateSurvey(svo, surveyNoNow);
		boolean insertCheck = sdao.insertSurvey(svo);
		if (insertCheck == true) {
			if (result == true) {
				System.out.println("설문 수정이 완료되었습니다. 이전 메뉴로 돌아갑니다.");
				surveyAdminMenu();
			} else if (result == false) {
				System.out.println("설문 수정에 실패하였습니다. 이전 메뉴로 돌아갑니다.");
				surveyAdminMenu();
			}
		} else {
			System.out.println("입력하지 않은 정보가 있어 수정이 완료되지 않았습니다. 이전 메뉴로 돌아갑니다.");
			surveyAdminMenu();
		}
	}

	// 설문 삭제
	public void surveyRemove(int surveyNoNow) throws IOException {
		System.out.println("================= 설문 삭제 ====================");
		System.out.print("해당 설문을 삭제하시겠습니까? (y)");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("입력 : ");
		Scanner scan = new Scanner(System.in);
		String yesNo = scan.nextLine();
		scan.nextLine();

		if (yesNo.equalsIgnoreCase("y")) {
			boolean result = sdao.deleteSurvey(surveyNoNow);
			if (result == true) {
				System.out.println("설문 삭제가 완료되었습니다. 이전 메뉴로 돌아갑니다.");
				surveyDetail(surveyNoNow);
			}
		} else {
			System.out.println("설문 삭제가 취소되었습니다. 이전 메뉴로 돌아갑니다.");
			surveyDetail(surveyNoNow);
		}
	}

	// 설문 참여
	public void surveyAttend(int surveyNoNow) throws IOException {

		System.out.println();
		SurveyVO svo = sdao.selectForAttend();
		int survey_no = sdao.insertVoteChk();
		if (survey_no == 0) {
			System.out.println("진행중인 설문이 없습니다. 이전으로 돌아갑니다.");
			surveyDetail(surveyNoNow);
		} else {
			System.out.println("==================================설문 참여========================================");
			System.out.println("★설문에 참여하신 분들 중 랜덤으로 소정의 상품이 지급됩니다.★");
			System.out.println("설문기간 : " + svo.getStartDate() + " ~ " + svo.getEndDate());
			System.out.println();
			System.out.println(svo.getsurveyTitle());
			System.out.println();
			System.out.println("1 : " + svo.getOne());
			System.out.println();
			System.out.println("2 : " + svo.getTwo());
			System.out.println();
			System.out.println("1 또는 2를 선택해주세요.");
			System.out.println("---------------------------------------------------------------------------------");
			System.out.print(" >> 선택 : ");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			scan.nextLine();

			// 1,2입력 안했을 경우
			if (input != 1 && input != 2) {
				System.out.println("올바른 번호를 입력해주세요.");
				surveyAttend(surveyNoNow);
			} else { // 설문 1 2 올바르게 입력했을 경우
				System.out.println();
				System.out.println("1. 저장 2. 이전으로");
				System.out.println("입력 : ");
				int inputtt = scan.nextInt();
				scan.nextLine();
			}
		}

//		if(inputtt==1) { //저장할건지  밑에 updatecnt 에러떠서 막아놨어요 
//			boolean result = sdao.updateCnt(svo, inputtt, id, surveyNoNow);	//★	
//			switch (inputtt) { //설문 1번 2번 중 어디에 했는지  
//			case 1:
//				if (result==true) {		
//					System.out.println("1번 " + svo.getcontent1() + "에 투표하셨습니다.");
//					System.out.println("설문에 참여해 주셔서 감사합니다. 회원 메뉴로 이동합니다.");
//					new MemberMain().memberMenu();					
//					} else if(result==false) {
//					System.out.println("설문 참여에 실패하였습니다. 이전 메뉴로 돌아갑니다.");
//					surveyDetail(surveyNoNow);}
//					break;	
//
//				case 2:
//					if (result==true) {		
//					System.out.println("2번" + svo.getcontent2() + "에 투표하셨습니다.");
//					System.out.println("설문에 참여해 주셔서 감사합니다. 회원 메뉴로 이동합니다.");
//					new MemberMain().memberMenu(); }
//					else if(result==false) {
//					System.out.println("설문 참여에 실패하였습니다. 이전 메뉴로 돌아갑니다.");
//					surveyDetail(surveyNoNow);}
//					break;	}}
//			else if(inputtt==2)	{ //이전으로 돌아가기 
//				System.out.println("이전 메뉴로 이동합니다.");
//				surveyDetail(surveyNoNow);
//			}
//			
//		else { //1.저장 2.이전으로 외의 다른 값 입력
//				System.out.println("올바른 번호를 입력해주세요.");
//				surveyAttend(surveyNoNow);
//				}
//		}	}
	}

	public static void main(String[] args) throws IOException {
//			DBCon.getConnection();
		new SurveyMain(scan, id).surveyMemberMenu();
	}
}
