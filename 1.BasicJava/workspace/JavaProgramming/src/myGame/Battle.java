package myGame;

import e_oop.ScanUtil;

public class Battle {
	static GameStart gs = new GameStart();
	static FinalBattle fb = new FinalBattle();
	
	void battle(){
		Darkknight dk = new Darkknight("다크나이트", 1, 100, 100, 300, new Item[]{gs.items[0], gs.items[1], gs.items[2], gs.items[6], gs.items[7], gs.items[8], gs.items[9],
				                                                           gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17],
				                                                           gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17],
				                                                           gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17]});
		Darkmagician dm = new Darkmagician("다크매지션", 1, 120, 80, 300, new Item[]{gs.items[3], gs.items[4], gs.items[5], gs.items[6], gs.items[7], gs.items[10], gs.items[11],
				                                                               gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17],
				                                                               gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17],
				                                                               gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17],
				                                                               gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17], gs.items[17]});
		System.out.println(dk.name + "와 " + dm.name + "을 만났습니다. 전투를 시작합니다.");
		
		int input = 0;
		battle : while(true){
			System.out.println("1.공격\t2.마법\t3.후퇴");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				System.out.println("어떤 상대를 공격하시겠습니까?");				
				System.out.println("1." + dk.name + "\t2." + dm.name);
				input = ScanUtil.nextInt();
				if(input == 1){
					if(dk.hp > 0){
						gs.h.attack3(dk);
						if(dk.hp <= 0){
							System.out.println(dk.name + "를 처치하였습니다.");
							gs.h.getExp(150);
							gs.h.wallet += dk.dkGolds;
							System.out.println(dk.dkGolds + " 골드를 획득했습니다.");
							if (!gs.inven[0].name.equals("미사용 공간") && !gs.inven[1].name.equals("미사용 공간") && !gs.inven[2].name.equals("미사용 공간") && !gs.inven[3].name.equals("미사용 공간") &&
									!gs.inven[4].name.equals("미사용 공간") && !gs.inven[5].name.equals("미사용 공간") && !gs.inven[6].name.equals("미사용 공간") && !gs.inven[7].name.equals("미사용 공간") &&
									!gs.inven[8].name.equals("미사용 공간") && !gs.inven[9].name.equals("미사용 공간")){
								System.out.println("인벤토리가 가득찼습니다.");
								System.out.println("아이템을 획득할 수 없습니다.");
							} else {
								gs.h.getItem(dk.itemDrop1());
							}
						} else if(dk.hp > 0){
							dk.attack1(gs.h);
							if(gs.h.hp <= 0 && gs.m.hp <= 0){
								gs.cd.condition2();
								break battle;
							}
							break;
						}
						if(dk.hp <= 0 && dm.hp <= 0){
							System.out.println();
							System.out.println("상대를 모두 처치하였습니다.");
							System.out.println("========================");
							break battle;
						}
						break;
					} else if(dk.hp <= 0){
						System.out.println("이미 처치된 상대입니다.");
						System.out.println("다시 선택해주세요.");
						break;
					}
					break;
				} else if(input == 2){
					if(dm.hp > 0){
						gs.h.attack4(dm);
						if(dm.hp <= 0){
							System.out.println(dm.name + "을 처치하였습니다.");
							gs.h.getExp(150);
							gs.h.wallet += dm.dmGolds;
							System.out.println(dm.dmGolds + " 골드를 획득했습니다.");
							if (!gs.inven[0].name.equals("미사용 공간") && !gs.inven[1].name.equals("미사용 공간") && !gs.inven[2].name.equals("미사용 공간") && !gs.inven[3].name.equals("미사용 공간") &&
									!gs.inven[4].name.equals("미사용 공간") && !gs.inven[5].name.equals("미사용 공간") && !gs.inven[6].name.equals("미사용 공간") && !gs.inven[7].name.equals("미사용 공간") &&
									!gs.inven[8].name.equals("미사용 공간") && !gs.inven[9].name.equals("미사용 공간")){
								System.out.println("인벤토리가 가득찼습니다.");
								System.out.println("아이템을 획득할 수 없습니다.");
							} else {
								gs.h.getItem(dm.itemDrop2());
							}
						} else if(dm.hp > 0){
							dm.attack1(gs.h);
							if(gs.h.hp <= 0 && gs.h.hp <= 0){
								gs.cd.condition2();
								break battle;
							}
							break;
						}
						if(dk.hp <= 0 && dm.hp <= 0){
							System.out.println();
							System.out.println("상대를 모두 처치하였습니다.");
							System.out.println("========================");
							fb.finalBattle();
							break battle;
						}
						break;
					} else if(dm.hp <= 0){
						System.out.println("이미 처치된 상대입니다.");
						System.out.println("다시 선택해주세요.");
						break;
					}
					break;
				}
			case 2:
				System.out.println(gs.m.magicianName + "은 마법 공격을 시전하였습니다.");
				if(dk.hp > 0){
					gs.m.attack3(dk);
					if(dk.hp <= 0){
						System.out.println(dk.name + "를 처치하였습니다.");
						gs.m.getExp(150);
						gs.h.wallet += dk.dkGolds;
						System.out.println(dk.dkGolds + " 골드를 획득했습니다.");
						if (!gs.inven[0].name.equals("미사용 공간") && !gs.inven[1].name.equals("미사용 공간") && !gs.inven[2].name.equals("미사용 공간") && !gs.inven[3].name.equals("미사용 공간") &&
								!gs.inven[4].name.equals("미사용 공간") && !gs.inven[5].name.equals("미사용 공간") && !gs.inven[6].name.equals("미사용 공간") && !gs.inven[7].name.equals("미사용 공간") &&
								!gs.inven[8].name.equals("미사용 공간") && !gs.inven[9].name.equals("미사용 공간")){
							System.out.println("인벤토리가 가득찼습니다.");
							System.out.println("아이템을 획득할 수 없습니다.");
						} else {
							gs.h.getItem(dk.itemDrop1());
						}
						System.out.println("=========================");
					} else {
						dk.attack2(gs.m);
						if(gs.h.hp <= 0 && gs.m.hp <= 0){
							gs.cd.condition2();
							break battle;
						}
					}
				}
				if(dm.hp > 0){
					gs.m.attack4(dm);
					if(dm.hp <= 0){
						System.out.println(dm.name + "을 처치하였습니다.");
						gs.m.getExp(150);
						gs.h.wallet += dm.dmGolds;
						System.out.println(dm.dmGolds + " 골드를 획득했습니다.");
						if (!gs.inven[0].name.equals("미사용 공간") && !gs.inven[1].name.equals("미사용 공간") && !gs.inven[2].name.equals("미사용 공간") && !gs.inven[3].name.equals("미사용 공간") &&
								!gs.inven[4].name.equals("미사용 공간") && !gs.inven[5].name.equals("미사용 공간") && !gs.inven[6].name.equals("미사용 공간") && !gs.inven[7].name.equals("미사용 공간") &&
								!gs.inven[8].name.equals("미사용 공간") && !gs.inven[9].name.equals("미사용 공간")){
							System.out.println("인벤토리가 가득찼습니다.");
							System.out.println("아이템을 획득할 수 없습니다.");
						} else {
							gs.h.getItem(dm.itemDrop2());
						}
					} else {
						dm.attack2(gs.m);
						if(gs.h.hp <= 0 && gs.m.hp <= 0){
							gs.cd.condition2();
							break battle;
						}
					}
				} 
				if(dk.hp <= 0 && dm.hp <= 0) {
					System.out.println();
					System.out.println("상대를 모두 처치하였습니다.");
					System.out.println("========================");
					fb.finalBattle();
					break battle;
				}
				break;
			case 3:
				System.out.println("후퇴하였습니다.");
				System.out.println("========================");
				break battle;
			}
		}
	}
}
