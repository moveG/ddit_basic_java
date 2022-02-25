package c_statement;

import java.util.Scanner;

public class RepetitiveStatement {

	public static void main(String[] args) {
		/*
		 * 반복문
		 * - for문
		 * - while문
		 * - do-while문
		 * 
		 * for문
		 * - for (초기화; 조건식; 증감식) {}
		 * - 포함하고 있는 문장들을 정해진 횟수만큼 반복하는 문장
		 *
		 */
		
		for (int i = 1; i <= 10; i++) {
			//초기화: 시작부분, 조건식과 증감식에 사용할 변수 초기화
			//조건식: 종료부분, 연산결과가 true이면 블럭 안의 내용을 수행, false이면 for문을 벗어남
			//증감식: 증감부분, 변수를 증가/감소시켜 반복문을 제어
			System.out.println(i + "번째 반복");
		}
		
		int sum = 0; //1부터 10까지 합계를 저장
		
		sum += 1;
		sum += 2;
		sum += 3;
		sum += 4;
		sum += 5;
		sum += 6;
		sum += 7;
		sum += 8;
		sum += 9;
		sum += 10;
		System.out.println(sum);
		
		sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		//for문 안의 변수i는 for문 안에서만 존재함
		
		sum = 0;
		
		for (int i= 100; i >= 1; i--) {
			sum += i;
		}
		System.out.println(sum);
		//조건식에는 항상 부등호가 포함되어야 함
		
		//1부터 100까지 짝수의 합을 출력해주세요.(문제)
		sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		sum = 0;
		for (int i = 2; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println(sum);
		
		//1부터 100까지 홀수의 합을 출력해주세요.(문제)		
		sum=0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		sum = 0;
		for (int i = 1; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println(sum);
		
		//구구단 출력
		/*
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * 2 * 4 = 8
		 * ...
		 */
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(2 + " * " + i + " = " + i * 2);
		}
		
		for (int i = 1; i <= 9; i++) {
			System.out.println(8 + " * " + i + " = " + i * 8);
		}
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <=9; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
		}
		
		/*
		 * 2 * 1 = 2    3 * 1 = 3    4 * 1 = 4
		 * 2 * 2 = 4    3 * 2 = 6    4 * 2 = 8
		 * 2 * 3 = 6    3 * 3 = 3    4 * 3 = 12
		 * ...
		 */
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + " * " + i + " = " + j * i + " \t ");
			}
			System.out.println();
		}	
				
		/*
		 * while문
		 * - while (조건식) {}
		 * - 포함하고 있는 문장들을 조건식이 만족하는 동안 반복하는 문장
		 * - 반복횟수가 정확하지 않은 경우에 주로 사용한다.		
		 * - 조건식이 true일 동안은 계속 반복, false가 되면 while문을 벗어남
		 */
				
		int a = 1; //for문의 초기화
		//a에 2씩 곱해서 1000 이상이 되려면 몇번을 곱해야 하는가?
		int count = 0;
		//숫자를 세기 위한 변수
		while (a < 1000) {
			a *= 2; //for문의 조건문
			count++;
			System.out.println("a에 2를 " + count + "번 곱하면 : " + a);
		}
		
		/*
		 * do-while문
		 * - do{}while(조건식);
		 * - 최소한 한 번의 수행을 보장한다.
		 * - 일단 한 번 무조건 실행한 다음, 조건식이 true면 반복, false이면 do-while문을 벗어남
		 */
		
//		//숫자 맞추기 게임
//		int answer = (int)(Math.random() * 100) + 1;
//		int input = 0;
//		Scanner sc = new Scanner(System.in);		
//		do {
//			System.out.print("1 ~ 100 사이의 수를 입력해주세요.>");
//			input = Integer.parseInt(sc.nextLine());
//			
//			if(answer < input) {
//				System.out.println(input + "보다 작습니다.");
//			} else if (input < answer) {
//				System.out.println(input + "보다 큽니다.");
//			} else {
//				System.out.println("정답입니다!!");
//			}
//			
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
	
		//별찍기(사각형)
//		System.out.println("*****");
//		System.out.println("*****");
//		System.out.println("*****");
//		
//		for(int i = 1; i <= 3; i++) {
//			for(int j = 1; j <= 5; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//별찍기(삼각형)(문제)
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");
				
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		//별찍기(역삼각형)(문제)
		System.out.println("*****");
		System.out.println("****");
		System.out.println("***");
		System.out.println("**");
		System.out.println("*");
		
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}		
	}

}
