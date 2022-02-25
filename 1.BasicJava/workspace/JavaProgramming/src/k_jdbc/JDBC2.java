package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //@왼쪽: 드라이버 / @오른쪽: ip주소, sid
		String user = "LDG89";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con =  DriverManager.getConnection(url, user, password);
			
			String sql = "select *"
			           + " from cart"
					   + " where cart_member = ?"
			           + " and cart_qty > ?"; //줄바꿈을 했으면 띄어쓰기가 필수임
			//원래는 '?'대신 'a001'이나 5가 들어가야함
			//그런데 값 대신 물음표를 넣음
			//이 물음표에 나중에 값을 세팅함
			
			ps = con.prepareStatement(sql); //ps에 쿼리의 내용이 들어감
			ps.setString(1, "a001"); //첫번째 물음표에 a001을 넣겠다.
			ps.setInt(2, 5); //두번째 물음표에 5를 넣겠다.
			// 앞에는 물음표의 순서, 뒤에는 타입에 맞는 데이터값
			// 물음표는 컬럼명이나 키워드를 대체할 수 없음, 오직 값만 대체할 수 있음
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			//메타데이터: 데이터에 대한 데이터, 데이터에 대한 구체적인 정보들
			
			int columnCount = metaData.getColumnCount();
			//getColumnCount: 컬럼이 몇개인지 알 수 있음
			
			for(int i = 1; i <= columnCount; i++){
				System.out.print(metaData.getColumnName(i) + "\t");
			}
			System.out.println();
			//metaData.getColumnName으로 컬렁명을 가져올 수 있다.
			
			
			while(rs.next()){
				for(int i = 1; i <= columnCount; i++){
					Object value = rs.getObject(i);//모든 컬럼을 가져올 수 있음
					System.out.print(value + "\t");
//					System.out.print(rs.getObject(i) + "\t");
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
