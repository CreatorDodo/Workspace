package pre;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import sistMovie.util.DBCon;

//메서드 내부에 있는 건 모두 MemberMain 이전 것 그대로 썼음
//구체적인 메서드 구현은 참고만 하고 새롭게 만들 것.

public class MemberMain {

	private int input;
	private MemberDAO mdao = new MemberDAO();

	//로그아웃
	public void logout() throws IOException {
		id = pw = null;
		System.out.println(">> 로그아웃합니다");
		menu();
	}

	//메인메뉴
	public void menu() throws IOException {

		do {
			System.out.println("---MEMBER only SYSTEM MAIN ----");
			System.out.println("1. 가입         2.로그인         3.시스템 종료");
			System.out.print(" >>선택 : ");
			input = scan.nextInt();
//			System.in.skip(2); //여기도 엔터값 들어있으니까 넣긴 해야됨. 
			scan.nextLine(); // 하지만 스캔이니까 다음 라인만 넘겨주면 됨.

			switch (input) {
			case 1:
				join();
				break; // 회원가입 메뉴 실행
			case 2:
				login();
				break; // 로그인 메뉴 실행
			case 3:
				System.out.println(">> 시스템을 종료합니다");
				scan.close();
				System.exit(0);
			default:
				System.out.println(">> 1~3을 입력해주세요");
				break;
			}
		} while (true);

	}

	// 회원가입
	public void join() throws IOException {
		// 회원가입에 필요한 데이터들을 입력받아서
		// MemberVO 객체의 각 필드에 저장하고
		// MemberDAO의 회원 가입 메소드를 호출하고

		MemberVO mvo = new MemberVO();

		System.out.println(" >> Member only SYSTEM JOIN");
		System.out.print("    아이디 : ");
		String id = scan.nextLine();
		System.out.print("    비밀번호 : ");
		String pw = scan.nextLine();
		System.out.print("    이름 : ");
		String name = scan.nextLine();
		System.out.print("    이메일 : ");
		String email = scan.nextLine();
		System.out.print("    사진 : ");
		String phote = scan.nextLine();
		System.out.print("    성별 : ");
		String gender = scan.nextLine();

		mvo.setId(id);
		mvo.setPw(pw);
		mvo.setName(name);
		mvo.setEmail(email);
		mvo.setPhote(phote);
		mvo.setGender(gender);

		boolean olCheck = mdao.idOverlapCheck(mvo);

		boolean result = mdao.insertmember(mvo);
		// MemberDAO의 회원 가입 메소드를 호출하고
		// 결과를 넘겨받아

		if (olCheck == true) {
			System.out.println(">>중복되는 아이디입니다");
			System.out.println(">>회원정보를 다시 입력해주세요");
			join();
		} else {
			if (result == true) {
//				lc.putMember(id, pw);// 신규회원 아이디와 비밀번호를 loginMap에 저장
				System.out.println("   회원가입이 완료되었습니다");
				System.out.println("   로그인 후 이용해주세요");
				// 회원가입에 성공한 경우 "회원가입이 완료되었습니다"
				// "로그인 후 이용해주세요"를 출력
				menu();
			} else {
				System.out.println("회원 가입에 실패하셨습니다.");
			}
		}

	}

