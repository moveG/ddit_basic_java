package j_collection;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import e_oop.ScanUtil;

public class Board {
	
	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 게시판 테이블 컬럼: 번호(PK), 제목, 내용, 작성자, 작성일
		 */
		
		Scanner sc = new Scanner(System.in);
		ArrayList<HashMap<String, Object>> boardTable = new ArrayList<>();
		
		while(true){
			System.out.println("번호\t제목\t\t작성자\t작성일");
			for(int i = boardTable.size() - 1; i >= 0; i--){
				HashMap<String, Object> board = boardTable.get(i);
				System.out.println(board.get("번호")
						+ "\t" + board.get("제목")
						+ "\t\t" + board.get("작성자")
						+ "\t" + board.get("작성일"));
			}
			System.out.println("\t\t\t<1.조회 / 2.등록 / 3.종료>");
			System.out.println("선택>");
			int input = Integer.parseInt(sc.nextLine());
			if(input == 1){
				read(boardTable);
			}else if(input == 2){
				write(boardTable);
			}else if(input == 3){
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(5);
			}
		}
	}

	static void read(ArrayList<HashMap<String, Object>> boardTable){
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 게시물을 선택해주세요.");
		int no = Integer.parseInt(sc.nextLine());
		
		HashMap<String, Object> board = new HashMap<>();
		for(int i = 0; i < boardTable.size(); i++){
			if((Integer)boardTable.get(i).get("번호") == no){
				board = boardTable.get(i);
				break;
			}
		}
		
		System.out.println("=================================");
		System.out.println(board.get("번호") + "번 게시물");
		System.out.println("제목 : " + board.get("제목"));
		System.out.println("=================================");
		System.out.println("내용 : " + board.get("내용"));
		System.out.println("=================================");
		System.out.println("작성자 : " + board.get("작성자"));
		System.out.println("작성일 : " + board.get("작성일"));
		System.out.println("=================================");
		System.out.println("\t\t<1.수정 / 2.삭제 / 3.목록>");
			int input = Integer.parseInt(sc.nextLine());
			switch (input) {
			case 1:
				modify(board);
				break;
			case 2:
				delete(boardTable, board);
				break;
			}
	}
	
	static void write(ArrayList<HashMap<String, Object>> boardTable){
		Scanner sc = new Scanner(System.in);
		System.out.println("제목을 입력해주세요.");
		String title = sc.nextLine();
		System.out.println("내용을 입력해주세요.");
		String content = sc.nextLine();
		System.out.println("작성자를 입력해주세요.");
		String name = sc.nextLine();
		
		int maxNo = 0;
		for(int i = 0; i < boardTable.size(); i++){
			int no = (Integer)boardTable.get(i).get("번호");
			if(maxNo < no){
				maxNo = no;
			}
		}
		
		HashMap<String, Object> temp = new HashMap<>();
		temp.put("번호", maxNo + 1);
		temp.put("제목", title);
		temp.put("내용", content);
		temp.put("작성자", name);
		temp.put("작성일", new Date());
		
		
		boardTable.add(temp);
		System.out.println("=================================");
	}
	
	static void modify(HashMap<String, Object> board){
		Scanner sc = new Scanner(System.in);
		System.out.println("수정하시겠습니까?");
		System.out.println("1.Yes / 2.No");
		int input = Integer.parseInt(sc.nextLine());
		switch (input) {
		case 1:
			System.out.println("제목을 수정해주세요.");
			String title = ScanUtil.nextLine();
			System.out.println("내용을 수정해주세요.");
			String content = ScanUtil.nextLine();
			
			board.put("제목", title);
			board.put("내용", content);
			board.put("작성일", new Date());
			
			System.out.println("게시글 수정이 완료되었습니다.");
			break;
		case 2:
			break;
		}
	}	
	
	static void delete(ArrayList<HashMap<String, Object>> boardTable, HashMap<String, Object> board){
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제하시겠습니까?");
		System.out.println("1.Yes / 2.No");
		int input = Integer.parseInt(sc.nextLine());
		switch (input) {
		case 1:
			for(int i = 0; i < boardTable.size(); i++){
				if(boardTable.get(i).get("번호") == board.get("번호")){
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
