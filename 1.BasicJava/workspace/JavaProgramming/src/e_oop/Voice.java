package e_oop;

import e_oop.ScanUtil;

public class Voice {

	public static void main(String[] args) {
		VoiceRecoder vc = new VoiceRecoder();
		while(true) {
			System.out.println("레코더를 실행하시겠습니까?(y/n)");
			
			String select = ScanUtil.nextLine();
			if (select.equals("y") || select.equals("Y") || select.equals("yes") ||select.equals("YES") || select.equals("Yes")) {
				vc.power();
				for (int i = 0; ; i++) {
					select = ScanUtil.nextLine();
					switch (select) {
					case "1":
						vc.record();
						vc.battery();
						vc.body();
						break;
					case "2":
						vc.play();
						vc.battery();
						vc.body();
						break;
					case "3":
						vc.delete();
						vc.body();
						break;
					case "4":
						vc.allDelete();
						vc.body();
						break;
					case "5":
						vc.volumeUp();
						vc.body();
						break;
					case "6":
						vc.volumeDown();
						vc.body();
						break;
					case "0":
						System.out.println("전원을 종료하겠습니다.");
						System.exit(0);
					}
				}
			} else if (select.equals("n") || select.equals("N") || select.equals("no") || select.equals("NO") || select.equals("No")) {
				System.out.println("전원을 종료하겠습니다.");
				System.exit(0);
			} else {
				System.out.println("잘못 선택하셨습니다.");
				System.out.println("다시 선택해주십시오.");
			}
		}
	}

}

