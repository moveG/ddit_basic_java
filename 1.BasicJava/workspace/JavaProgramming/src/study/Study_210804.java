package study;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Study_210804 {
	static int no = 1;
	
	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 게시판 테이블 컬럼: 번호(PK), 제목, 내용, 작성자, 작성일
		 */
		ArrayList<HashMap<String, Object>> boardTable= new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
//게시판 목록창		
		while(true){
			System.out.println("=======================================");
			System.out.println("번호\t제목\t\t작성자\t작성일");
			System.out.println("=======================================");
			for(int i = boardTable.size() - 1; i >= 0; i--){
				HashMap<String, Object> board = boardTable.get(i);
				System.out.println(board.get("No")
						  + "\t" + board.get("Title")
						  + "\t\t" + board.get("User")
						  + "\t" + sdf.format(board.get("Date")));
			}
			System.out.println("=======================================");
			System.out.println("\t\t[1.조회 / 2.등록 / 3.종료]");
			System.out.print("선택>");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1: //조회
				read(boardTable);
				break;
			case 2: //등록
				write(boardTable);
				break;
			case 3: //종료
				System.out.println("=======================================");
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(3);
			}
		}
	}
//조회	
	static void read(ArrayList<HashMap<String, Object>> boardTable) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.print("조회할 게시물을 선택해주세요.>");
		int no = ScanUtil.nextInt();
		
		HashMap<String, Object> board = new HashMap<>();
		for(int i = 0; i < boardTable.size(); i++){
			if((Integer)boardTable.get(i).get("No") == no){
				board = boardTable.get(i);
				break;
			}
		}
		System.out.println("=======================================");
		System.out.println(board.get("No") + "번 게시물");
		System.out.println("제목 : " + board.get("Title"));
		System.out.println("=======================================");
		System.out.println("내용 : ");
		System.out.println();
		System.out.println(board.get("Content"));
		System.out.println();
		System.out.println("=======================================");
		System.out.println("작성자 : " + board.get("User"));
		System.out.println("작성일 : " + sdf.format(board.get("Date")));
		System.out.println("=======================================");
		System.out.println("\t\t[1.수정 / 2.삭제 / 3.목록]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			update(board);
			break;
		case 2:
			delete(boardTable, board);
			break;
		}
		
	}
//등록
	static void write(ArrayList<HashMap<String, Object>> boardTable) {
		System.out.println("제목을 입력하세요.>");
		String title = ScanUtil.nextLine();
		System.out.println("내용을 입력하세요.>");
		String content = ScanUtil.nextLine();
		System.out.println("작성자를 입력하세요.>");
		String user = ScanUtil.nextLine();
		
		HashMap<String, Object> temp = new HashMap<>();
		temp.put("No", no);
		temp.put("Title", title);
		temp.put("Content", content);
		temp.put("User", user);
		temp.put("Date", new Date());
		
		boardTable.add(temp);
		System.out.println("게시글 등록이 완료되었습니다.");
	}
//수정	
	static void update(HashMap<String, Object> board) {
		System.out.println("수정하시겠습니까?");
		System.out.println("1.Yes / 2.No");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			System.out.println("제목을 수정해주세요.");
			String title = ScanUtil.nextLine();
			System.out.println("내용을 수정해주세요.");
			String content = ScanUtil.nextLine();
			
			board.put("Title", title);
			board.put("Content", content);
			board.put("Date", new Date());
			
			System.out.println("게시글 수정이 완료되었습니다.");
			break;
		case 2:
			break;
		}
	}
//삭제	
	static void delete(ArrayList<HashMap<String, Object>> boardTable, HashMap<String, Object> board) {
		System.out.println("삭제하시겠습니까?");
		System.out.println("1.Yes / 2.No");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			for(int i = 0; i < boardTable.size(); i++){
				if(boardTable.get(i).get("No") == board.get("No")){
					boardTable.remove(i);
					System.out.println("게시글 삭제가 완료되었습니다.");
				}
			}
			break;
		case 2:
			break;
		}
	}
}
