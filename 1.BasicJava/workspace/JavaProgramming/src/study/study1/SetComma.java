package study.study1;

import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 3자리 마다 콤마(,)를 붙여 출력해주세요.
		//1,234,567
		Scanner s = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		String num1 = s.nextLine();
		String num2 = "";
		
		int count = 0;
		for(int i = num1.length() - 1; i >= 0; i--){
			num2 = num1.charAt(i) + num2;	//1234567
			count++;	//1, 2, 3, 4, 5, 6, 7
			if(count % 3 == 0 && count != num1.length()){
				num2 = "," + num2;
			}
		}
		System.out.println(num2);
	}
}
