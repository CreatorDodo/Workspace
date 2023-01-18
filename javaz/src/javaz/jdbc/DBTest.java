package javaz.jdbc;

import java.sql.*;

public class DBTest {

	public static void main(String[] args) {
		//드라이버 로딩
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "madang";
		String password = "1111";
	

		try {
			//드라이버 로딩
			Class.forName(driver);
			System.out.println("driver ok");
			
			//데이터베이스 연결 Connection 객체 생성
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("con ok");
			
			//쿼리를 실행할 Statement 객체 생성
			//book 테이블의 모든 데이터를 조회하는 SELECT 쿼리를 실행한 결과 받기			
//			//book 테이블의 모든 데이터를 bookid를 오름차순하여 가져오는 쿼리 작성
			
			Statement stmt = con.createStatement();
			System.out.println("stmt ok");
			String query = "SELECT * FROM book ORDER BY bookid";
			
//			------------------------DELETE------------------------
			String bookName = "easy java";
			
			//book 테이블의 책이름이 'easy java'인 데이터 모두 삭제
			query = "DELETE FROM book WHERE bookname=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, bookName);
			
			//delete 쿼리를 실행하고 결과를 받아 성공 여부 확인
			int result = pstmt.executeUpdate();
			if(result > 0)	{	//삭제 성공
				System.out.println("데이터가 삭제되었습니다.");
			}else	{
				System.out.println("데이터 삭제에 실패했습니다.");
			}
			
//			------------------------UPDATE------------------------
//			int price = 20000;
//			
//			//book 테이블의 가격이 10000원인 책의 값을 위 변수의 값으로 변경
//			query = "UPDATE book SET price = ? WHERE price=10000 ";
//			
//			
//			
//			PreparedStatement pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, price);
//			
//			//update 쿼리를 실행하고 결과를 받아 성공 여부 확인
//			int result = pstmt.executeUpdate();
//			if(result > 0)	{	//변경 성공
//				System.out.println("데이터가 변경되었습니다.");
//			}else	{
//				System.out.println("데이터 변경에 실패했습니다.");
//			}
//			
//			
//			
//			
//			
			
//			------------------------INSERT------------------------
//			String bookName = "easy java";
//			String publisher = "SIST";
//			int price = 10000;
//			//book 테이블에 책아이디는 12, 책이름/출판사 가격은 위 변수의 값으로
//			//데이터를 추가하는 쿼리 작성
//			query = "INSERT INTO book(bookid, bookname, publisher, price) " +
////					"VALUES(11,'스포츠 의학', '한솔의학서적', 90000)";
////					" VALUES(12,' " +  bookName + " ', ' " + publisher + "', " +price + ")";
//					"VALUES(12, ?, ?, ?)";
//			
//			//쿼리를 실행할 PreparedStatement 객체 생성
//			PreparedStatement pstmt = con.prepareStatement(query);
//			pstmt.setString(1, bookName);
//			pstmt.setString(2, publisher);
//			pstmt.setInt(3, price);
//			
//			//insert 쿼리를 실행하고 결과를 받아 성공 여부 확인
//			int result = pstmt.executeUpdate();
//			if(result == 1)	{	//1행이 삽입되면 데이터 추가 성공
//				System.out.println("데이터가 추가되었습니다.");
//			}else	{
//				System.out.println("데이터 추가에 실패했습니다.");
//			}
//			
//			
//			-----------------------SELECT ALL-----------------------
			
//			String query = "SELECT * FROM book ORDER BY bookid";
//			ResultSet rs = stmt.executeQuery(query);
//			
//			//실행 결과가 있으면 화면에 출력
//			System.out.println("ID\t책 이름\t\t출판사\t가격");
//			System.out.println("----------------------------------------");
//			while(rs.next()) {	//실행 결과가 있으면 rs에서 값을 받아와서 화면에 출력
//				System.out.println(rs.getInt("bookid") + "\t" + 
//									rs.getString(2) + "\t" + 
//									rs.getString("publisher") + "\t" + 
//									rs.getInt("price"));
//			}
//			-----------------------SELECT ONE-----------------------
//			//book 테이블의 bookid가 1번인 데이터를 가져오는 쿼리 작성
//			//book 테이블의 bookid가 1번인 데이터를 조회하는
//			//						SELECT 쿼리 실행 결과 받기
//			//실행 결과가 있으면 rs에서 값을 받아와서 화면에 출력
//			query = "SELECT * FROM book WHERE bookid = 1";
//			ResultSet rs = stmt.executeQuery(query);
//			
//			//실행 결과가 있으면 화면에 출력
//			System.out.println("ID\t책 이름\t\t출판사\t가격");
//			System.out.println("----------------------------------------");
//			if(rs.next()) {	//실행 결과가 있으면 rs에서 값을 받아와서 화면에 출력
//				System.out.println(rs.getInt("bookid") + "\t" + 
//									rs.getString(2) + "\t" + 
//									rs.getString("publisher") + "\t" + 
//									rs.getInt("price"));
//			} else {
//				System.out.println("해당 책이 존재하지 않습니다.");
//			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
