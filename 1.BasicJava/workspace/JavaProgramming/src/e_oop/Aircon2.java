package e_oop;

import e_oop.ScanUtil;

public class Aircon2 {
//전원
		boolean power;
		void power() {
			power = !power;
			System.out.println(power ? "전원이 켜졌습니다." : "전원이 꺼졌습니다.");
		}

//온도		
		int temperature = 24;
		final int MIN_TEMP = 18;
		final int MAX_TEMP = 30;
		//앞에 final을 붙이면 변수가 변경이 불가능한 상수가 된다. 상수의 이름은 전부 대문자로 해준다.
		
		void tempUp() {
			if (power) {
				if(temperature < MAX_TEMP) {
					temperature++;
				}
				System.out.println("설정 온도: " + temperature + "도");
			}
		}
		void tempDown() {
			if (power) {
				if(temperature > MIN_TEMP) {
					temperature--;
				}
				System.out.println("설정 온도: " + temperature + "도");
			}
		}
		
//바람세기
		final String[] WINDARR = {"미풍", "약풍", "강풍", "터보"};
		int windIndex = 2;
		
		void wind() {
			if (power) {
				windIndex++;
				if (WINDARR.length <= windIndex) {
					windIndex = 0;
				}
				System.out.println("바람 세기: " + WINDARR[windIndex]);
			}
		}
		
		
		public static void main(String[] args) {
			Aircon2 ac = new Aircon2();
			while(true) {
				System.out.println("1.전원\t2.온도+\t3.온도-\t4.바람세기");
				int input = ScanUtil.nextInt();
				switch (input) {
				case 1:
					ac.power();
					break;
				case 2:
					ac.tempUp();
					break;
				case 3:
					ac.tempDown();
					break;
				case 4:
					ac.wind();
					break;
					
				case 0:
					System.exit(0);
				}
			}
		}
}
