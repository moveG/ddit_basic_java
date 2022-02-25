package study.study1;

public class SampleChild extends SampleParent {
//	SampleChild()
//	{
//		super.a = 10;
//		a = 6;
//	}
//	int a = 14;
	
//	오버로딩
//	int method(int a, int b, int c){
//		return a + b + c;
//	}
//	void test(){
//		System.out.println(super.a);
//		System.out.println(a);
//	}

	void childMethod(){
		System.out.println(var);			//상속받은 변수
		System.out.println(method(7,3));	//상속받은 메서드
	}
	//오버라이딩: 상속받은 메서드의 내용을 재정의 하는것, 이름과 파라미터는 동일하게 하고 내용만 바꿈
	@Override
	int method(int a, int b){
		return a * b;
		
	}
	
	
	//질문1: 부모가 자식에게 상속할 때 생성자는 상속 x라 했는데 super()로 부모 생성자를 호출가능?
	// 왜 호출하나?
	//질문2: @Override ctrl + space ? 표시하기 위해 붙이나? 반드시 붙여야 하나?
	// 붙여야 컴파일 오류가 안나나? 안나던데...
	//질문3: 초기화 블럭과 명시적 초기화의 초기화 순서
	
	//super., super()
	int var;
	//부모 클래스의 var, 자식 클래스의 var, 지역변수 var
	void test(double var){
		//super: 부모 클래스의 멤버와 자식 클래스의 멤버가 이름이 중복될 때, 이 둘을 구분하기 위해 사용한다.
		System.out.println(var);		//지역변수
		System.out.println(this.var);	//자식 클래스의 인스턴스 변수
		System.out.println(super.var);	//부모 클래스의 인스턴스 변수
		System.out.println(method(10, 20));			//자식 클래스의 메서드
		System.out.println(super.method(10,  20));	//부모 클래스의 메서드
	}
	
	SampleChild(){
		super();
		//부모 클래스의 생성자 호출
		//부모 클래스에 파라미터가 있으면 반드시 사용해줘야함
		//부모 클래스의 생성자를 반드시 호출해서 부모 클래스의 변수를 초기화시킴
		//super();를 넣지 않으면 컴파일러가 자동으로 삽입한다.
	}
	
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleParent();
		//다형성: 객체와 변수의 타입을 서로 다르게 사용하는 것, 클래스 간의 형변환 가능
		//반드시 변수는 부모타입, 객체는 자식타입이어야 한다.
		sc = (SampleChild)sp;
		//부모타입에서 자식타입으로의 형변환
		//형변환 이후 sc를 사용
		//자식타입의 멤버 5개를 사용하려는데 부모타입은 멤버가 2개라서 사용이 불가능함
		sp = sc;
		//자식타입에서 부모타입으로의 형변환
		//형변환 이후 sp를 사용
		//부모타입의 멤버 2개를 사용하려는데 자식타입은 멤버가 5개라서 사용이 가능함
		//자식타입에서 부모타입으로의 형변환은 생략할 수 있다.
		//유동적으로 작동하는 코드를 작성할 때 주로 사용함.
		SampleChild sc2 = (SampleChild)new SampleParent();
	}
}
