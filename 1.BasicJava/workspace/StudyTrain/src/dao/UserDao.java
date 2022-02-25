package dao;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class UserDao {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private UserDao(){}
	private static UserDao instance;
	public static UserDao getInstance(){
		if(instance == null){
			instance = new UserDao();
		}
		return instance;
	}
	
//싱글톤 생성자	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
//회원가입
	public int insertUser(Map<String, Object> param) {
		String sql = "INSERT INTO TRAIN_USER VALUES("
				+ " (SELECT NVL(MAX(USER_NO), 0) + 1 FROM TRAIN_USER),"
				+ " '" + param.get("USER_NAME") + "',"
				+ " " + param.get("USER_BIRTH") + ","
				+ " '" + param.get("USER_ID") + "',"
				+ " '" + param.get("PASSWORD") + "',"
				+ " " + param.get("MILEAGE") + ","
				+ " '" + param.get("USER_DISABLED") + "',"
				+ " '" + param.get("USER_ADMIN") + "',"
				+ " '" + param.get("USER_TYPE") + "')";
		return jdbc.update(sql);
	}
//중복아이디 확인
	public Map<String, Object> idCheck(String userId) {
		String sql = "SELECT USER_ID"
				+ "     FROM TRAIN_USER"
				+ "    WHERE USER_ID = '" + userId + "'";
		return jdbc.selectOne(sql);
	}
	
//로그인
	public Map<String, Object> selectUser(String userId, String password) {
		String sql = "SELECT USER_NO, USER_NAME, USER_BIRTH, USER_ID, PASSWORD, MILEAGE, USER_DISABLED, USER_ADMIN, USER_TYPE"
				+ "     FROM TRAIN_USER"
				+ "    WHERE USER_ID = '" + userId + "'"
				+ "      AND PASSWORD = '" + password + "'";
		return jdbc.selectOne(sql);
	}
//찾기
	public Map<String, Object> searchID(String name, int birth) {
		String sql = "SELECT USER_ID"
				+ "     FROM TRAIN_USER"
				+ "    WHERE USER_NAME = '" + name + "'"
				+ "      AND USER_BIRTH = '" + birth + "'";
		return jdbc.selectOne(sql);
	}
	
	public Map<String, Object> searchPW(String id, String name, int birth) {
		String sql = "SELECT PASSWORD"
				+ "     FROM TRAIN_USER"
				+ "    WHERE USER_ID = '" + id + "'"
				+ "      AND USER_NAME = '" + name + "'"
				+ "      AND USER_BIRTH = '" + birth + "'";
		return jdbc.selectOne(sql);
	}
	
	public int changePW(String id, String newPassword, Object oldPassword) {
		String sql = "UPDATE TRAIN_USER"
				+ "      SET PASSWORD = '" + newPassword + "'"
				+ "    WHERE PASSWORD = '" + oldPassword + "'"
				+ "      AND USER_ID = '" + id + "'";
		return jdbc.update(sql);
	}
	
//개인정보창
	public Map<String, Object> setUser(String password) {
		String sql = "SELECT USER_NO, USER_NAME, USER_BIRTH, USER_ID, PASSWORD, MILEAGE, USER_DISABLED, USER_ADMIN"
				+ "     FROM TRAIN_USER"
				+ "    WHERE PASSWORD = '" + password + "'";
		return jdbc.selectOne(sql);
	}

//정보수정
	public int updateUser(String password, String newPassword) {
		String sql = "UPDATE TRAIN_USER"
				+ "      SET PASSWORD = '" + newPassword + "'"
				+ "    WHERE PASSWORD = '" + password + "'";
		return jdbc.update(sql);
	}
//장애여부수정	
	public int updateDisabled(String disabled, Object no) {
		String sql = "UPDATE TRAIN_USER"
				+ "      SET USER_DISABLED = '" + disabled + "'"
				+ "    WHERE USER_NO = '" + no + "'";
		return jdbc.update(sql);
	}
	
//회원탈퇴
	public int deleteUser(Object userId) {
		String sql = "UPDATE TRAIN_USER"
				+ "      SET USER_TYPE = '탈퇴회원'"
				+ "    WHERE USER_ID = '" + userId + "'";
		return jdbc.update(sql);
	}
	
//티켓조회
	public List<Map<String, Object>> ticketList() {
		String sql = "SELECT * FROM BOOK"
				+ "    WHERE USER_ID = '" + Controller.loginUser.get("USER_ID") + "'"
				+ "    ORDER BY 1";
		return jdbc.selectList(sql);
	}
}
