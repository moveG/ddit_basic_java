package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 산술연산자
		 * - 사칙연산자: +, -, *, /, %(나머지)
		 * - 복합연산자: +=, -=, *=, /=, %=
		 * - 증감연산자: ++, --
		 */
		
		int result = 10 + 20 - 30 * 40 / 50 % 60;
		
		//나머지 연산
		result = 10 / 3; //3.33333
		System.out.println(result);
		result = 10 % 3;
		System.out.println(result);
		
		//5개의 산술연산자를 사용해 5개의 연산을 수행 후 결과를 출력해주세요.(문제)
		int a;
		a = 1 + 2;
		System.out.println(a);
		a = 1 - 2;
		System.out.println(a);
		a = 1 * 2;
		System.out.println(a);
		a = 2 / 2;
		System.out.println(a);
		a = 20 % 3;
		System.out.println(a);
		
		//복합연산자
		//변수에 저장되어 있는 값에 연산을 수행할 때, 수행할 연산자와 대입연산자를 결합해 사용할 수 있다.
		result = result + 3;
		System.out.println(result);
		
		result += 3;
		System.out.println(result);
		
		result -= 5;
		System.out.println(result);
		
		result *= 2;
		System.out.println(result);
		
		result /= 2;
		System.out.println(result);
		
		result %= 3;
		System.out.println(result);
		
		//아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요.(문제)
		//result = result + 10;
		result += 10;
		//result = result % 5;
		result %= 5;
		//result = result -2 * 3;
		result -= 2 * 3;		
		//result -= 6;
		//result = result - 6;
		//곱셈부터 먼저 연산이 된다.
		
		//증감연산자
		//증가연산자(++): 변수의 값을 1 증가시킨다.
		//감소연산자(--): 변수의 값을 1 감소시킨다.
		int i = 0;
		++i; //전위형: 변수의 값을 읽어오기 전에 1 증가된다.
		i++; //후위형: 변수의 값을 읽어온 후에 1 증가된다.
		--i;
		i--;
		
		i = 0;
		System.out.println("++i = " + ++i);
		i = 0;
		System.out.println("i++ = " + i++);
		System.out.println(i);
		
		//피연산자의 타입이 서로 같아야만 연산이 가능하다.
		int _int = 10;
		double _double = 3.14;
		double result2 = _int + _double; //표현 범위가 더 큰 타입으로 형변환된다.
		//double result2 = (double)_int + _double; //_int 앞에 (double)가 생략되어 있다.
		System.out.println(result2);
		
		byte _byte = 5;
		short _short = 10;
		_int = _byte + _short; //int보다 작은 타입은 int타입으로 형변환된다.
		System.out.println(_int);
		//컴퓨터는 기본적으로 4byte 이상이 되어야 계산이 가능하므로 자동으로 4byte로 형변환해서 계산한다. int(4byte)타입으로 형변환해서 int타입 결과값을 내놓는다.
		
		char _char = 'a';
		char _char2 = 'b';
		_int = _char + _char2;
		System.out.println(_int);
		//컴퓨터가 문자를 표현할 때는 문자와 숫자를 연결시켜 사용한다. 그 연결을 나타낸 표를 유니코드라고 한다. 각 문자를 할당된 숫자로 형변환해서 계산한다.
		//유니코드에서 a는 97, b는 95이다.
		
		//오버플로우, 언더플로우.
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		byte b = 127; //byte타입은 -128부터 127까지 표현할 수 있다.
		b++;
		System.out.println(b);
		//가장 큰 값을 벗어나면 오버플로우 되어 그 타입이 표현할 수 있는 가장 작은 값이 된다.
		b--;
		System.out.println(b);
		//가장 작은 값을 벗어나면 언더플로우 되어 그 타입이 표현할 수 있는 가장 큰 값이 된다.
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.(문제)
		//1. 123456 + 654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 123456
		
		long res = 123456 + 654321;
		res *= 123456;
		res /= 123456;
		res -= 654321;
		res %= 123456;
		System.out.println(res);
		
		//3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.(문제)
//		int aa = 90;
//		int bb = 20;
//		int cc = 40;
//		int sum = aa + bb + cc;
//		int avg = sum / 3;
//		System.out.println("합계 = " + sum + " / 평균 = " + avg);
		
		int num1 = 15;
		int num2 = 34;
		int num3 = 49;
		int sum = num1 + num2 + num3;
		double avg = sum / 3.0;
		System.out.println("합계 = " + sum + " / 평균= " + avg);
		
		//반올림
		avg = Math.round(avg * 10000) / 10000.0;
		//Math.round는 무조건 소수점 첫째자리에서 반올림을 한다.
		//원하는 자리수에서 반올림을 하려면, 원하는 자리수 만큼 곱해준 다음에 반올림 후 다시 같은 수를 나누어준다.
		//Math.round는 int타입이므로 원하는 소수점 결과값을 구하려면, 정수가 아니라 실수로 나누어준다.
		System.out.println(avg);
		
		//랜덤
		int random = (int)(Math.random() * 100) + 1;
		// *100을 해주면 0.0~99.0까지에서 랜덤값을 구해주고, +1을 해주면 1.0~100.0의 범위에서 랜덤값을 구해준다.
		System.out.println(random);
		//Math.random은 double타입이다.
		//Math.random(): 0.0 ~ 1.0미만(0.999999...)
	}
	
}