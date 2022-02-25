package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.LineDao;

public class LineService {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private LineService(){}
	private static LineService instance;
	public static LineService getInstance(){
		if(instance == null){
			instance = new LineService();
		}
		return instance;
	}

//싱글톤 생성자	
	private LineDao lineDao = LineDao.getInstance();

//노선리스트	
	public int lineList() {
		List<Map<String, Object>> lineList = lineDao.selectLineList();
		System.out.println("========== 노선 목록 ================================================== [관리자 ID: "+ Controller.loginUser.get("USER_ID") + "] ==");
		System.out.println("노선번호\t노선이름");
		System.out.println("=========================================================================================");
		for(Map<String, Object> line : lineList){
			System.out.println(line.get("LINE_NO")
					  + "\t" + line.get("LINE_NAME"));
		}
		System.out.println("=========================================================================================");
		System.out.println("[1.노선조회 | 2.노선등록 | 0.관리자페이지]");
		System.out.println("=========================================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.LINE_VIEW;
		case 2: return View.LINE_INSERT;
		case 0: return View.ADMIN_HOME;
		}
		return View.ADMIN_HOME;
	}
	
//노선등록
	public int lineInsert() {
		System.out.print("등록할 노선>");
		String line = ScanUtil.nextLine();
		
		Map<String, Object> param = new HashMap<>();
		param.put("LINE_NAME", line);
		
		int result = lineDao.insertLine(param);
		
		if(0 < result){
			System.out.println("노선등록에 성공하였습니다.");
		}else{
			System.out.println("노선등록에 실패하였습니다.");
		}		
		return View.MANAGE_LINE;
	}



}
