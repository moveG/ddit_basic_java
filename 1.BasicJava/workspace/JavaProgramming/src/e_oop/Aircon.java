package e_oop;

import e_oop.ScanUtil;

class Aircon {
//변수
	boolean power;
	boolean turbo;
	int tem = 24;
	int temMax = 32;
	int temMin = 18;
	int wind = 3;
	int windMax = 5;
	int windMin = 1;
	int temp;
	
//메서드
	//전원
	void power() {
		power = !power;
		if (power) {
			System.out.println("에어컨 조작을 시작하겠습니다.");
			remote();
		} else if (!power) {
			System.out.println("전원을 종료하겠습니다.");
		}
	}
	//터보
	void turbo() {
		turbo = !turbo;
		if (turbo) {
			System.out.println("터보모드를 시작하겠습니다.");
			temp = tem;
			tem = temMax;
			temMax = temp;
			temp = wind;
			wind = windMax;
			windMax = temp;
		} else if (!turbo) {
			System.out.println("터보모드를 종료하겠습니다.");
			System.out.println("원래 설정으로 복귀하겠습니다.");
			temp = tem;
			tem = temMax;
			temMax = temp;
			temp = wind;
			wind = windMax;
			windMax = temp;
		}
	}
	
	//온도
	void temUp() {
		if (tem < temMax) {
			tem++;
		} else if (tem >= temMax) {
			System.out.println("!!!!!최대설정온도입니다.!!!!!");
		}
	}
	void temDown() {
		if (tem > temMin) {
			tem--;
		} else if (tem <= temMin) {
			System.out.println("!!!!!최저설정온도입니다.!!!!!");
		}
	}
	//바람강도
	void windUp() {
		if (wind < windMax) {
			wind++;
		} else if (wind >= windMax) {
			System.out.println("!!!!!최대설정강도 입니다.!!!!!");
		}		
	}
	void windDown() {
		if (wind > windMin) {
			wind--;
		} else if (wind <= windMin) {
			System.out.println("!!!!!최저설정강도 입니다.!!!!!");
		}
		
	}
	//리모컨
	void remote() {
		if (power) {
			System.out.println("┌───────────────────────┐");
			System.out.println("│현재 설정온도는 " + tem + "도 입니다.\t│");
			System.out.println("│현재 설정풍속은 0" + wind + " 입니다.\t│");
			System.out.println("│───────────────────────│");
			System.out.println("│  1. 온도 UP\t\t│");
			System.out.println("│  2. 온도 DOWN\t\t│");
			System.out.println("│  3. 풍속 UP\t\t│");
			System.out.println("│  4. 풍속 DOWN\t\t│");
			System.out.println("│  5. 터보모드\t\t│");
			System.out.println("│  6. 전원\t\t│");
			System.out.println("└───────────────────────┘");
			System.out.println("원하는 동작을 입력해주세요.>");
		}
	}
	
	public static void main(String[] args) {
		Aircon ac = new Aircon();
		
			System.out.print("리모컨을 실행하시겠습니까?>");
			
			String str = ScanUtil.nextLine();
			if (str.equals("y")) {
				ac.power();
				for (int i = 0; ; i++) {
					switch (ScanUtil.nextLine()) {
					case "1":
						ac.temUp();
						ac.remote();
						break;
					case "2":
						ac.temDown();
						ac.remote();
						break;
					case "3":
						ac.windUp();
						ac.remote();
						break;
					case "4":
						ac.windDown();
						ac.remote();
						break;
					case "5":
						ac.turbo();
						ac.remote();
						break;
					case "6":
						System.out.println("전원을 종료하겠습니다.");
						System.exit(6);
					}	
				}
			} else if (str.equals("n")) {
				System.out.println("전원을 종료하겠습니다.");
				System.exit(6);
			}
		
		}
		
	

}