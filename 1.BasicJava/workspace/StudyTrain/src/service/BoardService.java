package service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.BoardDao;

public class BoardService {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private BoardService(){}
	private static BoardService instance;
	public static BoardService getInstance(){
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}

//싱글톤 생성자	
	private BoardDao boardDao = BoardDao.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	int no;
	String treat;
	String hide;
	
//게시판
	public int boardList() {
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		System.out.println("========== 분실물 게시판 ====================================================================");
		System.out.println("번호\t제목\t\t\t\t작성자\t작성일\t\t조회수\t처리여부");
		System.out.println("=========================================================================================");
		for(Map<String, Object> board : boardList){
			if(board.get("BOARD_STATUS").equals("신고")){
				System.out.println(board.get("BOARD_NO")
						  + "\t" + "신고된 게시물");
			}else if(board.get("BOARD_STATUS").equals("삭제")){
				System.out.println(board.get("BOARD_NO")
						  + "\t" + "삭제된 게시물");
			}else{
				System.out.println(board.get("BOARD_NO")
						  + "\t" + board.get("BOARD_TITLE")
						  + "\t\t\t\t" + board.get("USER_ID")
						  + "\t" + sdf.format(board.get("BOARD_DATE"))
						  + "\t  " + board.get("BOARD_COUNT")
						  + "\t  " + board.get("BOARD_TREAT"));
			}
		}
		System.out.println("=========================================================================================");
		System.out.println("[1.조회 | 2.등록 | 0.홈으로]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.BOARD_READ;		//조회
		case 2: return View.BOARD_INSERT;	//등록
		case 0: //홈으로
			if(Controller.loginUser.get("USER_ADMIN").equals("y")){
				return View.ADMIN_HOME;
			}else{
				return View.USER_HOME;
			}
		}
		return View.BOARD_LIST;
	}
	
//게시물
	public int boardRead() {
		System.out.println("조회할 게시물을 선택해주세요.");
		System.out.print("번호 입력>");
		no = ScanUtil.nextInt();
		
		Map<String, Object> board = boardDao.selectBoard(no);
		if(board == null){
			System.out.println("없는 게시물입니다.");
			System.out.println("조회할 수 없습니다.");
			return View.BOARD_LIST;
		}else if(board.get("BOARD_STATUS").equals("신고") && Controller.loginUser.get("USER_ADMIN").equals("n")){
			System.out.println("신고된 게시물입니다.");
			System.out.println("조회할 수 없습니다.");
			return View.BOARD_LIST;
		}else if(board.get("BOARD_STATUS").equals("삭제") && Controller.loginUser.get("USER_ADMIN").equals("n")){
			System.out.println("삭제된 게시물입니다.");
			System.out.println("조회할 수 없습니다.");
			return View.BOARD_LIST;
		}
		
		int count = boardDao.countBoard(no);
		
		System.out.println("=========================================================================================");
		System.out.println(board.get("BOARD_NO") + "번 게시물");
		System.out.println("제목 : " + board.get("BOARD_TITLE"));
		System.out.println("=========================================================================================");
		System.out.println("내용 : ");
		System.out.println(board.get("BOARD_CONTENT"));
		System.out.println();
		System.out.println("=========================================================================================");
		System.out.println("처리상태: " + board.get("BOARD_TREAT"));
		System.out.println("=========================================================================================");
		System.out.println("작성자: " + board.get("USER_ID"));
		System.out.println("작성일: " + sdf2.format(board.get("BOARD_DATE")));
		System.out.println("=========================================================================================");
		if(Controller.loginUser.get("USER_ADMIN").equals("y")){
			if(board.get("BOARD_STATUS").equals("삭제")){
				System.out.println("[1.수정 | 2.삭제 | 3.분실물처리 | 4.복구 | 0.목록]");
			}else{
				System.out.println("[1.수정 | 2.삭제 | 3.분실물처리 | 4.숨김 | 0.목록]");
			}
		}else{
			System.out.println("[1.수정 | 2.삭제 | 3.신고 | 0.목록]");
		}
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.BOARD_UPDATE;	//수정
		case 2: return View.BOARD_DELETE;	//삭제
		case 3:
			if(Controller.loginUser.get("USER_ADMIN").equals("y")){
				return View.BOARD_TREAT;
			}else{
				return View.BOARD_NOTIFY;
			}
		case 4:
			if(Controller.loginUser.get("USER_ADMIN").equals("y")){
				return View.BOARD_HIDE;
			}else{
				return View.BOARD_READ;
			}
		case 0: return View.BOARD_LIST;		//목록
		}
		return View.BOARD_READ;
	}
	
