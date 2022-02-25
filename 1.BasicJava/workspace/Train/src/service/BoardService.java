package service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.BoardDao;

public class BoardService {	//게시판과 관련된 서비스를 수행
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private BoardService(){}
	private static BoardService instance;
	public static BoardService getInstance(){
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}
	
	private BoardDao boardDao = BoardDao.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
	int no;
	
//게시판
	public int boardList() {
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		System.out.println("===========================================");
		System.out.println("번호\t제목\t\t작성자\t작성일");
		System.out.println("===========================================");
		for(Map<String, Object> board : boardList){
			System.out.println(board.get("BOARD_NO")
					  + "\t" + board.get("TITLE")
					  + "\t\t" + board.get("USER_NAME")
					  + "\t" + sdf.format(board.get("REG_DATE")));
		}
		System.out.println("===========================================");
		System.out.println("\t\t[1.조회 | 2.등록 | 3.설정 | 4.로그아웃]");
		System.out.print("입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1:	//조회
			System.out.print("조회할 게시물을 선택해주세요.>");
			no = ScanUtil.nextInt();
			return View.BOARD_READ;
		case 2:	//등록
			return View.BOARD_INSERT;
		case 3: //설정
			return View.USER_SET;
		case 4:	//로그아웃
			Controller.loginUser = null;
			return View.HOME;
		}
		return View.BOARD_LIST;
	}
	
//게시물
	public int boardRead() {
		Map<String, Object> board = boardDao.selectBoard(no);
		
		System.out.println("===========================================");
		System.out.println(board.get("BOARD_NO") + "번 게시물");
		System.out.println("제목 : " + board.get("TITLE"));
		System.out.println("===========================================");
		System.out.println("내용 : ");
		System.out.println(board.get("CONTENT"));
		System.out.println();
		System.out.println("===========================================");
		System.out.println("작성자: " + board.get("USER_NAME"));
		System.out.println("작성일: " + sdf.format(board.get("REG_DATE")));
		System.out.println("===========================================");
		System.out.println("\t\t[1.수정 | 2.삭제 | 3.목록]");
		System.out.print("입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.BOARD_UPDATE;	//수정
		case 2: return View.BOARD_DELETE;	//삭제
		case 3: return View.BOARD_LIST;	//목록
		}
		return View.BOARD_READ;
	}
	
//삽입
	public int boardInsert() {
		System.out.print("제목을 입력하세요.>");
		String title = ScanUtil.nextLine();
		System.out.print("내용을 입력하세요.>");
		String content = ScanUtil.nextLine();
		int result = boardDao.insertBoard(title, content);
		if(0 < result){
			System.out.println("게시글 등록이 완료되었습니다.");
		}else{
			System.out.println("게시글 등록에 실패하였습니다.");
		}
		return View.BOARD_LIST;
	}
	
//수정
	public int boardUpdate() {
		Map<String, Object> board = boardDao.selectBoard(no);
		
		System.out.println("수정하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //수정
			if(!board.get("USER_ID").equals(Controller.loginUser.get("USER_ID"))){
				System.out.println("작성자만 수정이 가능합니다.");
				return View.BOARD_READ;
			}else{
				System.out.println("제목을 수정해주세요.");
				String title = ScanUtil.nextLine();
				System.out.println("내용을 수정해주세요.");
				String content = ScanUtil.nextLine();
				
				int result = boardDao.updateBoard(title, content, no);
				
				if(0 < result){
					System.out.println("게시글 수정이 완료되었습니다.");
				}else{
					System.out.println("게시글 수정에 실패하였습니다.");
				}
				return View.BOARD_READ;
			}
		case 2: //목록
			return View.BOARD_READ;
		}	
		return View.BOARD_READ;
	}
	
//삭제
	public int boardDelete() {
		Map<String, Object> board = boardDao.selectBoard(no);
		
		System.out.println("삭제하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //삭제
			if(!board.get("USER_ID").equals(Controller.loginUser.get("USER_ID"))){
				System.out.println("작성자만 삭제가 가능합니다.");
				return View.BOARD_READ;
			}else{
				int result = boardDao.deleteBoard(no);
				
				if(0 < result){
					System.out.println("게시글 수정이 완료되었습니다.");
				}else{
					System.out.println("게시글 수정에 실패하였습니다.");
				}
				return View.BOARD_LIST;
			}
		case 2: //목록
			return View.BOARD_READ;
		}	
		return View.BOARD_READ;
	}
}
