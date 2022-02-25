package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class AreaDao {
//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private AreaDao(){}
	private static AreaDao instance;
	public static AreaDao getInstance(){
		if(instance == null){
			instance = new AreaDao();
		}
		return instance;
	}
	
//싱글톤 생성자
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
//지역리스트
	public List<Map<String, Object>> selectAreaList() {
		String sql = "SELECT *"
				+ "     FROM LINE_INFO"
				+ "    ORDER BY 1, 2";
		return jdbc.selectList(sql);
	}
	
	
	
	
		
}
