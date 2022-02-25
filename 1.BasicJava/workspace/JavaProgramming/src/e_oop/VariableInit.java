package e_oop;

public class VariableInit {
	//1. 명시적 초기화
	int var = 10;
	static int classVar = 20;
	//변수 선언과 동시에 명시적 초기화
	
	/*
	 * 2. 초기화 블럭
	 * 초기화를 하기 위한 블럭 공간
	 * 여러 줄의 코드로 초기화를 할 수 있다.
	 */
	//인스턴스 변수를 초기화하기 위한 블럭
	{
		var = 30;
		//var 변수를 30으로 초기화
	}
	//클래스 변수를 초기화하기 위한 블럭
	static {
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
	
	VariableInit() {
		//컴파일러가 만들어주는 기본 생성자
		//파라미터도 없고, 아무 내용도 없다.
		var = 50;
		//인스턴스 변수를 초기화
		//굳이 생성자를 이용해서 초기화를 하는 이유
		//초기화에 파라미터가 필요할 때 생성자를 이용해서 초기화함
		//초기화하는 값을 외부에서 받아서(파라미터 이용) 사용할 수 있다.
	}
	
	public static void main(String[] args) {
		Init i = new Init();
		i.a = 10;
		i.b = 20;
		i.c = 30;
		
		Init i2 = new Init();
		i2.a= 40;
		i2.b= 50;
		i2.c= 60;
		
		Init i3 = new Init(70, 80, 90);
		//new 뒤의 부분이 생성자이다.
	}
	
}

class Init {
	int a;
	int b;
	int c;
	//전역변수
	Init(int a, int b, int c) {
		//지역변수
//		a = 1;
//		b = 2;
//		c = 3;
		//전역변수
		this.a = a;
		this.b = b;
		this.c = c;
		//this: 인스턴스변수와 지역변수의 이름이 같을 때 둘을 구분하기 위해 사용한다.
		//지역 변수와 전역 변수의 이름이 같을 때, 지역변수를 우선적으로 사용한다.
		//this를 붙이면 전역 변수, 붙이지 않으면 지역 변수이다.
		//this: 자기 객체를 가르키는 변수
		
	}

	//오버로딩: 같은 이름의 메서드를 여러개 정의하는 것
	Init() {
		//파라미터가 하나도 없는 생성자
		
		//생성자도 메서드이다, 같은 이름을 가진 메서드가 존재한다, 메서드는 같은 이름을 가질 수 있다.
		//이름으로는 메서드를 구분할 수 없으므로 파라미터의 차이로 메서드를 구분한다.
		//파라미터의 개수 혹은 타입이 달라야 오버로딩을 할 수 있다.
//		a = 10;
//		b = 20;
//		c = 30;
		//생성자가 여럿일 때는 이런식의 초기화는 권장되지 않는다.
		//이 생성자에서 저 생성자를 호출하는 방식으로 초기화 하는 것을 권장한다.
		this(10, 20, 30); //생성자에서 다른 생성자를 호출할 때 사용한다.
		//this() : 생성자 안에서 다른 생성자를 호출할 때 사용함, 생성자 안에서 가장 윗줄에 있어야 오류가 발생하지 않는다.
		//this. : 인스턴스 변수와 지역 변수의 구분을 위해 사용함.
	}
}
