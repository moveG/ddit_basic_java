package study.study1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {

	public static void main(String[] args) {
		/*
		 * 런타임 에러
		 * - 런타임 에러 발생시 발생한 위치에서 프로그램이 비정상적으로 종료된다.
		 * - 에러: 프로그램 코드에 의해 수습될 수 없는 심각한 오류(처리 불가)
		 * - 예외: 프로그램 코드에 의해 수습될 수 있는 다소 미약한 오류(처리 가능)
		 * 
		 * 예외
		 * - 모든 예외는 Exception 클래스의 자식 클래스이다.
		 * - RuntimeException 클래스와 그 자식들은 예외처리가 강제되지 않는다.
		 * - [RuntimeException 클래스와 그 자식들을 제외한] Exception 클래스의 자식들은 예외처리가 강제된다.
		 * 
		 * 예외처리(try-catch)
		 * - 예외처리를 통해 프로그램이 비정상적으로 종료되는 것을 방지할 수 있다.
		 * - try {} catch(Exception e) {}
		 * - try 블럭 안의 내용을 실행 중 예외가 발생하면 catch로 넘어간다.
		 * - catch의 ()안에는 처리할 예외를 지정해줄 수 있다.
		 * - 여러 종류의 예외를 처리할 수 있도록 catch는 하나 이상 올 수 있다.
		 * - 발생한 예외와 일치하는 catch 블럭 안의 내용이 수행된 이후 try-catch를 빠져나간다.
		 * - 발생한 예외와 일치하는 catch가 없을 경우에는 예외는 처리되지 않는다.
		 */
		try {
			int result = 10 / 0;
			System.out.println(result);
		} catch (ArithmeticException | IndexOutOfBoundsException e) {
			e.printStackTrace();
			//발생한 에러의 메시지를 출력해줌
		} catch (NullPointerException e){
			//아무것도 들어있지 않아도 에러처리 가능, 타입 여러개도 가능
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("abcd");
		
		test1();
		/*
		 * CallStack
		 * |_______________|
		 * |_______________|
		 * |____test2()____|
		 * |____test1()____|
		 * |____main()_____|
		 * 한쪽만 뚫려있음
		 * 데이터가 위로만 들어오고 나간다.
		 * 데이터가 아래에서부터 누적된다.
		 * 데이터가 나중에 들어온 것부터 나간다.(후입선출)
		 */
	}
	private static void test1() {
		test2();
	}
	private static void test2() {
//		System.out.println(10 / 0);
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//에러 메시지가 여러개 발생하면 가장 위에서부터 찾되, 내가 만든 오류를 확인한다.
	//모든 에러에 대응하고 싶으면, ()부분에 Exception e를 넣어주면 된다.
}
