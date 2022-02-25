package study;

import java.util.Scanner;

public class Study_210709 {

	public static void main(String[] args) {
		//탈출 문자(Escape문자)
				System.out.println("탭은\t4칸에 맞춰 띄워줍니다.");
				System.out.println("줄바꿈을\n해줍니다.");
				System.out.println("\"쌍따옴표를 넣어줍니다.\"");
				System.out.println("\\역슬래시를 넣어줍니다.");
				
		// switch () {
		//   case 1: case 2:
		//      문장;
		//      break;
		//   case 3: case 4: case 5:
		//      문장;
		//      break;
		//   default:
		//      문장;	
		// }

		//1부터 100까지 짝수의 합을 출력해주세요.(문제)
		int sum = 0;		
		for (int i = 2; i <= 100; i = i+2) {
			sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		for (int i = 2; i <= 100; i++) {
			if (i % 2 == 0){
				sum += i;
			}
		}
		System.out.println(sum);
		
		//1부터 100까지 홀수의 합을 출력해주세요.(문제)
		sum = 0;		
		for (int i = 1; i <= 100; i = i+2) {
			sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1){
				sum += i;
			}
		}
		System.out.println(sum);		
	
		//구구단을 출력해주세요.(문제)
		/*
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * 2 * 4 = 8
		 * ...
		 */				
			
//		for (int i = 1; i <= 9; i++) {
//			System.out.println(2 + " * " + i + " = " + i * 2);
//		}
//		
//		for (int i = 1; i <= 9; i++) {
//			System.out.println(8 + " * " + i + " = " + i * 8);
//		}
//		
//		for (int i = 2; i <= 9; i++) {
//			for (int j = 1; j <=9; j++) {
//				System.out.println(i + " * " + j + " = " + i * j);
//			}
//		}
		
		//구구단을 가로로 출력해주세요.(문제)
		/*
		 * 2 * 1 = 2    3 * 1 = 3    4 * 1 = 4
		 * 2 * 2 = 4    3 * 2 = 6    4 * 2 = 8
		 * 2 * 3 = 6    3 * 3 = 3    4 * 3 = 12
		 * ...
		 */	
				
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++)
				System.out.print(j + " * " + i + " = " + j * i + "\t");
			System.out.println();
		}
				
		//a에 2씩 곱해서 1000 이상이 되려면 몇번을 곱해야 하는가?(문제)
		int a = 1;
		int count = 0;
		while (a < 1000) {
			a *= 2;
			count++;
			System.out.println("a에 2를 " + count + "번 곱하면 : " + a);
		}
				
		//숫자 맞추기 게임을 만들어 보시오.(문제)
//		Scanner sc = new Scanner(System.in);
//		
//		int answer = (int)(Math.random() * 100) + 1;
//		int input = 0;
//		
//		do {
//			System.out.print("1 ~ 100 사이의 수를 입력해주세요.>");
//			input = Integer.parseInt(sc.nextLine());
//			
//			if (answer > input) {
//				System.out.println("정답은 " + input + " 보다 큽니다.");
//			} else if (answer < input) {
//				System.out.println("정답은 " + input + " 보다 작습니다.");
//			} else {
//				System.out.println("정답입니다.");
//			}
//		} while (answer != input);	

		//이름 붙은 반복문
		
		outer : for(int i = 2; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				if(j == 5) {
//					break; //가장 가까운 반복문 "한개"를 빠져나간다.
//					break outer; //outer라는 이름의 반복문을 빠져나간다.
//					continue; //가장 가까운 반복문의 현재 반복회차를 빠져나간다. //1, 2, 3, 4, (), 6, 7, 8, 9 - (j == 5) 만 빠져나간다.
					continue outer; //"outer라는 이름의 반복문"의 "현재 반복회차"를 빠져나간다. // 1, 2, 3, 4, 1, 2, 3, 4 ... 
				}
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println();
		}
			
		//별찍기(사각형)(문제)
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
			
		//별찍기(삼각형)(문제)
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");	
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//별찍기(역삼각형)(문제)
		System.out.println("*****");
		System.out.println("****");
		System.out.println("***");
		System.out.println("**");
		System.out.println("*");
		
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
		
		//별찍기(오른직각삼각형)(문제)
		System.out.println("    *");
		System.out.println("   **");
		System.out.println("  ***");
		System.out.println(" ****");
		System.out.println("*****");	
		
		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > 0; j--) {
				if (i<j) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
	}

}
