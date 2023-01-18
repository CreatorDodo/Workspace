package javaz.oop;

//Tire 클래스는
//-	Tire는 제조사와 장착 위치를 갖고 있다.
//- Tire는 제조사와 장착 위치를 받아서 객체를 생성할 수 있다.
//- Tire는 타이어를 장착할 때 제조사와 장착 위치를 알릴 수 있다.

public class Tire {

	private String maker;
	private String position;
	
	public Tire(String maker, String position) {
		this.maker = maker;
		this.position = position;
	}

	public void setTire() {

		System.out.println(maker + "가 " + position + "에 장착했습니다");
	}
	

	
	
	
	
	
}
