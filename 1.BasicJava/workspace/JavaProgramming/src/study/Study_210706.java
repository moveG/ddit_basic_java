package study;

import java.util.Scanner;
//import: 다른 패키지에 있는 클래스의 위치를 알려주는 것, package와 class 사이에 위치.
//import 단축키: Ctrl + Shift + O(알파벳)
public class Study_210706 {

	public static void main(String[] args) {
		System.out.println("Hello, world");
		//주석: Ctrl + Shift + C
		//범위주석: Ctrl + Shift + / (해제: \)
		/*asdf
		adsf
		asdf*/
		
		//변수선언
		byte a;
		short b;
		int c;
		long d;
		float e;
		double f;
		char g;
		boolean h;
		String i;
		
		int j = (int)20.5;
		float k = 1.1f;
		float l = (float)1.1;
		
		//출력
		System.out.println(j);
		System.out.print(k);
		System.out.printf("출력 포멧 지정");
		System.out.println();
		
		//탈출문자(Escape문자): \n, \t, \", \\
		System.out.println("줄바꿈 \n해봅시다.");
		System.out.println("\"쌍따옴표 해봅시다.\"");
		System.out.println("\\역슬래시 해봅시다.");
		System.out.println("tab \t해봅시다.");
		
		//입력1
		Scanner m = new Scanner(System.in);
		System.out.print("문자, 입력해봅시다.> ");
		String n = m.nextLine();
		System.out.println("문자, 출력해봅시다.> " + n);
		
		//입력2 - 에러 (nextInt 사용하지 맙시다.)
//		System.out.print("숫자, 입력해봅시다.> ");
//		int o = m.nextInt();
//		System.out.println("숫자, 출력해봅시다.> " + o);
//		
//		System.out.print("문자출력, 에러예정.> ");
//		String p = m.nextLine();
//		System.out.println("문자출력, 에러예정." + p);
//		System.out.println("<입력 끝, nextInt 사용하지 맙시다.>");
		
		//입력3 - nextInt 대신.
		System.out.print("숫자, 제대로 입력해봅시다.> ");
		int q = Integer.parseInt(m.nextLine());
		System.out.println("숫자, 제대로 출력해봅시다.> " + q);
		//double 변수 = Double.parseDouble(m.nextLine());
		//float 변수 = Float.parseFloat(m.nextLine());
		
		//종합과제
		/*다음과 같은 프로그램을 작성해주세요.
		*
		* ======= 회원가입 =======
		* 아이디> admin
		* 비밀번호(4자리 숫자)> 1234
		* 이름> 홍길동
		* 나이> 30
		* 키> 185.5
		* ====================== 
		* 회원가입 완료!!
		* ======== 내 정보 ========
		* 아이디: admin
		* 비밀번호: 1234
		* 이름: 홍길동
		* 나이: 30세
		* 키: 185.5cm
		* ======================
		*/
//		Scanner m = new Scanner(System.in);
//		변수명: 아이디 id, 비밀번호 pw, 이름 name, 나이 age, 키  height
//		변수타입: 아이디 String, 비밀번호 int, 이름 String, 나이 int, 키 double
//		입력창은 같은 라인 System.out.print
		
		
		System.out.println("======= 회원가입 =======");
		//입력
		System.out.print("아이디> ");
		String id = m.nextLine();
		System.out.print("비밀번호(4자리)>");
		int pw = Integer.parseInt(m.nextLine());
		System.out.print("이름> ");
		String name = m.nextLine();
		System.out.print("나이> ");
		int age = Integer.parseInt(m.nextLine());
		System.out.print("키> ");
		double height = Double.parseDouble(m.nextLine());
		
		System.out.println("======================");
		System.out.println("회원가입 완료!!");
		System.out.println("======== 내 정보 ========");
		//출력
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
		System.out.println("이름: " + name);
		System.out.println("나이: " + age + "세");
		System.out.println("키: " + height + "cm");
		
		System.out.println("======================");		
	}
	
}