package javaz.io;

import java.io.*;

public class OutputStreamTest {

	public static void main(String[] args) throws IOException {
		System.out.write('A');
		System.out.write(66);
		System.out.write('c');
		System.out.write(68);
//		System.out.write('\n');
		System.out.write(10);
		
		OutputStream os = System.out;
		System.out.write('E');
		System.out.write(70);
		os.flush();	//출력 버퍼 비우기
		
		System.out.write('g');
		System.out.write('H');
		os.close();	//스트림 닫기
		
		
	}

}
