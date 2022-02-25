package myGame;

import e_oop.ScanUtil;

public class Equip {
	static GameStart gs = new GameStart();
//기초장비 착용	
	void startEquip(){
		gs.heroEquip[0] = gs.items[12];
		gs.heroEquip[1] = gs.items[13];
		gs.heroEquip[2] = gs.items[17];
		gs.heroEquip[3] = gs.items[17];
		gs.magicianEquip[0] = gs.items[14];
		gs.magicianEquip[1] = gs.items[15];
		gs.magicianEquip[2] = gs.items[17];
		gs.magicianEquip[3] = gs.items[17];

		for(int i = 0; i < 2; i++){
			gs.h.maxHp += gs.heroEquip[i].hp;
			gs.h.maxMp += gs.heroEquip[i].mp;
			gs.h.att += gs.heroEquip[i].att;
			gs.h.def += gs.heroEquip[i].def;
			gs.m.maxHp += gs.magicianEquip[i].hp;
			gs.m.maxMp += gs.magicianEquip[i].mp;
			gs.m.att += gs.magicianEquip[i].att;
			gs.m.def += gs.magicianEquip[i].def;
		}
	}
//장비착용	
	void equip(){
		System.out.println("장비를 착용하시겠습니까?");
		System.out.println("1.예\t2.아니오");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			System.out.println("누구의 장비를 착용하시겠습니까?");
			System.out.println("1.히어로\t2.매지션");
			input = ScanUtil.nextInt();
			if(input == 1){
				System.out.println("인벤토리에서 착용할 장비를 선택해주세요.");
				input = ScanUtil.nextInt();
				if(gs.inven[input].name.equals(gs.items[0].name)){
					gs.h.maxHp -= gs.heroEquip[0].hp;
					gs.h.maxMp -= gs.heroEquip[0].mp;
					gs.h.att -= gs.heroEquip[0].att;
					gs.h.def -= gs.heroEquip[0].def;
					
					gs.temp[0] = gs.heroEquip[0];
					gs.heroEquip[0] = gs.inven[input];
					gs.inven[input] = gs.temp[0];
					System.out.println("장비를 착용했습니다.");
					
					gs.h.maxHp += gs.heroEquip[0].hp;
					gs.h.maxMp += gs.heroEquip[0].mp;
					gs.h.att += gs.heroEquip[0].att;
					gs.h.def += gs.heroEquip[0].def;
					System.out.println("========================");
				} else if(gs.inven[input].name.equals(gs.items[1].name)){
					gs.h.maxHp -= gs.heroEquip[1].hp;
					gs.h.maxMp -= gs.heroEquip[1].mp;
					gs.h.att -= gs.heroEquip[1].att;
					gs.h.def -= gs.heroEquip[1].def;
					
					gs.temp[0] = gs.heroEquip[1];
					gs.heroEquip[1] = gs.inven[input];
					gs.inven[input] = gs.temp[0];
					System.out.println("장비를 착용했습니다.");
					
					gs.h.maxHp += gs.heroEquip[1].hp;
					gs.h.maxMp += gs.heroEquip[1].mp;
					gs.h.att += gs.heroEquip[1].att;
					gs.h.def += gs.heroEquip[1].def;
					System.out.println("========================");
				} else if(gs.inven[input].name.equals(gs.items[2].name)){
					gs.h.maxHp -= gs.heroEquip[2].hp;
					gs.h.maxMp -= gs.heroEquip[2].mp;
					gs.h.att -= gs.heroEquip[2].att;
					gs.h.def -= gs.heroEquip[2].def;
					
					gs.temp[0] = gs.heroEquip[2];
					gs.heroEquip[2] = gs.inven[input];
					gs.inven[input] = gs.temp[0];
					System.out.println("장비를 착용했습니다.");
					
					gs.h.maxHp += gs.heroEquip[2].hp;
					gs.h.maxMp += gs.heroEquip[2].mp;
					gs.h.att += gs.heroEquip[2].att;
					gs.h.def += gs.heroEquip[2].def;
					System.out.println("========================");
				} else if(gs.inven[input].name.equals(gs.items[16].name)){
					System.out.println("착용할 장비가 없습니다.");
					System.out.println("========================");
					break;
				} else{
					gs.h.maxHp -= gs.heroEquip[3].hp;
					gs.h.maxMp -= gs.heroEquip[3].mp;
					gs.h.att -= gs.heroEquip[3].att;
					gs.h.def -= gs.heroEquip[3].def;
					
					gs.temp[0] = gs.heroEquip[3];
					gs.heroEquip[3] = gs.inven[input];
					gs.inven[input] = gs.temp[0];
					System.out.println("장비를 착용했습니다.");
					
					gs.h.maxHp += gs.heroEquip[3].hp;
					gs.h.maxMp += gs.heroEquip[3].mp;
					gs.h.att += gs.heroEquip[3].att;
					gs.h.def += gs.heroEquip[3].def;
					System.out.println("========================");
				}
			} else if (input == 2){
				System.out.println("인벤토리에서 착용할 장비를 선택해주세요.");
				input = ScanUtil.nextInt();
				if(gs.inven[input].name.equals(gs.items[3].name)){
					gs.m.maxHp -= gs.magicianEquip[0].hp;
					gs.m.maxMp -= gs.magicianEquip[0].mp;
					gs.m.att -= gs.magicianEquip[0].att;
					gs.m.def -= gs.magicianEquip[0].def;
					
					gs.temp[0] = gs.magicianEquip[0];
					gs.magicianEquip[0] = gs.inven[input];
					gs.inven[input] = gs.temp[0];
					System.out.println("장비를 착용했습니다.");
					
					gs.m.maxHp += gs.magicianEquip[0].hp;
					gs.m.maxMp += gs.magicianEquip[0].mp;
					gs.m.att += gs.magicianEquip[0].att;
					gs.m.def += gs.magicianEquip[0].def;
					System.out.println("========================");
				} else if(gs.inven[input].name.equals(gs.items[4].name)){
					gs.m.maxHp -= gs.magicianEquip[1].hp;
					gs.m.maxMp -= gs.magicianEquip[1].mp;
					gs.m.att -= gs.magicianEquip[1].att;
					gs.m.def -= gs.magicianEquip[1].def;
					
					gs.temp[0] = gs.magicianEquip[1];
					gs.magicianEquip[1] = gs.inven[input];
					gs.inven[input] = gs.temp[0];
					System.out.println("장비를 착용했습니다.");
					
					gs.m.maxHp += gs.magicianEquip[1].hp;
					gs.m.maxMp += gs.magicianEquip[1].mp;
					gs.m.att += gs.magicianEquip[1].att;
					gs.m.def += gs.magicianEquip[1].def;
					System.out.println("========================");
				} else if(gs.inven[input].name.equals(gs.items[5].name)){
					gs.m.maxHp -= gs.magicianEquip[2].hp;
					gs.m.maxMp -= gs.magicianEquip[2].mp;
					gs.m.att -= gs.magicianEquip[2].att;
					gs.m.def -= gs.magicianEquip[2].def;
					
					gs.temp[0] = gs.magicianEquip[2];
					gs.magicianEquip[2] = gs.inven[input];
					gs.inven[input] = gs.temp[0];
					System.out.println("장비를 착용했습니다.");
					
					gs.m.maxHp += gs.magicianEquip[2].hp;
					gs.m.maxMp += gs.magicianEquip[2].mp;
					gs.m.att += gs.magicianEquip[2].att;
					gs.m.def += gs.magicianEquip[2].def;
					System.out.println("========================");
				} else if(gs.inven[input].name.equals(gs.items[16].name)){
					System.out.println("착용할 장비가 없습니다.");
					System.out.println("========================");
					break;
				} else{gs.temp[0] = gs.magicianEquip[3];
				gs.m.maxHp -= gs.magicianEquip[3].hp;
				gs.m.maxMp -= gs.magicianEquip[3].mp;
				gs.m.att -= gs.magicianEquip[3].att;
				gs.m.def -= gs.magicianEquip[3].def;
				
				gs.temp[0] = gs.magicianEquip[3];
				gs.magicianEquip[3] = gs.inven[input];
				gs.inven[input] = gs.temp[0];
				System.out.println("장비를 착용했습니다.");
				
				gs.m.maxHp += gs.magicianEquip[3].hp;
				gs.m.maxMp += gs.magicianEquip[3].mp;
				gs.m.att += gs.magicianEquip[3].att;
				gs.m.def += gs.magicianEquip[3].def;
				System.out.println("========================");
				}
			}
		case 2:
			break;
		}
		
	}
}
