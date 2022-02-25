package study.study2;

import java.util.List;
import java.util.Map;

public class JDBC_Test {

	public static void main(String[] args) {
		JDBC_Util jdbc = JDBC_Util.getInstance();
		
		Map<String, Object> map = jdbc.selectOne("select * from member where mem_name = '김은대'");
		System.out.println(map);
		
		List<Map<String, Object>> list = jdbc.selectList("select * from cart");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
