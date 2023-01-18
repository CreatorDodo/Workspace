package javaz.io;

import java.io.*;

public class BufferedReaderWriter {

	public static void main(String[] args) throws IOException {
		String filename = "writer.txt";
		FileWriter fw = new FileWriter(filename);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Hello 한글" );
		bw.newLine();
		bw.append("append....");
		bw.close();
		fw.close();
		
		System.out.println("BufferedReader로 파일 읽기 ---");
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String inputData = "";
		while((inputData = br.readLine()) != null) {
			System.out.println(inputData);
		}
		br.close();
		fr.close();
	}

}
