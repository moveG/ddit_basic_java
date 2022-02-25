package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.BoardDao;
import dao.TrainDao;
import dao.UserDao;

public class TrainService {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private TrainService(){}
	private static TrainService instance;
	public static TrainService getInstance(){
		if(instance == null){
			instance = new TrainService();
		}
		return instance;
	}
	
	private TrainDao trainDao= TrainDao.getInstance();
	public static int trainselect;
	
	public int TrainList()
	{
		List<Map<String, Object>> trainList = trainDao.selectTrainList();
		if (UserService.standard==1) // 접근한 사람이 회원이라면
		{
			System.out.println("===================열차 목록=================(로그인 중인 유저 이름: "+Controller.LoginUser.get("USER_NAME")+")=========");
		}
		else //접근한 사람이 관리자라면
		{
			System.out.println("===================열차 목록=================(로그인 중인 관리자 아이디: "+Controller.LoginUser.get("ADMIN_ID")+")=========");
		}
		//System.out.println("====================게시판=================(로그인 중인 유저 이름: "+Controller.LoginUser.get("USER_NAME")+")=========");
		System.out.println("열차번호\t출발지\t도착지\t이동거리\t티켓가격\t출발시간");
		System.out.println("-------------------------------------------------------------------------------------");
		//System.out.println(boardList);
		for (Map<String,Object> train: trainList)
		{
			System.out.println(train.get("TRAIN_NO")+"\t"
					+train.get("START_LOC")+"\t"
					+train.get("END_LOC")+"\t"
					+train.get("KM")+"\t"
					+train.get("COST")+"\t"
					+train.get("REG_DATE")+"\t");
		}
		System.out.println("=================================================================================");
		if (UserService.standard==1) // 접근한 사람이 회원이라면
		{
			System.out.println("<1.열차 조회>\t<0.뒤로 가기>");
			System.out.println("입력");
			int input=ScanUtil.nextInt();
			
			switch(input)
			{
			case 1: // 열차 조회
				return View.TRAIN_VIEW;
				//return boardView();
				//boardDao.insertUser(param);
			case 0: // 메뉴
				System.out.println("뒤로 돌아갑니다.");
				return View.KTX_HOME;
			}
			System.out.println("잘못된 번호입니다.");
			return View.KTX_TRAIN;
		}
		else //접근한 사람이 관리자라면
		{
			System.out.println("<1.조회>\t<2.열차등록>\t<0.뒤로 가기>");
			System.out.println("입력");
			int input=ScanUtil.nextInt();
			
			switch(input)
			{
			case 1: // 조회
				return View.TRAIN_VIEW;
				//return boardView();
				//boardDao.insertUser(param);
			case 2: // 등록 추가
				return View.TRAIN_INSERT;
				//return boardInsert(); //추가를 하면 보드를 다시 보여줘야 한다.
			case 0: // 메뉴
				System.out.println("관리자 화면으로 돌아갑니다.");
				return View.ADMIN_HOME;
			}
			System.out.println("잘못된 번호입니다.");
			return View.KTX_TRAIN;
		}
		
		
	}
	
