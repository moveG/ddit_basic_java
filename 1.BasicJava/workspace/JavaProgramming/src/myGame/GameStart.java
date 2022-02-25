package myGame;

import e_oop.ScanUtil;

public class GameStart {
	static Hero h;
	static Magician m;
	static Store st;
	static Hotel ht;
	static Equip e;
	Item[] items;
	static Item[] inven;
	static Condition cd;
	static Item[] heroEquip;
	static Item[] magicianEquip;
	static Item[] temp;
	Battle bt;
	
// 캐릭터, 아이템 구현	
	GameStart(){
		st = new Store();
		ht = new Hotel();
		cd = new Condition();
		e= new Equip();
		bt = new Battle();
		
		h = new Hero("히어로", 150, 100, 10, 10, 1500);
		m = new Magician("매지션", 100, 150, 10, 10);
		
		inven = new Item[10];
		heroEquip = new Item[4];
		magicianEquip = new Item[4];
		temp = new Item[1];
		for(int i = 0; i < inven.length; i++) {
			inven[i] = new Item("미사용 공간", 0, 0, 0, 0, 0);
		}
		items = new Item[18];
		items[0] = new Item("용사의 성검", 0, 0, 100, 0, 0);
		items[1] = new Item("용사의 갑옷", 0, 0, 0, 70, 0);
		items[2] = new Item("용사의 방패", 0, 0, 0, 30, 0);
		items[3] = new Item("마법 지팡이", 0, 0, 100, 0, 0);
		items[4] = new Item("마법사 로브", 0, 0, 50, 20, 0);
		items[5] = new Item("마법 서클릿", 0, 0, 30, 0, 0);
		items[6] = new Item("체력의 반지", 20, 0, 0, 0, 300);
		items[7] = new Item("마나의 반지", 0, 20, 0, 0, 300);
		items[8] = new Item("공격의 팔찌", 0, 0, 30, 0, 500);
		items[9] = new Item("방어의 팔찌", 0, 0, 0, 30, 500);
		items[10] = new Item("마공 귀걸이", 0, 0, 30, 0, 500);
		items[11] = new Item("마방 귀걸이", 0, 0, 0, 30, 500);
		items[12] = new Item("초보자 장검", 0, 0, 10, 0, 10);
		items[13] = new Item("초보자 갑옷", 0, 0, 0, 10, 10);
		items[14] = new Item("초보자 완드", 0, 0, 10, 0, 10);
		items[15] = new Item("초보자 로브", 0, 0, 0, 10, 10);
		items[16] = new Item("미사용 공간", 0, 0, 0, 0, 1);
		items[17] = new Item("미사용 공간", 0, 0, 0, 0, 1);
		
	}
//게임 구동
	public static void main(String[] args) {
		new GameStart().start();
	}
//게임 도입부	
	void start(){
		int input = 0;
		e.startEquip();
		System.out.println("<영웅전기I - 여행의 시작 - 마왕의 대적자들>");
		System.out.println("==================================");
		System.out.println("마왕을 물리치고, 세상을 구하세요.");
		while(true){
			System.out.println("당신은 모험가 마을에 머물고 있습니다.");
			System.out.println("행동을 선택하세요.");
			System.out.println("1.상태창\t2.상점\t3.여관\t4.이동\t5.종료");
			input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				h.showInfo();
				m.showInfo();
				e.equip();
				break;
			case 2:
				st.store();
				break;
			case 3:
				ht.hotel();
				break;
			case 4:
				move();
				break;
			case 5:
				System.out.println("게임을 종료하겠습니다.");
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(0);
				break;
			}
		}
	}
//이동	
	void move(){
		int input = 0;
		System.out.println("어디로 이동하시겠습니까?");
		System.out.println("1.마을\t2.사냥터\t3.마왕성");
		input = ScanUtil.nextInt();
		
		switch (input) {
		case 1:
			System.out.println("마을로 다시 귀환합니다.");
			break;
		case 2:
			System.out.println("사냥터로 이동하겠습니다.");
			hunt();
			break;
		case 3:
			System.out.println("마왕성에는 마왕이 거주하고 있습니다.");
			System.out.println("당신의 능력으로는 위험할 수도 있습니다.");
			System.out.println("진심으로 이동하시겠습니까?");
			System.out.println("1.이동한다\t2.이동하지 않는다.");
			input = ScanUtil.nextInt();
			if(input == 1) {
				bt.battle();
			} else if (input == 2) {
				move();
			}
		}
		
	}
