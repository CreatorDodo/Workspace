package exam.main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import exam.dao.MemberDAO;
import exam.vo.MemberVO;
import exam.vo.SurveyDAO;
import exam.vo.SurveyVO;
import exam.vo.VoteVO;

public class SurveyMain {
	private Scanner scan;
	private int input;
	private SurveyDAO sdao = new SurveyDAO();
	private String id;

	// 설문 메뉴
	public SurveyMain(Scanner scan, String id) {
		this.scan = scan;
		this.id = id;
	}

	// 설문 관리자 메뉴
	public void adminmenu() throws IOException {
		// 1.설문 목록 2.설문 등록 3.메인 메뉴가기 4.종료
		// 1.1설문 하나 보기
		// 1.1.1설문 수정
		// 1.1.2설문 삭제
		System.out.println();
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(">> 설문 관리자 메뉴 --------");
		System.out.println("1.설문 목록	\t2.설문 등록 \t3.메인 메뉴 \t4.종료");
		System.out.print(">> 선택 : ");
		input = scan.nextInt();

		if (input == 1) {
			surveyList();
		} else if (input == 2) {
			surveyAdd();
		} else if (input == 3) {
			new MemberMain().adminMenu();
		} else if (input == 4) {
			System.out.println(">> 시스템을 종료합니다");
			System.exit(0);
		} else {
			System.out.println(">> 1 ~ 3 중에 하나를 선택해주세요.");
			System.out.println();
		}
	}

	// 설문 회원 메뉴
	public void memberMenu() throws IOException {
		// 1.설문 목록 1.1.설문 참여 2.내 설문 보기 3. 메인 메뉴가기 4.종료
		System.out.println();
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(">> 설문 회원 메뉴 --------");
		System.out.println("     1.설문 목록");
		System.out.println("     2.내 설문 보기");
		System.out.println("     3.설문 참여");
		System.out.println("     4.메인 메뉴");
		System.out.println("     5.종료");
		System.out.print(">> 선택 : ");
		input = scan.nextInt();

		if (input == 1) {
			surveyList();
		} else if (input == 2) {
			surveyMyList();
		} else if (input == 3) {
			surveyAttend();
		} else if (input == 4) {
			new MemberMain().memberMenu();
		} else if (input == 5) {
			System.out.println(">> 시스템을 종료합니다");
			System.exit(0);
		} else {
			System.out.println(">> 1 ~ 3 중에 하나를 선택해주세요.");
			System.out.println();
		}

	}

