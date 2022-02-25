package myGame;

import e_oop.ScanUtil;

public class FinalBattle {
	static GameStart gs = new GameStart();
	
	void finalBattle(){
		System.out.println("마지막 전투가 기다리고 있습니다.");
		System.out.println("마왕에게 도전하시겠습니까?");
		System.out.println("1.도전한다\t2.도전하지 않는다.");
		int input = ScanUtil.nextInt();
		if(input == 1){
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("┌──────────────────────────┐");
			System.out.println("│                          │");
			System.out.println("│                          │");
			System.out.println("│           /| |\\          │");
			System.out.println("│          ( X X )         │");
			System.out.println("│          (  X  )         │");
			System.out.println("│          ─(___)─         │");
			System.out.println("│           /   \\          │");
			System.out.println("│                          │");
			System.out.println("│         O       ▲ @      │");
			System.out.println("│        O|\\/    /|\\│      │");
			System.out.println("│         /\\      /\\│      │");
			System.out.println("│                          │");
			System.out.println("│                          │");
			System.out.println("└──────────────────────────┘");
			System.out.println("============================");
			System.out.println("주인공들은 마왕의 시체를 발견했습니다.");
			System.out.println("이미 오래된 시체로 보입니다.");
			System.out.println("마왕을 흉내낸 진정한 흑막을 찾아주세요.");
			System.out.println();
			System.out.println("영웅들의 여행은 앞으로도 계속됩니다.");
			System.out.println("============================");
			System.out.println("지금까지 <영웅전기I - 여행의 시작 - 마왕의 대적자들>을 즐겨주셔서 감사합니다.");
			System.out.println();
			System.out.println("후속작 <영웅전기II - 진정한 여정 - 흑막을 찾아서>는 이번 가을 출시 예정입니다.");
			System.out.println("자세한 사항은 당사 홈페이지 공지사항을 참고해주세요.");
			System.out.println("링크: https://www.hero-story.co.kr");
			System.out.println("============================");
			System.out.println("이용해주셔서 감사합니다.");
			System.exit(0);
		} else if(input == 2){
			gs.move();
		}
	}
}
