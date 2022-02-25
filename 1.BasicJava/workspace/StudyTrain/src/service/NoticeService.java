package service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.NoticeDao;

public class NoticeService {	//게시판과 관련된 서비스를 수행
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private NoticeService(){}
	private static NoticeService instance;
	public static NoticeService getInstance(){
		if(instance == null){
			instance = new NoticeService();
		}
		return instance;
	}
	
//싱글톤 생성자	
	private NoticeDao noticeDao = NoticeDao.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	int no;
	
//공지게시판
	public int noticeList() {
		List<Map<String, Object>> noticeList = noticeDao.selectNoticeList();
		System.out.println("========== 공지 게시판 ======================================================================");
		System.out.println("번호\t제목\t\t\t\t작성자\t작성일\t\t조회수");
		System.out.println("=========================================================================================");
		for(Map<String, Object> notice : noticeList){
			System.out.println(notice.get("NOTICE_NO")
					  + "\t" + notice.get("NOTICE_TITLE")
					  + "\t\t\t\t" + notice.get("USER_ID")
					  + "\t" + sdf.format(notice.get("NOTICE_DATE"))
					  + "\t  " + notice.get("NOTICE_COUNT"));
		}
		System.out.println("=========================================================================================");
		System.out.println("[1.조회 | 2.등록 | 0.홈으로]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.NOTICE_READ;	//조회
		case 2:	return View.NOTICE_INSERT;		//등록
		case 0: //홈으로
			if(Controller.loginUser.get("USER_ADMIN").equals("y")){
				return View.ADMIN_HOME;
			}else{
				return View.USER_HOME;
			}
		}
		return View.NOTICE_LIST;
	}
	
//공지내용
	public int noticeRead() {
		System.out.println("조회할 게시물을 선택해주세요.");
		System.out.print("번호 입력>");
		no = ScanUtil.nextInt();
		
		Map<String, Object> notice = noticeDao.selectNotice(no);
		int count = noticeDao.countNotice(no);
		
		System.out.println("=========================================================================================");
		System.out.println(notice.get("NOTICE_NO") + "번 게시물");
		System.out.println("제목 : " + notice.get("NOTICE_TITLE"));
		System.out.println("=========================================================================================");
		System.out.println("내용 : ");
		System.out.println(notice.get("NOTICE_CONTENT"));
		System.out.println();
		System.out.println("=========================================================================================");
		System.out.println("작성자: " + notice.get("USER_ID"));
		System.out.println("작성일: " + sdf2.format(notice.get("NOTICE_DATE")));
		System.out.println("=========================================================================================");
		System.out.println("[1.수정 | 2.삭제 | 0.목록]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.NOTICE_UPDATE;	//수정
		case 2: return View.NOTICE_DELETE;	//삭제
		case 0: return View.NOTICE_LIST;	//목록
		}
		return View.NOTICE_READ;
	}
	
//삽입
	public int noticeInsert() {
		if(!Controller.loginUser.get("USER_ADMIN").equals("y")){
			System.out.println("관리자만 작성이 가능합니다.");
			return View.NOTICE_LIST;
		}else{
			System.out.print("제목을 입력하세요.>");
			String title = ScanUtil.nextLine();
			System.out.print("내용을 입력하세요.>");
			String content = ScanUtil.nextLine();
			int result = noticeDao.insertNotice(title, content);
			if(0 < result){
				System.out.println("공지글 등록이 완료되었습니다.");
			}else{
				System.out.println("공지글 등록에 실패하였습니다.");
			}
			return View.NOTICE_LIST;
		}
	}
	
//수정
	public int noticeUpdate() {
		Map<String, Object> notice = noticeDao.selectNotice(no);
		
		System.out.println("수정하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //수정
			if(Controller.loginUser.get("USER_ADMIN").equals("n")){
				System.out.println("관리자만 수정이 가능합니다.");
				return View.NOTICE_READ;
			}else{
				System.out.println("제목을 수정해주세요.");
				String title = ScanUtil.nextLine();
				System.out.println("내용을 수정해주세요.");
				String content = ScanUtil.nextLine();
				
				int result = noticeDao.updateNotice(title, content, no);
				
				if(0 < result){
					System.out.println("공지글 수정이 완료되었습니다.");
				}else{
					System.out.println("공지글 수정에 실패하였습니다.");
				}
				return View.NOTICE_READ;
			}
		case 2: //목록
			return View.NOTICE_READ;
		}	
		return View.NOTICE_READ;
	}
	
//삭제
	public int noticeDelete() {
		Map<String, Object> notice = noticeDao.selectNotice(no);
		
		System.out.println("삭제하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //삭제
			if(Controller.loginUser.get("USER_ADMIN").equals("y")){
				int result = noticeDao.deleteNotice(no);
				
				if(0 < result){
					System.out.println("공지글 삭제가 완료되었습니다.");
				}else{
					System.out.println("공지글 삭제에 실패하였습니다.");
				}
				return View.NOTICE_LIST;
			}else{
				System.out.println("관리자만 삭제가 가능합니다.");
				return View.NOTICE_READ;
			}
		case 2: //목록
			return View.NOTICE_READ;
		}	
		return View.NOTICE_READ;
	}

}
