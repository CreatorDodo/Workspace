package javaz.oop;

public class Staticz {
	//static field | static method
	//정적 필드,클래스 변수       정적 메소드, 클래스 메소드
	//- 클래스의 모든 객체가 공유
	//- 객체 생성벗이 클래스 이름만으로 사용 가능
	//  객체 생성 이전에 클래스가 로드될 때 메모리에 올라감
	//- this 사용 불가
	//- 사용법
	// [클래스이름].정적필드이름
	// [클래스이름].정적메소드이름
	
	String name = "Lee"; //인스턴스 변수
	static int age = 10; //클래스|정적 변수
	
	//name 과 age의 값을 화면에 출력하는 인스턴스 메소드 print
	public void print () {
			System.out.println(name + " : " + age);
	}
	
	//name 과 age의 값을 문자열로 반환하는 정적 메소드 printt
	public static String printt () {
		Staticz st = new Staticz();
		return st.name + " : " + age;
	}
	
	
	public static void main(String[] args) {
		//System 클래스의 currentTimeMillis()를 호출하여
		//반환되는 값을 임의의 변수에 저장
		
		long now = System.currentTimeMillis();
		
		
		//System 클래스의 currentTimeMillis()를 호출하여
		//반환되는 값을 화면에 출력
		System.out.println(System.currentTimeMillis());
				
		
		
		
		
		
		
		Staticz st = new Staticz();
		//print 메소드 호출
		st.print();
		//printt 메소드를 호출하여 반환되는 값을 임의의 변수에 저장하고
		//저장된 값을 화면 출력
//		st.printt(); // non - static way
		printt(); // static way
		String le = printt();
		
		System.out.println(le);
		
		
		System.out.println("name : " + st.name);
		System.out.println("age : " + age);
		
		System.out.println(Overloading.PI);		//Overloading 클래스의 PI의 값을 화면에 출력
//		System.out.println(Car.maker);		//Car 클래스의 maker의 값 출력
		Car car = new Car();
		car.maker = "KIA";
		System.out.println(car.maker);
	}

}
