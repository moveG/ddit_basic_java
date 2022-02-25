package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming)
		 * - 프로그래밍을 단순히 코드의 연속으로 보는 것이 아니라, 객체 간의 상호작용으로 보는 것
		 * - 코드의 재사용성이 높고 유지보수가 용이하다.
		 */
		
		SampleClass sc = new SampleClass();
		//SampleClass 객체가 생성되고, SampleClass타입 변수 sc에 객체의 주소값이 저장된다.
		
		System.out.println(sc.field);
		//자동으로 초기화된 0이 출력된다.
		//변수 출력
		
		String returnValue = sc.method1(10);
		System.out.println(returnValue);
		//메서드 출력
		sc.method2();
		//메서드 출력
		
		sc.flowTest1();
		
		//방금 만들 클래스의 객체를 생성하고 변수에 저장해주세요.
		//객체가 저장된 변수를 통해 메서드를 출력해주세요.
		//파라미터가 있는 메서드는 타입에 맞는 값을 넘겨주시고,
		//리턴타입이 있는 메서드는 리턴받은 값을 출력해주세요.
		ClassMaker cm = new ClassMaker();
		
		cm.method1();
		
		String b = cm.method2();
		System.out.println(b);
		
		cm.method3(3);		
		
		int c = cm.method4(3,  4);
		System.out.println(c);
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 123456
		Calculator cc = new Calculator();

		double result = cc.plus(123456, 654321);
		result = cc.multiply(result, 123456);
		result = cc.divide(result, 123456);
		result = cc.minus(result, 654321);
		result = cc.mod(result, 123456);		
		System.out.println(result);
		
	}

}
