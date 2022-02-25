package k_jdbc;

import java.util.List;
import java.util.Map;

public class JDBCTest {

	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		
//		List<Map<String, Object>> list = jdbc.selectList("select * from member");
//		for(int i = 0; i < list.size(); i++){
//			System.out.println(list.get(i));
//		}
		List<Map<String, Object>> list = jdbc.selectList("SELECT MAX(BOARD_NO) FROM TB_JDBC_BOARD");
		System.out.println(list);
//		Map<String, Object> map = jdbc.selectOne("select * from member where mem_name = '김은대'");
//		System.out.println(map);
//		
//		int update = jdbc.update("update member set values mem_regno1 = ");
	}

}
