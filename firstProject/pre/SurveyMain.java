package sistMovie.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import sistMovie.dao.MemberDAO;
import sistMovie.main.MemberMain;
import sistMovie.vo.MemberVO;
import sistMovie.dao.SurveyDAO;
import sistMovie.dao.VoteDAO;
import sistMovie.util.DBCon;
import sistMovie.vo.SurveyVO;
import sistMovie.vo.VoteVO;

//메서드 내부에 있는 건 모두 SurveyMain 이전 것 그대로 썼음
//구체적인 메서드 구현은 참고만 하고 새롭게 만들 것.

 
public class SurveyMain {
	private SurveyDAO sdao = new SurveyDAO();
	private VoteDAO vdao = new VoteDAO();
	private int surveyNo;


	// 설문 이벤트
	public void surveyMemberMenu() throws IOException {
		System.out.println("------- 설문조사 for Member -------");
		System.out.println("1. 설문 목록     2.내 설문 보기      " + "3. 설문 참여하기      4.메인메뉴 가기     5. 종료");
		System.out.print(" >> 선택 : ");
		int input = scan.nextInt();
		scan.nextLine();
		// 1. 설문 목록 2. 내 설문 보기 3. 메인메뉴 가기 4. 종료
		// 1.1 설문 참여하기

		switch (input) {
		case 1:
			surveyList();
			break;

		case 2:
			surveyMyList();
			break;

		case 3:
			surveyAttend();
			break;

		case 4:
			new MemberMain().memberMenu();
			break;

		case 5:
			System.out.println(">> 시스템을 종료합니다");
			scan.close();
			System.exit(0);

		default:
			System.out.println(">> 올바른 숫자를 선택해주세요");
			break;
		}
	}

	// 설문 이벤트 관리(관리자)
	public void surveyAdminMenu() throws IOException {
		// 1. 설문 목록 2. 설문 등록 3. 메인메뉴 가기 4. 종료
		// 1.1 설문 하나 보기(선택) (이거 선택하면 댓글 나오게)
		// 1.1.1 설문 수정(위에서 고른 것)
		// 1.1.2 설문 삭제

		System.out.println("------- 설문관리 for Administrator -------");
		System.out.println("1. 설문 목록     2.설문 등록      " + "3. 메인메뉴 가기     4. 종료");
		System.out.print(" >> 선택 : ");
		int input = scan.nextInt();
		scan.nextLine();

		switch (input) {
		case 1:
			surveyList();
			break;
		case 2:
			surveyAdd();
			break;
		case 3:
			new MemberMain().adminMenu();
			break;
		case 4:
			System.out.println(">> 시스템을 종료합니다");
			scan.close();
			System.exit(0);
		default:
			System.out.println(">> 올바른 숫자를 선택해주세요");
			break;
		}

	}

	// 설문 목록 출력
	public void surveyList() throws IOException {
		System.out.println("------- 설문 목록 -------");
		List<SurveyVO> sdaoList = sdao.selectAllSurvey();

		if (sdaoList == null || sdaoList.size() == 0) { // 만약에 회원 목록이 없다면
			System.out.println(">> 등록된 설문이 없습니다");

		} else {// 그렇지 않다면
			System.out.println();
			System.out.println("번호 |   설문 제목   | 참여자 수 " 
												+ "|  시작일자 ~ 끝 일자");
			System.out.println("------------------------------------");

			for (SurveyVO svo : sdaoList) {

				System.out.print(svo.getSurveyNo() + " | ");
				System.out.print(svo.getTitle() + " | ");
				System.out.print((svo.getOneCnt() + svo.getTwoCnt()) + " | ");
//				System.out.print(svo.getOne() + " vs ");
//				System.out.print(svo.getTwo() + " | ");
				System.out.print(svo.getStartDate() + " ~ ");
				System.out.println(svo.getEndDate() + " | ");
				
			}
			System.out.println();
		if (id.equalsIgnoreCase("admin")) {
			System.out.println("1. 설문 상세 보기,   2~9999999. 돌아가기");
			System.out.print(" >> 선택 : ");
			int input = scan.nextInt();
			scan.nextLine();

			if (input == 1) {
				System.out.println("보기 원하는 설문의 번호를 입력해주세요");
				System.out.print(" >> 선택 : ");
				input = scan.nextInt();
				surveyNoNow=input;
				scan.nextLine();
				surveyView(surveyNoNow);
			} else {
				adminMenu();
			}
			
			
		} else {
			System.out.println("--------------------------------------");
			System.out.println("1. 진행중인 설문 참여하기   2~999999. 돌아가기");
			System.out.print(" >> 선택 : ");
			int input = scan.nextInt();
			scan.nextLine();

			if (input == 1) {
				surveyAttend();
			} else {
				memberMenu();
			}
			
			
			
		}
			
		}

	}

