package javaz.io;

import java.io.*;

public class ReaderWriterTest {

	public static void main(String[] args) throws IOException {
		String filename = "src\\user.txt";
		
		System.out.println("1.InputStream 객체 is를 이용하여 파일 읽기");
		
		InputStream is = new FileInputStream(filename);
		int input = 0;
		while(input != -1) {	//읽은 값이 없을 때까지}
			input = is.read();
			
//			System.out.write(input);	//표준출력으로 출력 - 모니터로 표시
			System.out.print((char)input);
		}
		
		is.close();
		System.out.println();
		System.out.println("2.Reader 객체 reader를 이용하여 파일 읽기");
		Reader reader = new FileReader(filename);
		input = 0;
		while(input != -1) {	//읽은 값이 없을 때까지}
			input = reader.read();
			System.out.print((char)input);
		}
		
		reader.close();
		
		System.out.println();
		System.out.println("3.Writer 객체 writer를 이용하여 파일에 쓰기");
		filename = "write.txt";
//		Writer writer = new FileWriter(filename);
		Writer writer = new FileWriter(filename, true);
//		writer.write("writer를 이용하여 파일에 쓰기");
//		writer.write("writer를 이용하여 파일에 쓰기2");
//		writer.append("writer를 이용하여 파일에 쓰기3");
		writer.append("writer를 이용하여 파일에 쓰기4");
		writer.close();
		
		
	}

}
