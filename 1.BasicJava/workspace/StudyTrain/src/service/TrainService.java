package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.TrainDao;

public class TrainService {	//게시판과 관련된 서비스를 수행
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private TrainService(){}
	private static TrainService instance;
	public static TrainService getInstance(){
		if(instance == null){
			instance = new TrainService();
		}
		return instance;
	}
	
//싱글톤 생성자		
	private TrainDao trainDao = TrainDao.getInstance();
	int insertNo;
	int typeNo;
	
//열차리스트
	public int trainList() {
		List<Map<String, Object>> trainList = trainDao.selectTrainList();
		if(Controller.loginUser.get("USER_ADMIN").equals("y")){	//관리자
			System.out.println("========== 열차 목록 ================================================== [관리자 ID: "+ Controller.loginUser.get("USER_ID") + "] ==");
		}else{	//회원
			System.out.println("========== 열차 목록 ================================================= [유저 ID: "+ Controller.loginUser.get("USER_ID") + "] ==");
		}
		System.out.println("열차번호\t열차종류\t노선\t방향\t출발역\t종착역\t출발시간\t객차수\t좌석수\t총좌석수\t특실칸");
		System.out.println("=========================================================================================");
		for(Map<String, Object> train : trainList){
			int select = (int)train.get("LINE_NO");
			Map<String, Object> up = trainDao.upRow(select);
			Map<String, Object> down = trainDao.downRow(select);
			System.out.print(train.get("TRAIN_NO")
					+ "\t" + train.get("TRAIN_TYPE_NAME")
					+ "\t" + train.get("LINE_NAME") + "\t");
			if(train.get("DIRECTION").equals("하행")){
				System.out.print("하행\t" + down.get("AREA_NAME") + "\t" + up.get("AREA_NAME") + "\t");
			}else{
				System.out.print("상행\t" + up.get("AREA_NAME") + "\t" + down.get("AREA_NAME") + "\t");
			}
			
			Map<String, Object> all = trainDao.allSeat((int)train.get("TRAIN_NO"));
			int car = (int)all.get("CABIN_NO");
			int seat = (int)all.get("SEAT_CAPA");
			System.out.print(train.get("FIRST_TIME") + "시"
					+ "\t" + car + "개"
					+ "\t" + seat + "개"
					+ "\t" + (car * seat) + "개\t");
			
			List<Map<String, Object>> vip = trainDao.vipSeat((int)train.get("TRAIN_NO"));			
			
			if(vip.size() != 0){
				for(Map<String, Object> vs : vip){
					System.out.print(vs.get("CABIN_NO") + "호차 ");
				}
				System.out.println(" ");
			}else{
				System.out.println("-");
			}
		}
		System.out.println("=========================================================================================");
		if(Controller.loginUser.get("USER_ADMIN").equals("y")){	//관리자
			System.out.println("[1.열차조회 | 2.열차등록 | 3.열차타입관리 | 0.관리자페이지]");
			System.out.println("=========================================================================================");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1: return View.TRAIN_VIEW;
			case 2: return View.TRAIN_INSERT;
			case 3: return View.TRAIN_TYPE_MANAGE;
			case 0: return View.ADMIN_HOME;
			}
			return View.ADMIN_HOME;
		}else{	//회원
			System.out.println("[1.열차시간표 | 0.유저페이지]");
			System.out.println("=========================================================================================");
			System.out.print("번호 입력>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1: return View.TRAIN_TIME_TABLE;
			case 0: return View.USER_HOME;
			}
			return View.USER_HOME;
		}
	}
	
//열차조회
	public int trainView() {
		System.out.println("조회할 열차번호를 선택해주세요.");
		System.out.print("번호 입력>");
		int no = ScanUtil.nextInt();
		
		
		return View.USER_HOME;
	}
	
//열차등록
	public int trainInsert() {
		List<Map<String, Object>> typeList = trainDao.trainTypeList();
		if(Controller.loginUser.get("USER_ADMIN").equals("y")){	//관리자
			System.out.println("========== 열차 종류 ================================================ [관리자 ID: "+ Controller.loginUser.get("USER_ID") + "] ==");
		}else{	//회원
			System.out.println("========== 열차 종류 =============================================== [유저 ID: "+ Controller.loginUser.get("USER_ID") + "] ==");
		}
		
		
		return 0;
	}
	
//열차타입관리
	public int trainTypeManage(){
		List<Map<String, Object>> typeList = trainDao.selectTrainType();
		System.out.println("========== 열차타입 목록 =============================================== [관리자 ID: "+ Controller.loginUser.get("USER_ID") + "] ==");
		System.out.println("타입번호\t타입이름\t일반실 단가\t특실 단가");
		System.out.println("=========================================================================================");
		for(Map<String, Object> type : typeList){
			System.out.println(type.get("TRAIN_TYPE_NO")
					  + "\t" + type.get("TRAIN_TYPE_NAME")
					  + "\t" + type.get("NORMAL_PRICE")
					  + "\t\t" + type.get("VIP_PRICE"));
		}
		System.out.println("=========================================================================================");
		System.out.println("[1.타입조회 | 2.타입등록 | 0.뒤로가기]");
		System.out.println("=========================================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1:
			System.out.println("조회할 타입번호를 선택해주세요.");
			System.out.print("번호 입력>");
			typeNo = ScanUtil.nextInt();
			
			return View.TRAIN_TYPE_VIEW;	//열차타입 조회
		case 2: return View.TRAIN_TYPE_INSERT;	//열차타입 등록
		case 0: return View.MANAGE_TRAIN;		//뒤로가기
		}
		return View.MANAGE_TRAIN;
	}
	