	public int trainView() //조회
	{
		System.out.println("조회할 열차 번호를 입력하세요.");
		int sel=ScanUtil.nextInt();
		trainselect=sel;
		boolean flag=false;
		int index=-1;
		String[] titlenameOri={"열차번호","출발지","도착지","이동거리","티켓가격","출발시간"};
		
		List<Map<String, Object>> many = trainDao.selectTrainList();
		int count=many.size();
		for (int i=0;i<count;i++) //찾기
		{
			if (sel==Integer.parseInt(many.get(i).get("TRAIN_NO").toString()))
			{
				flag=true;
				index=i;
				break;
			}
		}
		if (flag) //입력한 번호의 BOARD_NO 가 있는 경우.
		{
//			--------------------------------
//			번호	: 1
//			작성자: d
//			작성일: 21-31-06
//			제목	: d
//			내용	: d
//			--------------------------------
			System.out.println("-----------열차 조회결과-------------");
			System.out.println(titlenameOri[0]+" : "+many.get(index).get("TRAIN_NO"));
			System.out.println(titlenameOri[1]+" : "+many.get(index).get("START_LOC"));
			System.out.println(titlenameOri[2]+" : "+many.get(index).get("END_LOC"));
			System.out.println(titlenameOri[3]+" : "+many.get(index).get("KM"));
			System.out.println(titlenameOri[4]+" : "+many.get(index).get("COST"));
			System.out.println(titlenameOri[5]+" : "+many.get(index).get("REG_DATE"));
			System.out.println("---------------------------------");
			
			if (UserService.standard==1) // 접근한 사람이 회원이라면
			{
				System.out.println("<1.예매>\t<2.장바구니에 넣기>\t<3.목록>");
				int how=ScanUtil.nextInt();
				
				if (how==1) //예매
				{
					int result = trainDao.insertTicket(sel);
					if (result>0) System.out.println("구매 성공하였습니다.");
					else System.out.println("구매 실패하였습니다.");
					return View.KTX_TRAIN;
				}
				else if(how==2) //장바구니에 넣기
				{
					int result = trainDao.insertBasketList(sel);
					
					if (result>0) System.out.println("장바구니에 등록되었습니다.");
					else System.out.println("장바구니 등록에 실패되었습니다.");
					
					return View.KTX_TRAIN;
				}
				else if(how==3) //목록
				{
					System.out.println("목록으로 돌아갑니다.");
					return View.KTX_TRAIN;
				}
				else //잘못입력
				{
					System.out.println("잘못된 번호 입력으로 목록으로 돌아갑니다.");
					return View.KTX_TRAIN;
				}
			}
			else //접근한 사람이 관리자라면
			{
				System.out.println("<1.수정>\t<2.삭제>\t<3.목록>");
				int how=ScanUtil.nextInt();
				
				if (how==1) //수정
				{
					return View.TRAIN_UPDATE;
				}
				else if(how==2) //삭제
				{
					return View.TRAIN_DELETE;
				}
				else if(how==3) //목록
				{
					System.out.println("목록으로 돌아갑니다.");
					return View.KTX_TRAIN;
				}
				else //잘못입력
				{
					System.out.println("잘못된 번호 입력으로 목록으로 돌아갑니다.");
					return View.KTX_TRAIN;
				}
			}
			
		}
		else
		{
			System.out.println(sel+"번 열차는 없습니다.");
			return View.KTX_TRAIN;
		}
	}
	
	
	public int trainInsert() //등록
	{
//		System.out.println("열차 번호를 입력하세요.");
//		String train_no=ScanUtil.nextLine();
		System.out.println("출발지를 입력하세요.");
		String start_loc=ScanUtil.nextLine();
		System.out.println("도착지를 입력하세요.");
		String end_loc=ScanUtil.nextLine();
		System.out.println("이동거리를 입력하세요.");
		String km=ScanUtil.nextLine();
		System.out.println("티켓가격을 입력하세요.");
		String cost=ScanUtil.nextLine();
		
		Map<String, Object> param=new HashMap<>();
		//param.put("TRAIN_NO",train_no);
		param.put("START_LOC",start_loc);
		param.put("END_LOC",end_loc);
		param.put("KM",km);
		param.put("COST",cost);
		
		int result = trainDao.insertTrainList(param);
		
		if (result>0) System.out.println("등록되었습니다.");
		else System.out.println("등록이 실패되었습니다.");
		
		return View.KTX_TRAIN;
	}
	
	
	public int trainUpdate() //열차 수정
	{
		System.out.println("수정할 출발지를 입력하시오.");
		String start_loc=ScanUtil.nextLine();
		System.out.println("수정할 도착지를 입력하시오.");
		String end_loc=ScanUtil.nextLine();
		System.out.println("수정할 이동거리를 입력하시오.");
		String km=ScanUtil.nextLine();
		System.out.println("수정할 티켓가격을 입력하시오.");
		String cost=ScanUtil.nextLine();

		Map<String, Object> param=new HashMap<>();
		param.put("START_LOC",start_loc);
		param.put("END_LOC",end_loc);
		param.put("KM",km);
		param.put("COST",cost);
		
		int result = trainDao.updateTrainList(param,trainselect);

		if (result>0) System.out.println("수정되었습니다.");
		else System.out.println("수정이 실패되었습니다.");

		return View.KTX_TRAIN;
	}
	
	public int trainDelete() //열차 삭제
	{
		System.out.println("삭제되었습니다.");	
		int result = trainDao.deleteTrainList(trainselect);

		if (result>0) System.out.println("삭제되었습니다.");
		else System.out.println("삭제가 실패되었습니다.");

		return View.KTX_TRAIN;
		
	}
	
	
//	public int trainBasket() //장바구니
//	{
//		System.out.println("장바구니에 넣을 열차 번호를 입력하세요.");
//		int sel=ScanUtil.nextInt();
//		boolean flag=false;
//		int index=-1;		
//		List<Map<String, Object>> many = trainDao.selectTrainList();
//		int count=many.size();
//		for (int i=0;i<count;i++) //찾기
//		{
//			if (sel==Integer.parseInt(many.get(i).get("TRAIN_NO").toString()))
//			{
//				flag=true;
//				index=i;
//				break;
//			}
//		}
//		if (flag) //입력한 번호의 BOARD_NO 가 있는 경우.
//		{
//			
//			int result = trainDao.insertBasketList(sel);
//			
//			if (result>0) System.out.println("장바구니에 등록되었습니다.");
//			else System.out.println("장바구니 등록에 실패되었습니다.");
//			
//			return View.KTX_TRAIN;
//		}
//		else
//		{
//			System.out.println(sel+"번 열차는 없습니다.");
//			return View.KTX_TRAIN;
//		}		
//	}
	
