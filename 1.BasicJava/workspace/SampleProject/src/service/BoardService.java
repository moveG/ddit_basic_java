package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.BoardDao;

public class BoardService { //게시판과 관련된 서비스를 수행
	//싱글톤 패턴
	private BoardService(){}
	private static BoardService instance;
	public static BoardService getInstance(){
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}
	
//게시판 목록
	private BoardDao boardDao = BoardDao.getInstance();
	static int no;
	
	public int boardList(){
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		
		System.out.println("=======================================");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("---------------------------------------");
		for(Map<String, Object> board : boardList){
			System.out.println(board.get("BOARD_NO") + "\t"
					+ board.get("TITLE") + "\t"
					+ board.get("USER_NAME") + "\t"
					+ board.get("REG_DATE"));
		}
		System.out.println("=======================================");
		System.out.println("1.조회\t2.등록\t0.로그아웃");
		System.out.print("입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: //조회
			System.out.print("조회할 게시물 번호>");
			no = ScanUtil.nextInt();
			return View.BOARD_VIEW;
		case 2: //등록
			return View.BOARD_INSERT;
		case 0: //로그아웃
			Controller.loginUser = null;
			return View.HOME;
		}
		
		return View.BOARD_LIST;
	}
	
	public int boardView(){
		Map<String, Object> board = boardDao.selectBoard(no);
		
		System.out.println("================================");
		System.out.println("번호\t: " + board.get("BOARD_NO"));
		System.out.println("작성자\t: " + board.get("USER_NAME"));
		System.out.println("작성일\t: " + board.get("REG_DATE"));
		System.out.println("제목\t: " + board.get("TITLE"));
		System.out.println("내용\t: " + board.get("CONTENT"));
		System.out.println("================================");
		System.out.println("1.수정\t2.삭제\t0.목록");
		System.out.print("번호입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.BOARD_UPDATE; //수정
		case 2: return View.BOARD_DELETE; //삭제
		case 0: return View.BOARD_LIST;   //목록
		}
		return View.BOARD_VIEW;
	}
	
	public int boardInsert(){
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		
		int result = boardDao.insertBoard(title, content);
		
		if(0 < result){
			System.out.println("게시글 등록이 완료되었습니다.");
		}else{
			System.out.println("게시글 등록에 실패하였습니다.");
		}
		return View.BOARD_LIST;
	}
	
	public int boardUpdate(){
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		
		int result = boardDao.updateBoard(title, content, no);
		
		if(0 < result){
			System.out.println("게시글 수정이 완료되었습니다.");
		}else{
			System.out.println("게시글 수정에 실패하였습니다.");
		}
		return View.BOARD_LIST;
	}
	
	public int boardDelete(){
		int result = boardDao.deleteBoard(no);
		
		if(0 < result){
			System.out.println("게시글 삭제가 완료되었습니다.");
		}else{
			System.out.println("게시글 삭제에 실패하였습니다.");
		}
		return View.BOARD_LIST;
	}
}
