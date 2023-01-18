package exam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import exam.util.DBCon;

public class LoginCheck {

	private PreparedStatement pstmt;
	private ResultSet rs;

	public boolean loginChk(String id, String pw) {
		String query = "select * FROM t_member WHERE id=? AND pw=?";

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) { 
				return true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close(rs, pstmt);
		}
		return false;
	}

}