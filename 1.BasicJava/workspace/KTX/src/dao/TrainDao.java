package dao;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class TrainDao {
	//싱글톤 패턴, 객체가 굳이 여러개일 필요가 없을때 싱글톤 패턴을 사용함
	private TrainDao(){}
	private static TrainDao instance;
	public static TrainDao getInstance(){
		if(instance == null){
			instance = new TrainDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String,Object>> selectTrainList() //열차 미리보기용 전체 조회.
	{
		String sql="SELECT * FROM TB_KTX_TRAIN ORDER BY 1 DESC";
		return jdbc.selectList(sql);
	}
	
	public List<Map<String,Object>> selectBasketList() //장바구니 미리보기용 전체 조회.
	{
		String sql="SELECT * FROM TB_KTX_BASKET ORDER BY 1 DESC";
		return jdbc.selectList(sql);
	}
	
//	public List<Map<String,Object>> selectall()
//	{
//		String sql="SELECT A.BOARD_NO, A.TITLE, B.USER_NAME, A.REG_DATE, A.CONTENT"
//				+" FROM TB_KTX_BOARD A"
//				+" LEFT OUTER JOIN TB_JDBC_USER B"
//				+" ON A.USER_ID=B.USER_ID"
//				+" ORDER BY A.BOARD_NO DESC";
//		return jdbc.selectList(sql); //전체
//	}
	
	public int insertTrainList(Map<String,Object> param) // 열차 목록에 열차 추가
	{
		int num=1;
		List<Map<String, Object>> many;
		String check="SELECT COUNT(*) FROM TB_KTX_TRAIN";
		if (Integer.parseInt(jdbc.selectOne(check).get("COUNT(*)").toString())!=0)
		{
			many = jdbc.selectList("SELECT * FROM TB_KTX_TRAIN ORDER BY 1 DESC");
			for (int i=0;i<many.size();i++)
			{
				if (num<Integer.parseInt(many.get(i).get("TRAIN_NO").toString()))
				{
					num=Integer.parseInt(many.get(i).get("TRAIN_NO").toString());
				}
			}
			num+=1;
		}
		String sql= "INSERT INTO TB_KTX_TRAIN VALUES ("+num+",'"+param.get("START_LOC")+"','"+param.get("END_LOC")+"', SYSDATE ,'"+param.get("KM")+"','"+param.get("COST")+"')";
		return jdbc.update(sql);
	}
	
	public int updateTrainList(Map<String,Object> param,int sel) // 열차 수정
	{
		List<Map<String, Object>> many;
		String sql="UPDATE TB_KTX_TRAIN SET START_LOC='"+param.get("START_LOC")+"',END_LOC='"+param.get("END_LOC")+"',KM='"+param.get("KM")+"',COST='"+param.get("COST")+"' WHERE TRAIN_NO="+sel;
		System.out.println(sql);
		return jdbc.update(sql);
	}
	
	public int deleteTrainList(int sel) // 열차 삭제
	{
		String sql="DELETE FROM TB_KTX_TRAIN WHERE TRAIN_NO="+sel;
		return jdbc.update(sql);
	}
	
	public int insertBasketList(int sel) // 장바구니 추가
	{
		int num=1;
		List<Map<String, Object>> many;
		String check="SELECT COUNT(*) FROM TB_KTX_BASKET";
		if (Integer.parseInt(jdbc.selectOne(check).get("COUNT(*)").toString())!=0)
		{
			many = jdbc.selectList("SELECT * FROM TB_KTX_BASKET ORDER BY 1 DESC");
			for (int i=0;i<many.size();i++)
			{
				if (num<Integer.parseInt(many.get(i).get("BASKET_NO").toString()))
				{
					num=Integer.parseInt(many.get(i).get("BASKET_NO").toString());
				}
			}
			num+=1;
		}
		String sql= "INSERT INTO TB_KTX_BASKET VALUES ("+num+",'"+Controller.LoginUser.get("USER_ID")+"','"+sel+"')";
		return jdbc.update(sql);
	}
	
	public int deleteBasketList(int sel) //장바구니 한개 삭제
	{
		String sql="DELETE FROM TB_KTX_BASKET WHERE BASKET_NO="+sel;
		return jdbc.update(sql);
	}
	
	public int deleteBasketAll() //장바구니 모두 비우기
	{
		String sql="TRUNCATE TABLE TB_KTX_BASKET";
		return jdbc.update(sql);
	}
	
	public int insertTicket(int train_no) //구매
	{
		String sql="INSERT INTO TB_KTX_TICKET VALUES('"+Controller.LoginUser.get("USER_ID")+"',(TO_CHAR(SYSDATE,'YYYYMMDD')||'00'),'"+train_no+"')";
		return jdbc.update(sql);
	}
	
	public List<Map<String, Object>> TicketList()
	{
		String sql="SELECT A.TRAIN_NO, B.START_LOC, B.END_LOC, B.KM FROM TB_KTX_TICKET A, TB_KTX_TRAIN B WHERE A.USER_ID='"+Controller.LoginUser.get("USER_ID")+"' AND A.TRAIN_NO=B.TRAIN_NO";
		return jdbc.selectList(sql);
	}
}
