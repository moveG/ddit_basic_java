package service;

import java.text.SimpleDateFormat;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.BoardDao;
import dao.UserDao;

public class AdminService {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private AdminService(){}
	private static AdminService instance;
	public static AdminService getInstance(){
		if(instance == null){
			instance = new AdminService();
		}
		return instance;
	}
	
//싱글톤 생성자	
	private BoardDao boardDao = BoardDao.getInstance();
	private UserDao userDao = UserDao.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
	int no;
	
//관리자페이지
	public int adminHome() {
		System.out.println("========== 관리자 페이지 =================================== [관리자 ID: "+ Controller.loginUser.get("USER_ID") + "] ==============");
		System.out.println("[1.열차관리 | 2.지역관리 | 3.노선관리 | 4.회원관리 | 5.분실물 게시판 | 6.공지사항 | 7.설정 | 0.로그아웃]");
		System.out.println("=========================================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.MANAGE_TRAIN;
		case 2: return View.MANAGE_AREA;
		case 3: return View.MANAGE_LINE;
		case 4: return View.MANAGE_USER;
		case 5: return View.BOARD_LIST;
		case 6: return View.NOTICE_LIST;
		case 7: return View.ADMIN_SETTING;
		case 0:
			Controller.loginUser = null;
			return View.HOME;
		}
		return View.ADMIN_HOME;
	}
	
//설정
	public int adminSetting() {
		System.out.println("========== 설정 =====================================================");
		System.out.println("[1.정보수정 | 2.관리자탈퇴 | 0.관리자페이지]");
		System.out.println("====================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.ADMIN_UPDATE;
		case 2: return View.ADMIN_DELETE;
		case 0: return View.ADMIN_HOME;
		}
		return View.ADMIN_HOME;
	}

//정보수정
	public int adminUpdate() {
		System.out.print("비밀번호>");
		String password = ScanUtil.nextLine();
		Map<String, Object> admin = userDao.setUser(password);
		
		if(admin == null){
			System.out.println("비밀번호를 잘못 입력하셨습니다.");
			return View.ADMIN_SETTING;
		}
		while(true){
			System.out.println("========== 정보 =====================================================");
			System.out.println("아이디 : " + admin.get("USER_ID"));
			System.out.println("이름 : " + admin.get("USER_NAME"));
			System.out.println("비밀번호 : ****");
			System.out.println("생년월일 : " + admin.get("USER_BIRTH"));
			System.out.println("마일리지 : " + admin.get("MILEAGE"));
			System.out.println("장애여부 : " + admin.get("USER_DISABLED"));
			System.out.println("====================================================================");
			System.out.println("수정하시겠습니까?");
			System.out.println("[1.YES | 2.NO]");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1: //수정
				System.out.println("[1.비밀번호 | 2.장애여부 | 0.수정취소]");
				System.out.println("번호 입력>");
				int select = ScanUtil.nextInt();
				switch (select) {
				case 1:	//비밀번호
					System.out.print("기존 비밀번호>");
					password = ScanUtil.nextLine();
					
					admin = userDao.setUser(password);
					if(admin == null){
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
						
						Controller.loginUser = admin;
						
						return View.USER_SETTING;
					}
				case 2:	//장애여부
					System.out.println("장애여부를 입력해주세요.");
					System.out.println("[1.장애인 | 2.비장애인]");
					System.out.print("번호 입력>");
					String disabled = ScanUtil.nextLine();
					System.out.println("====================================================================");
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
					Controller.loginUser = admin;
					break;
				case 0:	//관리자페이지
					return View.USER_SETTING;
				}
				break;
			case 2: //목록
				return View.ADMIN_SETTING;
			}	
		}
	}

//회원탈퇴	
	public int adminDelete() {
		System.out.println("탈퇴하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		System.out.println("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: //삭제
			System.out.println("비밀번호를 입력해주세요.");
			String password = ScanUtil.nextLine();
			Map<String, Object> user = userDao.setUser(password);
			
			if(user == null){
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
				return View.ADMIN_SETTING;
			}
			int result = userDao.deleteUser(Controller.loginUser.get("USER_ID"));
			
			if(0 < result){
				System.out.println("관리자 계정이 삭제되었습니다.");
				Controller.loginUser = null;
			}else{
				System.out.println("관리자 계정 삭제에 실패하였습니다.");
			}
			return View.HOME;
		case 2: //목록
			return View.ADMIN_SETTING;
		}	
		 
		return View.ADMIN_HOME;
	}
}
