package myGame;

public class Condition {
	static GameStart gs = new GameStart();
//몬스터 기절	
	void condition(){
		System.out.println("전투에서 패배하였습니다.");
		System.out.println("========================");
		if(Hero.wallet >= 3){
			System.out.println("소지금의 20%를 분실하셨습니다.");
			Hero.wallet -= (int)Hero.wallet * 0.2;
			Magician.hotelHeal();
			Hero.hotelHeal();
			System.out.println("마을로 귀환하겠습니다.");
			System.out.println("========================");
		} else if(Hero.wallet < 3){
			System.out.println("현금이 부족해 회복할 수 없습니다.");
			System.out.println("용사파티는 전멸하였습니다.");
			System.out.println("세상은 악의 세력에 의해 정복되었습니다.");
			System.out.println("<<<<<<< BAD END >>>>>>>");
			System.out.println("게임종료...");
			System.exit(0);
		}
	}
//마왕성 기절
	void condition2(){
		System.out.println("전투에서 패배하였습니다.");
		if(gs.h.wallet >= 3){
			System.out.println("소지금의 50%를 분실하셨습니다.");
			Hero.wallet -= (int)Hero.wallet * 0.5;
			Magician.hotelHeal();
			Hero.hotelHeal();
			System.out.println("마을로 귀환하겠습니다.");
			System.out.println("========================");
		} else if(gs.h.wallet < 3){
			System.out.println("현금이 부족해 회복할 수 없습니다.");
			System.out.println("용사파티는 전멸하였습니다.");
			System.out.println("세상은 악의 세력에 의해 정복되었습니다.");
			System.out.println("<<<<<<< BAD END >>>>>>>");
			System.out.println("게임종료...");
			System.exit(0);
		}
	}

}
