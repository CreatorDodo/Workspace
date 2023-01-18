package javaz.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageFileCopy {

	public static void main(String[] args) throws IOException {
		String source = "C:\\dev\\다운로드 (1).jpg";
		String copied = "C:\\dev\\2다운로드 (1).jpg";
		FileInputStream fis = new FileInputStream(source);	
		FileOutputStream fos =  new FileOutputStream(copied);
		
		//원본 파일의 이름에 ' - 복사본'을 붙여서 새로운 파일이름을 만들고
		//ex) due.png >> duke - 복사본.png
		//예외는 throws로 처리
		
		//원본 파일의 이름 앞에'2'를 붙여서 새로운 파일이름을 만들고
		//ex) duke.png >> 2duke.png
		
			//출력 파일 연결
		int input = 0;
			while(input != -1) {	//읽은 값이 없을 때까지}
				input = fis.read();
				
//				System.out.print((char)input);
				System.out.write(input);	//표준출력으로 출력 - 모니터로 표시
				fos.write(input);  //파일로 출력 - 파일에 쓰기
				}

			
			//입출력 스트림 닫기
			fos.close();
			fis.close();
		
		
		
	}

}
