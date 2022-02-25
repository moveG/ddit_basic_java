package dao;

import util.JDBCUtil;

public class KTXDao {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private KTXDao(){}
	private static KTXDao instance;
	public static KTXDao getInstance(){
		if(instance == null){
			instance = new KTXDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
}
