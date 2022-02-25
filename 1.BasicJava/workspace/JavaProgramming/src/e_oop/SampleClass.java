package e_oop;

public class SampleClass {
	//public: 접근제어자
	//class: 클래스 제작 명령어
	//SampleClass: 클래스 이름
	//클래스의 이름 첫글자만 대문자
	//import: 다른 클래스를 사용할 때, 클래스의 위치를 알려주는 것, package와 class의 사이에 위치한다.
	//클래스는 변수와 메서드로 구성된다.
	
	public static void main(String[] args) {
		//메인 메서드
		int local = 10;
		//지역변수: 메서드 안에서만 사용하는 변수
	}
	
	int field;
	//전역변수: 클래스 전체 영역에서 사용하는 변수, 초기화를 하지 않아도 자동으로 기본값으로 초기화가 됨.
	
	/*
	 * - 메서드: 변수를 가지고 할 일
	 * - 선언 방법: 리턴타입 메서드명 (파라미터) {}
	 * - 파라미터(매개변수): 실행에 필요한 정보
	 * - 리턴타입(반환타입): 실행 후 돌려줘야할 결과물
	 * - 메서드명: 임의대로 작성하면 됨
	 */
	
	String method1(int parameter)  {
		return parameter + "을/를 받아 명령을 수행하고 결과물을 리턴하는 메서드";
	}
	
	void method2() {
		System.out.println("파라미터도 리턴타입도 없는 메서드");
	}
	
	void flowTest1() {
		System.out.println("flowTest1 시작 : 1");
		flowTest3();
		System.out.println("flowTest1 종료 : 6");
	}
	
	void flowTest2() {
		System.out.println("flowTest2 시작 : 3");
		System.out.println("flowTest2 종료 : 4");
	}
	
	void flowTest3() {
		System.out.println("flowTest3 시작 : 2");
		flowTest2();
		System.out.println("flowTest3 종료 : 5");
	}
	//호출이 된 이후 다시 호출되었던 장소로 돌아간다.
	
}
