package study;

import e_oop.ScanUtil;

public class Study_210721 {

	public static void main(String[] args) {
		Aircon ac = new Aircon();
		
		while(true) {
			System.out.print("리모컨을 조작하시겠습니까? y/n>");
			String on = ScanUtil.nextLine(); 
			if (on.equals("y")) {
				ac.power();
			
				for (int i = 0; ; i++){
			
					switch (ScanUtil.nextInt()) {
					case 1:
						ac.temup();
						ac.remote();
						break;
					case 2:
						ac.temdown();
						ac.remote();
						break;
					case 3:
						ac.windup();
						ac.remote();
						break;
					case 4:
						ac.winddown();
						ac.remote();
						break;
					case 5:
						ac.wpup();
						ac.remote();
						break;
					case 6:
						ac.wpdown();
						ac.remote();
						break;
					case 7:
						ac.turbo();
						ac.remote();
						break;
					case 8:
						ac.power();
						break;
					}
				}
			} else if (on.equals("n")) {
				System.out.println("전원을 종료하겠습니다.");
				break;
			}
		}
	}
}

class Aircon {
//변수	
	boolean power;
	boolean turbo;
	
	String[] wpname = {"약", "중", "강"};
	int tem = 24;
	int temmax = 32;
	int temmin = 18;
	int wind = 2;
	int windmax = 5;
	int windmin = 1;
	int wp = 1;
	int wpmax = 2;
	int wpmin = 0;
	
	
//메서드
	//전원
	void power() {
		power = !power;
		if (power) {
			System.out.println("에어컨 전원을 켜겠습니다.");
			remote();
		} else if (!power) {
			System.out.println("전원을 종료하겠습니다.");
		}
	}
	
	//온도
	void temup() {
		if (tem < temmax) {
			tem++;
//			System.out.println("현재 온도는 " + tem + "도 입니다.");
		} else if (tem >= temmax) {
//			System.out.println("현재 온도는 " + tem + "도 입니다.");
			System.out.println("최고 온도입니다.");
		}
	}
	
	void temdown() {
		if (tem > temmin) {
			tem--;
//			System.out.println("현재 온도는 " + tem + "도 입니다.");
		} else if (tem <= temmin) {
//			System.out.println("현재 온도는 " + tem + "도 입니다.");
			System.out.println("최저 온도입니다.");
		}
	}
	
	//풍량
	void windup() {
		if (wind < windmax) {
			wind++;
			System.out.println("현재 풍량은 " + wind + "입니다.");
		} else if (wind >= windmax) {
			System.out.println("현재 풍량은 " + wind + "입니다.");
			System.out.println("최대 풍량입니다.");
		}
	}
	void winddown() {
		if (wind > windmin) {
			wind--;
			System.out.println("현재 풍량은 " + wind + "입니다.");
		} else if (wind <= windmin) {
			System.out.println("현재 풍량은 " + wind + "입니다.");
			System.out.println("최저 풍량입니다.");
		}
	}	
	
	//풍속
	void wpup() {
		if (wp < wpmax) {
			wp++;
			System.out.println("현재 풍속은 " + wpname[wp] +"풍입니다.");
		} else if (wp >= wpmax) {
			System.out.println("더이상 올릴 수 없습니다.");
		}
	}
	void wpdown() {
		if (wp > wpmin) {
			wp--;
			System.out.println("현재 풍속은 " + wpname[wp] +"풍입니다.");
		} else if (wp <= wpmin) {
			System.out.println("더이상 내릴 수 없습니다.");
		}
	}
	
	//터보모드	
	void turbo() {
		turbo = !turbo;
		if (turbo) {
			System.out.println("터보모드를 시작합니다.");
			int temp = tem;
			tem = temmax;
			temmax = temp;
			temp = wind;
			wind = windmax;
			windmax = temp;
			System.out.println("터보모드 온도는 " + tem + "도 이고, 풍량은 " + wind + " 입니다.");
		} else {
			System.out.println("터보모드를 종료합니다.");
			int temp = tem;
			tem = temmax;
			temmax = temp;
			temp = wind;
			wind = windmax;
			windmax = temp;
			System.out.println("현재 설정 온도는 " + tem + "도 이고, 풍량은 " + wind + " 입니다.");
		}
	}

	//리모컨
	void remote() {
		if (power) {
			System.out.println("-------------------------");
			System.out.println("|현재 온도는 " + tem + "도 입니다.\t|");
			System.out.println("|현재 풍량은 0" + wind + " 입니다.\t|");
			System.out.println("|현재 풍속은 " + wpname[wp] + "속 입니다.\t|");
			System.out.println("|-----------------------|");
			System.out.println("|  1. 온도 올리기\t\t|");
			System.out.println("|  2. 온도 내리기\t\t|");
			System.out.println("|  3. 풍량 올리기\t\t|");
			System.out.println("|  4. 풍량 내리기\t\t|");
			System.out.println("|  5. 풍속 올리기\t\t|");
			System.out.println("|  6. 풍속 내리기\t\t|");			
			System.out.println("|  7. 터보모드\t\t|");
			System.out.println("|  8. 전원\t\t|");
			System.out.println("-------------------------");
			System.out.println("숫자를 입력해주세요.>");
		}
	}
		
}