class VoiceRecoder {
	//변수
	boolean power;
	String[] record = {"0", "0", "0"};
	int count = 0;
	int volume = 12;
	int volumeMax = 20;
	int volumeMin = 1;
	int charge = 20;
	//카운트
	void count() {
		if (!record[0].equals("0")) {
			count++;
		} else if (record[0].equals("0")) {
			count--;
		}
	}
	//전원
	void power() {
		power = !power;
		if (power) {
			System.out.println("레코더 스위치  On!");
			body();
		}
	}
	//배터리
	void battery() {
		charge--;
		if (0 < charge && charge <= 3) {
			System.out.println("배터리가 부족합니다.");
			System.out.println("충전이 필요합니다.");
		} else if (charge == 0) {
			System.out.println("배터리가 부족합니다.");
			System.out.println("전원을 종료합니다.");
			System.exit(0);
		}
	}
	//녹음
	void record() {
		System.out.println("녹음을 시작하겠습니다.");
		System.out.println("저장할 공간을 선택해주세요.[1/2/3]");
		String select = ScanUtil.nextLine();
		switch(select) {
		case "1":
			if (!record[0].equals("0")){
				System.out.println("이미 녹음된 파일이 있습니다.");
				System.out.println("녹음을 진행하시겠습니까?(y/n)");
				select = ScanUtil.nextLine();
				if (select.equals("y")) {
					System.out.println("1번 공간에 녹음을 시작하겠습니다.");
					record[0] = ScanUtil.nextLine();
					System.out.println("녹음이 완료되었습니다.");
					break;
				} else {
					break;
				}
			} else {
				System.out.println("1번 공간에 녹음을 시작하겠습니다.");
				record[0] = ScanUtil.nextLine();
				System.out.println("녹음이 완료되었습니다.");
				count();
				break;
			}
		case "2":
			if (!record[1].equals("0")){
				System.out.println("이미 녹음된 파일이 있습니다.");
				System.out.println("녹음을 진행하시겠습니까?(y/n)");
				select = ScanUtil.nextLine();
				if (select.equals("y")) {
					System.out.println("2번 공간에 녹음을 시작하겠습니다.");
					record[1] = ScanUtil.nextLine();
					System.out.println("녹음이 완료되었습니다.");
					break;
				} else {
					break;
				}
			} else {
				System.out.println("2번 공간에 녹음을 시작하겠습니다.");
				record[1] = ScanUtil.nextLine();
				System.out.println("녹음이 완료되었습니다.");
				count();
				break;
			}
		case "3":
			if (!record[2].equals("0")){
				System.out.println("이미 녹음된 파일이 있습니다.");
				System.out.println("녹음을 진행하시겠습니까?(y/n)");
				select = ScanUtil.nextLine();
				if (select.equals("y")) {
					System.out.println("3번 공간에 녹음을 시작하겠습니다.");
					record[2] = ScanUtil.nextLine();
					System.out.println("녹음이 완료되었습니다.");
					break;
				} else {
					break;
				}
			} else {
				System.out.println("3번 공간에 녹음을 시작하겠습니다.");
				record[2] = ScanUtil.nextLine();
				System.out.println("녹음이 완료되었습니다.");
				count();
				break;
			}
		}
	}
	//선택삭제
	void delete() {
		System.out.println("삭제를 시작하겠습니다.");
		System.out.println("삭제할 파일을 선택해주세요.[1/2/3]");
		String select = ScanUtil.nextLine();
		switch(select) {
		case "1":
			if (record[0].equals("0")) {
				System.out.println("삭제할 파일이 없습니다.");
				break;
			} else {
				record[0] = "0";
				System.out.println("삭제가 완료되었습니다.");
				count();
				break;
			}
		case "2":
			if (record[1].equals("0")) {
				System.out.println("삭제할 파일이 없습니다.");
				break;
			} else {
				record[1] = "0";
				System.out.println("삭제가 완료되었습니다.");
				count();
				break;
			}
		case "3":
			if (record[2].equals("0")) {
				System.out.println("삭제할 파일이 없습니다.");
				count();
				break;
			} else {
				record[2] = "0";
				System.out.println("삭제가 완료되었습니다.");
				break;
			}
		}
	}
	//전체삭제
	void allDelete() {
		if (record[0].equals("0") && record[1].equals("0") && record[2].equals("0")) {
			System.out.println("삭제할 파일이 없습니다.");
		} else {
			System.out.println("삭제시 복구가 불가능합니다.");
			System.out.println("전체삭제를 진행하시겠습니까?(y/n)");
			String select = ScanUtil.nextLine();
			if (select.equals("y")) {
				for (int i = 0; i < record.length; i++) {
					record[i] = "0";
				}
				count = 0;
				System.out.println("모든 파일이 삭제되었습니다.");
			} else if (select.equals("n")) {
				System.out.println("삭제를 취소합니다.");
			}
			
		}
	}
	//재생
	void play() {
		System.out.println("재생을 시작하겠습니다.");
		System.out.println("재생할 파일을 선택해주세요.(1/2/3)");
		String select = ScanUtil.nextLine();
		switch(select) {
		case "1":
			if (record[0].equals("0")) {
				System.out.println("재생할 파일이 없습니다.");
				break;
			} else {
				System.out.println("1번 파일을 재생하겠습니다.");
				System.out.println(record[0]);
				break;
			}
		case "2":
			if (record[1].equals("0")) {
				System.out.println("재생할 파일이 없습니다.");
				break;
			} else {
				System.out.println("2번 파일을 재생하겠습니다.");
				System.out.println(record[1]);
				break;
			}
		case "3":
			if (record[2].equals("0")) {
				System.out.println("재생할 파일이 없습니다.");
				break;
			} else {
				System.out.println("3번 파일을 재생하겠습니다.");
				System.out.println(record[2]);
				break;
			}
		}
	}
	//볼륨업
	void volumeUp() {
		if (volume < volumeMax) {
			volume++;
		} else if (volume >= volumeMax) {
			System.out.println("최대볼륨입니다.");
		}
	}
	
	//볼륨다운
	void volumeDown() {
		if (volume > volumeMin) {
			volume--;
		} else if (volume <= volumeMin) {
			System.out.println("최저볼륨입니다.");
		}
	}
	//본체
	void body() {
		if(power) {
			System.out.println("┌───────────────┐");
			System.out.println("│  배터리: " + charge + "/20\t│");
			System.out.println("│  녹   음: 0" + count + "/03\t│");
			System.out.println("│  볼   륨: " + volume + "/20\t│");
			System.out.println("│───────────────│");
			System.out.println("│  1. 녹음\t│");
			System.out.println("│  2. 재생\t│");
			System.out.println("│  3. 삭제\t│");
			System.out.println("│  4. 전체삭제\t│");
			System.out.println("│  5. 볼륨 UP\t│");
			System.out.println("│  6. 볼륨 DOWN\t│");
			System.out.println("│  0. 전원\t│");
			System.out.println("└───────────────┘");
			System.out.println("원하는 동작을 입력해주세요.>");
		}
	}
}