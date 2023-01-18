package javaz.member;

import java.io.IOException;
import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MemberMain {
	private int input;
	private Scanner scan = new Scanner(System.in);
	private MemberDAO mdao = new MemberDAO();
	private LoginCheck lc = new LoginCheck();

	public void menu() throws IOException {
	while(true) {
		System.out.println(">> MEMBER only SYSTEM MAIN --------");
		System.out.println("1.가입	\t2.로그인	\t3.시스템 종료");
		System.out.print(">> 선택 : ");
		input = scan.nextInt();
//		System.in.skip(2);	//입력 버퍼에서 2바이트 건너뛰기
		scan.nextLine();
//		System.out.println(input);

		if(input == 1) {
			join();		break;	//회원가입 메뉴 실행
		}else if((char)input == 2){
			login();	break;	//로그인 메뉴 실행
		}else if((char)input == 3){
			System.out.println(">> 시스템을 종료합니다");
			scan.close();
			System.exit(0);
		}else {
			System.out.println(">> 1 ~ 3 중에 하나를 선택해주세요.");
			System.out.println();
			}
		}
	}
	
	
	public void join () throws IOException {
		MemberVO mvo = new MemberVO();
		//회원가입에 필요한 데이터들을 입력받아서
		//MemberVO 객체의 각 필드에 저장하고
		//MemberDAO의 회원 가입 메소드를 호출하고
		//결과를 넘겨받아
		//회원가입에 성공한 경우 "회원 가입이 완료되었습니다."
		//					"로그인 후 이용해주세요."를 출력
		System.out.println(">> MEMBER only SYSTEM 회원 가입 --------");
		System.out.println("   아이디 : ");
		String id = scan.nextLine();
		mvo.setId(id);
		
		System.out.println("   비밀번호 : ");
		String pw = scan.nextLine();
		mvo.setPw(pw);

		
		System.out.println("   이름 : ");
		String name = scan.nextLine();
		mvo.setName(name);
		
		System.out.println("   이메일 : ");
		String email = scan.nextLine();
		mvo.setEmail(email);
		
		System.out.println("   사진 : ");
		String photo = scan.nextLine();
		mvo.setPhoto(photo);
		
		System.out.println("   성별 : ");
		String gender = scan.nextLine();
		mvo.setGender(gender);
		
		boolean result = mdao.insertMember(mvo);
		if(result == true) {//결과를 넘겨받아 회원가입에 성공한 경우
			 lc.putMember(id, pw);//신규 회원 아이디와 비밀번호를 loginMap에 저장하는 메소드 호출
			System.out.println("회원 가입이 완료되었습니다.");
			System.out.println("로그인 후 이용해주세요.");
			System.out.println();
			menu();
		}


		
	}
	
	public void login () throws IOException {
		List<MemberVO> members = new ArrayList<>();
		
		System.out.println();
		System.out.println(">> MEMBER only SYSTEM 로그인 --------");
		System.out.println("   아이디 : ");
		String id = scan.nextLine();

		
		System.out.println("   비밀번호 : ");
		String pw = scan.nextLine();

		//로그인 체크 메소드 호출
		//로그인 성공 시 - 관리자이면 adminMenu() 호출
		//				그렇지 않으면 memberMenu() 호출
		//로그인 실패 시 - "아이디 또는 비밀번호가  일치하지 않습니다." 출력하고
		//메인 메뉴 표시

		boolean result = lc.loginChk(id, pw);
		if(result == true) {
			if(id.equals("admin")) {
				adminMenu();
			}else {
				memberMenu();
			}
				
		}else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			System.out.println();
			menu();
		}
		
	}
	
	
	public void adminMenu() throws IOException {
		System.out.println(">> MEMBER only SYSTEM 관리자 모드 --------");
		System.out.println("1.회원 목록	\t2.로그아웃");
		System.out.print(">> 선택 : ");
		input = scan.nextInt();
		
		if(input == 1) {
			memberList();
		}else if(input == 2){
			System.out.println("로그아웃이 완료되었습니다.");
			menu();
		}
		else {
			System.out.println(">> 1 ~ 2 중에 하나를 선택해주세요.");
			System.out.println();
		}
	}


	private void memberList() throws IOException {
		
		//MemberDAO 클래스의 selectAllMember() 메소드를 호출하여
		//전체 회원 목록을 넘겨 받는다
		//만약 회원 목록이 없다면
		
		List<MemberVO> memberList = mdao.selectAllMember();
		if(memberList == null || memberList.size() < 1) {
		System.out.println(">> 가입된 회원이 없습니다.");
		adminMenu();
		}
		else{//그렇지 않다면
		System.out.println("아이디|이름|이메일|가입일자");	
		System.out.println("---------------------");	
		SimpleDateFormat dateFmt
		= new SimpleDateFormat("yyyy.MM.dd");
		for (MemberVO mvo : memberList) {
			System.out.println(mvo.getId() + "|" +
					mvo.getName() + "|" +
					mvo.getEmail() + "|" +
					dateFmt.format(mvo.getJoinDate()));
			
		}
//		for (int i = 0; i < memberList.size(); i++) {
//			System.out.println(
//					memberList.get(i).getId() + "\t" +
//					memberList.get(i).getName() + "\t" +
//					memberList.get(i).getEmail() + "\t" +
//					memberList.get(i).getJoinDate());
//		}
		
		
		}

		
	}


	public void memberMenu() throws IOException {
		System.out.println(">> MEMBER only SYSTEM 사용자 모드 --------");
		System.out.println("1.내 정보	\t2.비밀번호 변경 \t3.로그아웃");
		System.out.print(">> 선택 : ");
		input = scan.nextInt();
		
		if(input == 1) {
			System.out.println("내 정보");	
		}else if(input == 2){
			System.out.println("비밀번호 변경");
		}
		else if(input == 3){
			System.out.println("로그아웃이 완료되었습니다.");
			menu();
		}
	}


	public static void main(String[] args) throws IOException {
		MemberMain member = new MemberMain();
		
		member.menu();
		
	}

}
