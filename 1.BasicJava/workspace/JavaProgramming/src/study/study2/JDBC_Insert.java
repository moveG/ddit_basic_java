package study.study2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Insert {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "LDG89"; 
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "INSET INTO 테이블명[(컬럼명1[,컬럼명2,...])] VALUES('값1'[,'값2',...]);";
			
			ps = con.prepareStatement(sql);
			
			int result = ps.executeUpdate();
			
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}

	}

}
