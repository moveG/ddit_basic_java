package k_jdbc;

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
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //드라이버 @ IP주소, SID
		String user = "LDG89";
		String password = "java";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password); //예외처리를 하지않으면 컴파일 에러 발생
			//드라이버매니저의 도움을 받아 연결
			
			String sql = "select * from member";//쿼리 작성, ""안에 ;넣으면 오류 발생
//			String sql = "insert into member values('', '', '');//insert문 사용방법
			ps = con.prepareStatement(sql); //ps가 쿼리의 정보를 가지고 있음, 작성한 쿼리를 ps 객체에 넘김
			
			//select의 경우 실행방법
			rs = ps.executeQuery(); //쿼리 실행
			
			//insert, update, delete의 경우 실행방법
//			int result = ps.executeUpdate(); //영향받은 행의 개수를 리턴해줌
			//JDBC에서 쿼리를 날리면 오라클SQL에 변화가 발생함, 자동으로 COMMIT되기 때문에 오라클SQL에서 ROLLBACK을 해도 돌아가지 않음
			
			//select와 update의 차이: 리턴값의 차이(select의 결과가 ResultSet으로 반환, update는 int타입을 반환)
			
			while(rs.next()){//next: resultSet의 결과에서 아무것도 바라보지 않다가 next를 소환 후 첫번째 행을 바라보게 됨, 
				             //첫 행의 존재여부를 리턴함, 첫 행이 존재하면 true반환하고 while문 실행, 첫 행이 없으면 false반환하고 while문 탈출
				String memId = rs.getString(1);//'1': 컬럼의 인덱스, 첫번째 컬럼(MEM_ID)을 의미, 컬럼인덱스 또는 컬럼명을 기술할 수 있음
				String memPass = rs.getString("MEM_PASS");//지금 바라보고 있는 첫 행에서만 데이터를 가져올 수 있음, 오라클에서의 값의 타입에 따라 get뒤의 단어가 달라짐
				String memName = rs.getString(3);
				System.out.println("MEM_ID : " + memId + " | MEM_PASS : " + memPass + " | MEM_NAME : " + memName);
				System.out.println("=========================================================================");
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
