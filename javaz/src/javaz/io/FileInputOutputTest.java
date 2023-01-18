package javaz.io;

import java.io.*;

public class FileInputOutputTest {

	public static void main(String[] args) {
		System.out.println("1.파일 '.classpath' 읽어오기");
		System.out.println("2.읽어온 파일의 백업 파일 만들기");
		
		String filename = ".classpath";
		

		FileInputStream fis = null;		//파일에서 읽어오기 위한 파일입력스트림
//		FileOutputStream fos = null;	//파일에 쓰기 위한 파일출력스트림
		
		
		
		
		try(FileOutputStream fos 	//출력 파일 연결
				= new FileOutputStream(filename + ".bak")) {
			fis = new FileInputStream(filename);	//입력 파일 연결
			int input = 0;
			while(input != -1) {	//읽은 값이 없을 때까지}
			input = fis.read();
			
//			System.out.print((char)input);
			System.out.write(input);	//표준출력으로 출력 - 모니터로 표시
			fos.write(input);  //파일로 출력 - 파일에 쓰기
			}
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
		
		
	}

}
