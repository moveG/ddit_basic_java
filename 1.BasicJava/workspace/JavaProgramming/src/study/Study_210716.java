package study;

import java.util.Scanner;

public class Study_210716 {

	public static void main(String[] args) {
		/*
		 * 이클립스 단축키
		 */
		Scanner sc = new Scanner(System.in);
		
		String answer = null;
		do {
			
			answer = "y";
			System.out.print("원하는 숫자를 입력하세요.>");
			int num = Integer.parseInt(sc.nextLine());
			
			if (num > 0) {
				System.out.println("당신이 입력한 숫자는 양수 입니다.");
			} else if (num < 0) {
				System.out.println("당신이 입력한 숫자는 음수 입니다.");
			} else if (num == 0){
				System.out.println("당신이 입력한 숫자는 0입니다.");
			}
			
			System.out.print("종료하시겠습니까?(y/n)>");
			answer = sc.nextLine();
			
			if (!(answer.equals("n") || answer.equals("y"))) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.print("종료하시겠습니까?(y/n)>");
				answer = sc.nextLine();
			}
			if (answer.equals("n")) {
				System.out.println("그럼 다시 시작하겠습니다.");
			}
		} while (answer.equals("n"));
		
		System.out.println("종료하겠습니다. 이용해주셔서 감사합니다.");
		




	}

}
