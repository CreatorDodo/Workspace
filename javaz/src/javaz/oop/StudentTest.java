package javaz.oop;

public class StudentTest {

	public static void main(String[] args) {
		
		Student kim = new Student(201111, "Kim");
		Student lee = new Student(211111, "Lee", "010-1111-2222");
		System.out.println(kim); //toString 메소드 오버라이딩
		System.out.println(lee.toString());
	}

}
