package javaz.util;

import java.util.*;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "dev");
		prop.setProperty("password", "1111");
		System.out.println(prop);
		System.out.println();
		
		System.out.println(prop.get("user"));
		System.out.println(prop.getProperty("password"));
		
		System.out.println("---- prop의 key와 value ----");
		Enumeration<?> propName = prop.propertyNames();
		while(propName.hasMoreElements()) {
			String name = (String) propName.nextElement();
			System.out.println(name + " : " + prop.get(name));
		}

		System.out.println();
		System.out.println("시스템의 파일 구분자와 경로 구분자 출력");
		System.out.println(System.getProperty("file.separator"));//시스템의 파일 구분자와 경로 구분자 출력
		System.out.println(System.getProperty("path.separator"));
		
		
		System.out.println("시스템의 전체 속성 출력");
		prop = System.getProperties();
		prop.list(System.out);
		
		
	}

}
