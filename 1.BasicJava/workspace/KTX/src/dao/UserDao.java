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
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertUser(Map<String,Object> param) //테이블에 새로 추가. 즉 회원가입
	{
		String sql= "INSERT INTO TB_KTX_USER VALUES ("
				+"'"+param.get("USER_ID")+"',"
				+"'"+param.get("PASSWORD")+"',"
				+"'"+param.get("USER_NAME")+"',"
				+"'"+param.get("USER_LOCATE")+"',"
				+"'"+param.get("USER_AGE")+"')"; 
		return jdbc.update(sql);
	}
	
	public int insertAdmin(Map<String,Object> param) //테이블에 새로 추가. 즉 관리자용 회원가입
	{
		String sql= "INSERT INTO TB_KTX_ADMIN VALUES ("
				+"'"+param.get("ADMIN_ID")+"',"
				+"'"+param.get("PASSWORD")+"',"
				+"'"+param.get("ADMIN_NAME")+"')"; 
		return jdbc.update(sql);
	}

	public Map<String, Object> selectUser(String userId, String password) {  //조회하여 반환. 로그인할때 필요함.
		String sql="SELECT *"
				+" FROM TB_KTX_USER"
				+" WHERE USER_ID = '"+userId+"'"
				+" AND PASSWORD = '"+password+"'";
		return jdbc.selectOne(sql); //값이 들어가서 정상적으로 수행이 된다하더라도, 특정 행이 반환되지 않았다면 (null) 로그인 하지 못하도록 설계.
	}
	

	public Map<String, Object> selectAdmin(String adminId, String password) {  //조회하여 반환. 관리자 로그인할때 필요함.
		String sql="SELECT *"
				+" FROM TB_KTX_ADMIN"
				+" WHERE ADMIN_ID = '"+adminId+"'"
				+" AND PASSWORD = '"+password+"'";
		return jdbc.selectOne(sql); //값이 들어가서 정상적으로 수행이 된다하더라도, 특정 행이 반환되지 않았다면 (null) 로그인 하지 못하도록 설계.
	}
	
	
	public int updateUser(Map<String,Object> param) //로그인한 회원정보 수정.
	{
		String sql="UPDATE TB_KTX_USER SET USER_ID='"+param.get("USER_ID")+"',USER_NAME='"+param.get("USER_NAME")+"' WHERE USER_ID="+Controller.LoginUser.get("USER_ID");
		return jdbc.update(sql);
	}
	
	public List<Map<String,Object>> selectUserList() //모든 유저 미리보기용 전체 조회.
	{
		String sql="SELECT * FROM TB_KTX_USER";
		return jdbc.selectList(sql);
	}
}
