package javaz.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class BufferedInputOutput {

	public static void main(String[] args) throws IOException {
		System.out.println("버퍼를 추가하여 파일에서 읽기 ----");
		
		String filename = ".classpath";
		FileInputStream fis = new FileInputStream(filename);	//파일과 연결할 파일 입력 스트림
		BufferedInputStream bis = new BufferedInputStream(fis);	//파일입력스트림과 연결할 버퍼입력스트림
		int input = 0;
		while(input != -1) {	//읽은 값이 없을 때까지}
		input = bis.read();	//버퍼에서 읽기
		System.out.write(input);	//표준출력으로 출력 - 모니터로 표시

		}
		
		//입력 스트림 닫기
		bis.close();
		fis.close();
		
		System.out.println("버퍼를 추가하여 파일에 쓰기 ----");
		filename = "buffered.txt";
		FileOutputStream fos = new FileOutputStream(filename);	//파일과 연결된 파일출력스트림
		BufferedOutputStream bos = new BufferedOutputStream(fos); //파일출력스트림과 연결된 버퍼출력스트림
		
		//buffered.txt 파일에 1 ~ 9까지 쓰기
		for (int i = '1'; i <= '9'; i++) {
			bos.write(i);
		}
		bos.flush();
		bos.close();
		fos.close();
		
	}

}
