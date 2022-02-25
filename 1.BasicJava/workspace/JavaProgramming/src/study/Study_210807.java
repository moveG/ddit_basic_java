package study;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;
import k_jdbc.JDBCUtil;

public class Study_210807 {
	JDBCUtil jdbc = JDBCUtil.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");

//시작
	public static void main(String[] args) {
		new Study_210807().start();
	}
	
//게시판 목록
	void start(){
		while(true){
			String sql = " Select * "
					   + " from TB_JDBC_BOARD A"
					   + " ORDER BY 1";
			List<Map<String, Object>> list = jdbc.selectList(sql);
			
			System.out.println("=======================================");
			System.out.println("번호\t제목\t\t작성자\t작성일");
			System.out.println("=======================================");
			
			for(int i = list.size() - 1; i >= 0; i--){
				Map<String, Object> board = list.get(i);
				System.out.println(board.get("BOARD_NO")
						  + "\t" + board.get("TITLE")
						  + "\t" + board.get("USER_ID")
						  + "\t" + sdf.format(board.get("REG_DATE")));
			}
			System.out.println("=======================================");
			System.out.println("\t\t[1.조회 | 2.등록 | 3.종료]");
			System.out.print("선택>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				read();
				break;
			case 2:
				write();
				break;
			case 3:
				System.out.println("=======================================");
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(3);
				break;
			}
		}
	}
	
//조회
	void read(){
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
	void write(){
		System.out.println("제목을 입력하세요.>");
		String title = ScanUtil.nextLine();
		System.out.println("내용을 입력하세요.>");
		String content = ScanUtil.nextLine();
		System.out.println("이름을 입력하세요.>");
		String user = ScanUtil.nextLine();
	
		String sql = "INSERT INTO TB_JDBC_BOARD (BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE)"
				+ " VALUES ((SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD), '" + title + " ', '" + content + " ', '" + user + " ', SYSDATE)";
		if(0 < jdbc.update(sql)){
			System.out.println("게시글 등록이 완료되었습니다.");
		}else{
			System.out.println("게시글 등록에 실패하였습니다.");
		}
	}
	
//수정
	void update(int no){
		System.out.println("수정하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //수정
			System.out.println("제목을 수정해주세요.");
			String title = ScanUtil.nextLine();
			System.out.println("내용을 수정해주세요.");
			String content = ScanUtil.nextLine();
			
			String sql = "UPDATE TB_JDBC_BOARD SET TITLE = '" + title + " ', CONTENT = '" + content + " ' WHERE BOARD_NO = " + no;
			if(0 < jdbc.update(sql)){
				System.out.println("게시글 수정이 완료되었습니다.");
			}else{
				System.out.println("게시글 수정에 실패하였습니다.");
			}
			break;
		case 2: //목록
			break;
		}
	}
	
//삭제
	void delete(int no){
		System.out.println("삭제하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //삭제
			String sql = "DELETE TB_JDBC_BOARD WHERE BOARD_NO = " + no;
			if(0 < jdbc.update(sql)){
				System.out.println("게시글 삭제가 완료되었습니다.");
			}else{
				System.out.println("게시글 삭제에 실패하였습니다.");
			}
			break;
		case 2: //목록으로
			break;
		}
	}
}
