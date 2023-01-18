package exam.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



//싱글톤 패턴을 이용하여 데이터베이스 연결Connection 객체 사용
public class DBCon {
	
	private static Connection con;
	
	//생성자 외부 클래스 접근 불가 처리
	private DBCon () {
		
	}
	
	//Connection 객체를 반환하는 공유 메소드 getConnection
		public static Connection getConnection() {
			//jdbc.properties 파일을 읽어서
			
			

			try {
				FileInputStream fis = new FileInputStream("src/exam/util/jdbc.properties");
			
				Properties prop = new Properties();
				prop.load(fis);//Properties 클래스의 load()를 이용하여 jdbc.properties 파일 로딩

				if(con == null) {
					Class.forName(prop.getProperty("driver"));
					System.out.println("driver ok");
					
					
					con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
					System.out.println("con ok");
					// 드라이버 로딩 및 DB 연결 객체 생성
				}
				
				
				
			} catch (FileNotFoundException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();} 
			catch (ClassNotFoundException e) {e.printStackTrace();} 
			catch (SQLException e) {e.printStackTrace();}
				return con;
		}
		
		public static void close(PreparedStatement pstmt)	{
			
				try {
					if(pstmt != null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}

		public static void close(ResultSet rs, PreparedStatement pstmt) {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
}