	public void surveyMyList() throws IOException {
		// 설문번호, 설문제목, 참여자 수, 진행기간
				// 2022.10.31 ~ 진행 중
				// 2022.10.24 ~ 2022.10.30

				List<SurveyVO> surveyList = sdao.voteAllList(id);
				if (surveyList == null || surveyList.size() < 1) {
					System.out.println(">> 등록된 설문이 없습니다.");
				} else {// 그렇지 않다면
					System.out.println("설문번호|설문시작일 - 설문종료일|참여자 수|설문 제목");
					System.out.println("------------------------------------------------");
					for (SurveyVO svo : surveyList) {
						System.out.println(svo.getSurveyNo() + "|" + svo.getStartDate() + "~" + svo.getEndDate() + "|"
								+ (svo.getOneCnt() + svo.getTwoCnt()) + "|" + svo.getTitle());

					}

					System.out.println();
					System.out.println(">> 1.상세보기 \t2.메뉴");
					System.out.print(">> 선택 : ");
					input = scan.nextInt();
					if (input == 1) {
						System.out.println();
						System.out.println(">> 확인하실 설문번호를 입력해주세요.");
						System.out.print(">> 선택 : ");
						int survey = scan.nextInt();
						surveyView(survey);
						if (id.equals("admin")) {
							System.out.println("===========================");
							System.out.println("1. 설문 수정 2. 설문 삭제 3. 이전으로");
							System.out.print(">> 선택 : ");
							survey = scan.nextInt();
							scan.nextLine();
							if (survey == 1) {
								System.out.println();
								if (surveyList == null || surveyList.size() < 1) {
									System.out.println(">> 등록된 설문이 없습니다.");
								} else {// 그렇지 않다면
									System.out.println("설문번호|설문시작일 - 설문종료일|참여자 수|설문 제목");
									System.out.println("------------------------------------------------");
									for (SurveyVO svo : surveyList) {
										System.out.println(svo.getSurveyNo() + "|" + svo.getStartDate() + "~" + svo.getEndDate()
												+ "|" + (svo.getOneCnt() + svo.getTwoCnt()) + "|" + svo.getTitle());

									}
								}
								System.out.println();
								System.out.print(">> 수정하실 설문번호를 선택해주세요. : ");
								int survey_no = scan.nextInt();
								scan.nextLine();
								surveyModify(survey_no);
							} else if (survey == 2) {
								surveyRemove();
							} else if (survey == 3) {
								adminmenu();
							} else {
								System.out.println(">> 1 ~ 3 중에 하나를 선택해주세요.");
								System.out.println();
							}

						} else { // 관리자가 아닐 경우 - 설문 참여 메뉴 표시
							System.out.println("===========================");
							System.out.println("1. 내 설문 보기 2. 설문 참여 3. 이전으로");
							System.out.print(">> 선택 : ");
							survey = scan.nextInt();
							if (survey == 1) {
								surveyMyList();
							} else if (survey == 2) {
								surveyAttend();
							} else if (survey == 3) {
								memberMenu();
							} else {
								System.out.println(">> 1 ~ 3 중에 하나를 선택해주세요.");
								System.out.println();
							}
						}
					} else if (input == 2) {
						if (id.equals("admin")) {
							adminmenu();
						} else {
							memberMenu();
						}
					} else {
						System.out.println(">> 1 ~ 2 중에 하나를 선택해주세요.");
						System.out.println();
					}

				}
			}


	// 설문 목록 출력
	public void surveyList() throws IOException {
		// 설문번호, 설문제목, 참여자 수, 진행기간
		// 2022.10.31 ~ 진행 중
		// 2022.10.24 ~ 2022.10.30

		List<SurveyVO> surveyList = sdao.selectAllList();
		if (surveyList == null || surveyList.size() < 1) {
			System.out.println(">> 등록된 설문이 없습니다.");
		} else {// 그렇지 않다면
			System.out.println("설문번호|설문시작일 - 설문종료일|참여자 수|설문 제목");
			System.out.println("------------------------------------------------");
			for (SurveyVO svo : surveyList) {
				System.out.println(svo.getSurveyNo() + "|" + svo.getStartDate() + "~" + svo.getEndDate() + "|"
						+ (svo.getOneCnt() + svo.getTwoCnt()) + "|" + svo.getTitle());

			}

			System.out.println();
			System.out.println(">> 1.상세보기 \t2.메뉴");
			System.out.print(">> 선택 : ");
			input = scan.nextInt();
			if (input == 1) {
				System.out.println();
				System.out.println(">> 확인하실 설문번호를 입력해주세요.");
				System.out.print(">> 선택 : ");
				int survey = scan.nextInt();
				surveyView(survey);
				if (id.equals("admin")) {
					System.out.println("===========================");
					System.out.println("1. 설문 수정 2. 설문 삭제 3. 이전으로");
					System.out.print(">> 선택 : ");
					survey = scan.nextInt();
					scan.nextLine();
					if (survey == 1) {
						System.out.println();
						if (surveyList == null || surveyList.size() < 1) {
							System.out.println(">> 등록된 설문이 없습니다.");
						} else {// 그렇지 않다면
							System.out.println("설문번호|설문시작일 - 설문종료일|참여자 수|설문 제목");
							System.out.println("------------------------------------------------");
							for (SurveyVO svo : surveyList) {
								System.out.println(svo.getSurveyNo() + "|" + svo.getStartDate() + "~" + svo.getEndDate()
										+ "|" + (svo.getOneCnt() + svo.getTwoCnt()) + "|" + svo.getTitle());

							}
						}
						System.out.println();
						System.out.print(">> 수정하실 설문번호를 선택해주세요. : ");
						int survey_no = scan.nextInt();
						scan.nextLine();
						surveyModify(survey_no);
					} else if (survey == 2) {
						surveyRemove();
					} else if (survey == 3) {
						adminmenu();
					} else {
						System.out.println(">> 1 ~ 3 중에 하나를 선택해주세요.");
						System.out.println();
					}

				} else { // 관리자가 아닐 경우 - 설문 참여 메뉴 표시
					System.out.println("===========================");
					System.out.println("1. 내 설문 보기 2. 설문 참여 3. 이전으로");
					System.out.print(">> 선택 : ");
					survey = scan.nextInt();
					if (survey == 1) {
						surveyMyList();
					} else if (survey == 2) {
						surveyAttend();
					} else if (survey == 3) {
						memberMenu();
					} else {
						System.out.println(">> 1 ~ 3 중에 하나를 선택해주세요.");
						System.out.println();
					}
				}
			} else if (input == 2) {
				if (id.equals("admin")) {
					adminmenu();
				} else {
					memberMenu();
				}
			} else {
				System.out.println(">> 1 ~ 2 중에 하나를 선택해주세요.");
				System.out.println();
			}

		}
	}

//		System.out.println();
//		System.out.println("=======================================================");
//		System.out.println(">> 설문 목록 --------");
//		
//		SurveyVO svo = new SurveyVO();
//		 sdao.selectAllList();
//		System.out.println("설문번호 : " + svo.getSurveyNo());
//		System.out.println("설문제목 : " + svo.getTitle());
//		System.out.println("참여자 수 : " + (svo.getOneCnt() + svo.getTwoCnt()));
//		System.out.println("진행기간 : " + svo.getStartDate() + "~" + svo.getEndDate());
//		System.out.println();
//		
//		System.out.println("1.설문 수정	\t2.설문 삭제 \t3. 메인 메뉴 \\t4. 종료");
//		System.out.print(">> 선택 : ");
//		input = scan.nextInt();
//		
//		if(input == 1) {
//			surveyModify();
//		}else if(input == 2){
//			surveyRemove();
//		}
//		else if(input == 3){
//			new MemberMain().adminMenu();
//		}
//		else if(input == 4){
//			System.out.println(">> 시스템을 종료합니다");
//			System.exit(0);
//		}
//		else {
//			System.out.println(">> 1 ~ 4 중에 하나를 선택해주세요.");
//			System.out.println();
//		}

