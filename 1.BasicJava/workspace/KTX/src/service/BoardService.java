package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ScanUtil;
import util.View;
import controller.Controller;
import dao.BoardDao;

public class BoardService {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private BoardService(){}
	private static BoardService instance;
	public static BoardService getInstance(){
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}
	
	private BoardDao boardDao= BoardDao.getInstance();
	private static int select;
	
	
	public int boardList()
	{
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		if (UserService.standard==1) // 접근한 사람이 회원이라면
		{
			System.out.println("====================게시판=================(로그인 중인 유저 이름: "+Controller.LoginUser.get("USER_NAME")+")=========");
		}
		else //접근한 사람이 관리자라면
		{
			System.out.println("====================게시판=================(로그인 중인 관리자 아이디: "+Controller.LoginUser.get("ADMIN_ID")+")=========");
		}
		//System.out.println("====================게시판=================(로그인 중인 유저 이름: "+Controller.LoginUser.get("USER_NAME")+")=========");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("-------------------------------------------------------------------------------------");
		//System.out.println(boardList);
		for (Map<String,Object> board: boardList)
		{
			System.out.println(board.get("BOARD_NO")+"\t"
					+board.get("TITLE")+"\t"
					//+board.get("USER_ID")+"\t"
					+board.get("USER_NAME")+"\t"
					+board.get("REG_DATE")+"\t");
		}
		System.out.println("=================================================================================");		
		System.out.println("<1.조회>\t<2.등록>\t<0.뒤로 가기>");
		System.out.println("입력");
		int input=ScanUtil.nextInt();
		
		if (UserService.standard==1) // 접근한 사람이 회원이라면
		{
			switch(input)
			{
			case 1: // 조회
				return View.KTX_BOARD_VIEW;
				//return boardView();
				//boardDao.insertUser(param);
			case 2: // 등록 추가
				return View.KTX_BOARD_INSERT;
				//return boardInsert(); //추가를 하면 보드를 다시 보여줘야 한다.
			case 0: // 메뉴
				System.out.println("홈으로 돌아갑니다.");
				return View.KTX_HOME;
			}
			System.out.println("잘못된 번호입니다.");
			return View.KTX_BOARD;
		}
		else //접근한 사람이 관리자라면
		{
			switch(input)
			{
			case 1: // 조회
				return View.KTX_BOARD_VIEW;
				//return boardView();
				//boardDao.insertUser(param);
			case 2: // 등록 추가
				return View.KTX_BOARD_INSERT;
				//return boardInsert(); //추가를 하면 보드를 다시 보여줘야 한다.
			case 0: // 메뉴
				System.out.println("관리자 화면으로 돌아갑니다.");
				return View.ADMIN_HOME;
			}
			System.out.println("잘못된 번호입니다.");
			return View.KTX_BOARD;
		}
		
//		switch(input)
//		{
//		case 1: // 조회
//			return View.KTX_BOARD_VIEW;
//			//return boardView();
//			//boardDao.insertUser(param);
//		case 2: // 등록 추가
//			return View.KTX_BOARD_INSERT;
//			//return boardInsert(); //추가를 하면 보드를 다시 보여줘야 한다.
//		case 0: // 메뉴
//			System.out.println("홈으로 돌아갑니다.");
//			return View.KTX_HOME;
//		}
//		System.out.println("잘못된 번호입니다.");
//		return View.KTX_BOARD;
	}
	
	
	public int boardView() //조회
	{
		System.out.println("조회할 번호를 입력하세요.");
		int sel=ScanUtil.nextInt();
		select=sel;
		boolean flag=false;
		int index=-1;
		String[] titlenameOri={"번호","제목","작성자","작성일","내용"};
		
		List<Map<String, Object>> many = boardDao.selectall();
		int count=many.size();
		for (int i=0;i<count;i++) //찾기
		{
			if (sel==Integer.parseInt(many.get(i).get("BOARD_NO").toString()))
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
			System.out.println("--------------조회결과-------------");
			System.out.println(titlenameOri[0]+" : "+many.get(index).get("BOARD_NO"));
			System.out.println(titlenameOri[1]+" : "+many.get(index).get("TITLE"));
			System.out.println(titlenameOri[2]+" : "+many.get(index).get("USER_NAME"));
			System.out.println(titlenameOri[3]+" : "+many.get(index).get("REG_DATE"));
			System.out.println(titlenameOri[4]+" : "+many.get(index).get("CONTENT"));
			System.out.println("---------------------------------");
			System.out.println("<1.수정>\t<2.삭제>\t<3.목록>");
			int how=ScanUtil.nextInt();
			
			if (how==1) //수정
			{
				return View.KTX_BOARD_UPDATE;
			}
			else if(how==2) //삭제
			{
				return View.KTX_BOARD_DELETE;
			}
			else if(how==3) //목록
			{
				System.out.println("메뉴로 돌아갑니다.");
				return View.KTX_BOARD;
			}
			else //잘못입력
			{
				System.out.println("잘못된 번호 입력으로 메뉴로 돌아갑니다.");
				return View.KTX_BOARD;
			}
		}
		else
		{
			System.out.println(sel+"번 게시물은 없습니다.");
			return View.KTX_BOARD;
		}
	}
	
	public int boardInsert() //등록
	{
		System.out.println("제목을 입력하세요.");
		String title=ScanUtil.nextLine();
		System.out.println("내용을 입력하세요.");
		String content=ScanUtil.nextLine();
		
		Map<String, Object> param=new HashMap<>();
		param.put("TITLE",title);
		param.put("CONTENT",content);
		
		int result = boardDao.insertBoardList(param);
		
		if (result>0) System.out.println("등록되었습니다.");
		else System.out.println("등록이 실패되었습니다.");
		
		return View.KTX_BOARD;
	}
	
	public int boardUpdate() //수정
	{
		System.out.println("수정할 제목을 입력하시오.");
		String title=ScanUtil.nextLine();
		System.out.println("수정할 내용을 입력하시오.");
		String content=ScanUtil.nextLine();

		Map<String, Object> param=new HashMap<>();
		param.put("TITLE",title);
		param.put("CONTENT",content);
		
		int result = boardDao.updateBoardList(param,select);

		if (result>0) System.out.println("수정되었습니다.");
		else System.out.println("수정이 실패되었습니다.");

		return View.KTX_BOARD;
	}
	
	public int boardDelete()
	{
		System.out.println("삭제되었습니다.");	
		int result = boardDao.deleteBoardList(select);

		if (result>0){
			System.out.println("삭제되었습니다.");
//			
//			boardDao.checkIndex();
//			//삭제한 후 num값 조정
		}
		else System.out.println("삭제가 실패되었습니다.");

		return View.KTX_BOARD;
		
	}
}
