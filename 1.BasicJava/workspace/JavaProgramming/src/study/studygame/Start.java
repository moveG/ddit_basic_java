package study.studygame;

import e_oop.ScanUtil;

public class Start {
//클래스 선언
//	Hunt h = new Hunt();
	MyGame mg = new MyGame();
	
	void start(){
		int input = 0;
		while(true){
			System.out.println("1.내정보\t2.사냥\t3.종료");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				mg.c.showInfo();
				break;
			case 2:
				mg.hunt();
				break;
			case 3:
				System.out.println("종료되었습니다.");
				System.exit(3);
				break;
			}
		}
	}
}