	// 설문 하나 보기
	public void surveyView(int survey_no) {
		SurveyVO svo = sdao.surveyOneList(survey_no);
		System.out.println("설문번호 : " + svo.getSurveyNo());
		System.out.println("설문기간 : " + svo.getStartDate() + " ~ " + svo.getEndDate());
		System.out.println("설문제목 : " + svo.getTitle());
		System.out.println("설문항목1 : " + svo.getOne() + "득표수 : " + svo.getOneCnt() + ")");
		System.out.println("설문항목2 : " + svo.getTwo() + "득표수 : " + svo.getTwoCnt() + ")");
		System.out.println();

	}

	// 설문 등록
	public void surveyAdd() throws IOException {
		SurveyVO svo = new SurveyVO();
		System.out.println();
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(">> 설문 등록 --------");
		scan.nextLine();
		System.out.println();
		System.out.print("   설문 제목 : ");
		String title = scan.nextLine();
		svo.setTitle(title);

		System.out.print("   선택 항목1 : ");
		String one = scan.nextLine();
		svo.setOne(one);

		System.out.print("   선택 항목2 : ");
		String two = scan.nextLine();
		svo.setTwo(two);

		System.out.print("   설문시작일 : ");
		String startDate = scan.nextLine();
		svo.setStartDate(startDate);

//		설문 시작일이 이미 등록되어 있는 설문의 조사기간과 중복되면
//		불가 안내 및 설문 등록 재요청 메시지를 출력하고 관리자 메뉴 표시

		String endDate = startDate;
		svo.setEndDate(endDate);

		boolean result = sdao.insert(svo);
		if (result == true) {
			System.out.println("설문 등록이 완료되었습니다.");
			System.out.println();
			adminmenu();
		}

	}

