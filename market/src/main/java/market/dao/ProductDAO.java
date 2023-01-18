package market.dao;

import java.sql.*;
import java.util.*;

import market.util.*;
import market.vo.ProductVO;

public class ProductDAO {

	private PreparedStatement pstmt;
	private String query;
	private ResultSet rs;
	private Statement stmt;
	ProductVO pvo;
	private Connection con;
	
	public boolean insertProduct(ProductVO pvo) {
		//이미지 파일이 없는 경우 default.png를 저장
		
		try {
			query = " INSERT INTO PRODUCT "
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, NVL(?, 'default.png')) ";

			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, pvo.getPid());
			pstmt.setString(2, pvo.getPname());
			pstmt.setInt(3, pvo.getPrice());
			pstmt.setString(4, pvo.getDescription());
			pstmt.setString(5, pvo.getMaker());
			pstmt.setString(6, pvo.getCategory());
			pstmt.setInt(7, pvo.getStock());
			pstmt.setString(8, pvo.getCondition());
			pstmt.setString(9, pvo.getPimage());

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
	
	
	public List<ProductVO> selectAllProduct(){
		query = "SELECT * FROM product ORDER BY pid";
		List<ProductVO> productList = new ArrayList<>();
		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
//					상품 이미지|상품명|상품 설명|상품 가격
				ProductVO pvo = new ProductVO();
				pvo.setPid((rs.getString("pid")));
				pvo.setPimage((rs.getString("pimage")));
				pvo.setPname((rs.getString("pname")));
				pvo.setDescription((rs.getString("description")));
				pvo.setPrice((rs.getInt("price")));

				productList.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return productList;
	}
	
	public ProductVO selectProduct(String pid) {

		query = "select * FROM product WHERE pid=?";

		ProductVO pvo = null;

		try {
			pstmt = DBCon.getConnection().prepareStatement(query);

			pstmt.setString(1, pid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pvo = new ProductVO();
				pvo.setPimage(rs.getString("pimage"));
				pvo.setPname(rs.getString("pname"));
				pvo.setDescription(rs.getString("description"));
				pvo.setPid(rs.getString("pid"));
				pvo.setMaker(rs.getString("maker"));
				pvo.setCategory(rs.getString("category"));
				pvo.setCondition(rs.getString("condition"));
				pvo.setStock(rs.getInt("stock"));
				pvo.setPrice(rs.getInt("price"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close(rs, pstmt);
		}
		return pvo;

	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
