package javaz.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "print.txt";
		
		PrintStream ps = new PrintStream(filename);
		ps.println("프린트스트림");
		
		
		ps.print(123);
		ps.print(false);
		ps.println(3.14);
		ps.printf("a");
		ps.close();
		
		
		
		
		

	}

}
