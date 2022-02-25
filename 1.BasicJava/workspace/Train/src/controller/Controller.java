package controller;

import java.util.Map;

import service.BoardService;
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
	private BoardService boardService = BoardService.getInstance();		
	
//화면이동
	private void start() {
		int view = View.FIRSTSCREEN;
		//화면이동
		while(true){
			switch(view) {
			//메서드를 만들어서 소환하는 방식
			case View.FIRSTSCREEN: view = firstScreen(); break;
			case View.LOGIN: view = userService.login(); break;
			case View.JOIN: view = userService.join(); break;
			
			case View.USER_SETTING: view = userService.userSet(); break;
			case View.USER_UPDATE: view = userService.userUpdate(); break;
			case View.USER_DELETE: view = userService.userLeave(); break;

			case View.ADMIN_SETTING: view = userService.userSet(); break;
			case View.ADMIN_UPDATE: view = userService.userUpdate(); break;
			case View.ADMIN_DELETE: view = userService.userLeave(); break;

			case View.KTX_BOARD: view = boardService.boardList(); break;
			case View.KTX_BOARD_VIEW: view = boardService.boardRead(); break;
			
			case View.KTX_BOARD_INSERT: view = boardService.boardInsert(); break;
			case View.KTX_BOARD_UPDATE: view = boardService.boardUpdate(); break;
			case View.KTX_BOARD_DELETE: view = boardService.boardDelete(); break;

			case View.KTX_NOTICE: view = boardService.boardList(); break;
			case View.KTX_NOTICE_VIEW: view = boardService.boardRead(); break;
			
			case View.KTX_NOTICE_INSERT: view = boardService.boardInsert(); break;
			case View.KTX_NOTICE_UPDATE: view = boardService.boardUpdate(); break;
			case View.KTX_NOTICE_DELETE: view = boardService.boardDelete(); break;
			}
		}
	}

//첫화면
	private int firstScreen() {
		System.out.println("============================================");
		System.out.println("[1.로그인 | 2.회원가입 | 3.프로그램 종료]");
		System.out.println("============================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.LOGIN;	//start()로 돌아가서 로그인 화면으로 이동
		case 2: return View.JOIN;	//start()로 돌아가서 가입 화면으로 이동
		case 3:
			System.out.println("이용해주셔서 감사합니다.");
			System.exit(3);
		}
		return View.FIRSTSCREEN;	//1, 2, 3번을 제외한 번호를 입력하면, start()로 돌아가서 홈화면으로 이동
	}
}
