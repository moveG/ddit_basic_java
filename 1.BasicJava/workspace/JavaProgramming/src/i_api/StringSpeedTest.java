package i_api;

public class StringSpeedTest {

	public static void main(String[] args) {
//		String str = "a";
//		long start = System.currentTimeMillis();
//		for(int i = 0; i < 200000; i++){
//			str += "a";
//		}
//		long end = System.currentTimeMillis(); //System.currentTimeMillis() : 현재 시간을 밀리세컨드 단위로 말해줌
//		System.out.println(end - start + "ms");

		StringBuffer sb = new StringBuffer("a");
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 200000; i++){
			sb.append("a"); //StringBuffer타입의 클래스 sb에 append라는 메서드를 이용해서 "a"라는 문자열을 추가함.
		}
		long end = System.currentTimeMillis(); //System.currentTimeMillis() : 현재 시간을 밀리세컨드 단위로 말해줌
		System.out.println(end - start + "ms");
	
		//StringBuffer는 추가할때 객체를 새로 생성한다. 버퍼를 사용하면 효율적인 생성이 가능해진다.
	
	}

}
