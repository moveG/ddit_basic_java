package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class LineDao {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private LineDao(){}
	private static LineDao instance;
	public static LineDao getInstance(){
		if(instance == null){
			instance = new LineDao();
		}
		return instance;
	}
	
//싱글톤 생성자	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
//노선리스트
	public List<Map<String, Object>> selectLineList() {
		String sql = "SELECT *"
				+ "     FROM LINE_INFO"
				+ "    ORDER BY 1";
		return jdbc.selectList(sql);
	}
	
//노선등록
	public int insertLine(Map<String, Object> param) {
		String sql = "INSERT INTO ";
		
		return jdbc.update(sql);
//		
//		public int insertRoute(Map<String,Object> param) //지역 등록
//		{
//			int num=1;
//			List<Map<String, Object>> many;
//			String check="SELECT COUNT(*) FROM TRAIN_ROUTE";
//			if (Integer.parseInt(jdbc.selectOne(check).get("COUNT(*)").toString())!=0)
//			{
//				many = jdbc.selectList("SELECT * FROM TRAIN_ROUTE ORDER BY 1 DESC");
//				for (int i=0;i<many.size();i++)
//				{
//					if (num<Integer.parseInt(many.get(i).get("ROUTE_NO").toString()))
//					{
//						num=Integer.parseInt(many.get(i).get("ROUTE_NO").toString());
//					}
//				}
//				num+=1;
//			}
//			String sql= "INSERT INTO TRAIN_ROUTE VALUES ("+num+",'"+param.get("ROUTE_NAME")+"')";
//			return jdbc.update(sql);
//		}
		
//		
//		public int insertUser(Map<String, Object> param) {
//			String sql = "INSERT INTO TRAIN_USER VALUES("
//					+ " (SELECT NVL(MAX(USER_NO), 0) + 1 FROM TRAIN_USER),"
//					+ " '" + param.get("USER_NAME") + "',"
//					+ " " + param.get("USER_BIRTH") + ","
//					+ " '" + param.get("USER_ID") + "',"
//					+ " '" + param.get("PASSWORD") + "',"
//					+ " " + param.get("MILEAGE") + ","
//					+ " '" + param.get("USER_DISABLED") + "',"
//					+ " '" + param.get("USER_ADMIN") + "',"
//					+ " '" + param.get("USER_TYPE") + "')";
//			return jdbc.update(sql);
//		}
		
		
		
		
	}
}
