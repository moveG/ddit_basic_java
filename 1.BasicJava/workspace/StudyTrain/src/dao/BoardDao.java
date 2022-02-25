package dao;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class BoardDao {
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
	public List<Map<String, Object>> selectBoardList() {
		String sql = "SELECT A.BOARD_NO"
				+ "        , A.BOARD_TITLE"
				+ "        , B.USER_NAME"
				+ "        , A.BOARD_DATE"
				+ "        , A.BOARD_TREAT"
				+ "        , A.BOARD_COUNT"
				+ "        , A.BOARD_STATUS"
				+ "        , A.BOARD_NOTIFY_NO"
				+ "        , B.USER_ID"
				+ "     FROM TRAIN_BOARD A"
				+ "     LEFT OUTER JOIN TRAIN_USER B"
				+ "       ON A.USER_NO = B.USER_NO"
				+ "    ORDER BY A.BOARD_NO DESC";
		return jdbc.selectList(sql);
	}
//카운트
	public int countBoard(int no) {
		String sql = "UPDATE TRAIN_BOARD"
				+ "      SET BOARD_COUNT = (BOARD_COUNT + 1)"
			    + "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}	
	
//게시물
	public Map<String, Object> selectBoard(int no) {
		String sql = "SELECT A.BOARD_NO"
				+ "        , A.BOARD_TITLE"
				+ "        , A.BOARD_CONTENT"
				+ "        , B.USER_NAME"
				+ "        , A.BOARD_DATE"
				+ "        , B.USER_ID"
				+ "        , A.BOARD_TREAT"
				+ "        , A.BOARD_STATUS"
				+ "        , A.BOARD_NOTIFY_NO"
				+ "     FROM TRAIN_BOARD A"
				+ "     LEFT OUTER JOIN TRAIN_USER B"
				+ "       ON A.USER_NO = B.USER_NO"
				+ "    WHERE A.BOARD_NO = " + no;
		return jdbc.selectOne(sql);
	}
	
//삽입
	public int insertBoard(String title, String content) {
		String sql = "INSERT INTO TRAIN_BOARD"
				+ "     VALUES ("
				+ "     (SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TRAIN_BOARD)"
				+ "     , '" + Controller.loginUser.get("USER_NO") + "'"
				+ "     , '" + title + "'"
				+ "     , '" + content + "'"
				+ "     , SYSDATE"
				+ "     , '대기'"
				+ "     , 1"
				+ "     , '정상'"
				+ "     , 1)";
		return jdbc.update(sql);
	}
	
//수정
	public int updateBoard(String title, String content, int no) {
		String sql = "UPDATE TRAIN_BOARD"
				+ "      SET BOARD_TITLE = '" + title + " ', BOARD_CONTENT = '" + content + " ', BOARD_DATE = SYSDATE"
			    + "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}
	
//삭제
	public int deleteBoard(int no) {
		String sql = "DELETE TRAIN_BOARD"
				+ "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}
	
//처리
	public int treatBoard(String treat, int no) {
		String sql = "UPDATE TRAIN_BOARD"
				+ "      SET BOARD_TREAT = '" + treat + "'"
				+ "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}
	
//신고
	public int notifyCount(int no) {
		String sql = "UPDATE TRAIN_BOARD"
				+ "      SET BOARD_NOTIFY_NO = (BOARD_NOTIFY_NO + 1)"
				+ "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}
	
	public int notifyBoard(String notify, int no) {
		String sql = "UPDATE TRAIN_BOARD"
				+ "      SET BOARD_STATUS = '" + notify + "'"
				+ "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}
	
//숨김, 복구
	public int hideBoard(String hide, int no) {
		String sql = "UPDATE TRAIN_BOARD"
				+ "      SET BOARD_STATUS = '" + hide + "'"
				+ "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}
	
	public int countZero(int no) {
		String sql = "UPDATE TRAIN_BOARD"
				+ "      SET BOARD_NOTIFY_NO = 0"
				+ "    WHERE BOARD_NO = " + no;
		return jdbc.update(sql);
	}
}