//삽입
	public int boardInsert() {
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
	
//수정
	public int boardUpdate() {
		Map<String, Object> board = boardDao.selectBoard(no);
		
		System.out.println("수정하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //수정
			if(!board.get("USER_ID").equals(Controller.loginUser.get("USER_ID"))){
				System.out.println("작성자만 수정이 가능합니다.");
			}else{
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
			}
			return View.BOARD_READ;
		case 2: //목록
			return View.BOARD_READ;
		}	
		return View.BOARD_READ;
	}
	
//처리
	public int boardTreat() {
		Map<String, Object> board = boardDao.selectBoard(no);
	
		System.out.println("처리상태를 변경하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:	//처리변경
			if(board.get("BOARD_TREAT").equals("대기")){
				treat = "처리중";
			}else if(board.get("BOARD_TREAT").equals("처리중")){
				treat = "처리완료";
			}else{
				System.out.println("처리가 완료된 게시물입니다.");
				return View.BOARD_READ;
			}
			
			int result = boardDao.treatBoard(treat, no);
			
			if(0 < result){
				System.out.println("처리상태 변경이 완료되었습니다.");
			}else{
				System.out.println("처리상태 변경에 실패하였습니다.");
			}
		case 2:	//목록으로
			return View.BOARD_READ;
		}
		return View.BOARD_READ;
	}
	
//신고
	public int boardNotify() {
		Map<String, Object> board = boardDao.selectBoard(no);
		
		System.out.println("이 게시물을 신고하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			int result = boardDao.notifyCount(no);
			
			board = boardDao.selectBoard(no);
			if((int)board.get("BOARD_NOTIFY_NO") == 5){
				String notify = "신고";
				int result2 = boardDao.notifyBoard(notify, no);
				if(0 < result2){
					System.out.println("신고가 완료되었습니다.");
					return View.BOARD_LIST;
				}else{
					System.out.println("신고에 실패하였습니다.");
					return View.BOARD_READ;
				}
			}
		case 2:
			return View.BOARD_READ;
		}
		return View.BOARD_READ;
	}
	
//숨김
	public int boardHide() {
		Map<String, Object> board = boardDao.selectBoard(no);
		if(board.get("BOARD_STATUS").equals("삭제")){
			System.out.println("이 게시물을 복구하시겠습니까?");
		}else{
			System.out.println("이 게시물을 삭제하시겠습니까?");
		}
		System.out.println("[1.YES | 2.NO]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			if(board.get("BOARD_STATUS").equals("신고") || board.get("BOARD_STATUS").equals("정상")){
				hide = "삭제";
				int result = boardDao.hideBoard(hide, no);
				if(0 < result){
					System.out.println("삭제가 완료되었습니다.");
					return View.BOARD_LIST;
				}else{
					System.out.println("삭제에 실패하였습니다.");
					return View.BOARD_READ;
				}
			}else if(board.get("BOARD_STATUS").equals("삭제")){
				hide = "정상";
				int result = boardDao.hideBoard(hide, no);
				int zero = boardDao.countZero(no);
				
				if(0 < result){
					System.out.println("복구가 완료되었습니다.");
					return View.BOARD_LIST;
				}else{
					System.out.println("복구에 실패하였습니다.");
					return View.BOARD_READ;
				}
			}
		case 2:
			return View.BOARD_READ;
		}
		return View.BOARD_READ;
	}
	
//삭제
	public int boardDelete() {
		Map<String, Object> board = boardDao.selectBoard(no);
		System.out.println("이 게시물을 삭제하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //삭제
			if(Controller.loginUser.get("USER_ADMIN").equals("y")){
				int result = boardDao.deleteBoard(no);
				
				if(0 < result){
					System.out.println("게시글 삭제가 완료되었습니다.");
				}else{
					System.out.println("게시글 삭제에 실패하였습니다.");
				}
				return View.BOARD_LIST;
				
			}else if(!board.get("USER_ID").equals(Controller.loginUser.get("USER_ID"))){
				System.out.println("작성자만 삭제가 가능합니다.");
				return View.BOARD_READ;
			}else{
				int result = boardDao.deleteBoard(no);
				
				if(0 < result){
					System.out.println("게시글 삭제가 완료되었습니다.");
				}else{
					System.out.println("게시글 삭제에 실패하였습니다.");
				}
				return View.BOARD_LIST;
			}
			
		case 2: //목록
			return View.BOARD_READ;
		}	
		return View.BOARD_READ;
	}

}
