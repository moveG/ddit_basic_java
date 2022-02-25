package study.study2;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;
import k_jdbc.JDBCUtil;

public class JDBCBoard {
	static JDBCUtil jdbc = JDBCUtil.getInstance();

//시작	
	public static void main(String[] args) {
		new JDBCBoard().start(jdbc);
	}
	
//게시판 목록
	static void start(JDBCUtil jdbc){
		SimpleDateFormat sdf1 = new SimpleDateFormat("yy/MM/dd");
		while(true){
			String sql = "SELECT BOARD_NO, TITLE, USER_ID, REG_DATE"
					   + " FROM TB_JDBC_BOARD"
					   + " ORDER BY 1";
			List<Map<String, Object>> list = jdbc.selectList(sql);
			
			System.out.println("=======================================");
			System.out.println("번호\t제목\t\t작성자\t작성일");
			System.out.println("=======================================");
			for(int i = list.size() - 1; i >= 0; i--){
				Map<String, Object> board = list.get(i);
				System.out.println(board.get("BOARD_NO")
						  + "\t" + board.get("TITLE")
						  + "\t\t" + board.get("USER_ID")
						  + "\t" + sdf1.format(board.get("REG_DATE")));
			}
			System.out.println("=======================================");
			System.out.println("\t\t[1.조회 | 2.등록 | 3.종료]");
			System.out.print("선택>");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1: //조회
				read(jdbc);
				break;
			case 2: //등록
				write(jdbc);
				break;
			case 3: //종료
				System.out.println("=======================================");
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(3);
			}
		}
	}
	
//조회
	static void read(JDBCUtil jdbc){
		SimpleDateFormat sdf1 = new SimpleDateFormat("yy/MM/dd");
		System.out.print("조회할 게시물을 선택해주세요.>");
		int no = ScanUtil.nextInt();
		
		String sql = "SELECT * FROM TB_JDBC_BOARD WHERE BOARD_NO = " + no;
		Map<String, Object> board = jdbc.selectOne(sql);
		
		System.out.println("=======================================");
		System.out.println(board.get("BOARD_NO") + "번 게시물");
		System.out.println("제목 : " + board.get("TITLE"));
		System.out.println("=======================================");
		System.out.println("내용 : ");
		System.out.println(board.get("CONTENT"));
		System.out.println();
		System.out.println("=======================================");
		System.out.println("작성자: " + board.get("USER_ID"));
		System.out.println("작성일: " + board.get("REG_DATE"));
		System.out.println("=======================================");
		System.out.println("\t\t[1.수정 | 2.삭제 | 3.목록]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //수정
			update(no);
			break;
		case 2: //삭제
			delete(no);
			break;
		case 3: //목록
			break;
		}
	}
	
//등록
	static void write(JDBCUtil jdbc){
		System.out.println("제목을 입력하세요.>");
		String title = ScanUtil.nextLine();
		System.out.println("내용을 입력하세요.>");
		String content = ScanUtil.nextLine();
		System.out.println("이름을 입력하세요.>");
		String user = ScanUtil.nextLine();
		
		String sql = "INSERT INTO TB_JDBC_BOARD (BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE)"
			+ " VALUES ((SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD), '" + title + " ', '" + content + " ', '" + user + " ', SYSDATE)";
		int update = jdbc.update(sql);
		System.out.println("게시글 등록이 완료되었습니다.");
	}
	
//수정
	static void update(int no){
		System.out.println("수정하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //수정
			System.out.println("제목을 수정해주세요.");
			String title = ScanUtil.nextLine();
			System.out.println("내용을 수정해주세요.");
			String content = ScanUtil.nextLine();
			
			String sql = "UPDATE TB_JDBC_BOARD "
				+ " SET TITLE = '" + title + " ', CONTENT = '" + content + " ' WHERE BOARD_NO = " + no;
			int update = jdbc.update(sql);
			System.out.println("게시글 수정이 완료되었습니다.");
			break;
		case 2: //목록으로
			break;
		}		
	}
	
//삭제
	static void delete(int no){
		System.out.println("삭제하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //삭제
			String sql = "DELETE TB_JDBC_BOARD WHERE BOARD_NO = " + no;
			int update = jdbc.update(sql);
			System.out.println("게시글 삭제가 완료되었습니다.");
			break;
		case 2: //목록으로
			break;
		}
	}
}
