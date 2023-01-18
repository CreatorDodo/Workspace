package javaz.io;

import java.io.*;


public class DataInputOutput {

	public static void main(String[] args) throws IOException {
		System.out.println("기본자료형을 파일에 쓰고 읽어오기 ---");
		String filename = "dataOut.txt";
		FileOutputStream fos = new FileOutputStream(filename);
		DataOutputStream dos = new DataOutputStream(fos); //파일출력스트림에 사용할 데이터출력스트림
		
		FileInputStream fis = new FileInputStream(filename);	
		DataInputStream dis = new DataInputStream(fis); //파일입력스트림에 사용할 데이터입력스트림
		
		
		
		dos.writeBoolean(true);
		dos.writeInt(123);
		dos.writeChar('C');
		dos.writeDouble(0.12345);
		
		dos.close();
		fos.close();
		
		//dataOut.txt 파일에서 기본자료형 읽어오기
		System.out.println(dis.readBoolean());
		System.out.println(dis.readInt());
		System.out.println(dis.readChar());
		System.out.println(dis.readDouble());
		

	}

}