	//로그인
	public void login() throws IOException {
		System.out.println(" >> Member only SYSTEM LOGIN");
		System.out.print("    아이디 : ");
		id = scan.nextLine();
		System.out.print("    패스워드 : ");
		pw = scan.nextLine();

		// 로그인 체크 메소드 호출
		if (lc.loginCheck(id, pw) == true) {
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

	// 회원 전용 모드
	public void memberMenu() throws IOException {
		System.out.println("---사용자 모드 MEMBER only SYSTEM----");
		System.out.println("1. 내 정보        2.비밀번호 변경     3. 회원탈퇴 "
				+ "      4.설문       5.로그아웃");
		System.out.print(" >>선택 : ");
		int adinput = scan.nextInt();
		scan.nextLine();

		System.out.println();
		switch (adinput) {
		case 1:
			memberInfo();
			System.out.println();
			break;
		case 2:
			System.out.println(">> 비밀번호 변경"); // 비밀번호 변경
			changePw();
			menu();
			break;
		case 3:
			System.out.println(">> 회원탈퇴");
			memberRemove();
			menu();
			break;
		case 4:
			new SurveyMain(scan, id).memberMenu();
			break;
		case 5:
			logout(); // 로그아웃, 메인 메뉴 실행
			break;
		default:
			System.out.println(">> 1~4을 입력해주세요");
			break;
		}
	}
	
	// 마이페이지
	public void myPage() {}
	
	// 내 관심영화보기
	public void showMyLikeMovie() { /*수정란*/
		
	}
	
	// 회원탈퇴 페이지(회원)
	public void memberRemove() throws IOException {
			System.out.println(">> 정말로 탈퇴하시겠습니까?");
			System.out.println(">> 탈퇴하시려면 y를 입력해주세요");
			String yesNo = scan.nextLine();

			if (yesNo.equalsIgnoreCase("y")) {
				boolean result = mdao.delete(id);
				if (result == true) {
					System.out.println(">> 회원 탈퇴가 완료되었습니다.");
				}
			} else {
				System.out.println(">>회원탈퇴가 취소되었습니다.");
			}
			System.out.println();
			memberMenu();

		}

	//회원 정보 자세히 보기
	public void memberInfo() throws IOException {
		MemberVO mvo = mdao.select(id);

		System.out.println(">> 내 정보");
		System.out.println("아이디 : " + mvo.getId());
		System.out.println("이름 : " + mvo.getName());
		System.out.println("이메일 : " + mvo.getEmail());
		System.out.println("사진 : " + mvo.getPhote());
		System.out.println("성별 : " + mvo.getGender());

		memberMenu();
	}
	
	// 아이디 찾기
	public void findId() {}
	
	// 비밀번호 찾기
	public void findPw() throws IOException {}

	// 관리자 전용 모드
	public void adminMenu() throws IOException {
			System.out.println("---관리자 페이지 MEMBER only SYSTEM----");
			System.out.println("1. 회원 목록         2. 설문관리         3.회원정보 업데이트        4. 회원 삭제        5.로그아웃");
			System.out.print(" >>선택 : ");
			int adinput = scan.nextInt();
			scan.nextLine();

			switch (adinput) {
			case 1:
				showAllMember();
				break; // 회원목록 메뉴

			case 2:
				new SurveyMain(scan,id).adminMenu();
				break;

			case 3:
				updateMember();
				break;

			case 4:
				memberRemoveAdmin();
				break;

			case 5:
				// 로그아웃, 메인 메뉴 실행
				logout();
				break;
			default:
				System.out.println(">> 1또는 2를 입력해주세요");
				break;
			}

		}
	
	// 회원목록 페이지
	public void showAllMember() {
			// selectAllmember()메소드를 활용하여 전체 회원 목록을 넘겨받음
			List<MemberVO> mdaoList = mdao.selectAllmember();
			try {
				if (mdaoList == null || mdaoList.size() == 0) { // 만약에 회원 목록이 없다면
					System.out.println(">> 가입된 회원이 없습니다");
	
				} else {// 그렇지 않다면
					System.out.println();
					System.out.println("아이디|이름|이메일|가입일자");
					System.out.println("-----------------------");
	
					SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy년 mm월 dd일");
	
	//						for (int i = 0; i < mdaoList.size(); i++) {
					//
	//							Date date = mdaoList.get(i).getJoinDate();
	//							String dateStr = dateFmt.format(date);
					//
	//							System.out.println(mdaoList.get(i).getId() 
	//									+ "|" + mdaoList.get(i).getName()
	//									+ "|" + mdaoList.get(i).getEmail()
	//									+ "|" + dateStr);
	//						} // 나의 코드
					for (MemberVO mvo : mdaoList) {
	
						Date date = mvo.getJoinDate();
						String dateStr = dateFmt.format(date);
	
						System.out.print(mvo.getId() + "|");
						System.out.print(mvo.getName() + "|");
						System.out.print(mvo.getEmail() + "|");
						System.out.println(dateStr);
	
					} // 이게 훨신 간단함.
				}
				adminMenu();
				System.out.println();
				adminMenu();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	// 회원삭제(관리자)
	public void memberRemoveAdmin(String id) throws IOException {

		List<MemberVO> mdaoList = mdao.selectAllmember();

		if (mdaoList == null || mdaoList.size() == 0) { // 만약에 회원 목록이 없다면
			System.out.println(">> 가입된 회원이 없습니다");
			adminMenu();
		} else {// 그렇지 않다면
			System.out.println();
			System.out.println("----전체 회원 목록입니다----");
			System.out.println("아이디|이름|이메일|가입일자");
			System.out.println("-----------------------");

			SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy년 mm월 dd일");

			for (MemberVO mvo : mdaoList) {

				Date date = mvo.getJoinDate();
				String dateStr = dateFmt.format(date);

				System.out.print(mvo.getId() + "|");
				System.out.print(mvo.getName() + "|");
				System.out.print(mvo.getEmail() + "|");
				System.out.println(dateStr);
			}

			System.out.println("-----------------------");
			System.out.println("삭제하려는 회원의 ID를 입력해주세요");
			String memberId = scan.nextLine();

			System.out.println(">> 정말로" + memberId + "회원을 삭제하시겠습니까?");
			System.out.println(">> 삭제하시려면 y를 입력해주세요");
			String yesNo = scan.nextLine();

			if (yesNo.equalsIgnoreCase("y")) {
				boolean result = mdao.delete(memberId);
				if (result == true) {
					System.out.println(">> 회원 삭제가 완료되었습니다.");
				}
			} else {
				System.out.println(">>회원삭제가 취소되었습니다.");
			}
		}

		System.out.println();
		adminMenu();

	}
	
	// 내 정보 수정(회원)
	public void updateMyinfo() {}
	
	// 회원 정보 수정(관리자)
	public void updateMemberinfo(String id) throws IOException {
		// 회원가입에 필요한 데이터들을 입력받아서
		// MemberVO 객체의 각 필드에 저장하고
		// MemberDAO의 회원 가입 메소드를 호출하고

		MemberVO mvo = new MemberVO();

		System.out.println(" >> Member INFO UPDATE");
		System.out.print("  변경할 회원의 아이디를 입력해주세요 : ");
		String id = scan.nextLine();
		System.out.print("  새 비밀번호를 입력해주세요 : ");
		String pw = scan.nextLine();
		System.out.print("  새 이름을 입력해주세요 : ");
		String name = scan.nextLine();
		System.out.print("  새 이메일을 입력해주세요 : ");
		String email = scan.nextLine();
		System.out.print("  새 사진을 입력해주세요 : ");
		String phote = scan.nextLine();
		System.out.print("  새 성별을 입력해주세요 : ");
		String gender = scan.nextLine();

		mvo.setId(id);
		mvo.setPw(pw);
		mvo.setName(name);
		mvo.setEmail(email);
		mvo.setPhote(phote);
		mvo.setGender(gender);

		boolean result = mdao.update(mvo);
		// MemberDAO의 회원 가입 메소드를 호출하고
		// 결과를 넘겨받아

		if (result == true) {
			System.out.println("   회원정보 변경이 완료되었습니다");
			// 회원가입에 성공한 경우 "회원가입이 완료되었습니다"
			// "로그인 후 이용해주세요"를 출력
			adminMenu();
		} else {
			System.out.println("	회원정보 변경에 실패하셨습니다.");
		}

	}

	// 비회원 메뉴
	public void guestMain() {}
	
	
	public static void main(String[] args) throws IOException {
//		DBCon.getConnection();
		new MemberMain().menu();

	}

}
