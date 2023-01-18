package javaz.util;

import java.util.HashMap;
import java.util.Map;








//Capital 클래스
class Capital{
	//- 국가 이름을 Key로, 국가의 수도를 value로 갖는 
//	필드 map 선언(클래스 외부에서 사용 불가)

	private Map<String, String> map;

	
	//- 기본 생성자에서 임의의 국가와 수도 정보 4개를 
//	map에 저장하여 초기화
	public Capital() {
		map = new HashMap<>();
		map.put("대한민국", "서울");
		map.put("중국", "베이징");
		map.put("일본", "도쿄");
		map.put("대만", "타이완");
		
	}
	
	public void getCapital(String country) {
		//- 국가 이름을 매개변수로 받아서 수도 이름을 출력하는
//		"~~~의 수도는 ~~~입니다."
//	getCapital 메소드 작성
//	map에 저장된 국가 이외의 경우에는
//		"등록되지 않은 나라입니다."를 출력
		
		String capital = map.get(country);
		if(capital != null) {
			System.out.println(country + "의 수도는 " + capital + "입니다.");
		} else {
			System.out.println("등록되지 않은 나라입니다.");
		}

		
		
	}
	
	
	
	


	
	
}



public class MapCapitalQuiz {

	public static void main(String[] args) {
		String input = "대한민국";
		
		
		Capital capital = new Capital();
		
		System.out.println("-- 각 나라의 수도 알아보기 --");
		System.out.println("나라 이름 : " + input);
		capital.getCapital(input);
		
		
		
		

		
	}

}
