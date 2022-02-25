package g_oop2;

public abstract class SampleAbstractParent {
	/*
	 * 추상클래스와 추상메서드
	 */
	
	void method(){
		
	}
	
	//추상클래스: 추상메서드가 하나라도 있으면 추상클래스, 앞부분에 abstract 제어자를 붙임
	//추상메서드: 선언부만 있고 구현부는 없는 메서드, 앞부분에 abstract 제어자를 붙임
	//부모클래스 역할을 하기 위해 추상클래스와 추상메서드를 사용
	//추상클래스를 상속받은 자식클래스는 오버라이딩을 통해 내용을 만들어줘야함
	abstract void abstractMethod();
	
	
}
//오버라이딩 하지 않으면 컴파일 오류 발생, Ctrl + space + 첫번째 선택을 통해 오버라이딩을 사용하자
class SampleAbstractChild extends SampleAbstractParent {

	@Override
	void abstractMethod() {
		
		
	}
	
}
