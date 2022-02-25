package study;

import java.util.Scanner;

public class Study_210720_01 {

	public static void main(String[] args) {
		Study_210720_01 mt = new Study_210720_01();
		System.out.println("나의 연애 유형은?");
		System.out.println("말해 YES or NO!");
		mt.q0();
	}
	
	String[] question = {"나는 금사빠다.",
					     "연애할 때 끌려다니는 타입이다.",
					     "데이트 코스는 미리 짜는게 편하다.",
					     "감정기복이 크지 않다.",
					     "감정표현에 솔직한 편이다.",
					     "활동적인 데이트가 좋다.",
					     "연락이 없어도 믿고 기다리는 편이다.",
					     "이성친구는 존재할 수 없다.",
					     "아무것도 아닌 일에 쉽게 섭섭함이 쌓인다."
	};
	
	String[] answer = {"당신은 A유형 입니다.",
					   "서로에 대한 신뢰감이 깊고, 존중해주는 어른스러운 연애를 하는 타입!",
			           "당신은 B유형 입니다.",
			           "구속을 하는 것도, 받는 것도 싫은 자유로운 연애를 하는 타입!",
			           "당신은 C유형 입니다.",
			           "이것이 의리인가 사랑인가... 친구같이 편안한 연애를 하는 타입!",
			           "당신은 D유형 입니다.",
			           "무조건 잘해주고, 무조건  맞춰주는 다 퍼주는 연애를 하는 타입!",
	};
	
	Scanner sc = new Scanner(System.in);
	
	void q0() {
		System.out.println(question[0]);
		String a = sc.nextLine();
		if (a.equals("y")) {
			q1();
		} else {
			q3();
		}
	}
	
	void q1() {
		System.out.println(question[1]);
		String a = sc.nextLine();
		if (a.equals("y")) {
			q4();
		} else {
			q2();
		}
	}	
	
	void q2() {
		System.out.println(question[2]);
		String a = sc.nextLine();
		if (a.equals("y")) {
			q5();
		} else {
			q4();
		}
	}
	
	void q3() {
		System.out.println(question[3]);
		String a = sc.nextLine();
		if (a.equals("y")) {
			q6();
		} else {
			q4();
		}
	}
	
	void q4() {
		System.out.println(question[4]);
		String a = sc.nextLine();
		if (a.equals("y")) {
			q7();
		} else {
			q5();
		}
	}
	
	void q5() {
		System.out.println(question[5]);
		String a = sc.nextLine();
		if (a.equals("y")) {
			q7();
		} else {
			q8();
		}
	}
	
	void q6() {
		System.out.println(question[6]);
		String a = sc.nextLine();
		if (a.equals("y")) {
			a1();
		} else {
			q7();
		}
	}
	
	void q7() {
		System.out.println(question[7]);
		String a = sc.nextLine();
		if (a.equals("y")) {
			q8();
		} else {
			a2();
		}
	}
	
	void q8() {
		System.out.println(question[8]);
		String a = sc.nextLine();
		if (a.equals("y")) {
			a4();
		} else {
			a3();
		}
	}
	
	void a1() {
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		String a = sc.nextLine();
	}
	
	void a2() {
		System.out.println(answer[2]);
		System.out.println(answer[3]);
		String a = sc.nextLine();
	}	
	
	void a3() {
		System.out.println(answer[4]);
		System.out.println(answer[5]);
		String a = sc.nextLine();
	}	
	
	void a4() {
		System.out.println(answer[6]);
		System.out.println(answer[7]);
		String a = sc.nextLine();
	}	
	
	
	
	
	

}
