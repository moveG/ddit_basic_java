package controller;

import java.util.Map;

import service.BoardService;
import service.UserService;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {
		/*
		 * 발표순서 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연 > 프로젝트 후기
		 * 발표인원 : 발표자 1명, ppt 및 시연 도우미 1명
		 * 
		 * Controller : 화면 이동
		 * Service : 화면 기능, 실제 기능
		 * Dao : 쿼리 작성, 데이터베이스 접속
		 */
		
		new Controller().start();
	}
//로그인한 유저 기억	
	public static Map<String, Object> loginUser;
	
	private UserService userService = UserService.getInstance();
	private BoardService boardService = BoardService.getInstance();
	
//화면 이동 기능
	private void start(){
		int view = View.HOME;
		
		//화면 이동 기능
		while(true){
			switch (view) {
				case View.HOME: view = home();  break; //메서드를 만들어서 소환하는 방식을 사용함
				case View.LOGIN: view = userService.login(); break;
				case View.JOIN: view = userService.join(); break;
				
				case View.BOARD_LIST: view = boardService.boardList(); break;
				case View.BOARD_VIEW: view = boardService.boardView(); break;
				case View.BOARD_INSERT: view = boardService.boardInsert(); break;
				case View.BOARD_UPDATE: view = boardService.boardUpdate(); break;
				case View.BOARD_DELETE: view = boardService.boardDelete(); break;
				
			}
		}
	}

//홈화면
	private int home(){
		System.out.println("==========================================");
		System.out.println("1.로그인\t2.회원가입\t0.프로그램 종료");
		System.out.println("==========================================");
		System.out.print("번호 입력>");
		
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.LOGIN;	//start로 돌아가서 로그인 화면으로 이동
		case 2: return View.JOIN;	//start로 돌아가서 가입 화면으로 이동
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
		
		return View.HOME;	//1, 2, 0번을 제외한 번호를 입력한 경우, start로 돌아가서 홈화면으로 이동
	}
}
