package dao;

import java.util.Map;

import util.JDBCUtil;

public class UserDao {	//유저와 관련된 Dao
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
		String sql = "INSERT INTO TB_JDBC_USER VALUES("
				+ "'" + param.get("USER_ID") + "',"
				+ "'" + param.get("PASSWORD") + "',"
				+ "'" + param.get("USER_NAME") + "')";
		return jdbc.update(sql);
	}
//중복아이디 확인
	public Map<String, Object> idCheck(String userId) {
		String sql = "SELECT USER_ID"
				+ "     FROM TB_JDBC_USER"
				+ "    WHERE USER_ID = '" + userId + "'";
		return jdbc.selectOne(sql);
	}
	
//로그인
	public Map<String, Object> selectUser(String userId, String password){
		String sql = "SELECT USER_ID, PASSWORD, USER_NAME"
				+ "     FROM TB_JDBC_USER"
				+ "    WHERE USER_ID = '" + userId + "'"
				+ "      AND PASSWORD = '" + password + "'";
		return jdbc.selectOne(sql);
	}

//개인정보창
	public Map<String, Object> setUser(String password){
		String sql = "SELECT USER_ID, PASSWORD, USER_NAME"
				+ "     FROM TB_JDBC_USER"
				+ "    WHERE PASSWORD = '" + password + "'";
		return jdbc.selectOne(sql);
	}

//정보수정
	public int updateUser(String password, String newPassword) {
		String sql = "UPDATE TB_JDBC_USER"
				+ "      SET PASSWORD = '" + newPassword + "'"
				+ "    WHERE PASSWORD = '" + password + "'";
		return jdbc.update(sql);
	}
	
//회원탈퇴
	public int deleteUser(Object userId) {
		String sql = "DELETE TB_JDBC_USER "
				+ "    WHERE USER_ID = '" + userId + "'";
		return jdbc.update(sql);
	}
}
