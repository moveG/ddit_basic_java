package study.study1;


public class VariableInit {
	/*
	 * 1. 명시적 초기화
	 * - 변수 선언과 동시에 명시적 초기화
	 */
	int var = 10;
	static int classVar = 20;
	
	/*
	 * 2. 초기화 블럭
	 * - 초기화를 하기 위한 블럭 공간
	 * - 여러 줄의 코드로 초기화를 할 수 있다.
	 */
	//인스턴스 변수를 초기화하기 위한 블럭
	{
		var = 30; //var변수를 30으로 초기화
	}
	//클래스 변수를 초기화하기 위한 블럭
	static{
		classVar = 40;
	}
	
	/*
	 * 3. 생성자
	 * - 클래스와 같은 이름의 메서드
	 * - 인스턴스 변수를 초기화하기 위해 사용된다.
	 * - 클래스에 생성자는 반드시 하나 이상 존재해야 한다.
	 * - 직접 선언해주지 않으면 컴파일러가 기본 생성자를 만들어준다.
	 * - 생성자는 리턴타입이 없다.
	 * - 리턴타입이 없는 것과 void는 다르다.
	 */
	VariableInit(){
		var = 50;
		//컴파일러가 만들어주는 기본 생성자
		//파라미터도 없고, 아무 내용도 없다.
		//인스턴스 변수를 초기화
		//굳이 생성자를 이용해서 초기화를 하는 이유
		//초기화에 파라미터가 필요할 때(초기화하는 값을 외부에서 받아 사용(파라미터 이용))
	}
	
	public static void main(String[] args) {
		Init i1 = new Init();
		i1.a = 10;
		i1.b = 20;
		i1.c = 30;
		
		Init i2 = new Init();
		i2.a = 40;
		i2.b = 50;
		i2.c = 60;
		
		Init i3 = new Init(70, 80, 90);
		
//		SampleParent sp = new SampleParent();
		SampleChild sc = new SampleChild();
//		int result = sc.method(1, 2000, 3);
//		System.out.println(result);
//		int result1 = sp.a;
//		int result2 = sc.a;
//		System.out.println(result1);
//		System.out.println(result2);
		
//		System.out.println("asdfasdf!");
//		sc.test();
//		sc.test(1.0);
//		System.out.println();
		
	}
	
}

class Init {
	//전역변수
	int a;
	int b;
	int c;
	
	Init(int a, int b, int c) {
		//지역변수
		a = 1;
		b = 2;
		c = 3;
		
		//전역변수
		this.a = a;
		this.b = b;
		this.c = c;
		//this: 인스턴스 변수와 지역 변수의 이름이 같을 때, 둘을 구분하기 위해 사용한다.
		//지역 변수와 전역 변수의 이름이 같을 때, 지역변수를 우선적으로 사용한다.
		//this.을 붙이면 전역 변수이고, this.을 붙이지 않으면 지역 변수이다.
		//this: 자기 객체를 가르키는 변수
	}
	
	//오버로딩: 같은 이름의 메서드를 여러개 정의하는것
	Init(){
		//파라미터가 하나도 없는 생성자
		//생성자도 메서드이고, 같은 이름을 가진 메서드가 존재하므로 메서드는 같은 이름을 가질 수 있다.
		//이름으로는 메서드를 구분할 수 없으므로 파라미터의 차이로 메서드를 구분한다.
		//파라미터의 개수 혹은 타입이 달라야 오버로딩을 할 수 있다.
		
//		a = 10;
//		b = 20;
//		c = 30;
		//생성자가 여럿일 때는 이런 식의 초기화는 권장되지 않는다.
		//이 생성자에서 저 생성자를 호출하는 방식으로 초기화하는 것을 권장한다.
		
		this(10, 20, 30);
		//this() : 생성자 안에서 다른 생성자를 호출할 때 사용한다, 생선자 안에서 가장 윗줄에 있어야 오류가 발생하지 않는다.
		//this. : 인스턴스 변수와 지역 변수의 구분을 위해 사용한다.
	}
}
