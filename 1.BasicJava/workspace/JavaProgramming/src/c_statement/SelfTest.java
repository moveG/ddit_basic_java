package c_statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
				
		System.out.println("'탄수화물 중독' 자가진단하기");
		System.out.println("(자료: 식품의약품안정청)");
		System.out.println("------------------------------------------------");
		System.out.println("진단을 시작하겠습니다, Enter키를 치세요.>");
		String et1 = sc.nextLine();
		
		System.out.println("1. 아침을 배불리 먹은 후 점심시간 전에 배가 고프다.");
		System.out.print("y/n>");
		String st1 = sc.nextLine();
		
		System.out.println("2. 밥, 빵, 과자 등의 음식을 먹기 시작하면 끝이 없다.");
		System.out.print("y/n>");
		String st2 = sc.nextLine();
		
		System.out.println("3. 음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.");
		System.out.print("y/n>");
		String st3 = sc.nextLine();
		
		System.out.println("4. 정말 배가 고프지 않더라도 먹을 때가 있다.");
		System.out.print("y/n>");
		String st4 = sc.nextLine();
		
		System.out.println("5. 저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다.");
		System.out.print("y/n>");
		String st5 = sc.nextLine();
		
		System.out.println("6. 스트레스를 받으면 자꾸 먹고 싶어진다.");
		System.out.print("y/n>");
		String st6 = sc.nextLine();
		
		System.out.println("7. 책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다.");
		System.out.print("y/n>");
		String st7 = sc.nextLine();
		
		System.out.println("8. 오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다.");
		System.out.print("y/n>");
		String st8 = sc.nextLine();
		
		System.out.println("9. 과자, 초콜릿 등의 단 음식은 상상만 해도 먹고 싶어진다.");
		System.out.print("y/n>");
		String st9 = sc.nextLine();
		
		System.out.println("10. 다이어트를 위해 식이조절을 하는데 3일도 못 간다.");
		System.out.print("y/n>");
		String st10 = sc.nextLine();
		System.out.println("------------------------------------------------");
		System.out.println("결과를 보시려면, Enter키를 치세요.>");
		String et2 = sc.nextLine();
		
		
		
		if (st1.equals("y")) {
			answer += 1;
		} else if (st1.equals("n")) {
			answer += 0;
		}
		
		if (st2.equals("y")) {
			answer += 1;
		} else if (st2.equals("n")) {
			answer += 0;
		}
		
		if (st3.equals("y")) {
			answer += 1;
		} else if (st3.equals("n")) {
			answer += 0;
		}
		
		if (st4.equals("y")) {
			answer += 1;
		} else if (st4.equals("n")) {
			answer += 0;
		}
		
		if (st5.equals("y")) {
			answer += 1;
		} else if (st5.equals("n")) {
			answer += 0;
		}
		
		if (st6.equals("y")) {
			answer += 1;
		} else if (st6.equals("n")) {
			answer += 0;
		}
		
		if (st7.equals("y")) {
			answer += 1;
		} else if (st7.equals("n")) {
			answer += 0;
		}
		
		if (st8.equals("y")) {
			answer += 1;
		} else if (st8.equals("n")) {
			answer += 0;
		}
		
		if (st9.equals("y")) {
			answer += 1;
		} else if (st9.equals("n")) {
			answer += 0;
		}
		
		if (st10.equals("y")) {
			answer += 1;
		} else if (st10.equals("n")) {
			answer += 0;
		}
		
		System.out.println("당신은 " + answer + "개의 항목을 선택했습니다.");
		
		if (answer <= 3) {
			System.out.println("3개 이하: 주의! 위험한 수준은 아니지만 관리가 필요함.");
		} else if (answer <= 6) {
			System.out.println("4~6개: 위험! 탄수화물 섭취를 줄이기 위한 식습관 개선이 필요함.");
		} else if (answer >= 7) {
			System.out.println("7개 이상: 중독! 전문의 상담이 필요함.");
		}
		
		
	}

}
