package controller;

import java.util.Map;

import service.BoardService;
import service.KTXService;
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
	public static Map<String, Object> LoginUser;
	public static Map<String, Object> LoginAdmin;

//싱글톤 생성자
	private UserService userService = UserService.getInstance();
	private BoardService boardService = BoardService.getInstance();
	private KTXService ktxService = KTXService.getInstance();
	private TrainService trainService = TrainService.getInstance();
	
//화면이동
	private void start() {
		int view = View.FIRSTSCREEN;
		//화면이동
		while(true){
			switch(view) {
			//메서드를 만들어서 소환하는 방식
			case View.FIRSTSCREEN: view = firstScreen(); break; //초기 화면
			case View.LOGIN: view = userService.login(); break; //회원가입
			case View.JOIN: view = userService.join(); break; //로그인
			
			case View.JOIN_USER: view = userService.joinUser(); break; //회원용 회원가입
			case View.JOIN_ADMIN: view = userService.joinAdmin(); break; //관리자 회원가입
			
			case View.LOGIN_USER: view = userService.loginUser(); break; // 회원 로그인 
			case View.LOGIN_ADMIN: view = userService.loginAdmin(); break; // 관리자 로그인
			
			case View.ADMIN_HOME: view = ktxService.adminHome(); break; //관리자 홈화면
			case View.KTX_USER_ALL: view = userService.userList(); break; //관리자 - 유저관리 홈화면
			
			case View.KTX_HOME: view = ktxService.ktxHome(); break; //KTX 홈화면
			case View.KTX_USER: view = ktxService.ktxUser(); break; //KTX 회원 정보 관리
			case View.KTX_TRAIN: view = trainService.TrainList(); break; //KTX 열차메뉴
			
			case View.KTX_BOARD: view = boardService.boardList(); break; //KTX 게시판 들어가기 (미리보기)
			case View.KTX_BOARD_VIEW: view = boardService.boardView(); break; //KTX 게시판 조회
			case View.KTX_BOARD_INSERT: view = boardService.boardInsert(); break; //KTX 게시판 추가
			case View.KTX_BOARD_UPDATE: view = boardService.boardUpdate(); break; //KTX 게시판 수정
			case View.KTX_BOARD_DELETE: view = boardService.boardDelete(); break; //KTX 게시판 삭제
			
			case View.TRAIN_VIEW: view = trainService.trainView(); break; //TRAIN 조회
			case View.TRAIN_INSERT: view = trainService.trainInsert(); break; //TRAIN 등록
			case View.TRAIN_UPDATE: view = trainService.trainUpdate(); break; //TRAIN 수정
			case View.TRAIN_DELETE: view = trainService.trainDelete(); break; //TRAIN 삭제
			
			//case View.TRAIN_BASKET: view=trainService.trainBasket(); break; //장바구니
			case View.TRAIN_BUY: view = trainService.trainBuy(); break; //구매
			case View.TRAIN_BASKET: view = trainService.trainBasket(); break; //장바구니 목록 미리 보기
			case View.TRAIN_BASKET_VIEW: view = trainService.trainBasketView(); break; //장바구니 조회하기.
			
			case View.TRAIN_TICKET: view = trainService.ticket(); break; // 티켓 목록 미리보기
			}
		}
		
	}

//홈화면
	private int firstScreen() {
		System.out.println("============================================");
		System.out.println("[1.로그인 | 2.회원가입 | 0.프로그램 종료]");
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
		System.out.println("잘못된 번호를 입력하였습니다.");
		return View.FIRSTSCREEN;	//1, 2, 3번을 제외한 번호를 입력하면, start()로 돌아가서 홈화면으로 이동
	}
}
