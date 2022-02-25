package dao;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class NoticeDao {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private NoticeDao(){}
	private static NoticeDao instance;
	public static NoticeDao getInstance(){
		if(instance == null){
			instance = new NoticeDao();
		}
		return instance;
	}
	
//싱글톤 생성자
	private JDBCUtil jdbc = JDBCUtil.getInstance();

//공지게시판
	public List<Map<String, Object>> selectNoticeList(){
		String sql = "SELECT A.NOTICE_NO"
				+ "        , A.NOTICE_TITLE"
				+ "        , A.USER_NO"
				+ "        , B.USER_NAME"
				+ "        , A.NOTICE_DATE"
				+ "        , A.NOTICE_COUNT"
				+ "        , B.USER_ID"
				+ "        , B.USER_ADMIN"
				+ "     FROM TRAIN_NOTICE A"
				+ "     LEFT OUTER JOIN TRAIN_USER B"
				+ "       ON A.USER_NO = B.USER_NO"
				+ "    ORDER BY A.NOTICE_NO DESC";
		return jdbc.selectList(sql);
	}

//카운트
	public int countNotice(int no) {
		String sql = "UPDATE TRAIN_NOTICE"
				+ "      SET NOTICE_COUNT = (NOTICE_COUNT + 1)"
			    + "    WHERE NOTICE_NO = " + no;
		return jdbc.update(sql);
	}		
	
//공지글
	public Map<String, Object> selectNotice(int no) {
		String sql = "SELECT A.NOTICE_NO"
				+ "        , A.NOTICE_TITLE"
				+ "        , A.NOTICE_CONTENT"
				+ "        , B.USER_NAME"
				+ "        , A.NOTICE_DATE"
				+ "        , B.USER_ID"
				+ "        , B.USER_ADMIN"
				+ "     FROM TRAIN_NOTICE A"
				+ "     LEFT OUTER JOIN TRAIN_USER B"
				+ "       ON A.USER_NO = B.USER_NO"
				+ "    WHERE A.NOTICE_NO = " + no;
		return jdbc.selectOne(sql);
	}
	
//삽입
	public int insertNotice(String title, String content) {
		String sql = "INSERT INTO TRAIN_NOTICE"
				+ "     VALUES ("
				+ "     (SELECT NVL(MAX(NOTICE_NO), 0) + 1 FROM TRAIN_NOTICE)"
				+ "     , '" + Controller.loginUser.get("USER_NO") + "'"
				+ "     , '" + title + "'"
				+ "     , '" + content + "'"
				+ "     , SYSDATE"
				+ "     , 1)";
		return jdbc.update(sql);
	}
	
//수정
	public int updateNotice(String title, String content, int no) {
		String sql = "UPDATE TRAIN_NOTICE"
				+ "      SET NOTICE_TITLE = '" + title + " ', NOTICE_CONTENT = '" + content + " ', NOTICE_DATE = SYSDATE"
			    + "    WHERE NOTICE_NO = " + no;
		return jdbc.update(sql);
	}
	
//삭제
	public int deleteNotice(int no) {
		String sql = "DELETE TRAIN_NOTICE "
				+ "    WHERE NOTICE_NO = " + no;
		return jdbc.update(sql);
	}
}
