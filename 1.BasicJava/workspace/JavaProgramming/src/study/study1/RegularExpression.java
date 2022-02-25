package study.study1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		/*
		 * 정규표현식: 문자열의 패턴을 검사하는 표현식, 회원가입할 때 사용
		 * 
		 * ^    뒷 문자로 종료
		 * $    앞 문자로 종료
		 * .    임의의 문자(줄바꿈 제외)
		 * *    앞 문자가 0개 이상
		 * +    앞문자가 1개 이상
		 * ?    앞 문자가 없거나 1개
		 * []   문자의 집합이나 범위([a-z]: a부터 z까지, [^a-z]: a부터 z가 아닌것)
		 * {}   앞 문자의 개수 ({2}: 2개, {2,4}: 2개 이상 4개 이하)
		 * ()   그룹화(1개의 문자처럼 인식)
		 * |    OR 연산
		 * \s   공백, 탭, 줄바꿈
		 * \S   공백, 탭, 줄바꿈이 아닌 문자
		 * \w   알파벳이나 숫자
		 * \W   알파벳이나 숫자가 아닌 문자
		 * \d   숫자
		 * \D   숫자가 아닌 문자
		 * (?i) 뒷 문자의 대소문자 구분 안함
		 * \    정규표현식에서 사용되는 특수문자 표현
		 */
		//정규표현식도 문자열로 만듦
		//정규표현식은 범위가 좁을수록 원하는 값을 얻을 수 있다.
		//String str = "abc123";				//
		//String regex = "abc123";				//abc123만 통과시킴
		//String regex = "[a-z]{3}[0-9]{1,3}";	//a-z에서 3개, 0-9에서 1개이상 3개이하만 통과
		//String regex = "[a-z0-9]+"			//소문자 a-z 숫자 0-9 1개이상 온다는 뜻
		//String regex = "\\w*"					//알파벳이나 숫자가 0개이상 온다는 뜻
		
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(str);
//		System.out.println(m.matches());
		//String regex = "[a-z]{3}[0-9]{1,3}";
		//"abc123": 문자열과 정규표현식이 일치하므로 true를 반환
		//"abc1234": 문자열과 정규표현식이 일치하지 않으므로 false를 반환
		
		//String regex = "[a-z0-9]+";
		//"abc1234": 문자열과 정규표현식이 일치하므로 true를 반환
		
		//String regex = "\\w*";
		//"abc1234": 문자열과 정규표현식이 일치하므로 true를 반환
				
		//아이디, 전화번호, 이메일 주소의 유효성을 검사하는 정규표현식을 만들어주세요.
		//아이디: [a-z0-9_-]{5,20}
		//전화번호: ^0\\d{1,3}-\\d{3,4}-\\d{4}
		//이메일주소: [a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?!)(com|net|org|([a-z]{2}\\.kr))$
		
		//5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용이 가능합니다.		
		Scanner sc = new Scanner(System.in);
		System.out.println("id를 입력하세요>");
		String id = sc.nextLine();
		String regex = "[a-z0-9-_]{5,20}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(id);
		System.out.println(m.matches());
	}
}