//사냥
	void hunt(){
		Goblin g = new Goblin("고블린", 50, 7, 7, 5);
		Orc o = new Orc("오크", 1000, 1000, 10, 10);
		System.out.println(g.name + "과 " + o.name + "를 만났습니다. 전투를 시작합니다.");
		
		int input = 0;
		battle : while(true){
			System.out.println("1.공격\t2.마법\t3.도망");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				System.out.println("어떤 몬스터를 공격하시겠습니까?");				
				System.out.println("1." + g.name + "\t2." + o.name);
				input = ScanUtil.nextInt();
				if(input == 1){
					if(g.hp > 0){
						h.attack1(g);
						if(g.hp <= 0){
							System.out.println(g.name + "을 처치하였습니다.");
							h.getExp(150);
							h.wallet += g.gGolds;
							System.out.println(g.gGolds + " 골드를 획득했습니다.");
						} else if(g.hp > 0){
							g.attack1(h);
							if(h.hp <= 0 && m.hp <= 0){
								cd.condition();
								break battle;
							}
							break;
						}
						if(g.hp <= 0 && o.hp <= 0){
							System.out.println();
							System.out.println("몬스터를 모두 처치하였습니다.");
							System.out.println("마을로 귀환하겠습니다.");
							System.out.println("========================");
							break battle;
						}
						break;
					} else if(g.hp <= 0){
						System.out.println("이미 처치된 몬스터입니다.");
						System.out.println("다시 선택해주세요.");
						break;
					}
					break;
				} else if(input == 2){
					if(o.hp > 0){
						h.attack2(o);
						if(o.hp <= 0){
							System.out.println(o.name + "를 처치하였습니다.");
							h.getExp(150);
							h.wallet += o.oGolds;
							System.out.println(o.oGolds + " 골드를 획득했습니다.");
						} else if(o.hp > 0){
							o.attack1(h);
							if(h.hp <= 0 && m.hp <= 0){
								cd.condition();
								break battle;
							}
							break;
						}
						if(g.hp <= 0 && o.hp <= 0){
							System.out.println();
							System.out.println("몬스터를 모두 처치하였습니다.");
							System.out.println("마을로 귀환하겠습니다.");
							System.out.println("========================");
							break battle;
						}
						break;
					} else if(o.hp <= 0){
						System.out.println("이미 처치된 몬스터입니다.");
						System.out.println("다시 선택해주세요.");
						break;
					}
					break;
				}
			case 2:
				System.out.println(m.magicianName + "은 마법 공격을 시전하였습니다.");
				if(g.hp > 0){
					m.attack1(g);
					if(g.hp <= 0){
						System.out.println(g.name + "을 처치하였습니다.");
						m.getExp(150);
						h.wallet += g.gGolds;
						System.out.println(g.gGolds + " 골드를 획득했습니다.");
					} else {
						g.attack2(m);
						if(h.hp <= 0 && m.hp <= 0){
							cd.condition();
							break battle;
						}
					}
				}
				if(o.hp > 0){
					m.attack2(o);
					if(o.hp <= 0){
						System.out.println(o.name + "를 처치하였습니다.");
						m.getExp(150);
						h.wallet += o.oGolds;
						System.out.println(o.oGolds + " 골드를 획득했습니다.");
					} else {
						o.attack2(m);
						if(h.hp <= 0 && m.hp <= 0){
							cd.condition();
							break battle;
						}
					}
				} 
				if(g.hp <= 0 && o.hp <= 0) {
					System.out.println();
					System.out.println("몬스터를 모두 처치하였습니다.");
					System.out.println("마을로 귀환하겠습니다.");
					System.out.println("========================");
					break battle;
				}
				break;
			case 3:
				System.out.println("도망쳤습니다.");
				break battle;
			}
		}
	}
	
}