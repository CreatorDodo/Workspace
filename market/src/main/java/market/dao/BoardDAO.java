package market.dao;

import java.sql.*;
import java.util.*;

import market.util.*;
import market.vo.BoardVO;

public class BoardDAO {

	private PreparedStatement pstmt;
	private String query;
	private ResultSet rs;
	private Statement stmt;
	BoardVO bvo;
	private Connection con;
	
	public BoardDAO(Connection con) {
		this.con = con;
	}
	
	public boolean insertBoard(BoardVO bvo) {
		
		try {
			query = " INSERT INTO BOARD "
					+ " VALUES(SEQ_BOARD_NUM.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?) ";

			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, bvo.getUserid());
			pstmt.setString(2, bvo.getSubject());
			pstmt.setString(3, bvo.getContent());
			pstmt.setInt(4, bvo.getHit());
			pstmt.setString(5, bvo.getIP());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(pstmt);
		}

		return false;
	}
	
	public List<BoardVO> selectPage(int page, int total){
		

		
		query = "SELECT * FROM ( SELECT * FROM board WHERE num <= ? "
				+ " ORDER BY num DESC ) WHERE ROWNUM <= 5 ";
		List<BoardVO> boardList = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setInt(1, (total - (page - 1)*5));
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setNum((rs.getInt("num")));
				bvo.setUserid((rs.getString("userid")));
				bvo.setSubject((rs.getString("subject")));
				bvo.setContent((rs.getString("content")));
				bvo.setRegDate((rs.getDate("reg_date")));
				bvo.setHit((rs.getInt("hit")));
				bvo.setIP((rs.getString("IP")));
				
				boardList.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return boardList;
	}
	
	
	public List<BoardVO> selectBoardAll(){
		query = "SELECT * FROM board ORDER BY num DESC";
		List<BoardVO> boardList = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setNum((rs.getInt("num")));
				bvo.setUserid((rs.getString("userid")));
				bvo.setSubject((rs.getString("subject")));
				bvo.setContent((rs.getString("content")));
				bvo.setRegDate((rs.getDate("reg_date")));
				bvo.setHit((rs.getInt("hit")));
				bvo.setIP((rs.getString("IP")));
				
				boardList.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return boardList;
	}
	
	public BoardVO selectBoard(int num) {

		query = "select * FROM board WHERE num=?";

		BoardVO bvo = null;

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bvo = new BoardVO();
				bvo.setNum((rs.getInt("num")));
				bvo.setUserid((rs.getString("userid")));
				bvo.setSubject((rs.getString("subject")));
				bvo.setContent((rs.getString("content")));
				bvo.setRegDate((rs.getDate("reg_date")));
				bvo.setHit((rs.getInt("hit")));
				bvo.setIP((rs.getString("IP")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return bvo;

	}
	
	public boolean updateBoard(BoardVO bvo) {
		query = "UPDATE BOARD SET SUBJECT=?, CONTENT=? "
				+ " WHERE NUM=? ";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			
			pstmt.setString(1, bvo.getSubject());
			pstmt.setString(2, bvo.getContent());
			pstmt.setInt(3, bvo.getNum());
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(pstmt);
		}

		return false;

	}
	
	public boolean deleteBoard(int num) {
		query = "DELETE BOARD where num=?";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			pstmt.setInt(1, num);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(pstmt);
		}

		return false;

	}


	
	
	
	public int totalCount() {	//전체 게시물 수
		
	
		query = "SELECT COUNT(*) FROM board";

		int total = 0;

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			
			rs = pstmt.executeQuery();

			if (rs.next()) {
			total = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return total;
	
	}
	
	
//public boolean updateHit(int num) {	//게시물 조회 수 증가
//		
//		query = "UPDATE BOARD SET HIT= hit + 1 WHERE num = " + num;
//		try {
//			pstmt = DBCon.getConnection().prepareStatement(query);
//			
//
//			int result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBCon.close(pstmt);
//		}
//
//		return false;
//		
//	}
	
	
	public boolean updateHit(int num) {	//게시물 조회 수 증가
		
		query = "UPDATE BOARD SET HIT= (SELECT NVL(hit, 0) + 1 FROM BOARD WHERE num = ?) "
				+ " WHERE num=? ";
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);
			
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(pstmt);
		}

		return false;
		
	}
	
	
	
	
}
