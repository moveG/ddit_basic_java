package a_variable; //패키지: 클래스의 위치.

import java.util.Scanner;

//import: 다른 패키지에 있는 클래스의 위치를 알려주는 것, 패키지와 클래스 사이에 위치해야 한다.
//import 단축키: Ctrl + Shift + O(알파벳)

public class Variable { //클래스: 데이터와 기능의 집합.

	public static void main(String[] args) {
		//메서드: 명령문의 집합, 명령문은 메서드 안에 작성해야 함, 메서드 이름 뒤에 ()가 붙는다.
		//main메서드: 프로그램의 시작과 끝.
		
		//주석: 프로그램 코드로 인식되지 않는 문장(주로 코드를 설명하는데 사용).
		//한줄 주석: Ctrl + Shift + C
		//여러줄 주석: 블록 지정 + Ctrl + Shift + C
		//여러줄 주석
		//여러줄 주석
		//여러줄 주석
		//범위 주석: Ctrl + Shift + /(해제:\)
		/*범위주석
		범위주석
		범위주석*/
		
		/*
		 * 데이터
		 * 
		 * 1. 기본형
		 * - 숫자
		 * - 문자
		 * - 논리
		 * 
		 * 2. 참조형(데이터가 위치한 주소를 저장)
		 * - 배열(형태가 같은 여러개의 데이터를 묶어서 사용)
		 * - 클래스(형태가 다른 여러개의 데이터와 기능을 묶어서 사용)
		 */
		
		/*
		 * 기본형 타입 (* - 자주 사용)
		 * - 정수: byte(1byte), short(2), *int(4 - 약20억), long(8 - 약900경)
		 * - 실수: float(4 - 7자리(정확히 표현할 수 있는 소수점 아래 자리수)), *double(8 - 15자리)
		 * - 문자: char(2 - 1글자)
		 * - 논리: boolean(1 - true or false)
		 * 
		 * 참조형 타입
		 * - 문자열: String(4 - 여러글자) //String타입은 class이다.
		 * 
		 * 명명규칙
		 * - 영문자 대소문자, 한글(사용빈도 낮음), 숫자, 특수문자('_', '$')를 사용할 수 있다.
		 * - 숫자로 시작할 수 없다.
		 * - 예약어(Java에서 이미 어떤 기능으로 사용하고 있는 단어)는 사용할 수 없다.
		 * - [낙타식 표기법(맨 앞글자는 소문자, 중간에 구분을 위해 대문자를 사용)을 사용한다.(mySampleVariable)]
		 * - [클래스명의 첫글자는 대문자로 한다.(MySampleClass)]
		 */
		
		//변수 선언(값을 저장할 공간을 만드는 것)
		int x; //;(세미콜론): 문장의 마침표
		long y;
		float z;
		char abc;
		boolean boolean$;
		String name123;
		//{}중괄호 안에서는 변수명이 중복되어서는 안된다.
		
		//9가지 타입을 모두 사용해 9개의 변수를 선언해주시오.(문제)
		byte a; 
		short b;
		int c;
		long d;
		float e;
		double f;
		char g;
		boolean h;
		String i;
		
		//초기화(변수에 값을 처음으로 저장하는 것)
		//=(대입연산자): 오른쪽의 값을 왼쪽의 변수에 저장한다.
		//변수를 선언한 이후에는 변수의 이름을 가지고 변수를 사용한다.
		x = 10; //타입에 맞는 값을 저장해야 한다.
		y = 20L; //접미사 L을 붙여야 long타입이 된다.
		z = 3.14f; //접미사 f를 붙여야 float타입이 된다.
		abc = '가'; //따옴표 안에 반드시 '한'글자만 넣어야 한다.
		boolean$ = true; // true or false.
		name123 = "가나다라 abcd 1234"; //쌍따옴표로 문자열을 표현한다.
		
		//위에서 선언한 9개의 변수들을 초기화 해주세요.(문제)
		a = 1;
		b = 2;
		c = 1000000000;
		d = 4;
		e = 1.1234567f;
		f = 1.123456789012345;
		g = '한';
		h = false;
		i = "Hello, world!";
		
		int j = 10; //한 문장에서 변수의 선언과 초기화를 한번에 할 수 있다.
		j=20; //변수에 저장한 값을 바꾸고 싶으면, 다른 값을 대입주면 된다.
		
		//형변환(데이터의 타입을 다른 타입으로 변경하는 것)
		int _int = 10;
		long _long = 20L;
		
		_int = (int)_long;
		_long = _int; //표현범위(!=byte)가 작은 타입에서 큰 타입으로의 형변환은 생락할 수 있다. (표현범위: long > int)
		
		_int = _int + (int)_long; //서로 다른 타입은 연산할 수 없다, 형변환을 통해 타입을 맞춰야 연산할 수 있다.
		
		//변수 3개를 선언해 변수의 타입과 다른 타입의 값으로 초기화해 주세요.(문제)
		int k = (int)1.0;
		float l = (float)1.1;
		char m = (char)_int;
		//기본형 타입(boolean타입을 제외한 7개 타입)끼리만 형변환이 가능하다.
		
		//출력(콘솔)		
		System.out.println("출력"); //출력을 위한 메서드
		System.out.println(x);
		//실행 단축키: Ctrl + F11
		//출력 전에는 항상 저장(Ctrl + S)을 먼저한다.
		System.out.print("출력 후 줄바꿈을 안함.");
		System.out.print("진짜 줄바꿈을 안 해줄까?");
		System.out.println("진짜 안해주네...");
		System.out.printf("출력 포멧 지정");
		System.out.println("");
		
		//탈출 문자(Escape문자)
		System.out.println("탭은\t4칸에 맞춰 띄워줍니다.");
		System.out.println("줄바꿈을\n해줍니다.");
		System.out.println("\"쌍따옴표를 넣어줍니다.\"");
		System.out.println("\\역슬래시를 넣어줍니다.");
		
		//입력
		Scanner sc = new Scanner(System.in); //입력받기 위한 클래스
//		System.out.println("아무거나 입력해주세요>");
//		String str = sc.nextLine(); //nextLine: 입력을 위한 메서드		
//		System.out.println("입력받은 내용: " + str);
		
//		System.out.println("숫자를 입력해주세요>");
//		int nextInt = sc.nextInt();
//		System.out.println("입력받은 숫자: " + nextInt);
		
//		System.out.println("문자열 다시 입력>");
//		String nextLine = sc.nextLine();
//		System.out.println("입력받은 문자열: " + nextLine);
//		System.out.println("입력 끝!!");
		
		//왠만하면 숫자는 nextInt를 사용하지 않는 것이 좋다.
		
		System.out.println("숫자 입력>");
		int number = Integer.parseInt(sc.nextLine()); //Integer.parseInt 메서드: 문자열을 int타입으로 바꿀 수 있다.
		System.out.println("입력받은 숫자: " + number);
//		double dd= Double.parseDouble(sc.nextLine()); //Double.parseDouble 메서드: 문자열을 double타입으로 바꿀 수 있다.
		
		//자신의 이름을 저장할 변수를 선언하고 Scanner를 사용해 이름을 저장해 주세요.(문제)
		System.out.println("이름을 입력해주세요>");
		String myName = sc.nextLine();
		System.out.println("입력받은 이름: " + myName);
		
		//자신의 나이를 저장할 변수를 선언하고 Scanner를 사용해 나이를 저장해주세요.(문제)
		System.out.println("나이를 입력해주세요>");
		int myAge = Integer.parseInt(sc.nextLine());
		System.out.println("입력받은 나이: " + myAge);
		
		//이름과 나이를 출력해주세요.(문제)
		System.out.println("이름과 나이를 출력해주세요: " + myName + ", " + myAge);
 	}
	
}
