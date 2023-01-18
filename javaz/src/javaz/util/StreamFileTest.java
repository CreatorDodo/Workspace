package javaz.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamFileTest {

	public static void main(String[] args) throws IOException {
		String pathStr = "src/javaz/io";
		System.out.println("-- src/javaz/io 디렉토리의 모든 파일들 --");
		Path path = Paths.get(pathStr);
		for (Path p : path) {
			System.out.println(p.getFileName());
		}
		
		System.out.println("-------------------");
		Files.list(path).forEach(System.out::println);
		System.out.println("-------------------");
		
		path = Paths.get("src/user.txt");
		Files.lines(path).forEach(System.out::println);
		
		//user.txt 파일에서 Laa 포함된 데이터만 필터링하여
		//List 타입의 객체 laa에 저장
		List<String> laa = Files.lines(path).filter(str -> str.contains("Laa")).collect(Collectors.toList());
		System.out.println(laa);
		
		
		
		
	}

}
