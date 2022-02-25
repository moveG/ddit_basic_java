package myGame;

public class Hotel {
//상태회복
	void hotel(){
		if(Hero.wallet >= 3){
			System.out.println("여관에 도착했습니다.");
			System.out.println("여관비로 3골드를 지불했습니다.");
			System.out.println("휴식으로 상태가 회복되었습니다.");
			System.out.println("========================");
			Magician.hotelHeal();
			Hero.hotelHeal();
		} else if(Hero.wallet < 3){
			System.out.println("현금이 부족합니다.");
			System.out.println("여관을 이용할 수 없습니다.");
			System.out.println("========================");
		}
		
	}
}
