package myGame;

public class Magician {
	static String magicianName;		//이름
	static int maxHp;				//최대 체력
	static int maxMp;				//최대 마나
	static int hp;					//체력
	static int mp;					//마나
	static int att;					//마법공격력
	static int def;					//방어력
	static int level;				//레벨
	static int levelMax;			//최대 레벨
	static int exp;					//경험치
	static Item[] magicianEquip;	//착용아이템
	static GameStart gs = new GameStart();
	
//특성 결정
	Magician(String magicianName, int hp, int mp, int att, int def) {
		this.magicianName = magicianName;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.level = 1;
		this.levelMax = 100;
		this.exp = 0;
		this.magicianEquip = new Item[4];
	}
	
//상태창
	void showInfo(){
		System.out.println("┌───────────────────────────────────┐");
		System.out.println("│             상      태      창                       │");
		System.out.println("├───────────────────────────────────┤");
		System.out.println("│ 이   름 : " + magicianName + "\t\t            │");
		System.out.println("│ 레   벨 : " + level + "\t\t\t    │");
		System.out.println("│ 경험치 : " + exp + "\t\t\t    │");
		System.out.println("│ 체   력 : " + hp + "\t/    " + maxHp + "\t    │");
		System.out.println("│ 마   나 : " + mp + "\t/    " + maxMp + "\t    │");
		System.out.println("│ 공격력 : " + att + "\t\t\t    │");
		System.out.println("│ 방어력 : " + def + "\t\t\t    │");
		System.out.println("├───────────────────────────────────┤");
		System.out.println("│             장      비      창                       │");
		System.out.println("├───────────────────────────────────┤");
		System.out.println("│ 복   장 : " + gs.magicianEquip[0].name + "\t\t    │");
		System.out.println("│ 무   기 : " + gs.magicianEquip[1].name + "\t\t    │");
		System.out.println("│ 방어구 : " + gs.magicianEquip[2].name + "\t\t    │");
		System.out.println("│ 장신구 : " + gs.magicianEquip[3].name + "\t\t    │");
		System.out.println("└───────────────────────────────────┘");
	}
//몬스터 공격	
		void attack1(Goblin g){
			if(hp > 0){
				mp -= 30;
				int damage = att - g.def;
				damage = damage <= 0 ? 1: damage;
				g.hp = g.hp < damage ? 0 : g.hp - damage;
				if(g.hp > 0){
					System.out.println(magicianName + "이 공격으로 " + g.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
					System.out.println(g.name + "의 남은 HP : " + g.hp);
				} else{
					System.out.println(magicianName + "이 공격으로 " + g.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
				}
			} else{
				System.out.println("기절하셨습니다. 공격하실 수 없습니다.");
			}
		}
		void attack2(Orc o){
			if(hp > 0){
				mp -= 30;
				int damage = att - o.def;
				damage = damage <= 0 ? 1: damage;
				o.hp = o.hp < damage ? 0 : o.hp - damage;
				if(o.hp > 0){
					System.out.println(magicianName + "이 공격으로 " + o.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
					System.out.println(o.name + "의 남은 HP : " + o.hp);
				} else{
					System.out.println(magicianName + "이 공격으로 " + o.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
				}
			} else{
				System.out.println("기절하셨습니다. 공격하실 수 없습니다.");
			}
		}
//마왕성 공격			
		void attack3(Darkknight dk){
			if(hp > 0){
				int damage = att - dk.def;
				damage = damage <= 0 ? 1: damage;
				dk.hp = dk.hp < damage ? 0 : dk.hp - damage;
				if(dk.hp > 0){
					System.out.println(magicianName + "가 공격으로 " + dk.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
					System.out.println(dk.name + "의 남은 HP : " + dk.hp);
				} else{
					System.out.println(magicianName + "이 공격으로 " + dk.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
				}	
			} else{
				System.out.println("기절하셨습니다. 공격하실 수 없습니다.");
			}
		}
		void attack4(Darkmagician dm){
			if(hp > 0){
				int damage = att - dm.def;
				damage = damage <= 0 ? 1: damage;
				dm.hp = dm.hp < damage ? 0 : dm.hp - damage;
				if(dm.hp > 0){
					System.out.println(magicianName + "가 공격으로 " + dm.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
					System.out.println(dm.name + "의 남은 HP : " + dm.hp);
				} else{
					System.out.println(magicianName + "이 공격으로 " + dm.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
				}	
			} else{
				System.out.println("기절하셨습니다. 공격하실 수 없습니다.");
			}
			
		}
//경험치획득	
		void getExp(int exp){
			System.out.println(exp + "의 경험치를 획득하였습니다.");
			this.exp += exp;
			while(100 <= this.exp){
				levelUp();
				this.exp -= 100;
			}
		}
//레벨업		
		void levelUp(){
			level++;
			maxHp += 5;
			maxMp += 10;
			att += 2;
			def += 2;
			hp = maxHp;
			mp = maxMp;
			System.out.println("LEVEL UP!!");
			
		}
//여관 회복		
		static void hotelHeal(){
			hp = maxHp;
			mp = maxMp;
		}
}
