package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
//싱글톤 생성자	
	private UserDao userDao = UserDao.getInstance();
	String newPassword;
	String newPassword2;
	Object oldPassword;
	String admin;
	
//회원가입
	public int join(){
		System.out.println("========== 회원가입 ========================================================================");
		//아이디 입력
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		//아이디 유효성확인
		String regex = "[a-zA-Z0-9-_]{5,20}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(userId);
		if(m.matches() == false){
			System.out.println("5~20자의 영문 대소문자, 숫자, 특수기호('_', '-')만 사용 가능합니다.");
			return View.JOIN;
		}
		//아이디 중복확인
		Map<String, Object> checkId = userDao.idCheck(userId);
		if(checkId != null){
			System.out.println("중복된 아이디입니다.");
			return View.JOIN;
		}else{
			System.out.println("사용하실 수 있는 아이디입니다.");
		}
		//비밀번호 입력
		String password = null;
		while(true){
			System.out.print("비밀번호>");
			password = ScanUtil.nextLine();
			System.out.print("비밀번호 확인>");
			String password2 = ScanUtil.nextLine();
			if(!password.equals(password2)){
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
			}else{
				break;
			}
		}
		//이름 입력
		System.out.print("이름>");
		String userName = ScanUtil.nextLine();
		//생일 입력
		System.out.print("생년월일 [ex)950101]>");
		int userBirth = ScanUtil.nextInt();
		//장애여부 입력
		String disabled;
		while(true){
			System.out.println("장애여부를 입력해주세요.");
			System.out.println("[1.장애인 | 2.비장애인]");
			System.out.print("번호 입력>");
			disabled = ScanUtil.nextLine();
			if(disabled.equals("1")){
				disabled = "y";
				break;
			}else if(disabled.equals("2")){
				disabled = "n";
				break;
			}else{
				System.out.println("잘못 입력하셨습니다.");
			}
			
		}
		//회원타입 입력
		admin1 : while(true){
			System.out.println("회원타입을 입력해주세요.");
			System.out.println("[1.관리자 | 2.회원]");
			System.out.print("번호 입력>");
			admin = ScanUtil.nextLine();
			if(admin.equals("1")){
				while(true){
					System.out.print("관리자 코드>");
					String adminCode = ScanUtil.nextLine();
					if(adminCode.equals("admin")){	//관리자 코드 임의 설정
						System.out.println("관리자임이 확인되었습니다.");
						admin = "y";
						break admin1;
					}else{
						System.out.println("잘못 입력하셨습니다.");
						System.out.println("입력을 취소하시면 회원가입이 취소됩니다.");
						System.out.println("다시 입력하시겠습니까?");
						System.out.println("[1.YES | 2.NO]");
						System.out.print("번호 입력>");
						int input = ScanUtil.nextInt();
						if(input == 1){
							
						}else if(input == 2){
							System.out.println("회원가입이 취소되었습니다.");
							return View.HOME;
						}
					}
				}
			}else if(admin.equals("2")){
				admin = "n";
				break;
			}else{
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		Map<String, Object> param = new HashMap<>();
		param.put("USER_NAME", userName);
		param.put("USER_BIRTH", userBirth);
		param.put("USER_ID", userId);
		param.put("PASSWORD", password);
		param.put("MILEAGE", 0);
		param.put("USER_DISABLED", disabled);
		param.put("USER_ADMIN", admin);
		if(admin.equals("y")){
			param.put("USER_TYPE", "관리자");
		}else{
			param.put("USER_TYPE", "일반회원");
		}
		
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
		System.out.println("========== 로그인 =========================================================================");
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		
		Map<String, Object> user = userDao.selectUser(userId, password);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			return View.HOME;
		}else if(user.get("USER_TYPE").equals("탈퇴회원")){
			System.out.println("탈퇴한 계정입니다.");
			return View.HOME;
		}else{
			System.out.println("로그인 성공");
			Controller.loginUser = user; //로그인에 성공한 유저를 LoginUser 변수에 저장
			if(user.get("USER_ADMIN").equals("y")){
				return View.ADMIN_HOME;	//관리자페이지로 이동
			}else{
				return View.USER_HOME;	//유저페이지로 이동
			}
		}
	}
	
//찾기
	public int search() {
		System.out.println("=========================================================================================");
		System.out.println("[1.아이디 | 2.비밀번호 | 0.홈으로]");
		System.out.println("=========================================================================================");
		System.out.print("번호 선택>");
		int input = ScanUtil.nextInt();
		if(input == 1){
			System.out.print("이름>");
			String name = ScanUtil.nextLine();
			System.out.print("생년월일 [ex)950101]>");
			int birth = ScanUtil.nextInt();
			System.out.println("=========================================================================================");
			Map<String, Object> searchID = userDao.searchID(name, birth);
			if(searchID != null){
				System.out.println("아이디 : " + searchID.get("USER_ID"));
			}else{
				System.out.println("정보를 확인하지 못했습니다.");
				System.out.println("다시 확인해 주세요.");
				return View.SEARCH;
			}
			return View.SEARCH;
		}else if(input == 2){
			System.out.print("아이디>");
			String id = ScanUtil.nextLine();
			System.out.print("이름>");
			String name = ScanUtil.nextLine();
			System.out.print("생년월일 [ex)950101]>");
			int birth = ScanUtil.nextInt();
			System.out.println("=========================================================================================");
			Map<String, Object> searchPW = userDao.searchPW(id, name, birth);
			
			if(searchPW == null){
				System.out.println("정보를 확인하지 못했습니다.");
				System.out.println("다시 확인해 주세요.");
				return View.SEARCH;
			}else{
				System.out.println("정보를 확인했습니다.");
				System.out.println("비밀번호를 변경하시겠습니까?");
				System.out.print("[1.예 | 2.아니오]>");
				int change = ScanUtil.nextInt();
				System.out.println("=========================================================================================");
				switch (change) {
				case 1:
					oldPassword = searchPW.get("PASSWORD");
					while(true) {
						System.out.print("새 비밀번호>");
						newPassword = ScanUtil.nextLine();
						System.out.print("비밀번호 확인>");
						newPassword2 = ScanUtil.nextLine();
						System.out.println("=========================================================================================");
						if(!newPassword.equals(newPassword2)){
							System.out.println("비밀번호를 잘못 입력하셨습니다.");
							System.out.println("=========================================================================================");
						}else if(oldPassword.equals(newPassword)){
							System.out.println("기존 비밀번호와 동일한 번호입니다.");
							System.out.println("=========================================================================================");
						}else{
							break;
						}
					}
					
					int result = userDao.changePW(id, newPassword, oldPassword);
					
					if(0 < result){
						System.out.println("비밀번호 수정이 완료되었습니다.");
					}else{
						System.out.println("비밀번호 수정에 실패하였습니다.");
					}	
				case 2:
					return View.SEARCH;
				}
			}
			return View.SEARCH;
		}else{
			return View.HOME;
		}
	}
	
//유저페이지
	public int userHome() {
		System.out.println("========== 유저 페이지 =================================== [유저 ID: "+ Controller.loginUser.get("USER_ID") + "] ==================");
		System.out.println("[1.열차예매 | 2.분실물 게시판 | 3.공지사항 | 4.설정 | 0.로그아웃]");
		System.out.println("=========================================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.BOOK_BOARD;
		case 2: return View.BOARD_LIST;
		case 3: return View.NOTICE_LIST;
		case 4: return View.USER_SETTING;
		case 0:	
			Controller.loginUser = null;
			return View.HOME;
		}
		return View.USER_HOME;
	}
	
//설정
	public int userSetting() {
		System.out.println("========== 설정 ===========================================================================");
		System.out.println("[1.승차권 조회 | 2.정보수정 | 3.회원탈퇴 | 0.유저페이지]");
		System.out.println("=========================================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.TICKET_VIEW;
		case 2: return View.USER_UPDATE;
		case 3: return View.USER_DELETE;
		case 0: return View.USER_HOME;
		}
		return View.USER_HOME;
	}

//정보수정
	public int userUpdate() {
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		Map<String, Object> user = userDao.setUser(password);
		
		if(user == null){
			System.out.println("비밀번호를 잘못 입력하셨습니다.");
			return View.USER_SETTING;
		}
		while(true){
			System.out.println("========== 정보 ==========================================================================");
			System.out.println("아이디 : " + user.get("USER_ID"));
			System.out.println("비밀번호 : ****");
			System.out.println("이름 : " + user.get("USER_NAME"));
			System.out.println("생년월일 : " + user.get("USER_BIRTH"));
			System.out.println("마일리지 : " + user.get("MILEAGE"));
			System.out.println("장애여부 : " + user.get("USER_DISABLED"));
			System.out.println("=========================================================================================");
			System.out.println("수정하시겠습니까?");
			System.out.println("[1.YES | 2.NO]");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1: //수정
				System.out.println("[1.비밀번호 | 2.장애여부 | 0.유저페이지]");
				System.out.println("=========================================================================================");
				System.out.println("수정할 항목을 선택해주세요.");
				System.out.print("번호 입력>");
				int select = ScanUtil.nextInt();
				switch (select) {
				case 1:	//비밀번호
					System.out.print("기존 비밀번호>");
					password = ScanUtil.nextLine();
					
					user = userDao.setUser(password);
					if(user == null){
						System.out.println("비밀번호를 잘못 입력하셨습니다.");
						return View.USER_SETTING;
					}else{
						System.out.print("신규 비밀번호>");
						String newPassword = ScanUtil.nextLine();
						
						int result = userDao.updateUser(password, newPassword);
						
						if(0 < result){
							System.out.println("정보수정이 완료되었습니다.");
						}else{
							System.out.println("정보수정에 실패하였습니다.");
						}
						Controller.loginUser = user;
						break;
					}
				case 2:	//장애여부
					System.out.println("장애여부를 입력해주세요.");
					System.out.println("[1.장애인 | 2.비장애인]");
					System.out.print("번호 입력>");
					String disabled = ScanUtil.nextLine();
					System.out.println("=========================================================================================");
					Object no = Controller.loginUser.get("USER_NO");
					if(disabled.equals("1")){
						disabled = "y";
					}else{
						disabled = "n";
					}
					int result = userDao.updateDisabled(disabled, no);
					
					if(0 < result){
						System.out.println("정보수정이 완료되었습니다.");
					}else{
						System.out.println("정보수정에 실패하였습니다.");
					}
					Controller.loginUser = user;
					break;
				case 0: //유저페이지
					return View.USER_SETTING;
				}
				break;
			case 2:	//수정거부
				return View.USER_SETTING;
			}
		}
	}

