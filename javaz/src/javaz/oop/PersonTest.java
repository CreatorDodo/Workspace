package javaz.oop;

public class PersonTest {

	public static void main(String[] args) {
		//Person 객체를 저장하는 persons 배열을 크기 100으로 생성
		Person[] per = new Person[100];
		int total = 0;
		per[total++] = new Person("Kim", "010-1111-2222"); 
		per[total++] = new Person("Lee", "010-2222-3333"); 
		per[total++] = new Person("Mon", "010-3333-0000");
		
		//임의의 데이터를 갖는 Person 객체 3개를 저장
		//저장된 persons 배열의 값을 화면에 출력
		
		//정수 데이터를 저장하는 arr 배열을 크기 100으로 생성
		//임의의 데이터를 갖는 정수 3개를 저장
		//저장된 arr 배열의 값을 화면에 출력
		int[] arr = new int[100];
		arr[0] = 1; arr[1] = 2;
		
		System.out.println("---- 연락처 목록 ----");
		System.out.println("이름		전화번호");
		System.out.println(per);
		for (int i = 0; i < total ; i++) {
			System.out.println(per[i].getName() +"\t\t"+ per[i].getPhone());
		}
		
		System.out.println(per[0].getName() +"\t\t"+ per[0].getPhone());
		System.out.println(per[1].getName() +"\t\t"+ per[1].getPhone());
		System.out.println(per[2].getName() +"\t\t"+ per[2].getPhone());
	}

}
