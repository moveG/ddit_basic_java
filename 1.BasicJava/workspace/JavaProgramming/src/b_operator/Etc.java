package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		/*
		 * 비트연산자
		 * - |, &, ^, ~, <<, >>
		 * - 비트 단위로 연산한다.
		 * - 사용 빈도가 낮다, 특수 분야에서 사용한다.
		 * 
		 * 기타연산자
		 * - .(참조연산자): 특정 범위 내에서 속해 있는 멤버를 지칭할 때 사용한다.
		 * - ?:(삼항연산자): 조건식 ? 조건식이 참일 경우 수행할 문장 : 조긴식이 거짓일 경우 수행할 문장
		 */
		
		//bit: 컴퓨터가 표현할 수 있는 가장 작은 단위.
		//1byte: 01010101
		//1byte = 8bit
		
		System.out.println(10 | 15); //|: 둘다 0인 경우 0 그외 1
		//10: 00001010 (비트 단위, 2진수)
		//15: 00001111
		//10과 15를 비교한다.
		//| : 00001111 //15가 된다.
		
		int x = 10;
		int y = 20;
		int result = x < y ? x : y;
		System.out.println(result);
		
		//주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면 여자.
		int regNo = 1;
		String gender = regNo == 1 ? "남자" : "여자";
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		gender = regNo == 1 ? "남자" : (regNo == 2 ? "여자" : "확인불가");
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		//2개의 숫자를 입력받고, 둘 중 더 큰 숫자를 출력해주세요.(문제)
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자: ");
		int a = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자: ");
		int b = Integer.parseInt(sc.nextLine());
		int c = a > b ? a : b;
		System.out.println("둘 중 더 큰 숫자는 " + c + " 입니다.");
		
		//숫자를 입력받고, 그 숫자가 1이나 3이면 남자를 2나 4면 여자를 출력해주세요.(문제)
		//그외의 숫자를 입력하면 확인불가를 출력해주세요.
		System.out.print("숫자를 입력하세요> ");
		int d = Integer.parseInt(sc.nextLine());
//		String e = d == 1 ? "남자" : (d == 2 ? "여자" : (d == 3 ? "남자" : (d == 4 ? "여자" : "확인불가")));
		String e = d == 1 || d == 3 ? "남자" : (d == 2 || d == 4 ? "여자" : "확인불가");
		System.out.println("당신의 성별은 " + e + " 입니다.");		
	}

}
