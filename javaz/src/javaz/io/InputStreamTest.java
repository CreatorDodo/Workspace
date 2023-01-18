package javaz.io;

import java.io.*;

public class InputStreamTest {

	public static void main(String[] args) {
		InputStream is = null;
		
		try { 
			is = System.in;
			System.out.println("-- 문자의 아스키코드 알아보기 --");
			String str = "문자를 입력해 주세요(종료는 Ctrl + z) : ";
			int input = 0;
			System.out.print(str);
			while(input != -1) {	//읽은 값이 없을 때까지}
			input = is.read();
			
			if(input == 13) {	//13의 경우 continue
				continue;
			}else if(input == 10) {	//10의 경우 입력 안내 메시지 출력 후 continue
				System.out.print(str);
				continue;
			}else if(input == -1) {	//-1의 경우 종료 메시지 출력 후 프로그램 종료
				System.out.println("\n프로그램이 종료되었습니다.");
				System.exit(0);
			}
			
			System.out.println((char) input + " : " + input);
		

			}
		
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}//예외가 발생하거나 발생하지 않거나 관계없이
			//is 객체가 null이 아니라면
			//닫기 메소드close() 호출
			
		
	}

}
