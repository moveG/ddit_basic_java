package e_oop;

import java.util.Scanner;

public class MindTest {

	public static void main(String[] args) {
		MindTest mt = new MindTest();
		System.out.println("나의 연애 유형은?");
		System.out.println("말해 Yes or No!");
		System.out.println();
		mt.q0();
	}

	String[] question = {"나는 금사빠다: y/n>",
						 "연애할 때 끌려다니는 타입이다: y/n>",
						 "데이트 코스는 미리 짜는게 편하다: y/n>",
						 "감정기복이 크지 않다: y/n>",
						 "감정표현에 솔직한 편이다: y/n>",
						 "활동적인 데이트가 좋다: y/n>",
						 "연락이 없어도 믿고 기다리는 편이다: y/n>",
						 "이성친구는 존재할 수 없다: y/n>",
						 "아무것도 아닌 일에 쉽게 섭섭함이 쌓인다: y/n>"
	};
	
	String[] answer = {"당신은 A타입 입니다! - 어른스러운 연애를 하세요.",
					   "당신은 B타입 입니다! - 자유로운 연애를 하세요.",
					   "당신은 C타입 입니다! - 친구같이 편안한 연애를 하세요.",
					   "당신은 D타입 입니다! - 다 퍼주는 연애를 하세요."
	};
	
	Scanner s= new Scanner(System.in);
		
	void q0() {
		System.out.print(question[0]);
		String a = s.nextLine();
		if (a.equals("y")) {
			q1();
		} else {
			q3();
		}
	}
	void q1() {
		System.out.print(question[1]);
		String a = s.nextLine();
		if (a.equals("y")) {
			q4();
		} else {
			q2();
		}
	}
	void q2() {
		System.out.print(question[2]);
		String a = s.nextLine();
		if (a.equals("y")) {
			q5();
		} else {
			q4();
		}
	}
	void q3() {
		System.out.print(question[3]);
		String a = s.nextLine();
		if (a.equals("y")) {
			q6();
		} else {
			q4();
		}
	}
	void q4() {
		System.out.print(question[4]);
		String a = s.nextLine();
		if (a.equals("y")) {
			q7();
		} else {
			q5();
		}
	}
	void q5() {
		System.out.print(question[5]);
		String a = s.nextLine();
		if (a.equals("y")) {
			q7();
		} else {
			q8();
		}
	}
	void q6() {
		System.out.print(question[6]);
		String a = s.nextLine();
		if (a.equals("y")) {
			q9();
		} else {
			q7();
		}
	}
	void q7() {
		System.out.print(question[7]);
		String a = s.nextLine();
		if (a.equals("y")) {
			q8();
		} else {
			q10();
		}
	}
	void q8() {
		System.out.print(question[8]);
		String a = s.nextLine();
		if (a.equals("y")) {
			q12();
		} else {
			q11();
		}
	}
	void q9() {
		System.out.print(answer[0]);
		
	}
	void q10() {
		System.out.print(answer[1]);
		
	}
	void q11() {
		System.out.print(answer[2]);
		
	}
	void q12() {
		System.out.print(answer[3]);
		
	}
}


