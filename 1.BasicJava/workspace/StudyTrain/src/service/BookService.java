package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BookDao;
import util.ScanUtil;
import util.View;

public class BookService {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private BookService(){}
	private static BookService instance;
	public static BookService getInstance(){
		if(instance == null){
			instance = new BookService();
		}
		return instance;
	}
	
	private BookDao bookDao = BookDao.getInstance();
	int no;
	
//예약 게시판
	public int bookBoard() {
		List<Map<String, Object>> bookList = bookDao.selectBoardList();
		System.out.println("================= 예약 게시판 =================");
		System.out.println("예약번호\t예약일자\t예약자\t  금액\t결제여부");
		System.out.println("===========================================");
		for(Map<String, Object> book : bookList){
			if(book.get("USER_NO").equals(Controller.loginUser.get("USER_NO"))){
				System.out.println(book.get("BOOK_NO")
						  + "\t" + book.get("BOOK_DATE")
						  + "\t" + book.get("USER_NAME")
						  + "\t" + book.get("PRICE") + "원"
						  + "\t   " + book.get("PAY_STATUS"));
			}
		}
		System.out.println("===========================================");
		System.out.println("\t\t[1.예약 | 2.예약취소 | 3.홈으로]");
		System.out.print("입력>");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1: return View.BOOK_INSERT;	//예약
		case 2:	return View.BOOK_CANCEL;	//예약취소
		case 3:	return View.USER_HOME;		//홈으로
		}
		return View.BOOK_BOARD;
	}
//예약 페이지	
	public int bookPage() {
		System.out.println("출발역>");
		System.out.println("도착역>");
		System.out.println("출발시간>");
		System.out.println("객차>");
		System.out.println("좌석>");
		System.out.println("특실여부>");
		return View.BOOK_BOARD;
	}
	
//예약	
	public int bookInsert() {
		System.out.println("출발역>");
		String start = ScanUtil.nextLine();
		System.out.println("도착역>");
		String finish = ScanUtil.nextLine();
		System.out.println("출발시간>");
		String sTime = ScanUtil.nextLine();
		System.out.println("특실여부>");
		String vip = ScanUtil.nextLine();
		
		return View.BOOK_BOARD;
	}	
	
//예약취소
	public int bookCancel() {
		System.out.print("취소할 예약번호>");
		no = ScanUtil.nextInt();
		
		int result = bookDao.cancelBook(no);
		int result2 = bookDao.cancelBook2(no);
		
		if(0 < result && 0 < result2){
			System.out.println("예약 취소가 완료되었습니다.");
		}else{
			System.out.println("예약 취소를 실패하였습니다.");
		}
		return View.BOOK_BOARD;
	}		
	
	
	
	
	
	
	
	
	
	
	
	
}
