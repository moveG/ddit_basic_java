package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		/*
		 * 비교연산자 ㅣ
		 * - <, >, <=, >=, ==, !=
		 * =: 대입연산자, ==: 비교연산자
		 * - 문자열 비교 : equals()
		 */
		
		int x = 10;
		int y = 20;
		boolean b = x < y; //비교연산자의 연산결과는 boolean이다.
		System.out.println(b);
		b = x <= y - 15; //산술연산자가 먼저 실행되어 결과값을 얻어, 그 결과값과 비교한다.
		System.out.println(b);
		
		String str1 = "abc";
		String str2 = "ABC"; //String타입은 class이다.
//		String str2 = new String("abc"); //abc를 각기 다른 주소값에 저장하고 싶으면 이 방식을 사용한다.
		b = str1 == str2; //문자열의 내용이 아니라 주소를 비교한 것이다.
		System.out.println(b);
		
		//String의 주소가 아닌 내용을 비교하기 위해서는 equals()메서드를 사용한다.
		b = str1.equals(str2);
		System.out.println(b);
		
		//다음 문장들을 코드로 작성해주세요.(문제)
		//x는 y보다 작거나 같다.
		b = x <= y;
		//x + 5 와 y는 같다.
		b = x + 5 == y;
		//y는 홀수이다.
		b = y % 2 == 1;
		//"기본형"과 "참조형"은 다르다.
		b = !"기본형".equals("참조형");
	}
	
}