package service;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.UserDao;

public class UserService { //유저와 관련된 서비스를 수행
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없으므로 싱글톤 패턴을 사용함, 굳이 이해해서 사용할 필요없음, 당장은 이해할 필요가 없음
	private UserService(){}
	private static UserService instance;
	public static UserService getInstance(){
		if(instance == null){
			instance = new UserService();
		}
		return instance;
	}
	
	private UserDao userDao = UserDao.getInstance();
	
//회원가입
	public int join(){
		System.out.println("=============== 회원가입 ===============");
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		System.out.print("이름>");
		String userName = ScanUtil.nextLine();
		//아이디 중복 확인 생략
		//비밀번호 확인 생략
		//유효성 검사(정규표현식) 생략
		
		Map<String, Object> param = new HashMap<>();
		param.put("USER_ID", userId);
		param.put("PASSWORD", password);
		param.put("USER_NAME", userName);
		
		int result = userDao.insertUser(param);
		
		if(0 < result){
			System.out.println("회원가입 성공");
		}else{
			System.out.println("회원가입 실패");
		}
		
		return View.HOME;
	}

//로그인
	public int login() {
		System.out.println("=============== 로그인 ===============");
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		
		Map<String, Object> user = userDao.selectUser(userId, password);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하였습니다.");
		}else{
			System.out.println("로그인 성공");
			Controller.loginUser = user; //로그인 성공한 유저를 LoginUser변수에 저장
			return View.BOARD_LIST; //게시판으로 이동
		}
		
		return View.LOGIN;
	}
}
