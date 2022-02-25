package service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.UserDao;

public class UserService {	//유저와 관련된 서비스를 수행
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private UserService(){}
	private static UserService instance;
	public static UserService getInstance(){
		if(instance == null){
			instance = new UserService();
		}		
		return instance;
	}
	
//싱글톤 생성자	
	private UserDao userDao = UserDao.getInstance();
	
//회원가입
	public int join(){
		System.out.println("=================== 회원가입 ===================");
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		String regex = "[a-zA-Z0-9-_]{5,20}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(userId);
		if(m.matches() == false){
			System.out.println("5~20자의 영문 대소문, 숫자, 특수기호('_', '-')만 사용 가능합니다.");
			return View.JOIN;
		}
		Map<String, Object> checkId = userDao.idCheck(userId);
		if(checkId != null){
			System.out.println("중복된 아이디입니다.");
			return View.JOIN;
		}else{
			System.out.println("사용하실 수 있는 아이디입니다.");
		}
		boolean pw = true;
		while(pw){
			System.out.print("비밀번호>");
			String password = ScanUtil.nextLine();
			System.out.print("비밀번호 확인>");
			String password2 = ScanUtil.nextLine();
			if(!password.equals(password2)){
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
				pw = true;
			}else{
				break;
			}
		}
		
		System.out.print("이름>");
		String userName = ScanUtil.nextLine();
		
		Map<String, Object> param = new HashMap<>();
		param.put("USER_ID", userId);
		param.put("PASSWORD", password);
		param.put("USER_NAME", userName);
		
		int result = userDao.insertUser(param);
		
		if(0 < result){
			System.out.println("회원가입에 성공하였습니다.");
		}else{
			System.out.println("회원가입에 실패하였습니다.");
		}		
		return View.HOME;
	}

//로그인
	public int login() {
		System.out.println("=================== 로그인 ===================");
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		
		Map<String, Object> user = userDao.selectUser(userId, password);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			return View.HOME;
		}else{
			System.out.println("로그인 성공");
			Controller.loginUser = user; //로그인에 성공항 유저를 LoginUser 변수에 저장
			return View.BOARD_LIST;	//게시판으로 이동
		}
	}
	
//설정
	public int userSet() {
		System.out.println("==================== 설정 ====================");
		System.out.println("[1.정보수정 | 2.회원탈퇴 | 3.목록]");
		System.out.println("============================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.USER_UPDATE;
		case 2: return View.USER_DELETE;
		case 3: return View.BOARD_LIST;
		}
		return View.BOARD_LIST;
	}

//정보수정
	public int userUpdate() {
		System.out.println("비밀번호를 입력해주세요.");
		String password = ScanUtil.nextLine();
		Map<String, Object> user = userDao.setUser(password);
		
		if(user == null){
			System.out.println("비밀번호를 잘못 입력하셨습니다.");
			return View.USER_SET;
		}
		System.out.println("==================== 정보 ====================");
		System.out.println("아이디 : " + user.get("USER_ID"));
		System.out.println("이름 : " + user.get("USER_NAME"));
		
		System.out.println("수정하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //수정
			System.out.println("기존 비밀번호를 입력해주세요.");
			password = ScanUtil.nextLine();
			
			user = userDao.setUser(password);
			if(user == null){
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
				return View.USER_SET;
			}else{
				System.out.println("신규 비밀번호를 입력해주세요.");
				String newPassword = ScanUtil.nextLine();

				int result = userDao.updateUser(password, newPassword);

				if(0 < result){
					System.out.println("정보수정이 완료되었습니다.");
				}else{
					System.out.println("정보수정에 실패하였습니다.");
				}

				Controller.loginUser = user;

				return View.USER_SET;
			}
		case 2: //목록
			return View.USER_SET;
		}	
		return View.USER_SET;
	}

//회원탈퇴	
	public int userLeave() {
		System.out.println("탈퇴하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: //삭제
			System.out.println("비밀번호를 입력해주세요.");
			String password = ScanUtil.nextLine();
			Map<String, Object> user = userDao.setUser(password);
			
			if(user == null){
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
				return View.USER_SET;
			}
			int result = userDao.deleteUser(Controller.loginUser.get("USER_ID"));
			
			if(0 < result){
				System.out.println("회원탈퇴가 완료되었습니다.");
				Controller.loginUser = null;
			}else{
				System.out.println("회원탈퇴에 실패하였습니다.");
			}
			return View.HOME;
		case 2: //목록
			return View.USER_SET;
		}	
		
		return View.HOME;
	}
}
