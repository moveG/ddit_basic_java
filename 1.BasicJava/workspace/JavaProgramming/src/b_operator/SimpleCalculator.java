package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		//두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요. +-*/%
			Scanner sc = new Scanner(System.in);
			System.out.print("첫번째 숫자를 입력하세요.>");
			double num1 = Double.parseDouble(sc.nextLine());
			
			System.out.print("연산자를 입력하세요.>");
			String str1 = sc.nextLine();
			
			System.out.print("두번째 숫자를 입력하세요.>");
			double num2 = Double.parseDouble(sc.nextLine());
								
			double num3 = str1.equals("+") ? num1 + num2 
						: (str1.equals("-") ? num1 - num2 
						: (str1.equals("*") ? num1 * num2 
						: (str1.equals("/") ? num1 / num2 
						: num1 % num2)));
			
			System.out.println("계산한 결과는 " + num3 + "입니다.");
	}

}
