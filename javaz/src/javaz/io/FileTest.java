package javaz.io;

import java.io.*;
import java.util.Arrays;

//File
//- 파일과 디렉토리 경로 관리
//- 파일 크기, 생성, 삭제, 변경 및 마지막 수정날짜 등을
//	알 수 있는 메소드 제공

public class FileTest {

	public static void main(String[] args) {
		//src 디렉토리를 파일 객체로 생성
		File dir = new File("src");
		
		
		//src 디렉토리의 내용 보기
		String[] srcList = dir.list();
		System.out.println(Arrays.toString(srcList));
		
		
		
		//src 디렉토리의 내용을 파일 배열로 받기
		File[] fileList = dir.listFiles();
		for (File file : fileList) {
			System.out.println("이름 : " + file.getName());
			System.out.println("디렉토리 : " + file.isDirectory());
			System.out.println("파일 : " + file.isFile());
			System.out.println();
			
			if(file.isFile())	{
				System.out.println("크기 : " + file.length());
				
			}
			System.out.println();
		}
	}

}
