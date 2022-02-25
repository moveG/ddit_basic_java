package e_oop;

import e_oop.ScanUtil;

public class Static {
	/*
	 * - static을 붙이면 프로그램 실행시 메모리에 올라간다.
	 * - 객체 생성을 하지 않아도 사용할 수 있다.
	 * - static을 붙인 변수는 객체 간에 변수 값을 공유한다.
	 * - static이 붙은 멤버의 명칭: 클래스 변수, 클래스 메서드
	 * - static이 붙지 않은 멤버의 명칭: 인스턴스 변수, 인스턴스 메서드
	 */
	
	//값을 공유하기 위해 static을 붙인다.
	static int var;
	
	//카드 클래스에서 카드 숫자나 무늬는 인스턴스 변수, 인스턴스 메서드로 만들고, 카드의 가로세로 길이는 static을 붙여 클래스 변수, 클래스 메서드로 만든다.
	//전역변수: 인스턴스 변수 + static변수
	//지역변수: 메서드 안의 변수
	//지역변수에는 static을 붙일 수 없다.
	//지역변수는 메서드 밖에서 사용할 수 없다.
	
	public static void main(String[] args) {
		Saram s1 = new Saram();
		Saram s2 = new Saram();
		
		s1.name = "철수";
		s2.name = "영희";
		
		s1.saveMoney(1);
		s2.saveMoney(33300);
		
		s1.saveDateMoney(1342400);
		s2.saveDateMoney(1);
		
		Saram.dateAccount = 0; //dateAccount 초기화, 클래스 변수는 앞에 '클래스명.'을 붙여 접근한다.
		
		//특정 메서드가 너무 자주 사용되어 객체선언하기 귀찮을 때, static을 붙여 클래스 메서드로 만들어준다.
		//System.out.println(); - System 클래스
		//Math.random(); - Math 클래스 
		
		System.out.println("문자열 입력>");
		String str = ScanUtil.nextLine();
		System.out.println(str);
		
		System.out.println("정수 입력>");
		int num1 = ScanUtil.nextInt();
		System.out.println(num1);
		
		System.out.println("실수 입력>");
		double num2 = ScanUtil.nextDouble();
		System.out.println(num2);
		
	}

}

class Saram {
	String name;
	int account; //계좌 잔고
	
	void saveMoney(int money) {
		account += money;
		System.out.println(name + "의 계좌 잔고: " + account);
	}
	
	static int dateAccount;
	
	void saveDateMoney(int money) {
		dateAccount += money;
		System.out.println("데이트 계좌 잔고: " + dateAccount);
		
	}
	
}