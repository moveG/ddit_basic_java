package study;

import java.util.Scanner;

public class Study_210710 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//숫자를 입력받아 그 숫자가 0인지 아닌지 출력해주세요.
//		System.out.print("임의의 숫자를 입력하세요.>");
//		int random = Integer.parseInt(sc.nextLine());
//		
//		if (random == 0) {
//			System.out.println("당신이 출력한 숫자는 0입니다.");
//		} else {
//			System.out.println("당신이 출력한 숫자는 0이 아닙니다.");
//		}
		
		//숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
//		System.out.print("임의의 숫자를 입력하세요.>");
//		int random = Integer.parseInt(sc.nextLine());
//		
//		if (random / 2 == 0) {
//			System.out.println("당신이 출력한 숫자는 짝수입니다.");
//		} else {
//			System.out.println("당신이 출력한 숫자는 홀수입니다.");
//		}
		
		//점수 3개를 입력받아 합계, 평균, 등급을 출력해주세요.
//		System.out.println("세 과목의 점수를 입력하세요.>");
//		int score1 = Integer.parseInt(sc.nextLine());
//		int score2 = Integer.parseInt(sc.nextLine());
//		int score3 = Integer.parseInt(sc.nextLine());
//		
//		int sum = score1 + score2 + score3;
//		double avg = Math.round(sum / 3.0 * 100) / 100.0;
//		String grade = "F";
//		
//		if (avg >= 90) {
//			grade = "A";
//			if (avg >= 97) {
//				grade += "+";
//			} else if (avg <= 93) {
//				grade += "-";
//			}
//		} else if (avg >= 80) {
//			grade = "B";
//			if (avg >= 87) {
//				grade += "+";
//			} else if (avg <= 83) {
//				grade += "-";
//			}
//		} else if (avg >= 70) {
//			grade = "C";
//			if (avg >= 77) {
//				grade += "+";
//			} else if (avg <= 73) {
//				grade += "-";
//			}
//		} else if (avg >= 60) {
//			grade = "D";
//			if (avg >= 67) {
//				grade += "+";
//			} else if (avg <= 63) {
//				grade += "-";
//			}
//		}
//		
//		System.out.println("당신이 입력한 점수의 합계는 " + sum + "점 이고, 평균은 " + avg + "점 이고, 등급은 " + grade + " 입니다.");
		
		//1~100 사이의 랜덤한 정수를 3개 발생시키고 오름차순으로 출력해주세요.(작은 수부터 출력)
//		int random1 = (int)(Math.random() * 100) + 1;
//		int random2 = (int)(Math.random() * 100) + 1;
//		int random3 = (int)(Math.random() * 100) + 1;
//		int temp;
//		
//		if (random1 > random2) {
//			temp = random1;
//			random1 = random2;
//			random2 = temp;
//		}
//		if (random1 > random3) {
//			temp = random1;
//			random1 = random3;
//			random3 = temp;
//		}
//		if (random2 > random3) {
//			temp = random2;
//			random2 = random3;
//			random3 = temp;
//		}
//		
//		
//		System.out.println(random1 + " < " + random2 +  " < " + random3);
		
		//1부터 10까지 합계를 저장
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
		
		//1부터 100까지의 합계를 저장
		//정순, 역순
//		int sum = 0;
//		for (int i = 1; i <= 100; i++) {
//			sum += i;
//		}
//		System.out.println(sum);
//		
//		sum = 0;
//		for (int i = 100; i >= 1; i--) {
//			sum += i;
//		}
//		System.out.println(sum);
		
		//1부터 100까지 짝수의 합을 출력해주세요.
//		int sum = 0;
//		for (int i =1; i <= 100; i++) {
//			if (i % 2 == 0) {
//				sum += i;
//			}
//		}
//		System.out.println(sum);
//		
//		sum = 0;
//		for (int i = 2; i <= 100; i += 2) {
//			sum += i;
//		}
//		System.out.println(sum);
		
		//1부터 100까지 홀수의 합을 출력해주세요.
//		int sum = 0;
//		for (int i = 1; i <= 100; i++) {
//			if (i % 2 != 0) {
//				sum += i;
//			}
//		}
//		System.out.println(sum);
//		
//		sum = 0;
//		for (int i = 1; i <= 100; i += 2) {
//			sum += i;
//		}
//		System.out.println(sum);
		
		//구구단 출력(2단)
//		for (int i = 1; i <= 9; i++) {
//			System.out.println("2 *" + i + " = " + 2 * i);
//		}
		
		//구구단 출력(3단, 역순)
//		for (int i = 9; i >= 1; i--) {
//			System.out.println("3 *" + i + " = " + 3 * i);
//		}	
		
		//구구단 출력(모든 단, 세로)
//		for (int i = 2; i <= 9; i++) {
//			for (int j = 1; j <= 9 ; j++) {
//				System.out.println(i + " * " + j + " = " + i * j);
//			}
//			System.out.println();
//		}
		
		//구구단 출력(모든 단, 가로)
//		for (int i = 1; i < 9; i++) {
//			for (int j = 2; j < 9; j++) {
//				System.out.print(j + " * " + i + " = " + i * j + "\t");
//			}
//			System.out.println();
//		}
		
		/*
		 * while문
		 * - while (조건식) {}
		 * - 포함하고 있는 문장들을 조건식이 만족하는 동안 반복하는 문장
		 * - 반복횟수가 정확하지 않은 경우에 주로 사용한다.		
		 * - 조건식이 true일 동안은 계속 반복, false가 되면 while문을 벗어남
		 */
		
		//a에 2씩 곱해서 1000 이상이 되려면 몇번을 곱해야 하는가?
