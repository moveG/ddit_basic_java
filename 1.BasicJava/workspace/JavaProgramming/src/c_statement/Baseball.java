package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/*
		 * 숫자 야구 게임
		 */
		
		Scanner sc = new Scanner(System.in);

		int random1 = 0;
		int random2 = 0;
		int random3 = 0;
		
		do {
			random1 = (int)(Math.random() * 9) + 1;
			random2 = (int)(Math.random() * 9) + 1;
			random3 = (int)(Math.random() * 9) + 1;
		} while (random1 == random2 || random1 == random3 || random2 == random3 );

		int count = 0;
		while (true) { 
			System.out.println("숫자 야구 게임을 시작하겠습니다.");
			System.out.println("중복되지 않는 세자리 숫자를 입력해주세요.");
			
			int input = Integer.parseInt(sc.nextLine());
			
			int i3 = input % 10;
			input /= 10;
			int i2 = input % 10;
			input /= 10;
			int i1 = input % 10;
			
			int strike = 0;
			int ball = 0;
			int out = 0;
			
			if (random1 == i1) strike++;
			if (random2 == i2) strike++;
			if (random3 == i3) strike++;
			
			if (random1 == i2 || random1 == i3) ball++;
			if (random2 == i1 || random2 == i3) ball++;
			if (random3 == i1 || random3 == i2) ball++;
			
			out = 3 - strike - ball;
			
			System.out.println(++count + "차 시도(" + i1 + i2 + i3 + ") : " + strike + "S" + ball + "B" + out + "O");
			System.out.println("------------------------------------------");
		}
		
	}
	
}
