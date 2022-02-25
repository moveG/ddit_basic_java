package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 조건문
		 * - if문
		 * - switch문
		 * 
		 * if문
		 * - if(조건식){}: 조건식의 결과가 true이면 블럭 안의 문장을 수행한다.
		 * - else if(조건식){}: 다수의 조건이 필요할때, if 뒤에 추가한다.
		 * - else{}: 조건식 이외의 경우를 위해 추가한다. 
		 * - 조건식은 boolean 타입의 값이 나와야 한다.
		 */

		int a = 4;

		if (a == 1) {
			System.out.println("a == 1");
		} else if (a == 2) {
			System.out.println("a == 2");
		} else if (a == 3) {
			System.out.println("a == 3");
		} else {
			System.out.println("else");
		}
		//여러개가 true라도 if문은 첫 true만 실행한다.

		if (a < 10) {
			System.out.println("a가 10보다 작다.");
		}
		if (a < 20) {
			System.out.println("a가 20보다 작다.");
		}
		//2개의 다른 if문이다, 두번째 if를 else if로 바꾸어줘야 한다.

		//점수가 60점 이상이면 합격, 그렇지 않으면 불합격.
		int score = 80;

		if (60 <= score) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

		//성적에 등급을 부여하는 프로그램.
		score = 100;
		String grade = null;
		if (90 <= score) {
			grade = "A";
		} else if (80 <= score) {
			grade = "B";
		} else if (70 <= score) {
			grade = "C";
		} else if (60 <= score) {
			grade = "D";
		} else {
			grade = "F";
		}
		System.out.println(score + "점에 해당하는 당신의 등급은 " + grade + " 입니다.");

		//기본값: 자동으로 초기화 될 때 저장되는 값.
		//참조형 타입: null
		//boolean: false
		//나머지: 0, 0.0, 0.0f 등

		score = 90;
		grade = null;
		if (90 <= score) {
			grade = "A";
			if (97 <= score) {
				grade += "+";
			} else if (score <= 93) {
				grade += "-";
			}
		} else if (80 <= score) {
			grade = "B";
			if (87 <= score) {
				grade += "+";
			} else if (score <= 83) {
				grade += "-";
			}
		} else if (70 <= score) {
			grade = "C";
			if (77 <= score) {
				grade += "+";
			} else if (score <= 73) {
				grade += "-";
			}
		} else if (60 <= score) {
			grade = "D";
			if (67 <= score) {
				grade += "+";
			} else if (score <= 63) {
				grade += "-";
			}
		} else {
			grade = "F";
		}
		System.out.println(score + "점에 해당하는 당신의 등급은 " + grade + " 입니다.");

		//스페이스바 4개 = 1탭
		//줄맞추기 단축키: 블록지정 + Ctrl + Shift + F
		//블록을 지정하지 않으면 주석까지 모두 정리된다. <주의할 것!>
		
		/*
		 * switch문
		 * - switch(int/String){ case1: break; }
		 * - 조건식의 결과는 정수와 문자열만(JDK1.7부터 문자열 허용) 허용한다.
		 * - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 * - default
		 */
		
		a = 20;
		
		switch (a){
		case 10:
			System.out.println("a == 10");
			break;
		case 20:
			System.out.println("a == 20");
			break;
		default:
			System.out.println("default");		
		}
		//break가 case 사이에 반드시 존재해야 한다.
		
		String b = "a";
		
		switch (b){
		case "a":
			System.out.println("b == \"a\"");
			break;
		case "b":
			System.out.println("b == \"b\"");
			break;
		default:
			System.out.println("default");
		}
		//switch-case문은 정확히 일치하는 값이 있어야 실행이 가능하다.
		//switch문으로 표현할 수 있는 문장은 if문으로 전부 표현할 수 있다.
		//반복된 문장은 switch문이 if문보다 실행속도가 살짝 빠르다.
		//switch문은 if문보다 사용빈도가 낮다.
		
		//주어진 월에 해당하는 계절을 출력해봅시다.
		int month = 12;
		String season = null;
		
		switch(month){
		case 3:	case 4:	case 5:
			season = "봄";
			break;
		case 6:	case 7: case 8:
			season = "여름";
			break;
		case 9:	case 10: case 11:
			season = "가을";
			break;
		case 12: case 1: case 2:
			season = "겨울";
			break;
		}
		
		System.out.println(month + "월은 " + season + " 입니다.");
		
		score = 0;
		grade = null;
		switch(score / 10){
		case 10: case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		
		System.out.println(score + "점에 해당하는 당신의 등급은 " + grade + " 입니다.");
		//점수에 따른 등급을 매기려면 굉장히 많은 case수가 필요하다, 그러므로 10으로 나누어주어 계산한다.
		//마지막 case나 default에는 break;를 생략할 수 있다.
		
		//숫자를 입력받아 그 숫자가 0인지 아닌지 출력해주세요.
		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자를 입력해주세요.>");
//		int input = Integer.parseInt(sc.nextLine());
//		
//		if (input == 0) {
//			System.out.println("당신이 입력한 숫자는 0 입니다.");
//		} else {
//			System.out.println("당신이 입력한 숫자는 0이 아닙니다.");
//		}
		
		//숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
//		System.out.print("숫자를 입력해주세요.>");
//		int input = Integer.parseInt(sc.nextLine());
//		
//		if (input % 2 != 0) {
//			System.out.println("당신이 입력한 숫자는 홀수입니다.");
//		} else {
//			System.out.println("당신이 입력한 숫자는 짝수입니다.");
//		}
		
		//점수 3개를 입력받아 합계, 평균, 등급을 출력해주세요.
//		System.out.print("국어 점수를 입력하세요.>");
//		int kor = Integer.parseInt(sc.nextLine());
//		System.out.print("영어 점수를 입력하세요.>");
//		int eng = Integer.parseInt(sc.nextLine());
//		System.out.print("수학 점수를 입력하세요.>");
//		int math = Integer.parseInt(sc.nextLine());
//		
//		int sum = kor + eng + math;
//		double avg = Math.round(sum / 3.0 * 10) / 10.0;
//		if (90 <= avg) {
//			grade = "A";
//			if (97 <= avg) {
//				grade += "+";
//			} else if (avg <= 93){
//				grade += "-";
//			}
//		} else if (80 <= avg) {
//			grade = "B";
//			if (87 <= avg) {
//				grade += "+";
//			} else if (avg <= 83){
//				grade += "-";
//			}
//		} else if (70 <= avg) {
//			grade = "C";
//			if (77 <= avg) {
//				grade += "+";
//			} else if (avg <= 73){
//				grade += "-";
//			}
//		} else if (60 <= avg) {
//			grade = "D";
//			if (67 <= avg) {
//				grade += "+";
//			} else if (avg <= 63){
//				grade += "-";
//			}
//		} else {
//			grade = "F";
//		}
//		
//		System.out.println("점수의 합계는 " + sum + " 이고, " + "점수의 평균은 " + avg + " 이고, " + "평균의 등급은 " + grade + " 입니다.");
		
		//1~100 사이의 랜덤한 정수를 3개 발생시키고 오름차순으로 출력해주세요.(작은 수부터 출력)
//		int r1 = (int)(Math.random() * 100) + 1;
//		int r2 = (int)(Math.random() * 100) + 1;
//		int r3 = (int)(Math.random() * 100) + 1;
//		
//		if (r1 < r2 && r2 < r3 && r1 < r3) {
//			System.out.println(r1 + "," + r2 + "," + r3);
//		} else if (r1 < r3 && r3 < r2 && r1 < r2) {
//			System.out.println(r1 + "," + r3 + "," + r2);
//		} else if (r2 < r1 && r1 < r3 && r2 < r3) {
//			System.out.println(r2 + "," + r1 + "," + r3);
//		} else if (r2 < r3 && r3 < r1 && r2 < r1) {
//			System.out.println(r2 + "," + r3 + "," + r1);
//		} else if (r3 < r1 && r1 < r2 && r3 < r2) {
//			System.out.println(r3 + "," + r1 + "," + r2);
//		} else if (r3 < r2 && r2 < r1 && r3 < r1) {
//			System.out.println(r3 + "," + r2 + "," + r1);
//		}
		
		//x, y, z 오름차순 출력
		int x = (int)(Math.random() * 100) + 1;
		int y = (int)(Math.random() * 100) + 1;
		int z = (int)(Math.random() * 100) + 1;
		int temp;		
		if(x > y) {
			temp = x;
			x = y;
			y = temp;
		}
		if (x > z) {
			temp = x;
			x = z;
			z = temp;
		}
		if (y > z) {
			temp = y;
			y = z;
			z= temp;
		}
		
		System.out.println(x + "<" + y + "<" + z);
		
	}

}