	// 설문 수정
	public void surveyModify(int surveyNo) throws IOException {

		SurveyVO svo = sdao.surveyOneList(surveyNo);
		System.out.println();
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(">> 설문 수정 --------");
		System.out.println();
		System.out.print("   설문 제목 : ");
		svo.setTitle(scan.nextLine());

		System.out.print("   선택 항목1 : ");
		svo.setOne(scan.nextLine());

		System.out.print("   선택 항목1 득표수 : ");
		svo.setOneCnt(Integer.parseInt(scan.nextLine()));

		System.out.print("   선택 항목2 : ");
		svo.setTwo(scan.nextLine());

		System.out.print("   선택 항목2 득표수 : ");
		svo.setTwoCnt(Integer.parseInt(scan.nextLine()));

		System.out.print("   설문시작일 : ");
		String startDate = scan.nextLine();
		svo.setStartDate(startDate);

		boolean result = sdao.surveyUpdate(svo);
		if (result == true) {
			System.out.println("설문 수정이 완료되었습니다.");
			System.out.println();
			adminmenu();
		}

	}

	// 설문 삭제
	public void surveyRemove() throws IOException {
		List<SurveyVO> surveyList = sdao.selectAllList();
		System.out.println();
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(">> 설문 삭제 --------");
		System.out.println();
		if (surveyList == null || surveyList.size() < 1) {
			System.out.println(">> 등록된 설문이 없습니다.");
		} else {// 그렇지 않다면
			System.out.println("설문번호|설문시작일 - 설문종료일|참여자 수|설문 제목");
			System.out.println("------------------------------------------------");
			for (SurveyVO svo : surveyList) {
				System.out.println(svo.getSurveyNo() + "|" + svo.getStartDate() + "~" + svo.getEndDate() + "|"
						+ (svo.getOneCnt() + svo.getTwoCnt()) + "|" + svo.getTitle());

			}
		}
		System.out.println();
		System.out.print(">> 삭제하실 설문번호를 선택해주세요. : ");
		int survey_no = scan.nextInt();
		for (SurveyVO svo : surveyList) {
			if (survey_no == svo.getSurveyNo()) {
				System.out.print(survey_no + "번 설문을 삭제하시겠습니까?(y/n)");
				scan.nextLine();
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Y")) {
					boolean result = sdao.delete(survey_no);
					if (result == true) {
						System.out.println(">>선택하신 설문이 삭제되었습니다.");
						adminmenu();
						System.out.println();
					}
				} else {
					System.out.println(">> 설문 삭제가 취소되었습니다.");
					adminmenu();
					System.out.println();

					break;
				}
			} else {

			}
		}

	}

	// 설문 참여
	// 현재 진행 중인 설문이 없는 경우
	// 안내 메시지를 표시하고 중단

	// 현재 진행 중인 설문이 있는 경우
	// 해당 설문을 데이터베이스에서 받아와서 표시하고
	// 설문에 참여 진행

	// 설문 참여 등록에 성공한 경우
	// 해당 설문의 득표수 +1 업데이트
	public void surveyAttend() throws IOException {

		System.out.println();
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(">> 설문 참여 --------");
		int survey_no = sdao.insertVoteChk();

		if (survey_no != 0) {
			SurveyVO svo = sdao.surveyOneList(survey_no);
			VoteVO vvo = new VoteVO(survey_no, id, svo.getOne());

			surveyView(survey_no);

			System.out.println(">> 항목을 선택해 주세요.");
			System.out.println("   1. " + svo.getOne());
			System.out.println("   2. " + svo.getTwo());
			System.out.println("   3.이전으로");
			System.out.println();
			System.out.print(">> 선택 : ");
			input = scan.nextInt();
			if (input == 1) {
				sdao.insertVote(vvo);
				sdao.updateCnt(1, survey_no, svo);
				System.out.println("설문에 참여해주셔서 감사합니다.");
				memberMenu();
			} else if (input == 2) {
				sdao.insertVote(vvo);
				sdao.updateCnt(2, survey_no, svo);
				System.out.println("설문에 참여해주셔서 감사합니다.");
				memberMenu();
			} else if (input == 3) {
				memberMenu();
			}
			// 1 또는 2를 선택한 경우 t_survey 테이블에 update, t_vote 테이블에 insert
		} else {
			System.out.println("진행중인 설문이 없습니다.");
			memberMenu();
		}

	}

}
