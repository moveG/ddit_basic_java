package study.study2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) {
		/*
		 * JDBC(Java Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - OJDBC: 오라클 JDBC
		 * 
		 * JDBC 작성단계
		 * 1. Connection 생성(DB 연결)
		 * 2. Statement 생성(쿼리 작성)
		 * 3. Query 실행(select(결과 존재O) or not(결과 존재X))
		 * 4. ResultSet에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기(역순으로 닫아야함)
		 */
		
		//데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//드라이버 @ IP주소, SID
		String user = "LDG89"; 
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//예외처리를 하지 않으면 컴파일 에러 발생
			//DriverManager를 통해 연결
			
//			String sql = "insert into member value('', '', '')";
			//쿼리 작성, insert문 사용방법
			String sql = "select * from member";
			//쿼리 작성, ""(쌍따옴표) 안에는 ;(세미콜론) 넣으면 오류 발생
			
			ps = con.prepareStatement(sql);
			//작성한 쿼리를 ps객체에 넘김
			
//			int result = ps.executeUpdate();
			//insert, update, delete 실행방법, 영향을 받은 행들의 숫자를 리턴함
			//JDBC에서의 동작은 자동커밋이 되기 때문에 오라클SQL에서 롤백을 해도 복구가 불가능함
			
			rs = ps.executeQuery();
			//select 실행방법
			//select는 결과가 ResultSet으로 반환되지만, update는 int타입으로 반횐됨
			
			while(rs.next()){
			//rs.next(): 첫번째 행을 지목함, 첫행의 존재여부를 리턴함, 존재시 true를, 부존재시 false를 반환
				String memId = rs.getString(1);
				String memPass = rs.getString("MEM_PASS");
				String memName = rs.getString(3);
				
				System.out.println("MEM_ID : " + memId + "MEM_PASS : " + memPass + "MEM_NAME : " + memName);
				System.out.println("=======================================================================");
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
