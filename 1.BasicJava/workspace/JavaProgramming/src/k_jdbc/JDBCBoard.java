package k_jdbc;

import java.util.List;
import java.util.Date;
import java.util.Map;

import e_oop.ScanUtil;

public class JDBCBoard {

	public static void main(String[] args) {
		new JDBCBoard().start();
		
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	void start(){
		while(true){
			String sql = "SELECT A.BOARD_NO"
					+ "        , A.TITLE"
					+ "        , B.MEM_NAME AS USER_NAME"
					+ "        , TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
					+ "     FROM TB_JDBC_BOARD A"
					+ "     LEFT OUTER JOIN MEMBER B ON A.USER_ID = B.MEM_ID"
					+ "    ORDER BY A.BOARD_NO DESC";
			List<Map<String, Object>> list = jdbc.selectList(sql);

			System.out.println("=======================================");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("=======================================");
			for(Map<String, Object> board : list){
				System.out.println(board.get("BOARD_NO")
						+ "\t" + board.get("TITLE")
						+ "\t" + board.get("USER_NAME")
						+ "\t" + board.get("REG_DATE"));
			}
			System.out.println("=======================================");
			System.out.println("1.조회\t2.등록\t3.종료");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1: //조회
				read();
				break;
			case 2: //등록
				insert();
				break;
			case 3: //종료
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(3);
			}
		}
	}
	
	void read(){
		System.out.println("조회할 게시글 번호 입력>");
		int no = ScanUtil.nextInt();
		
		String sql = "SELECT A.BOARD_NO"
				+ "        , A.TITLE"
				+ "        , A.CONTENT"
				+ "        , B.MEM_NAME AS USER_NAME"
				+ "        , TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "     FROM TB_JDBC_BOARD A"
				+ "     LEFT OUTER JOIN MEMBER B ON A.USER_ID = B.MEM_ID"
				+ "    WHERE A.BOARD_NO = " + no;
		Map<String, Object> board = jdbc.selectOne(sql);
		
		System.out.println("=======================================");
		System.out.println("번호\t: " + board.get("BOARD_NO"));
		System.out.println("작성자\t: " + board.get("USER_NAME"));
		System.out.println("작성일\t: " + board.get("REG_DATE"));
		System.out.println("제목\t: " + board.get("TITLE"));
		System.out.println("내용\t: " + board.get("CONTENT"));
		System.out.println("=======================================");
		System.out.println("1.수정\t2.삭제\t3.목록");
		System.out.println("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: //수정
			update(no);
			break;
		case 2: //삭제
			delete(no);
			break;
		}
	}
	
	void insert(){
		System.out.println("제목>");
		String title = ScanUtil.nextLine();
		System.out.println("내용>");
		String content = ScanUtil.nextLine();
		System.out.println("이름>");
		String user = ScanUtil.nextLine();
		
		String sql = "INSERT INTO TB_JDBC_BOARD"
				+ " VALUES ("
				+ "(SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
				+ ", '" + title + "'"
				+ ", '" + content + "'"
				+ ", '" + user + "'"
				+ ", SYSDATE)";
		if(0 < jdbc.update(sql)){
			System.out.println("게시글 등록이 완료되었습니다.");
		}else{
			System.out.println("게시글 등록에 실패하였습니다.");
		}
	}
	
	void update(int no){
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		
		String sql = "UPDATE TB_JDBC_BOARD SET TITLE = '" + title + " ', CONTENT = '" + content + " ' WHERE BOARD_NO = " + no;
		if(0 < jdbc.update(sql)){
			System.out.println("게시글 수정이 완료되었습니다.");
		}else{
			System.out.println("게시글 수정에 실패하였습니다.");
		}
	}
	
	void delete(int no){
		System.out.println("삭제하시겠습니까?");
		System.out.println("1.Yes / 2.No");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			String sql = "DELETE TB_JDBC_BOARD WHERE BOARD_NO = " + no;
			if(0 < jdbc.update(sql)){
				System.out.println("게시글 삭제가 완료되었습니다.");
			}else{
				System.out.println("게시글 삭제에 실패하였습니다.");
			}
			break;
		case 2:
			break;
		}
	}

}
