package myGame;

public class Darkknight {
	String name;//이름
	int maxHp;	//최대체력
	int hp;		//체력
	int att;	//공격력
	int def;	//방어력
	int dkGolds;	//보유 골드
	Item[] items;	//보유아이템
	
	Darkknight(String name, int hp, int att, int def, int dgolds, Item[] items){
		this.name = name;
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.att = att;
		this.def = def;
		this.dkGolds = 300;
		this.items = items;
	}
	
	void attack1(Hero h){
		if(h.hp > 0) {
			int damage = att - h.def;
			damage = damage <= 0 ? 1: damage;
			h.hp = h.hp < damage ? 0 : h.hp - damage;
			System.out.println(name + "이 공격으로 " + h.heroName + "에게 " + damage + "만큼 데미지를 주었습니다.");
			System.out.println(h.heroName + "의 남은 HP : " + h.hp);
		}
	}
	void attack2(Magician m){
		if(m.hp > 0) {
			int damage = att - m.def;
			damage = damage <= 0 ? 1: damage;
			m.hp = m.hp < damage ? 0 : m.hp - damage;
			System.out.println(name + "이 공격으로 " + m.magicianName + "에게 " + damage + "만큼 데미지를 주었습니다.");
			System.out.println(m.magicianName + "의 남은 HP : " + m.hp);
		}
	}
	
	Item itemDrop1(){
		return items[(int)(Math.random() * items.length)];
	}
	
}
