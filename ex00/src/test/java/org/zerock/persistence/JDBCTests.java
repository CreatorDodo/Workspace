package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static	{
		
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}
	
	@Test
	public void testConnection() {
	try (	Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"Madang", "1111")){
					log.info(con);
				} catch (Exception e) {
					fail(e.getMessage());
				}

				
	}
	
	
	
	
}