//		int a = 1;
//		int count = 0;
//		while (a < 1000) {
//			a *= 2;
//			count++;
//			System.out.println("a에 2를 " + count + "번 곱하면 : " + a);
//		}
		
		/*
		 * do-while문
		 * - do{}while(조건식);
		 * - 최소한 한 번의 수행을 보장한다.
		 * - 일단 한 번 무조건 실행한 다음, 조건식이 true면 반복, false이면 do-while문을 벗어남
		 */
		
		//숫자 맞추기 게임(1~100)
//		int answer = (int)(Math.random() * 100) + 1;
//		int input = 0;
//		do {
//			System.out.print("1 ~ 100 사이의 수를 입력해주세요.>");
//			input = Integer.parseInt(sc.nextLine());
//			
//			if (input > answer) {
//				System.out.println(input + "보다 작습니다.");
//			} else if (input < answer) {
//				System.out.println(input + "보다 큽니다.");
//			} else {
//				System.out.println("정답입니다!!");
//			}
//		} while (answer != input);
		
//		outer : for(int i = 2; i <= 9; i++) {
//			for(int j = 1; j <= 9; j++) {
//				if(j == 5) {
////					break; //가장 가까운 반복문 "한개"를 빠져나간다.
////					break outer; //outer라는 이름의 반복문을 빠져나간다.
////					continue; //가장 가까운 반복문의 현재 반복회차를 빠져나간다. //1, 2, 3, 4, (), 6, 7, 8, 9 - (j == 5) 만 빠져나간다.
////					continue outer; //"outer라는 이름의 반복문"의 "현재 반복회차"를 빠져나간다. // 1, 2, 3, 4, 1, 2, 3, 4 ... 
//				}
//				System.out.println(i + " * " + j + " = " + i * j);
//			}
//			System.out.println();
//		}
		
		//별찍기(사각형)
//		System.out.println("*****");
//		System.out.println("*****");
//		System.out.println("*****");
//		System.out.println();
//		
//		for (int i = 1; i <= 3; i++) {
//			for (int j = 1; j <= 5; j++ ) {
//			System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		//별찍기(삼각형)
//		System.out.println("*");
//		System.out.println("**");
//		System.out.println("***");
//		System.out.println("****");
//		System.out.println("*****");
//		System.out.println();
//		
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		//별찍기(역삼각형)
//		System.out.println("*****");
//		System.out.println("****");
//		System.out.println("***");
//		System.out.println("**");
//		System.out.println("*");
//		System.out.println();		
//		
//		for (int i = 0; i <= 5; i++) {
//			for (int j = 5; j > i ; j--) {
//			System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		//별찍기(문제)
//		System.out.println("    *");
//		System.out.println("   **");
//		System.out.println("  ***");
//		System.out.println(" ****");
//		System.out.println("*****");
//		System.out.println();
//		
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 5; j >= 1; j--) {
//				if (j > i) {
//					System.out.print(" ");
//				} else {
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		//별찍기(문제)
//		System.out.println("    *|    ");
//		System.out.println("   **|*   ");
//		System.out.println("  ***|**  ");
//		System.out.println(" ****|*** ");
//		System.out.println("*****|****");
//		System.out.println();
//		
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 5; j >= 1; j--) {
//				if (j > i) {
//					System.out.print(" ");
//				} else {
//					System.out.print("*");
//				}
//			}
//			for (int k = 1; k < i; k++) {
//				System.out.print("*");
//				
//			}
//			System.out.println();
//		}
//		System.out.println();

		/*
		 * 숫자 야구 게임
		 */
//변수선언부
		int strike = 0;
		int ball = 0;
		int out = 0;
		
//랜덤 숫자 생성부		
		int random1 = (int)(Math.random() * 9) + 1;
		int random2 = (int)(Math.random() * 9) + 1;
		int random3 = (int)(Math.random() * 9) + 1;
		
		while (random1 == random2) {
			random2 = (int)(Math.random() * 9) + 1;
		}
		
		while (random1 == random3 || random2 == random3) {
			random3 = (int)(Math.random() * 9) + 1;
		}
		
//게임 시작부		
//		System.out.println(random1 + " " + random2 + " " + random3);
		System.out.println("숫자 야구 게임을 시작하겠습니다.");
		
//변수 초기화부
		while (strike != 3) {
			
		strike = 0;
		ball = 0;
		out = 0;
			
//유저 숫자 입력부				
		System.out.println("중복되지 않는 숫자(1~9) 3개를 입력해주세요.");
		int num1 = Integer.parseInt(sc.nextLine());
		int num2 = Integer.parseInt(sc.nextLine());
		int num3 = Integer.parseInt(sc.nextLine());
		
//게임 구동부
		if (num1 == random1) {
			strike++;
		} else if (num1 == random2 || num1 == random3) {
			ball++;
		} else {
			out++;
		}
		
		if (num2 == random2) {
			strike++;
		} else if (num2 == random1 || num2 == random3) {
			ball++;
		} else {
			out++;
		}
		
		if (num3 == random3) {
			strike++;
		} else if (num3 == random2 || num3 == random1) {
			ball++;
		} else {
			out++;
		}

//결과 출력부		
		System.out.println("결과가 나왔습니다.");
		System.out.println("당신은 숫자 " + num1 + ", " + num2 + ", "+ num3 + " 를 입력하였습니다.");
//		System.out.println("상대는 숫자 " + random1 + ", " + random2 + ", "+ random3 + " 를 입력하였습니다.");
		System.out.println("게임의 결과는 " + strike + "S, " + ball +"B, "+ out + "O 입니다.");
		System.out.println("-------------------------------------");
		}
		
//게임 종료부		
		System.out.println("게임을 종료하겠습니다.");
	}

}
