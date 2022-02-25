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
	
//싱글톤 생성자	
	private JDBCUtil jdbc = JDBCUtil.getInstance();

//열차리스트	
	public List<Map<String, Object>> selectTrainList() {
		String sql = "SELECT A.TRAIN_NO"
				+ "        , B.TRAIN_TYPE_NAME"
				+ "        , C.LINE_NAME"
				+ "        , A.FIRST_TIME"
				+ "        , A.DIRECTION"
				+ "        , A.LINE_NO"
				+ "     FROM TRAIN A, TRAIN_TYPE B, LINE_INFO C"
				+ "    WHERE A.TRAIN_TYPE_NO = B.TRAIN_TYPE_NO"
				+ "      AND A.LINE_NO = C.LINE_NO"
				+ "      AND A.AREA_NO = C.AREA_NO"
				+ "    ORDER BY A.TRAIN_NO";
		return jdbc.selectList(sql);
	}
	
//상행
	public Map<String, Object> upRow(int select) {
		String sql = "SELECT AREA_NAME"
				+ "     FROM (SELECT AREA_NAME"
				+ "             FROM LINE_INFO"
				+ "            WHERE LINE_NO = " + select
				+ "            ORDER BY AREA_NO DESC)"
				+ "    WHERE ROWNUM = 1";
        return jdbc.selectOne(sql);
	}
	
//하행
	public Map<String, Object> downRow(int select) {
		String sql = "SELECT AREA_NAME"
				+ "     FROM (SELECT AREA_NAME"
				+ "             FROM LINE_INFO"
				+ "            WHERE LINE_NO = " + select
				+ "            ORDER BY AREA_NO)"
				+ "    WHERE ROWNUM = 1";
		return jdbc.selectOne(sql);
	}
	
//좌석
	public Map<String, Object> allSeat(int trainNo) {
		String sql = "SELECT * "
				+ "     FROM (SELECT DISTINCT TRAIN_NO"
				+ "                , CABIN_NO"
				+ "                , SEAT_CAPA"
				+ "             FROM TRAIN_SEAT"
				+ "            WHERE TRAIN_NO = " + trainNo
				+ "            ORDER BY 1, 2 DESC)"
				+ "    WHERE ROWNUM = 1";
		return jdbc.selectOne(sql);
	}	
	
//VIP좌석	
	public List<Map<String, Object>> vipSeat(int trainNo) {
		String sql = "SELECT * "
				+ "     FROM TRAIN_SEAT"
				+ "    WHERE VIP_ROOM = 'y'"
				+ "      AND TRAIN_NO = " + trainNo;
		return jdbc.selectList(sql);		
	}
	
//열차타입조회
	public List<Map<String, Object>> trainTypeList() {
		String sql = "SELECT A.TIME_NO, A.TRAIN_NO, B.LINE_NAME, B.AREA_NAME, A.DEPT_TIME"
				+ "     FROM TRAIN_SCHEDULE A, LINE_INFO B"
				+ "    WHERE A.LINE_NO = B.LINE_NO"
				+ "      AND A.AREA_NO = B.AREA_NO"
				+ "    ORDER BY 1";
		return jdbc.selectList(sql);
	}
	
//열차타입관리
	public List<Map<String, Object>> selectTrainType() {
		String sql = "SELECT A.TRAIN_TYPE_NO, A.TRAIN_TYPE_NAME, B.NORMAL_PRICE, B.VIP_PRICE"
				+ "     FROM TRAIN_TYPE A, PRICE B"
				+ "    WHERE A.TRAIN_TYPE_NO = B.TRAIN_TYPE_NO"
				+ "    ORDER BY 1";
		return jdbc.selectList(sql);
	}

//열차타입조회
	public Map<String, Object> trainTypeView(int typeNo){
		String sql = "SELECT A.TRAIN_TYPE_NO, A.TRAIN_TYPE_NAME, B.NORMAL_PRICE, B.VIP_PRICE"
				+ "     FROM TRAIN_TYPE A, PRICE B"
				+ "    WHERE A.TRAIN_TYPE_NO = B.TRAIN_TYPE_NO"
				+ "      AND A.TRAIN_TYPE_NO = " + typeNo
				+ "    ORDER BY 1";
		return jdbc.selectOne(sql);
	}
//열차타입수정
	public int updateNormalPrice(int typeNo, int newNPrice) {
		String sql = "UPDATE PRICE"
				+ "      SET NORMAL_PRICE = '" + newNPrice + "'"
				+ "    WHERE TRAIN_TYPE_NO = " + typeNo;
		return jdbc.update(sql);
	}
	public int updateVIPPrice(int typeNo, int newPPrice) {
		String sql = "UPDATE PRICE"
				+ "      SET VIP_PRICE = '" + newPPrice + "'"
				+ "    WHERE TRAIN_TYPE_NO = " + typeNo;
		return jdbc.update(sql);
	}
	
//열차타입삭제
	public int deleteTrainType(int typeNo) {
		String sql = "DELETE PRICE"
				+ "    WHERE TRAIN_TYPE_NO = " + typeNo;
		return jdbc.update(sql);
	}
	
//열차타입등록
	public Map<String, Object> searchTrainType(String type) {
		String sql = "SELECT *"
				+ "     FROM TRAIN_TYPE"
				+ "    WHERE TRAIN_TYPE_NAME = '" + type + "'";
		return jdbc.selectOne(sql);
	}
	public Map<String, Object> searchTrainType2(int insertNo) {
		String sql = "SELECT *"
				+ "     FROM PRICE"
				+ "    WHERE TRAIN_TYPE_NO = " + insertNo;
		return jdbc.selectOne(sql);
	}
	public int insertTrainType(String type) {
		String sql = "INSERT INTO TRAIN_TYPE"
				+ "     VALUES ("
				+ "     (SELECT NVL(MAX(TRAIN_TYPE_NO), 0) + 1 FROM TRAIN_TYPE)"
				+ "     , '" + type + "')";
		return jdbc.update(sql);
	}
	public int insertTrainTypePrice(String type, int nPrice, int vPrice) {
		String sql = "INSERT INTO PRICE"
				+ "     VALUES ("
				+ "     (SELECT TRAIN_TYPE_NO FROM TRAIN_TYPE WHERE TRAIN_TYPE_NAME = '" + type + "')"
				+ "     , '" + nPrice + "'"
				+ "     , '" + vPrice + "')";
		return jdbc.update(sql);
	}
}
