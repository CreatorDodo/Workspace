package javaz.io;

import java.io.*;

public class InputStreamReaderTest {

	public static void main(String[] args) throws IOException {
		//InputStreamReader : InputStream 1byte >>> 2byte Reader
		//OutputStreamWriter : OutputStream >>> Writer

		
		//키보드 입력(표준입력)을 2byte로 연결하는 스트림 객체 생성
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		while(true) {
			System.out.print("단어를 입력해주세요(종료는 /q) : " );
			String input = br.readLine();
			
			//입력 단어를 화면에 표시
			//단, /q가 입력된 경우에는 '단어입력종료' 표시 및 중단
			//단어를 입력하지 않은 경우에는
			//	'단어가 입력되지 않았습니다.'를 표시
				if(input.equals("/q")) {
					System.out.println("단어입력종료");
					break;
				}else if(input.trim().length() > 0) {
					System.out.println("입력단어 : " + input);
			}else {
				System.out.println("단어가 입력되지 않았습니다.");
			}
			
			
			
			
			
		}
		br.close();
		isr.close();
	}

}
