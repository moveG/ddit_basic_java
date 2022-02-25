package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC_P_Select {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //@왼쪽: 드라이버 / @오른쪽: ip주소, sid
		String user = "LDG89";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "SELECT MEM_ID AS 회원번호, MEM_NAME AS 회원명, CONCAT(CONCAT(MEM_REGNO1, '-'), MEM_REGNO2) AS 주민번호, CONCAT(CONCAT(MEM_ADD1, ' '), MEM_ADD2) AS 주소"
					+ " FROM MEMBER"
                    + " WHERE MEM_ADD1 LIKE '충남%'"
					+ " ORDER BY 1";
			
//			mem_reno1, -, mem_regno2,    
			ps = con.prepareStatement(sql);
//			ps.setString(1, "20010409");
//			ps.setInt(2, 43000);
//			ps.setInt(3, 30000);
			
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			
			
			int columnCount = metaData.getColumnCount();
			
			while(rs.next()){
				for(int i = 1; i <= columnCount; i++){
					Object value = rs.getObject(i);
					System.out.print(value + "\t");
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
