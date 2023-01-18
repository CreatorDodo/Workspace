package javaz.api;

import java.io.IOException;
import java.io.InputStream;

//예외
//- 예기치 않은 상황
//- 가벼운 오류
//- 프로그램적으로 처리
//- 복구 가능

//에러
//- 치명적 오류
//- JVM에 의존하여 처리
//- 더이상 실행 불가

//예외 발생
//- 정수를 0으로 나누는 경우
//- 배열의 INDEX가 음수 또는 범위를 벗어나는 경우
//- 형변환이 적절치 않은 경우
//- 입출력 파일이 없는 경우

//예외 객체
//- Exception 클래스 또는 Exception의 하위 클래스
//- 예외 발생 정보를 가지고 있으며
//	예외 발생 시 만들어지고 던져짐
//	throw new Exception();
//- 예외처리 코드가 있으면 계속 수행되고,
//	그렇지 않으면 메시지가 출력되고 종료

//checked Exception
//- 반드시 명시적으로 예외 처리 필요
//- IOException, InterruptedException 등

//unchecked Exception
//- 잘못 작성된 코드 떄문에 발생
//- RuntimeException : Arthme..., Array...

//예외 처리 방법
//- 직접 처리 : 던져진 예외 객체를 잡아서 처리
//			try/catch 또는 try/catch/finally,
//			try-with-resources를 사용		
			//-리소스 자동 관리
			//- try/catch 문에서 사용되는 리소스 객체의
			//	close()가 호출되어
			// 블럭의 끝에서 리소스를 자동으로 닫음
			//- java.lang.Autoclosable 인터페이스를 구현한			
			//클래스 대상

//try( resources ) {
//
//} catch ( ) { 
//
//} finally {
//try {
//		예외 발생 가능성 있는 코드 블럭
//		예외 발생 X : 정상 실행 후 종료
//		예외 발생 O : 실행 중단 후 catch 구문으로 이동
//} catch(발생한예외타입 변수이름) {
//
//} catch(위의 예외타입보다 상위타입) {
//		catch 블럭은 여러 개 명시 가능
//		단, 발생한 예외와 일치하거나 상위 타입 예외블럭만 실행
//		일치하는 블럭이 없으면 수행 X
//}	finally {
//		예외 발생 여부와 관계없이 수행되는 코드
//		생략 가능
//}
//
//간접 예외 처리
//- 예외를 직접 처리하지 않고
//	메소드를 호출한 쪽으로 처리 위임
//- 예외 발생 가능한 메소드의 선언부에
//	매개변수 다음에 throws 키워드를 명시하고
//	예외이름을 써줌
//
//	ex) public void method() throws Exception {		}
//
//사용자 정의 예외
//- 사용자가 직접 예외 클래스 작성 가능
//- Exception 클래스를 상속받아 구현
//	필요 시에 예외를 직접 발생시킬 수 있음
//	throw new 예외타입


class SamChoException extends Exception {

	//Exception 클래스를 상속받는 SamChoException 클래스
	//- 문자열 메세지를 매개변수로 받아
	// 부모 생성자에게 전달

	public SamChoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
public class ExceptionTest {
	//매개변수로 받은 시간(초)만큼 카운트다운 값을 표시하는
	//countDown 메소드
	
	public void countDown(int time) 
			throws InterruptedException, SamChoException {		//예외를 호출한 쪽에서 처리하도록 위임
		if(time < 3){//카운트다운 시간이 3초 미만이면
			//SamChoException 예외 발생시켜서 던지기
		throw new SamChoException("카운트다운은 3초 이상으로 지정해주세요.");
		}
		for (int i = time; i > 0; i--) {
			System.out.println(i);
			Thread.sleep(1000);	//예외 발생
		}
	}

	public static void main(String[] args) {
		
		
		ExceptionTest et = new ExceptionTest();
		
		try {
			et.countDown(2);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (SamChoException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		
		
		//1.예외 직접 처리
		try {
			System.out.println("1.예외 발생 전 ");
			System.out.println(args[2]);
			System.out.println("3.예외 발생 후 ");
		} catch (NullPointerException e) {
			System.out.println("4.상관없는 예외 객체 i ");
		} catch (ClassCastException | ArithmeticException e) {
			System.out.println("5.상관없는 예외 객체 ii ");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("6.발생되어 던져진 예외 객체");
			System.out.println(e.getMessage());
			System.out.println(e);
			e.printStackTrace();
			System.err.println("예외 잡음!!!");
			
		} catch (Exception e) {
			System.out.println("7.최상위 예외 객체 - 다 잡아!! ");
		} finally {
			System.out.println("8.마지막!! 항상 실행됨 ");
		}
		
		System.out.println("---- try with resources ----");
//	InputStream is = null;
//		
//		try() { 
//			is = System.in;
				try(InputStream is = System.in){ 
					
					System.out.println("-- 문자의 아스키코드 알아보기 --");
					String str = "문자를 입력해 주세요(종료는 Ctrl + z) : ";
					int input = 0;
					while(input != -1) {	//읽은 값이 없을 때까지}
					input = is.read();
					}
				
				}catch (IOException e) {
					e.printStackTrace();
				}
//				finally {
//					if(is != null) {
//						try {
//							is.close();
//						} catch (IOException e) {
//
//							e.printStackTrace();
//						}
//					}
//				}//예외가 발생하거나 발생하지 않거나 관계없이
//					//is 객체가 null이 아니라면
//					//닫기 메소드close() 호출
//	
	
	
	
	
	}

}
