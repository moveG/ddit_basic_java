package g_oop2;

public interface SampleInterface {
	/*
	 * 인터페이스는 멤버로 상수와 추상메서드만 받을 수 있음
	 * 부모의 역할만 하려고 만들어짐
	 * 클래스와는 달리 인터페이스는 다중상속이 가능함
	 * 상속받을 클래스의 틀을 잡아주는 역할로 주로 쓰임
	 * 관계가 없는 클래스끼리 관계를 만들어주는 역할도 수행
	 */ 
	 
	//인터페이스의 모든 멤버변수는 "public static final" 제어자를 사용해야 한다.
	public static final int NUM1 = 1;
	
	//모든 멤버변수의 제어자가 같기 때문에 생략이 가능하다.
	int NUM2 = 2;
	
	//인터페이스의 모든 메서드는 "public abstract" 제어자를 사용해야 한다.
	public abstract void method1();
	
	//모든 메서드의 제어자가 같기 때문에 생략이 가능하다.
	void method2();
	
}

interface SampleInterface2 {
	void method1();
	void method3();
}

//오버라이딩 하지 않으면 컴파일 에러 발생
class SampleImplement implements SampleInterface, SampleInterface2 {

	@Override
	public void method1() {
		//SampleInterface와 SampleInterface2를 동시에 오버라이드 해줌
		//내용이 있으면 구분이 필요하지만, 내용이 없으므로 구분없이 하나로 오버라이드 해줌
		
	}

	@Override
	public void method2() {
		
		
	}

	@Override
	public void method3() {
		
		
	}	
}
