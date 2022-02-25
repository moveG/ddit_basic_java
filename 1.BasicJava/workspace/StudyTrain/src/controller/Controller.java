package controller;

import java.util.Map;

import service.AdminService;
import service.AreaService;
import service.BoardService;
import service.BookService;
import service.LineService;
import service.NoticeService;
import service.TrainService;
import service.UserService;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {
		/*
		 * Controller : 화면이동
		 * Service : 화면기능
		 * Dao : 쿼리 작성
		 */
		new Controller().start();
	}
//로그인유저 저장
	public static Map<String, Object> loginUser;

//싱글톤 생성자
	private UserService userService = UserService.getInstance();
	private AdminService adminService = AdminService.getInstance();		
	private BoardService boardService = BoardService.getInstance();		
	private NoticeService noticeService = NoticeService.getInstance();		
	private TrainService trainService = TrainService.getInstance();		
	private BookService bookService = BookService.getInstance(); 
	private AreaService areaService = AreaService.getInstance();
	private LineService lineService = LineService.getInstance();
	
//화면이동
	private void start() {
		int view = View.HOME;
		//화면이동
		while(true){
			switch(view) {
			//메서드를 만들어서 소환하는 방식
			case View.HOME: view = home(); break;
			case View.JOIN: view = userService.join(); break;
			case View.LOGIN: view = userService.login(); break;
			case View.SEARCH: view = userService.search(); break;
			case View.USER_HOME: view = userService.userHome(); break;
			case View.ADMIN_HOME: view = adminService.adminHome(); break;

			case View.TICKET_VIEW: view = userService.ticketView(); break;
			
			case View.USER_SETTING: view = userService.userSetting(); break;
			case View.USER_UPDATE: view = userService.userUpdate(); break;
			case View.USER_DELETE: view = userService.userDelete(); break;

			case View.ADMIN_SETTING: view = adminService.adminSetting(); break;
			case View.ADMIN_UPDATE: view = adminService.adminUpdate(); break;
			case View.ADMIN_DELETE: view = adminService.adminDelete(); break;
			
			case View.BOARD_LIST: view = boardService.boardList(); break;
			case View.BOARD_READ: view = boardService.boardRead(); break;
			case View.BOARD_INSERT: view = boardService.boardInsert(); break;
			case View.BOARD_UPDATE: view = boardService.boardUpdate(); break;
			case View.BOARD_DELETE: view = boardService.boardDelete(); break;
			case View.BOARD_TREAT: view = boardService.boardTreat(); break;
			case View.BOARD_NOTIFY: view = boardService.boardNotify(); break;
			case View.BOARD_HIDE: view = boardService.boardHide(); break;

			case View.NOTICE_LIST: view = noticeService.noticeList(); break;
			case View.NOTICE_READ: view = noticeService.noticeRead(); break;
			case View.NOTICE_INSERT: view = noticeService.noticeInsert(); break;
			case View.NOTICE_UPDATE: view = noticeService.noticeUpdate(); break;
			case View.NOTICE_DELETE: view = noticeService.noticeDelete(); break;
			
			case View.MANAGE_TRAIN: view = trainService.trainList(); break;
			case View.MANAGE_AREA: view = areaService.areaList(); break;
			case View.MANAGE_LINE: view = lineService.lineList(); break;
			
			case View.AREA_INSERT: view = areaService.areaInsert(); break;
//			case View.MANAGE_LINE: view = ; break;
//			case View.MANAGE_USER: view = ; break;
			
			case View.TRAIN_VIEW: view = trainService.trainView(); break;
			case View.TRAIN_INSERT: view = trainService.trainInsert(); break;
			case View.TRAIN_TYPE_MANAGE: view = trainService.trainTypeManage(); break;
			case View.TRAIN_TYPE_VIEW: view = trainService.trainTypeView(); break;
			case View.TRAIN_TYPE_INSERT: view = trainService.trainTypeInsert(); break;
			case View.TRAIN_TYPE_UPDATE: view = trainService.trainTypeUpdate(); break;
			case View.TRAIN_TYPE_DELETE: view = trainService.trainTypeDelete(); break;
			
			
//			case View.TRAIN_TIME_TABLE: view = trainService.trainTimeTable(); break;
			
			case View.BOOK_BOARD: view = bookService.bookBoard(); break;
			case View.BOOK_INSERT: view = bookService.bookInsert(); break;
			case View.BOOK_CANCEL: view = bookService.bookCancel(); break;

			
			
			
			
			
			
			}
		}
	}

//홈화면
	private int home() {
		System.out.println("========== Let's Korail =================================================================");
		System.out.println("[1.로그인 | 2.회원가입 | 3.아이디/비밀번호 찾기 | 0.프로그램 종료]");
		System.out.println("=========================================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.LOGIN;	//start()로 돌아가서 로그인 화면으로 이동
		case 2: return View.JOIN;	//start()로 돌아가서 가입 화면으로 이동
		case 3: return View.SEARCH;
		case 0:
			System.out.println("이용해주셔서 감사합니다.");
			System.exit(0);
		}
		return View.HOME;	//1, 2, 3, 0번을 제외한 번호를 입력하면, start()로 돌아가서 홈화면으로 이동
	}
}
