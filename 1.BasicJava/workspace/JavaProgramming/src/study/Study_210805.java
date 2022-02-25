package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Study_210805 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "LDG89";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT D.LPROD_GU AS 분류코드, D.LPROD_NM AS 분류명, NVL(AAAA.CCNT, 0) AS 매출수량, NVL(AAAA.CAMT, 0) AS 매출금액"
					+ " FROM (SELECT B.LPROD_GU AS CID, SUM(A.CART_QTY) AS CCNT,"
					+ " SUM(A.CART_QTY * C.PROD_PRICE) AS CAMT"
					        + " FROM CART A, LPROD B, PROD C"
					        + " WHERE A.CART_PROD = C.PROD_ID"
					        + " AND C.PROD_LGU = B.LPROD_GU"
					        + " AND SUBSTR(A.CART_NO, 1, 6) BETWEEN '200504' AND '200506'"
					        + " GROUP BY B.LPROD_GU) AAAA, LPROD D"
					+ " WHERE D.LPROD_GU = AAAA.CID (+)"
					+ " ORDER BY 1";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData metadata = rs.getMetaData();
			
			int columnCount = metadata.getColumnCount();
			
			while(rs.next()){
				for(int i = 1; i <= columnCount; i++){
					Object value = rs.getObject(i);
					System.out.print(value + "      ");
				}
				System.out.println();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}

	}

}