	public int trainBasket() //장바구니 목록 조회
	{
		List<Map<String, Object>> basketList = trainDao.selectBasketList();
		
		System.out.println("===================장바구니 목록=================(로그인 중인 유저 아이디: "+Controller.LoginUser.get("USER_NAME")+")=========");
		System.out.println("장바구니 번호\t열차번호\t");
		System.out.println("-------------------------------------------------------------------------------------");
		for (Map<String,Object> basket: basketList)
		{
			System.out.println(basket.get("BASKET_NO")+"\t"
					+basket.get("TRAIN_NO")+"\t");
		}
		System.out.println("=================================================================================");
		System.out.println("<1.조회하기>\t<2.장바구니 모두 비우기>\t<0.뒤로 가기>");
		System.out.println("입력");
		int input=ScanUtil.nextInt();
		
		switch(input)
		{
		case 1: // 조회하기
			return View.TRAIN_BASKET_VIEW;
		case 2: // 장바구니 비우기
			int result = trainDao.deleteBasketAll();
			if (result>0) System.out.println("장바구니를 모두 비웠습니다.");
			else System.out.println("장바구니 비우기를 실패하였습니다.");
			return View.TRAIN_BASKET;
		case 0: // 메뉴
			System.out.println("뒤로 돌아갑니다.");
			return View.KTX_USER;
		}
		System.out.println("잘못된 번호입니다.");
		return View.TRAIN_BASKET;
		
	}
	
	
	public int trainBasketView() //조회
	{
		System.out.println("조회할 장바구니 번호를 입력하세요.");
		int sel=ScanUtil.nextInt();
		boolean flag=false;
		int index=-1;
		String[] titlenameOri={"장바구니 번호","열차 번호"};
		
		List<Map<String, Object>> many = trainDao.selectBasketList();
		int count=many.size();
		for (int i=0;i<count;i++) //찾기
		{
			if (sel==Integer.parseInt(many.get(i).get("BASKET_NO").toString()))
			{
				flag=true;
				index=i;
				break;
			}
		}
		if (flag) //입력한 번호의 BOARD_NO 가 있는 경우.
		{
			System.out.println("-----------장바 구니 조회결과-------------");
			System.out.println(titlenameOri[0]+" : "+many.get(index).get("BASKET_NO"));
			System.out.println(titlenameOri[1]+" : "+many.get(index).get("TRAIN_NO"));
			System.out.println("---------------------------------");
			
			System.out.println("<1.예매>\t<2.삭제>\t<3.목록>");
			int how=ScanUtil.nextInt();
			
			if (how==1) //예매
			{
				return View.TRAIN_BUY;
			}
			else if(how==2) //삭제
			{
				int result = trainDao.deleteBasketList(sel);
				
				if (result>0) System.out.println("장바구니에서 삭제 되었습니다.");
				else System.out.println("장바구니에서 삭제가 실패되었습니다.");
				
				return View.TRAIN_BASKET;
			}
			else if(how==3) //목록
			{
				System.out.println("목록으로 돌아갑니다.");
				return View.TRAIN_BASKET;
			}
			else //잘못입력
			{
				System.out.println("잘못된 번호 입력으로 목록으로 돌아갑니다.");
				return View.TRAIN_BASKET;
			}
			
		}
		else
		{
			System.out.println(sel+"번 장바구니는 없습니다.");
			return View.TRAIN_BASKET;
		}
	}
	
	public int ticket()
	{
		List<Map<String, Object>> ticketList = trainDao.TicketList();
		System.out.println("===================티켓 목록=================(로그인 중인 유저 아이디: "+Controller.LoginUser.get("USER_ID")+")=========");
		System.out.println("열차번호\t출발지\t도착지\t이동거리");
		System.out.println("-------------------------------------------------------------------------------------");
		for (Map<String,Object> ticket: ticketList)
		{
			System.out.println(ticket.get("TRAIN_NO")+"\t"
					+ticket.get("START_LOC")+"\t"
					+ticket.get("END_LOC")+"\t"
					+ticket.get("KM")+"\t");
		}
		System.out.println("=================================================================================");
		return View.KTX_USER;
	}
	
	
	
	public int trainBuy() //티켓 구매
	{
		
		
		Map<String, Object> param=new HashMap<>();
		//param.put("TRAIN_NO",train_no);
		
		int result = trainDao.insertTrainList(param);
		
		if (result>0) System.out.println("구매 성공하였습니다.");
		else System.out.println("구매 실패하였습니다.");
		
		return View.KTX_TRAIN;
		
	}
}