//열차타입조회
	public int trainTypeView() {
		Map<String, Object> trainType = trainDao.trainTypeView(typeNo);
		
		System.out.println("=========================================================================================");
		System.out.println("타입번호     :  " + trainType.get("TRAIN_TYPE_NO") + "번");
		System.out.println("타입이름     :  " + trainType.get("TRAIN_TYPE_NAME") + "타입");
		System.out.println("일반실 단가 :  " + trainType.get("NORMAL_PRICE") + "원");
		System.out.println("특실 단가    :  " + trainType.get("VIP_PRICE") + "원");
		System.out.println("=========================================================================================");
		System.out.println("[1.수정 | 2.삭제 | 0.뒤로가기]");
		System.out.println("=========================================================================================");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.TRAIN_TYPE_UPDATE;		//수정
		case 2: return View.TRAIN_TYPE_DELETE;		//삭제
		case 0: return View.TRAIN_TYPE_MANAGE;		//뒤로가기
		}
		return View.TRAIN_TYPE_VIEW;
	}
	
//열차타입수정
	public int trainTypeUpdate() {
		System.out.println("[1.일반실 단가 | 2.특실 단가 | 0.수정종료]");
		System.out.println("=========================================================================================");
		System.out.println("수정할 항목을 선택해주세요.");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			System.out.print("신규 일반실 단가>");
			int newNPrice = ScanUtil.nextInt();
			
			int result1 = trainDao.updateNormalPrice(typeNo, newNPrice);
			if(0 < result1){
				System.out.println("일반실 단가 수정이 완료되었습니다.");
			}else{
				System.out.println("일반실 단가 수정에 실패하였습니다.");
			}
			System.out.println("=========================================================================================");
			return View.TRAIN_TYPE_UPDATE;
		case 2:
			System.out.print("신규 특실 단가>");
			int newPPrice = ScanUtil.nextInt();
			
			int result2 = trainDao.updateVIPPrice(typeNo, newPPrice);
			if(0 < result2){
				System.out.println("특실 단가 수정이 완료되었습니다.");
			}else{
				System.out.println("특실 단가 수정에 실패하였습니다.");
			}
			System.out.println("=========================================================================================");
			return View.TRAIN_TYPE_UPDATE;
		case 0: return View.TRAIN_TYPE_VIEW;
		}
		return View.TRAIN_TYPE_VIEW;
	}
	
//열차타입삭제	
	public int trainTypeDelete() {
		System.out.println("삭제하시겠습니까?");
		System.out.println("[1.YES | 2.NO]");
		System.out.print("번호 입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: //삭제
			int result = trainDao.deleteTrainType(typeNo);
			if(0 < result){
				System.out.println("열차타입 삭제가 완료되었습니다.");
			}else{
				System.out.println("열차타입 삭제에 실패하였습니다.");
			}
			return View.TRAIN_TYPE_MANAGE;
		case 2: //목록
			return View.TRAIN_TYPE_VIEW;
		}	
		return View.TRAIN_TYPE_MANAGE;
	}
	
//열차타입등록
	public int trainTypeInsert() {
		System.out.print("등록할 타입이름>");
		String type = ScanUtil.nextLine();
		System.out.print("일반실 단가>");
		int nPrice = ScanUtil.nextInt();
		System.out.print("특실 단가>");
		int vPrice = ScanUtil.nextInt();
		
		Map<String, Object> search = trainDao.searchTrainType(type);
		if(search == null){
			System.out.println("새로운 타입의 열차입니다.");
			System.out.println("타입과 단가를 등록하겠습니다.");
			System.out.println("=========================================================================================");
			int result1 = trainDao.insertTrainType(type);
			int result2 = trainDao.insertTrainTypePrice(type, nPrice, vPrice);
			if(0 < result1 && 0 < result2){
				System.out.println("타입등록에 성공하였습니다.");
			}else{
				System.out.println("타입등록에 실패하였습니다.");
			}		
			return View.TRAIN_TYPE_MANAGE;
		}else{
			insertNo = (int)search.get("TRAIN_TYPE_NO");
			Map<String, Object> search2 = trainDao.searchTrainType2(insertNo);
			if(search2 == null){
				System.out.println("이미 존재하는 열차입니다.");
				System.out.println("단가만 등록하겠습니다.");
				System.out.println("=========================================================================================");
				
				int result2 = trainDao.insertTrainTypePrice(type, nPrice, vPrice);
				
				if(0 < result2){
					System.out.println("타입등록에 성공하였습니다.");
				}else{
					System.out.println("타입등록에 실패하였습니다.");
				}		
				return View.TRAIN_TYPE_MANAGE;
			}else{
				System.out.println("이미 등록이 완료된 열차입니다.");
				return View.TRAIN_TYPE_MANAGE;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
