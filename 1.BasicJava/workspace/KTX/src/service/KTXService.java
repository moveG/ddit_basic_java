package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.BoardDao;
import dao.UserDao;

public class KTXService {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private KTXService(){}
	private static KTXService instance;
	public static KTXService getInstance(){
		if(instance == null){
			instance = new KTXService();
		}
		return instance;
	}
	
	private BoardDao boardDao= BoardDao.getInstance();
	private UserDao userDao= UserDao.getInstance();
	private static int select;
	
	public int ktxHome() //로그인 후 보이는 화면 (사실상 홈화면)
	{
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		
		System.out.println("======코레일에 오신것을 환영합니다====================KTX HOME====================(로그인한 유저 : "+Controller.LoginUser.get("USER_NAME")+" )========");
		System.out.println("<1.회원 정보 관리>\t<2.열차 메뉴>\t<3.게시판 보기>\t<0.로그아웃>");
		System.out.println("===================================================================================================");
		System.out.println("입력>");
		int input=ScanUtil.nextInt();

		switch(input)
		{
		case 1: // 회원정보
			return View.KTX_USER;
		case 2: // 열차메뉴
			return View.KTX_TRAIN;
		case 3: // 게시판 보기
			return View.KTX_BOARD;
		case 0: // 로그아웃
			Controller.LoginUser=null; // 로그아웃은 생각해보면 일단 홈화면으로 돌리고, 현재 접근해 있는 하나의 행을 null값으로 만들어 주면 될 뿐이다.
			System.out.println("로그아웃 되었습니다.");
			return View.FIRSTSCREEN; //로그아웃으로 인해 처음 화면으로 돌아간다.
		}
		System.out.println("잘못된 번호입니다.");
		return View.KTX_HOME;
	}
	
	public int adminHome() //관리자용 홈화면.
	{
		System.out.println("======코레일 ==============================관리자 화면========================(로그인한 관리자: "+Controller.LoginUser.get("ADMIN_NAME")+" )========");
		System.out.println("<1.열차 관리>\t<2.게시판 관리>\t<3.회원관리>\t<0.로그아웃>");
		System.out.println("===================================================================================================");
		System.out.println("입력>");
		int input=ScanUtil.nextInt();

		switch(input)
		{
		case 1: // 열차 관리
			return View.KTX_TRAIN;
		case 2: // 게시판 관리
			return View.KTX_BOARD;
		case 3: // 회원 관리
			return View.KTX_USER_ALL;
		case 0: // 로그아웃
			Controller.LoginUser=null; // 로그아웃은 생각해보면 일단 홈화면으로 돌리고, 현재 접근해 있는 하나의 행을 null값으로 만들어 주면 될 뿐이다.
			System.out.println("로그아웃 되었습니다.");
			return View.FIRSTSCREEN; //로그아웃으로 인해 처음 화면으로 돌아간다.
		}
		
		System.out.println("잘못된 번호입니다.");
		return View.ADMIN_HOME;
	}
	
	
	
	public int ktxUser() //KTX 회원정보
	{
		System.out.println("-----------------내정보--------------------");
		//Controller.LoginUser.get("USER_NAME"));
		//System.out.println(Controller.LoginUser);
		System.out.println("아이디 : "+Controller.LoginUser.get("USER_ID"));
		System.out.println("이름 : "+Controller.LoginUser.get("USER_NAME"));
		System.out.println("나이 : "+Controller.LoginUser.get("USER_AGE"));
		System.out.println("지역 : "+Controller.LoginUser.get("USER_LOCATE"));
		System.out.println("-----------------------------------------");
		System.out.println("<1.내 회원정보 수정>\t<2.내가 예매한 표 조회>\t<3.내가 담은 장바구니 보기>\t<4.메뉴로 돌아가기>");
		int log=ScanUtil.nextInt();
		if (log==1) //회원정보 수정
		{
			System.out.println("수정할 아이디를 입력하시오.");
			String userId=ScanUtil.nextLine();
			System.out.println("수정할 이름을 입력하시오.");
			String userName=ScanUtil.nextLine();
			
			Map<String, Object> param=new HashMap<>();
			param.put("USER_ID",userId);
			param.put("USER_NAME",userName);
			
			int result = userDao.updateUser(param);

			if (result>0) System.out.println("수정되었습니다.");
			else System.out.println("수정이 실패되었습니다.");
			
			return View.KTX_USER;
		}
		else if (log==2) //구매한 열차표 조회
		{
			return View.TRAIN_TICKET;
		}
		else if (log==3) //장바구니 보기
		{
			return View.TRAIN_BASKET;
		}
		else if (log==4)
		{
			System.out.println("메뉴로 돌아갑니다.");
			return View.KTX_HOME;
		}
		else
		{
			System.out.println("잘못된 입력입니다.");
			return View.KTX_HOME;
		}
	}
}
