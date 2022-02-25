package study.study2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {

	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 게시판 테이블 컬럼: 번호(PK), 제목, 내용, 작성자, 작성일
		 */
		ArrayList<HashMap<String, Object>> boardTable = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		
		while(true){
			System.out.println("======================================");
			System.out.println("번호\t제목\t\t작성자\t작성일");
			for(int i = boardTable.size() - 1; i >= 0; i--){
				HashMap<String, Object> board = boardTable.get(i);
				System.out.println(board.get("No")
						+ "\t" + board.get("Title") 
						+ "\t\t" + board.get("User")
						+ "\t" + sdf.format(board.get("Reg_Date")));
			}
			System.out.println("\t\t<1.조회 / 2.등록 / 3.삭제 / 4.종료>");
			System.out.print("선택>");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1: //조회
				read(boardTable);
				break;
			case 2: //등록
				write(boardTable);
				break;
			case 3:	
				delete2(boardTable);
				break;
			case 4: //종료
				System.out.println("=================================");
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(3);
			}
		}
	}
	
	static void read(ArrayList<HashMap<String, Object>> boardTable){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.print("조회할 게시물을 선택해주세요.>");
		int no = ScanUtil.nextInt();
		
		HashMap<String, Object> board = null;//ArrayList에서 수정할 글을 뽑아 HashMap<String, Object>타입 board 변수에 저장함
		for(int i = 0; i < boardTable.size(); i++){
			if((Integer)boardTable.get(i).get("No") == no){
				board = boardTable.get(i);
				break;
			}
		}
		System.out.println("=================================");
		System.out.println(board.get("No") + "번 게시물");
		System.out.println("제목 : " + board.get("Title"));
		System.out.println("=================================");
		System.out.println("내용 : " + board.get("Content"));
		System.out.println("=================================");
		System.out.println("작성자 : " + board.get("User"));
		System.out.println("작성일 : " + sdf.format(board.get("Reg_Date")));
		System.out.println("=================================");
		System.out.println("\t\t<1.수정 / 2.삭제 / 3.목록>");
		int input = ScanUtil.nextInt();
		
		switch (input){
		case 1:
			update(board);
			break;
		case 2:
			delete(boardTable, board);
			break;
		}
		
	}
	
	static void write(ArrayList<HashMap<String, Object>> boardTable){
		System.out.println("제목을 입력해주세요.");
		String title = ScanUtil.nextLine();
		System.out.println("내용을 입력해주세요.");
		String content = ScanUtil.nextLine();
		System.out.println("작성자를 입력해주세요.");
		String user = ScanUtil.nextLine();
		
		int maxNo = 0;
		for(int i = 0; i < boardTable.size(); i++){
			int no = (Integer)boardTable.get(i).get("No");
			if(maxNo < no){
				maxNo = no;
			}
		}
		
		HashMap<String, Object> temp = new HashMap<>();
		temp.put("No", maxNo + 1);
		temp.put("Title", title);
		temp.put("Content", content);
		temp.put("User", user);
		temp.put("Reg_Date", new Date());
		
		boardTable.add(temp);
		System.out.println("게시글 등록이 완료되었습니다.");
	}
	
	static void update(HashMap<String, Object> board){
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
			board.put("Reg_Date", new Date());
			
			System.out.println("게시글 수정이 완료되었습니다.");
			break;
		case 2:
			break;
		}
	}
	
	static void delete(ArrayList<HashMap<String, Object>> boardTable, HashMap<String, Object> board){
		System.out.println("삭제하시겠습니까?");
		System.out.println("1.Yes / 2.No");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			for(int i = 0; i < boardTable.size(); i++){
				if(boardTable.get(i).get("No") == board.get("No")){
					boardTable.remove(i);
					System.out.println("게시글 삭제가 완료되었습니다.");
					break;
				}
			}
			break;
		case 2:
			break;
		}
	}
	
	static void delete2(ArrayList<HashMap<String, Object>> boardTable){
		System.out.print("삭제할 게시물을 선택해주세요.>");
		int no = ScanUtil.nextInt();
		System.out.println("삭제하시겠습니까?");
		System.out.println("1.Yes / 2.No");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			for(int i = 0; i < boardTable.size(); i++){
				if((Integer)boardTable.get(i).get("No") == no){
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
