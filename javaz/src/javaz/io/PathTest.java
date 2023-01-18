package javaz.io;


import java.io.IOException;
import java.nio.file.*;

public class PathTest {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/javaz/io/PathTest.java");
		System.out.println(path.getFileName());
		System.out.println(path.getParent().getFileName());
		System.out.println(path.toAbsolutePath());
		System.out.println("디렉토리 : " + Files.isDirectory(path));
		System.out.println("파일 : " + Files.isRegularFile(path));
		System.out.println("크기 : " + Files.size(path));
		
	}

}
