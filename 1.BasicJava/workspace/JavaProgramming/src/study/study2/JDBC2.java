package study.study2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "LDG89"; 
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select *"
			           + " from cart"
			           + " where cart_member = ?"
					   + " and cart_qty > ?";
			//줄바꿈을 했으면 맨 앞에 띄어쓰기 해줘야함
			//?(물음표)에는 나중에 값을 세팅함
			
			ps = con.prepareStatement(sql);
			//ps에 쿼리 내용 삽입
			ps.setString(1, "a001");
			//첫번째 물음표에 "a001"삽입
			ps.setInt(2,  5);
			//두번째 물음표에 5를 삽입
			//앞에는 물음표의 순서, 뒤에는 타입에 맞는 데이터값 삽입
			//물음표는 값만 대체 가능함, 컬럼명이나 키워드는 대체 불가능
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			//메타데이터: 데이터에 대한 데이터, 데이터에 대한 구체적인 정보들
			
			int columnCount = metaData.getColumnCount();
			//getColumnCount: 컬럼의 수를 카운트
			
			for(int i = 1; i <= columnCount; i++){
				System.out.print(metaData.getColumnName(i) + "\t");
				//metaData.getColumnName으로 컬럼명 추출
			}
			System.out.println();
			
			while(rs.next()){
				for(int i = 1; i <= columnCount; i++){
					Object value = rs.getObject(i);
					//모든 컬럼을 가져올 수 있음
					System.out.print(value + "\t");
				}
				System.out.println();
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}

	}

}
