package dao;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class BoardDao {	//게시판과 관련된 Dao
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private BoardDao(){}
	private static BoardDao instance;
	public static BoardDao getInstance(){
		if(instance == null){
			instance = new BoardDao();
		}
		return instance;
	}
	
//싱글톤 생성자
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
//게시판
	public List<Map<String, Object>> selectBoardList(){
		String sql = "SELECT A.BOARD_NO"
				+ "        , A.TITLE"
				+ "        , B.USER_NAME"
				+ "        , A.REG_DATE"
				+ "        , B.USER_ID"
				+ "     FROM TB_JDBC_BOARD A"
				+ "     LEFT OUTER JOIN TB_JDBC_USER B"
				+ "       ON A.USER_ID = B.USER_ID"
				+ "    ORDER BY A.BOARD_NO DESC";
		return jdbc.selectList(sql);
	}

//게시물
	public Map<String, Object> selectBoard(int no) {
		String sql = "SELECT A.BOARD_NO"
				+ "        , A.TITLE"
				+ "        , A.CONTENT"
				+ "        , B.USER_NAME"
				+ "        , REG_DATE"
				+ "        , B.USER_ID"
				+ "     FROM TB_JDBC_BOARD A"
				+ "     LEFT OUTER JOIN TB_JDBC_USER B"
				+ "       ON A.USER_ID = B.USER_ID"
				+ "    WHERE A.BOARD_NO = " + no;
		return jdbc.selectOne(sql);
	}
	
//삽입
	public int insertBoard(String title, String content) {
		String sql = "INSERT INTO TB_JDBC_BOARD"
				+ "     VALUES ("
				+ "     (SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
				+ "     , '" + title + "'"
				+ "     , '" + content + "'"
				+ "     , '" + Controller.loginUser.get("USER_ID") + "'"
				+ "     , SYSDATE)";
		return jdbc.update(sql);
	}
	
//수정
	public int updateBoard(String title, String content, int no) {
		String sql = "UPDATE TB_JDBC_BOARD "
				+ "      SET TITLE = '" + title + " ', CONTENT = '" + content + " ' "
			    + "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}
	
//삭제
	public int deleteBoard(int no) {
		String sql = "DELETE TB_JDBC_BOARD "
				+ "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}
}