	//지난 설문 보기
	public void presurveyList() {}
	
	// 설문 하나 보기
	public void surveyView(int surveyNo) throws IOException {
		SurveyVO svo = sdao.selectSurvey(surveyNoNow);

		System.out.println();
		System.out.println("------- 설문 정보 -------");

		System.out.println("타이틀 : " + svo.getTitle());
		System.out.println("선택지 : < " + svo.getOne() + " > vs < " + svo.getTwo() +" >");
		System.out.println("득표수 : < " + svo.getOneCnt() + " > vs < " + svo.getTwoCnt() + " >");
		System.out.println("진행일자 : " + svo.getStartDate() + " ~ " + svo.getEndDate() );
		System.out.println("등록일자 : " + svo.getRegDate());
		System.out.println("수정일자 : " + svo.getModDate());

		System.out.println("-------------------");
		System.out.println("1. 설문 수정     2. 설문 삭제    3. 관리자 메뉴로 돌아가기");
		System.out.print(" >> 선택 : ");

		int input = scan.nextInt();
		scan.nextLine();
		
		switch (input) {
		case 1:
			surveyModify();
			break;

		case 2:
			surveyRemove();
			break;
			
		case 3:
			adminMenu();
			break;
		}
	}

	//설문 자세히 보기
	public void surveyDetail(int surveyNo) {}
	
	//이번주 당첨자
	public void weeklyWinner() {}
	
	// 내가 응모한 설문
	public void surveyMyList() throws IOException {
		System.out.println();
		System.out.println("--------내가 참여한 설문 목록---------");
		List<SurveyVO> sdaoList = sdao.selectMySurvey(id);
		List<VoteVO> vdaoList = vdao.selectMyVote(id);

		if ((sdaoList == null || sdaoList.size() == 0) || (vdaoList == null || vdaoList.size() == 0)) { // 만약에 회원 목록이 없다면
			System.out.println(">> 등록된 설문이 없습니다");

		} else {// 그렇지 않다면
			System.out.println("   설문 제목    |  항목1  vs  항목2  " 
												+ " | 나의 선택 |  등록일자 ");
			System.out.println("--------------------------------------------");

//			for (SurveyVO svo : sdaoList) {
//
//				System.out.print(svo.getTitle() + " | ");
//				System.out.print(svo.getOne() + " vs " + svo.getTwo() + " | ");
//				
//			}
//			for (VoteVO vvo : vdaoList) {
//				System.out.print(vvo.getOneTwo() + " | ");
//				System.out.print(vvo.getVoteDate() + " ");
				
				
			for (int i = 0; i < sdaoList.size(); i++) {
				SurveyVO svo = sdaoList.get(i);
				VoteVO vvo = vdaoList.get(i);
				
				System.out.print(svo.getTitle() + " | ");
				System.out.print(svo.getOne() + " vs " + svo.getTwo() + " | ");
				System.out.print(vvo.getOneTwo() + " | ");
				System.out.println(vvo.getVoteDate() + " ");
			}
			
			System.out.println();
			memberMenu();
		}
	}

