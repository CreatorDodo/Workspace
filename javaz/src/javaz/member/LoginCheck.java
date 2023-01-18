package javaz.member;

import java.util.HashMap;
import java.util.Map;

public class LoginCheck {
	//로그인 정보(아이디, 비밀번호)를 저장하는 map
	
	private Map<String, String>	loginMap;

	public LoginCheck() {
		loginMap = new  HashMap<>();	//맵 객체 생성
		loginMap.put("admin", "1234");
		loginMap.put("aaa", "1111");
		loginMap.put("bbb", "1111");
		loginMap.put("ccc", "1111");
	
	}
	
	//신규 회원 아이디와 비밀번호를 loginMap에 저장
	public void putMember(String id, String pw) {
		loginMap.put(id, pw);
	}
	
	
	//아이디와 비밀번호를 받아서
	//loginMap의 데이터와 일치하는지 확인
	public boolean loginChk(String id, String pw) {
		if(loginMap.get(id) != null &&
			loginMap.get(id).equals(pw)) {//일치하면 true 반환
		//그렇지 않으면 false 반환
		return true;
		}else {
		return false ;}
	}
	
}
