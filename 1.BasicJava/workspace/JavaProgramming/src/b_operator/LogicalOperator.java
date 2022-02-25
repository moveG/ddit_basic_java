package b_operator;

public class LogicalOperator {

	public static void main(String[] args) {
		/*
		 * 논리연산자
		 * - &&(AND), ||(OR), !(NOT) 
		 * - 피연산자로 boolean만 허용한다.
		 */
		
		int x = 10;
		int y = 20;
		boolean b = 0 < x && x < 10 || x < y; //&&가 ||보다 우선순위가 높다.
		
		b = !(x < y); //!은 boolean타입에 붙여야 한다. 그래서 x < y에 ()괄호를 붙여서 boolean타입의 결과값을 얻는다.
		System.out.println(b);
		
		//효율적 연산
		b = true && true; //true
		b = true && false; //false
		b = false && true; //false
		b = false && false; //false
		//&&(AND)는 한쪽이라도 false가 나오면 false가 된다.

		b = true || true; //true
		b = true || false; //true
		b = false || true; //true
		b = false || false; //false
		//||(OR)는 한쪽이라도 true가 나오면 true가 된다.
		//왼쪽의 피연산자에서 결과가 정해지면 오른쪽은 수행하지 않는다.
		
		int a = 10;
		b = a < 5 && 0 < a++;
		//앞에서 false가 나와서 뒤의 것은 수행하지 않는다. 원치 않는 결과를 얻을 가능성이 있다.
		System.out.println(a);
		
		//다음의 문장들을 코드로 작성해주세요.(문제)
		//x가 y보다 크고 x가 10보다 작다.
		b = x > y && x < 10;
		//x가 짝수이고 y보다 작거나 같다.
		b = x % 2 == 0 && x <= y;
		//x가 3의 배수이거나 5의 배수이다.
		b = x % 3 == 0 || x % 5 == 0;
	}

}
