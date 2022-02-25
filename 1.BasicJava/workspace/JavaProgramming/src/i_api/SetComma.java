package i_api;

import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마(,)를 붙여 출력해주세요.
		//1,234,567
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요.");
		String num = sc.nextLine();
		String num2 = "";
		
		int count = 0;
		for(int i = num.length() - 1; i >= 0; i--){
			num2 = num.charAt(i) + num2;
			count++;
			if(count % 3 == 0 && count != num.length()){
				num2 = "," + num2;
			}
		}
		System.out.println(num2);
	}

}
