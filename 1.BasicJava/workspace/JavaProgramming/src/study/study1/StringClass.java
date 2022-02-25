package study.study1;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
		/*
		 * String
		 * - 여러개의 문자를 사용하기 쉽게 만들어놓은 클래스
		 * 
		 * String의 주요 메서드
		 * - equals() : 문자열의 내용이 같은지 반환한다.
		 * - length() : 문자열의 길이를 반환한다.
		 * - charAt() : 특정 인덱스에 위치한 문자를 반환한다.(String(문자열)이 아닌, char(문자)를 반환함)
		 * - substring() : 문자열의 특정 부분을 잘라서 반환한다.
		 * - indexOf() : 문자열 내의 특정 문자의 인덱스를 반환한다.
		 * - contains() : 문자열이 특정 문자열을 포함하고 있는지 여부를 반환한다.(포함하고 있으면 true, 포함하고 있지 않으면 false를 반환함)
		 * - split() : 문자열을 특정 문자를 기준으로 나누어 배열 형태로 반환한다.
		 * - trim() : 문자열 앞뒤의 공백을 제거해 반환한다, 문자열 사이의 공백은 제거하지 못한다.
		 * - valueOf() : 다른 타입의 데이터를 문자열로 변환해 반환한다.
		 */
		boolean equals = "문자열".equals("문자열");
		System.out.println(equals);
		
		String str1 = "문자열";
		String str2 = null;
		System.out.println(str1.equals(str2));
		//문자열은 null과 비교할 수 있다.
//		System.out.println(str2.equals(str1));
		//null은 문자열과 비교할 수 없다.
		//null 값을 가진 String타입 변수는 equals()메서드를 소환할 수 없다.
		
		String str = "12345";
		int length = str.length();
		//length()는 for문에 자주 이용된다.
		//length()는 길이를 int타입으로 반환한다.
		for(int i = 0; i < str.length(); i++){
			char charAt = str.charAt(i);
			System.out.print(charAt);
			//for문이 돌면서 charAt()을 통해 1, 2, 3, 4, 5를 차례로 반환한다.
		}
		//문자열 뒤집기
		String rev = "";
		for(int i = length - 1; 0 <= i; i--){
			rev += str.charAt(i);
		}
		System.out.println();
		System.out.println(rev);
		
		str = "0123456789";
		String sub1 = str.substring(3);
		System.out.println(sub1);//substring()은 String타입을 반환한다.
		String sub2 = str.substring(5, 8);
		System.out.println(sub2);//5번 인덱스~8번 이전 인덱스(7번 인덱스)까지 잘라서 반환한다.
		
		str = "수박 오렌지 귤 블루베리";
		int index = str.indexOf("오렌지");//indexOf()는 인덱스 값을 int타입으로 반환한다.
		System.out.println(index);//substring과 indexOf를 함께 사용하는 경우가 많다.
		//substring과 indexOf를 조합해서 문자열 자르기
		String[] menu = {"수박 20000원",
						 "오렌지 100000원",
						 "귤 500원",
						 "블루베리 3000원"};
		for(int i = 0; i < menu.length; i++){
			String name = menu[i].substring(0, menu[i].indexOf(" "));
			System.out.println(name);
//			int price = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ") + 1, menu[i].indexOf("원")));
			int price = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ") + 1, menu[i].length() - 1));
			System.out.println(price);
		}
		
		str = "abcd";
		boolean contains = str.contains("c");
		System.out.println(contains);
		//contains()는 문자열이 특정 문자열을 포함하고 있는지 여부를 반환한다.
		//포함하고 있으면 true, 포함하고 있지 않으면 false를 반환한다.
		for(int i = 0; i < menu.length; i++){
			if(menu[i].contains("오렌지")){
				System.out.println("오렌지는 " + i + "번 인덱스에 있습니다.");
			}
		}
		
		str = "a/b/c";
		String[] split = str.split("/");
		System.out.println(Arrays.toString(split));
		for(int i = 0; i < menu.length; i++){
			String[] s = menu[i].split(" ");
			System.out.println("이름: " + s[0] + ", 가격: " + s[1]);
		}
		//split(): 문자열을 특정 문자를 기준으로 나누어 배열 형태로 반환한다.
		
		str = " 문 자 열 ";
		String trim = str.trim();
		System.out.println("[" + str + "] -> [" + trim + "]");
		//문자열 앞과 뒤의 공백을 제거해 반환한다.
		//문자열 사이의 공백은 제거하지 못한다.
		//사용자의 입력 실수를 방지하는데 사용된다.
		String id = " myid ";
		String pw = " mypw ";
		System.out.println("[" + id + "] -> [" + id.trim() + "]");
		System.out.println("[" + pw + "] -> [" + pw.trim() + "]");
		
		int num = 10;
		str = num + "";//빈 문자열을 더해 문자열로 변환한다.
		str = String.valueOf(num);
		System.out.println(num);
	}

}
