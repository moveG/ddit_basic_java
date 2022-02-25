package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BookDao {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private BookDao(){}
	private static BookDao instance;
	public static BookDao getInstance(){
		if(instance == null){
			instance = new BookDao();
		}
		return instance;
	}
	
//싱글톤 생성자	
	private JDBCUtil jdbc = JDBCUtil.getInstance();

//예약게시판
	public List<Map<String, Object>> selectBoardList() {
		String sql = "SELECT A.BOOK_NO"
				+ "        , B.USER_NO"
				+ "        , B.USER_NAME"
				+ "        , A.BOOK_DATE"
				+ "        , A.PAY_STATUS"
				+ "        , A.PRICE"
				+ "     FROM BOOK A"
				+ "     LEFT OUTER JOIN TRAIN_USER B"
				+ "       ON A.USER_NO = B.USER_NO"
				+ "    ORDER BY BOOK_NO DESC";
		return jdbc.selectList(sql);
	}
	
//예약페이지
	
//예약
	public int insertBook(){
		String sql = "INSERT INTO BOOK_SEAT"
				+ "     VALUES ("
				+ "     (SELECT NVL(BOOK_NO), 0) + 1 FROM BOOK)"
				+ "     , '";
		return jdbc.update(sql);
	}
	
//예약취소
	public int cancelBook(int no){
		String sql = "DELETE BOOK_SEAT"
				+ "    WHERE BOOK_NO = " + no;
		return jdbc.update(sql);
		}
	
	public int cancelBook2(int no){
		String sql = "DELETE BOOK"
				+ "    WHERE BOOK_NO = " + no;
		return jdbc.update(sql);
		}
	
	
	
	
	
	
}