	// 설문 등록
	public void surveyAdd() throws IOException {
		// 설문번호, 설문제목, 참여자 수, 진행기간
		// 2022.10.31 ~ 진행 중
		// 2022.10.24 ~ 2022.10.30

		SurveyVO svo = new SurveyVO();
		SurveyOverlapCheck solc = new SurveyOverlapCheck();

		System.out.println(" >> 설문 등록중");
		System.out.print("    설문 제목 : ");
		String title = scan.nextLine();
		System.out.print("    설문 항목 1 : ");
		String one = scan.nextLine();
		System.out.print("    설문 항목 2 : ");
		String two = scan.nextLine();
		System.out.print("    설문 시작일 : ");
		String startDate = scan.nextLine();

		svo.setTitle(title);
		svo.setOne(one);
		svo.setTwo(two);
		svo.setStartDate(startDate);
		
		boolean overLapCheck = solc.serveyOverlapCheck(svo);
		if (overLapCheck) {
			System.out.println("   겹치는 날짜의 설문이 있습니다.");
			System.out.println("   설문 등록에 실패하셨습니다.");
		} else {
		
		boolean insertCheck = sdao.insertSurvey(svo);

		try {
			if (insertCheck) {
				System.out.println("   설문 등록이 완료되었습니다");
				adminMenu();

			} else {
				System.out.println("   설문 등록에 실패하셨습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		}
		adminMenu();
	} 

	// 설문 수정
	public void surveyModify(int surveyNo) throws IOException {
		System.out.println("-- 선택한 설문을 변경합니다 --");
		SurveyVO svo = new SurveyVO();
		
		System.out.print("새로운 타이틀을 입력해주세요 : ");
		String title = scan.nextLine();
		System.out.print("[새로운 항목1]을 입력해주세요 : ");
		String one = scan.nextLine();
		System.out.print("[새로운 항목2]를 입력해주세요 : ");
		String two = scan.nextLine();
		System.out.println("새로운 시작일자를 입력해주세요 [yyyy.mm.dd 형식]:");
		String startDate = scan.nextLine();
		
		svo.setTitle(title);
		svo.setOne(one);
		svo.setTwo(two);
		svo.setStartDate(startDate);
		
		boolean result = sdao.updateSurvey(svo, surveyNoNow);
		
		if (result == true) {
			System.out.println("   설문 변경이 완료되었습니다");
			adminMenu();
		} else {
			System.out.println("	설문 변경에 실패하셨습니다.");
		}
	}

	// 설문 삭제
	public void surveyRemove(int surveyNo) throws IOException {
		System.out.println(">> 정말로 지우시겠습니까?");
		System.out.print(">> 지우시려면 y를 입력해주세요 : ");
		String yesNo = scan.nextLine();

		if (yesNo.equalsIgnoreCase("y")) {
			boolean result = sdao.deleteSurvey(surveyNoNow);
			if (result == true) {
				System.out.println(">> 설문 삭제가 완료되었습니다.");
			}
		} else {
			System.out.println(">>설문 삭제가 취소되었습니다.");
		}
		System.out.println();
		surveyList();
	}

	// 설문 참여
	public void surveyAttend(int surveyNo) throws IOException {
		
		System.out.println();
		SurveyVO svo = sdao.selectForAttend();
		
		if (svo == null) {
			System.out.println("진행중인 설문이 없습니다");
		} else {
		System.out.println("------- 두근두근 신나는 설문 조사! -------");

		System.out.println("설문 진행일자 : " + svo.getStartDate() + " ~ " + svo.getEndDate() );
		System.out.println();
		System.out.println("질문 : [[[ " + svo.getTitle() + " ]]]");
		System.out.println("      >>>>>>>>> 당신의 선택은??? <<<<<<<<<<     ");
		System.out.println("1 : < " + svo.getOne() + " >  vs  2 : < " + svo.getTwo() + " > ");
		System.out.println("-----------------------------------------     ");
		System.out.println("3. 댓글보기         4. 메뉴로 돌아가기   ");
		System.out.print(" >> 선택 : ");

		int input = scan.nextInt();
		scan.nextLine();
		
		switch (input) {
		case 1:
			sdao.attend(svo ,id, input);
			System.out.println(" >> 1번 " + svo.getOne() + "에 투표하셨습니다");
			break;

		case 2:
			sdao.attend(svo ,id, input);
			System.out.println(" >> 2번 : " + svo.getTwo() + "에 투표하셨습니다");
			break;
		case 3:
			System.out.println("댓글을 보러 갑니다~");
			System.out.println("구현중입니다...");
			break;
		case 4:
			memberMenu();
			break;
		}
		
		System.out.println();
		memberMenu();
		}
		//1. 질문 띄우기 SELECT
		//	타이틀, 선택지
		//-------- 트랜젝션 시작----------
		//2. 1 혹은 2번 입력받기
		//3. t_vote에 참가 데이터 넣기
		//4. UPDATE로 1 혹은 2번 카운트 올리기
		//-------- 트랜젝션 끝 ----------
		//5. 참여 완료 띄우기
		
		// 질문 두개가 뜨고
		// 선택한 것에 대해서

		// - 여기부터는 DAO에서 하기.
		// survey테이블에서는 득표수를 하나 올리고(update)
		// 설문참여 테이블에서는 insert하나 해야됨.
	}


}
