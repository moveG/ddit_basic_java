package j_collection;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class BoardAnswer {

	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 게시판 테이블 컬럼: 번호(PK), 제목, 내용, 작성자, 작성일
		 */
		ArrayList<HashMap<String, Object>> boardTable = new ArrayList<>();
		//파라미터로 넣던가, 전역변수로 설정해주면 다른 메서드에서 사용할 수 있음, 지금은 전역변수로 빼면 컴파일 오류가 발생하므로 파라미터로 넘기는 방식으로 구현함
		
		while(true){
			System.out.println("=======================================");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("=======================================");
			for(int i = boardTable.size() - 1; i >= 0; i--){
				HashMap<String, Object> board = boardTable.get(i);
				System.out.println(board.get("NO")
						+ "\t" + board.get("TITLE")
						+ "\t" + board.get("USER")
						+ "\t" + board.get("REG_DATE"));
			
			}
			System.out.println("=======================================");
			System.out.println("1.조회\t2.등록\t3.종료");
			int input = ScanUtil.nextInt();
		
			switch (input) {
			case 1: //조회
				read(boardTable);
				break;
			case 2: //등록
				insert(boardTable);
				break;
			case 3: //종료
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(3);
			}
		}
	}
	
	static void read(ArrayList<HashMap<String, Object>> boardTable) {
		System.out.print("조회할 게시글 번호 입력>");
		int no = ScanUtil.nextInt();
		
		HashMap<String, Object> board = null; //수정할 글을 변수에 담음
		for(int i = 0; i < boardTable.size(); i++){
			if((Integer)boardTable.get(i).get("NO") == no){
				board = boardTable.get(i);
				break;
			}
		}
		
		System.out.println("=======================================");
		System.out.println("번호\t: " + board.get("NO"));
		System.out.println("작성자\t: " + board.get("USER"));
		System.out.println("작성일\t: " + board.get("REG_DATE"));
		System.out.println("제목\t: " + board.get("TITLE"));
		System.out.println("내용\t: " + board.get("CONTENT"));
		System.out.println("=======================================");
		System.out.println("1.수정\t2.삭제\t3.목록");
		System.out.println("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: //수정
			update(board);
			break;
		case 2: //삭제
			delete(boardTable, board);
			break;
		}
		
		
	}
	
	static void delete(ArrayList<HashMap<String, Object>> boardTable, HashMap<String, Object> board) {
		for(int i = 0; i < boardTable.size(); i++){
			if(boardTable.get(i).get("NO") == board.get("NO")){
					boardTable.remove(i);
					System.out.println("삭제가 완료되었습니다.");
					break;
			}
		}
	}
	
	static void insert(ArrayList<HashMap<String, Object>> boardTable) {
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		System.out.print("이름>");
		String user = ScanUtil.nextLine();

		int maxNo = 0;
		for(int i = 0; i < boardTable.size(); i++){
			int no = (Integer)boardTable.get(i).get("NO");
			if(maxNo < no){
				maxNo = no;
			}
		}
		
		HashMap<String, Object> temp = new HashMap<>();
		temp.put("NO", maxNo + 1);
		temp.put("TITLE", title);
		temp.put("CONTENT", content);
		temp.put("USER", user);
		temp.put("REG_DATE", new Date());
		
		boardTable.add(temp);
		System.out.println("게시글 등록이 완료되었습니다.");
	}
	
	static void update(HashMap<String, Object> board) {
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
	
		board.put("TITLE", title);
		board.put("CONTENT", content);
	
		System.out.println("수정이 완료되었습니다.");
	}
}

	





