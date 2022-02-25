package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.UserDao;

public class UserService {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private UserService(){}
	private static UserService instance;
	public static UserService getInstance(){
		if(instance == null){
			instance = new UserService();
		}		
		return instance;
	}
	
	private UserDao userDao=UserDao.getInstance();
	public static int standard;
	
	public int join() //회원가입
	{
		System.out.println("================회원가입===================");
		System.out.println("<1.회원가입>\t<2.관리자 회원가입>\t<0.돌아가기>");
		int who=ScanUtil.nextInt();
		if (who==1) //회원가입
		{
			return View.JOIN_USER;
		}
		else if (who==2) //관리자 회원가입
		{
			return View.JOIN_ADMIN;
		}
		else if(who==0)
		{
			System.out.println("처음으로 돌아갑니다.");
			return View.FIRSTSCREEN;
		}
		else
		{
			System.out.println("잘못된 번호입니다.");
			return View.LOGIN;
		}
	}
	
	public int joinUser()
	{
		System.out.println("==============회원가입================");
		System.out.println("아이디>");
		String userId=ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password=ScanUtil.nextLine();
		System.out.println("이름>");
		String userName=ScanUtil.nextLine();
		  
		System.out.println("지역>");
		String userLocate=ScanUtil.nextLine();
		System.out.println("나이");
		String userAge=ScanUtil.nextLine();
		
		//아이디 중복 확인 생략
		//비밀번호 확인 생략
		//유효성 검사 (정규표현식) 생략
		
		Map<String, Object> param=new HashMap<>();
		param.put("USER_ID", userId);
		param.put("PASSWORD", password);
		param.put("USER_NAME", userName);
		
		param.put("USER_LOCATE", userLocate);
		param.put("USER_AGE", userAge);
		
		int result = userDao.insertUser(param);
		
		if (0<result) System.out.println("회원가입 성공");
		else System.out.println("회원가입 실패");
		
		return View.FIRSTSCREEN;
	}
	
	public int joinAdmin()
	{
		System.out.println("==============회원가입================");
		System.out.println("관리자 아이디>");
		String adminId=ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password=ScanUtil.nextLine();
		System.out.println("관리자 이름>");
		String adminName=ScanUtil.nextLine();
		
		//아이디 중복 확인 생략
		//비밀번호 확인 생략
		//유효성 검사 (정규표현식) 생략
		
		Map<String, Object> param=new HashMap<>();
		param.put("ADMIN_ID", adminId);
		param.put("PASSWORD", password);
		param.put("ADMIN_NAME", adminName);
		
		int result = userDao.insertAdmin(param);
		
		if (0<result) System.out.println("관리자 가입 성공");
		else System.out.println("관리자 가입 실패");
		
		return View.FIRSTSCREEN;
	}
	
	public int login() //로그인
	{
		System.out.println("===============로그인===================");
		System.out.println("<1.회원 로그인>\t<2.관리자 계정으로 로그인>\t<0.돌아가기>");
		int who=ScanUtil.nextInt();
		if (who==1) //회원 로그인
		{
			standard=1;
			return View.LOGIN_USER;
		}
		else if (who==2)
		{
			standard=2;
			return View.LOGIN_ADMIN;
		}
		else if(who==0)
		{
			System.out.println("처음으로 돌아갑니다.");
			return View.FIRSTSCREEN;
		}
		else
		{
			System.out.println("잘못된 번호입니다.");
			return View.LOGIN;
		}
		
	}
	
	public int loginUser() // 회원 로그인
	{
		System.out.println("===============회원 로그인===================");
		System.out.println("아이디>");
		String userId=ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password=ScanUtil.nextLine();
		
		Map<String,Object> user = userDao.selectUser(userId,password);
		
		if (user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다. ");
			return View.LOGIN; //실패 시 다시 로그인
		}
		else 
		{
			System.out.println("로그인 성공"); 
			Controller.LoginUser=user; //원래는 로그인한 정보를 세션에 저장해주는데 우린 그게 없으니 컨트롤러에 변수를 하나 만들어서 거기에 저장을 할거다.
			return View.KTX_HOME; //성공시 ktx 홈으로 들어간다.
		}
	}

	public int loginAdmin() // 관리자 로그인
	{
		System.out.println("===============관리자 로그인===================");
		System.out.println("관리자 아이디>");
		String adminId=ScanUtil.nextLine();
		System.out.println("관리자 비밀번호>");
		String password=ScanUtil.nextLine();
		
		Map<String,Object> user = userDao.selectAdmin(adminId,password);
		
		if (user == null){
			System.out.println("관리자 아이디 혹은 관리자 비밀번호를 잘못 입력하셨습니다. ");
			return View.LOGIN; //실패 시 다시 로그인
		}
		else 
		{
			System.out.println("관리자 로그인 성공"); 
			Controller.LoginUser=user; //원래는 로그인한 정보를 세션에 저장해주는데 우린 그게 없으니 컨트롤러에 변수를 하나 만들어서 거기에 저장을 할거다.
			return View.ADMIN_HOME; //성공시 관리자용 홈으로 들어간다.
		}
	}
	
	public int userList() // 모든 회원 미리보기.
	{
		List<Map<String, Object>> userList = userDao.selectUserList();
		
		System.out.println("===================모든 회원정보=================(로그인 중인 관리자 이름: "+Controller.LoginUser.get("ADMIN_NAME")+")==============");
		System.out.println("아이디\t비밀번호\t이름\t나이\t지역");
		System.out.println("-------------------------------------------------------------------------------------");
		for (Map<String,Object> user: userList)
		{
			System.out.println(user.get("USER_ID")+"\t"
					+user.get("PASSWORD")+"\t"
					+user.get("USER_NAME")+"\t"
					+user.get("USER_AGE")+"\t"
					+user.get("USER_LOCATE")+"\t");
		}
		System.out.println("=================================================================================");
		System.out.println("관리자 화면으로 돌아갑니다.");
//		System.out.println("<1.조회>\t<2.등록>\t<0.KTX 홈>");
//		System.out.println("입력");
//		int input=ScanUtil.nextInt();
		
//		switch(input)
//		{
//		case 1: // 조회
//			return View.KTX_BOARD_VIEW;
//			//return boardView();
//			//boardDao.insertUser(param);
//		case 2: // 등록 추가
//			return View.KTX_BOARD_INSERT;
//			//return boardInsert(); //추가를 하면 보드를 다시 보여줘야 한다.
//		case 0: // 메뉴
//			System.out.println("홈으로 돌아갑니다.");
//			return View.KTX_HOME;
//		}
//		System.out.println("잘못된 번호입니다.");
		return View.ADMIN_HOME;
	}
}
