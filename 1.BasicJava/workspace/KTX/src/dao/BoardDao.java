package dao;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class BoardDao {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private BoardDao(){}
	private static BoardDao instance;
	public static BoardDao getInstance(){
		if(instance == null){
			instance = new BoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String,Object>> selectBoardList() //게시판 미리보기용 전체 조회.
	{
		String sql="SELECT A.BOARD_NO, A.TITLE, B.USER_NAME, A.REG_DATE"
				+" FROM TB_KTX_BOARD A"
				+" LEFT OUTER JOIN TB_KTX_USER B"
				+" ON A.USER_ID=B.USER_ID"
				+" ORDER BY A.BOARD_NO DESC";
		return jdbc.selectList(sql);
	}
	
	public List<Map<String,Object>> selectall()
	{
		String sql="SELECT A.BOARD_NO, A.TITLE, B.USER_NAME, A.REG_DATE, A.CONTENT"
				+" FROM TB_KTX_BOARD A"
				+" LEFT OUTER JOIN TB_JDBC_USER B"
				+" ON A.USER_ID=B.USER_ID"
				+" ORDER BY A.BOARD_NO DESC";
		return jdbc.selectList(sql); //전체
	}
	
	public int insertBoardList(Map<String,Object> param) //테이블에 새로 추가.
	{
		//등록할때만 BOARD_NO 을 점검하면 된다. 삭제하든(무시하고 삭제) 수정하든(있는거 그대로 사용) 신경쓸 필요가 없다.
		//이 함수안에서 등록이 완료되기 때문에, num을 반환해줄 필요도 없다.
		int num=1;
		List<Map<String, Object>> many;
		String check="SELECT COUNT(*) FROM TB_KTX_BOARD";
		if (Integer.parseInt(jdbc.selectOne(check).get("COUNT(*)").toString())!=0)
		{
			many = jdbc.selectList("SELECT * FROM TB_KTX_BOARD ORDER BY 1 DESC");
			for (int i=0;i<many.size();i++)
			{
				if (num<Integer.parseInt(many.get(i).get("BOARD_NO").toString()))
				{
					num=Integer.parseInt(many.get(i).get("BOARD_NO").toString());
				}
			}
			num+=1;
		}
		String sql= "INSERT INTO TB_KTX_BOARD VALUES ("+num+",'"+param.get("TITLE")+"','"+param.get("CONTENT")+"','"+Controller.LoginUser.get("USER_ID")+"',"+"SYSDATE)";
		return jdbc.update(sql);
	}
	
	public int updateBoardList(Map<String,Object> param,int sel) //테이블 행 수정
	{
		List<Map<String, Object>> many;
		String sql="UPDATE TB_KTX_BOARD SET TITLE='"+param.get("TITLE")+"',CONTENT='"+param.get("CONTENT")+"',USER_ID='"+Controller.LoginUser.get("USER_ID")+"',REG_DATE=SYSDATE WHERE BOARD_NO="+sel;
		return jdbc.update(sql);
	}
	
	public int updateBoardList(Map<String,Object> param) //테이블 행 수정
	{
		String sql="UPDATE TB_KTX_USER SET USER_ID='"+param.get("USER_ID")+"',USER_NAME='"+param.get("USER_NAME")+"' WHERE USER_ID="+Controller.LoginUser.get("USER_ID");
		return jdbc.update(sql);
	}
	
	public int deleteBoardList(int sel)
	{
		String sql="DELETE FROM TB_KTX_BOARD WHERE BOARD_NO="+sel;
		return jdbc.update(sql);
	}
	
//	public int checkIndex()
//	{
//		int num=-1;
//		String check="SELECT COUNT(*) FROM TB_JDBC_BOARD";
//		List<Map<String, Object>> many;
//		if (Integer.parseInt(jdbc.selectOne(check).get("COUNT(*)").toString())==0) num=1;
//		else
//		{
//			many = jdbc.selectList("SELECT * FROM TB_JDBC_BOARD ORDER BY 1 DESC");
//			num=1;
//			for (int i=0;i<many.size();i++)
//			{
//				if (num<Integer.parseInt(many.get(i).get("BOARD_NO").toString()))
//				{
//					num=Integer.parseInt(many.get(i).get("BOARD_NO").toString());
//				}
//			}
//			num+=1;
//		}
//		return num;
//	}
}
