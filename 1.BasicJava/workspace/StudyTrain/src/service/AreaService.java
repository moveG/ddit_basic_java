package service;

import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.AreaDao;

public class AreaService {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private AreaService(){}
	private static AreaService instance;
	public static AreaService getInstance(){
		if(instance == null){
			instance = new AreaService();
		}
		return instance;
	}

//싱글톤 생성자	
	private AreaDao areaDao = AreaDao.getInstance();
		
//지역리스트
	public int areaList() {
		List<Map<String, Object>> areaList = areaDao.selectAreaList();
		System.out.println("========== 지역 목록 =======================================================================");
		System.out.println("노선번호\t노선이름\t지역번호\t지역이름");
		System.out.println("=========================================================================================");
		for(Map<String, Object> area : areaList){
			System.out.println(area.get("LINE_NO")
					  + "\t" + area.get("LINE_NAME")
					  + "\t" + area.get("AREA_NAME")
					  + "\t" + area.get("AREA_NAME"));
		}
		System.out.println("=========================================================================================");
		System.out.println("[1.지역조회 | 2.지역등록 | 0.관리자페이지]");
		System.out.println("=========================================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.AREA_VIEW;
		case 2: return View.AREA_INSERT;
		case 0: return View.ADMIN_HOME;
		}
		return View.ADMIN_HOME;
	}
		
//지역등록
	public int areaInsert() {
		System.out.println("등록할 지역>");
		String area = ScanUtil.nextLine();
		System.out.println("=========================================================================================");
		System.out.println("[1.기존 노선에 등록 | 2.신규 노선에 등록 | 0.목록]");
		System.out.println("=========================================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
		case 2:
		case 0: return View.MANAGE_AREA;
		}
		return View.MANAGE_AREA;
	}
		
}
