package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Map: 인덱스가 아닌 키에 값을 저장함, 값을 저장할 키는 직접 설정함, 보통 키와 값을 같이 저장함, 순서가 없음, 자주 사용됨
		 * 
		 * Object put(Object key, Object value): 지정된 키와 값을 저장한다.
		 * Object remove(Object key): 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key): 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet(): 저장된 모든 키를 Set으로 반환한다. 
		 */
		
		HashMap<String, Object> map = new HashMap<>();
		//키는 String타입을 주로 사용함
		//ArrayList와는 달리 값을 확실하게 타입을 지정하지 않고 아무거나 저장함
		
		map.put("age", 10);
		map.put("name", "홍길동");
		map.put("date", new Date()); //date라는 객체, 날짜를 표현하는 객체, 객체도 저장 가능
		System.out.println(map);
		
		map.put("name", "이순신");
		//HashMap은 수정하는 메서드가 없음
		//같은 키 이름으로 덮어써야함
		System.out.println(map);
		
		map.remove("age");
		System.out.println(map);
		
		Object value = map.get("name");
		//Object으로 지정했으므로 Object타입의 변수에 저장해야함
		System.out.println(value);
		
		//String클래스의 모든 메서드를 사용하고 싶으면 String타입으로 형변환해줘야함
		System.out.println(((String)value).charAt(0));
		
		Set<String> keys = map.keySet(); //저장된 모든 키를 Set으로 반환
		//Set타입 변수에 저장
		//위에서 key의 타입을 String으로 지정했으므로 제네릭을 String으로 정해줌(<String>)
		//남이 만든 HashMap이라서 키를 몰르면 값을 꺼내지 못하므로 , 키를 꺼낼 때 사용함
		//set은 값을 꺼낼 수 있는 get같은 메서드가 없음
		//아래와 같은 방법으로 값을 꺼내는 것이 가장 간단한 방법임
		for(String key : keys){
			//지금까지와의 for문과는 작동방식이 다름
			//:을 기준으로 뒤쪽에 값이 여러개 닮겨있는 것이 옴
			//하나씩 꺼내서 하나씩 실행함
			System.out.println(key + " : " + map.get(key));
		}
		
//		Object[] arr = map.values().toArray();
		//HashMap의 값을 배열에 저장하는 방법
		
		//HashMap타입의 배열 또는 ArrayList도 가능함
		
		//주로 테이블 형태를 만들 때 map을 사용함
		//HashMap을 사용해서 테이블의 한 행을 표현할 수 있음
		
		//HashMap을 여러개 만들어서, ArrayList에 담으면 테이블과 동일한 형태가 됨
		//오라클에서 테이블의 컬럼명이 키가 되고, 값이 값이 됨
		
		//회원 테이블, 1명의 회원을 저장
		/*
		 * 아이디		: admin
		 * 비밀번호	: admin123
		 * 이름		: 관리차
		 * 전화번호	: 010-1234-5678
		 */
//		ArrayList<HashMap<String, String>> table = new ArrayList<>();
//		HashMap<String, String> user = new HashMap<>();
//		user.put("id", "admin");
//		user.put("password", "admin123");
//		user.put("name", "관리자");
//		user.put("tel", "010-1234-5678");
//		table.add(user);
//		
//		user = new HashMap<>();
//		user.put("id", "admin2");
//		user.put("password", "admin456");
//		user.put("name", "홍길동");
//		user.put("tel", "010-5678-1234");
//
//		table.add(user);
//		
//		System.out.println(table);
		
		//오라클 LPROD테이블
		System.out.println();
		ArrayList<HashMap<String, String>> lprodTable = new ArrayList<>();
		HashMap<String, String> lprod = new HashMap<>();
		lprod.put("LPROD_ID", "1");
		lprod.put("LPROD_GU", "P101");
		lprod.put("LPROD_NM", "컴퓨터제품");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", "2");
		lprod.put("LPROD_GU", "P102");
		lprod.put("LPROD_NM", "전자제품");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", "3");
		lprod.put("LPROD_GU", "P201");
		lprod.put("LPROD_NM", "여성캐주얼");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", "4");
		lprod.put("LPROD_GU", "P202");
		lprod.put("LPROD_NM", "남성캐주얼");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", "5");
		lprod.put("LPROD_GU", "P301");
		lprod.put("LPROD_NM", "피혁잡화");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", "6");
		lprod.put("LPROD_GU", "P302");
		lprod.put("LPROD_NM", "화장품");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", "7");
		lprod.put("LPROD_GU", "P401");
		lprod.put("LPROD_NM", "음반/CD");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", "8");
		lprod.put("LPROD_GU", "P402");
		lprod.put("LPROD_NM", "도서");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", "9");
		lprod.put("LPROD_GU", "P403");
		lprod.put("LPROD_NM", "문구류");
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", "10");
		lprod.put("LPROD_GU", "p501");
		lprod.put("LPROD_NM", "농산물");
		lprodTable.add(lprod);
		
		System.out.println("LPROD_ID\tLPROD_GU\tLPROD_NM");
		for(int i = 0; i < lprodTable.size(); i++){
			System.out.println(lprodTable.get(i).get("LPROD_ID")
					+ "\t\t" + lprodTable.get(i).get("LPROD_GU")
					+ "\t\t" + lprodTable.get(i).get("LPROD_NM"));
		}
		
//		ArrayList<HashMap<String, String>> lprodTable = new ArrayList<>();
//		HashMap<String, String> lprod = new HashMap<>();
//		Set<String> keys = map.keySet();
		
//		for(int i  = 0; i<lprodTable.size(); i++){
//			Set<String> lpkeys = lprodTable.get(i).keySet(); //저장된 모든 키를 Set으로 반환
//			for(String lpkey : lpkeys){
//				
//			}
//		}
		//Set타입 변수에 저장
		//위에서 key의 타입을 String으로 지정했으므로 제네릭을 String으로 정해줌(<String>)
		//남이 만든 HashMap이라서 키를 몰르면 값을 꺼내지 못하므로, 키를 꺼낼 때 사용함
//		//set은 값을 꺼낼 수 있는 get같은 메서드가 없음
//		//아래와 같은 방법으로 값을 꺼내는 것이 가장 간단한 방법임
//		for(String key : keys){
//			//지금까지와의 for문과는 작동방식이 다름
//			//:을 기준으로 뒤쪽에 값이 여러개 닮겨있는 것이 옴
//			//하나씩 꺼내서 하나씩 실행함
//			System.out.println(key + " : " + map.get(key));
//		}
		
	}
}
