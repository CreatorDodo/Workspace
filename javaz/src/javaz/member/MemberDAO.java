package javaz.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//DAO ; Data Access Object

public class MemberDAO {
	private List<MemberVO> members = new ArrayList<>();
	

	
	
	//회원 가입 메소드 insertMember
	//- 회원 가입에 필요한 데이터들을 매개변수로 넘겨받아
	
	
	public void insertMember(String id,String pw,String name,String email,String photo,String gender) {}
	
	public boolean insertMember(MemberVO mvo) {
		Date joinDate = new Date();	//가입일자는 현재 시점의 Date 객체를 이용하여
		mvo.setJoinDate(joinDate);	//설정하고
		boolean result = members.add(mvo); //	members에 저장한
		return result;	//결과를 반환
	}
	
	
	//전체 회원 목록 메소드 selectAllMember

	public List<MemberVO> selectAllMember() {
		return members;		//- members 객체를 반환
	}
	
	
	
	
	
	
	
}