//회원탈퇴	
	public int userDelete() {
		System.out.println("탈퇴하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: //탈퇴
			System.out.println("비밀번호를 입력해주세요.");
			String password = ScanUtil.nextLine();
			Map<String, Object> user = userDao.setUser(password);
			
			if(user == null){
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
				return View.USER_SETTING;
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
			return View.USER_SETTING;
		}	
		 
		return View.USER_HOME;
	}
	
//티켓조회
	public int ticketView(){
		List<Map<String, Object>> ticketList = userDao.ticketList();
		System.out.println("========== 승차권 조회 ======================================================================");
		System.out.println("예매번호\t예매일자\t열차종류\t열차번호\t객차번호\t노선\t출발역\t출발시간\t도착역\t도착시간\t가격");
		System.out.println("=========================================================================================");
		for(Map<String, Object> ticket : ticketList){
			System.out.println(ticket.get("BOOK_NO")
				 	  + "\t" + ticket.get("BOOK_DATE")
					  + "\t" + ticket.get("TRAIN_TYPE_NAME")
					  + "\t" + ticket.get("TRAIN_NO")
					  + "\t" + ticket.get("CABIN_NO")
					  + "\t" + ticket.get("LINE_NAME")
					  + "\t" + ticket.get("S_AREA_NAME")
					  + "\t" + ticket.get("S_TIME")
					  + "\t" + ticket.get("E_AREA_NAME")
					  + "\t" + ticket.get("E_TIME")
					  + "\t" + ticket.get("PRICE"));
		}
		System.out.println("=========================================================================================");
		System.out.println("[1.환불 | 0.홈으로]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		
		
		
		
		
		
		return 0;
	}
}
