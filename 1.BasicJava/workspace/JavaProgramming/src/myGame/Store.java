package myGame;

import e_oop.ScanUtil;

public class Store {
	static GameStart gs = new GameStart();
//현금부족
	int noMoney;
//구입
	void buyItem(int input) {

		System.out.println(gs.items[input].name + "구입 완료!");
		for(int i = 0; i < gs.inven.length; i++){
			if(gs.inven[i].name == "미사용 공간"){
				gs.inven[i] = gs.items[input];
				break;
			}
		}
	}
//판매
	void sellItem(int input2){
		System.out.println(gs.inven[input2].name + "판매 완료!");
		System.out.println("=========================");
		gs.h.wallet += (int)(gs.inven[input2].price * 0.1);
		gs.inven[input2] = gs.items[16];
	}
//상점	
	void store(){
		System.out.println("=========================");
		System.out.println("상점에 오신 것을 환영합니다.");
		System.out.println("방문하신 목적을 말씀해주세요.");
		System.out.println("1.아이템 구입\t2.아이템 판매\t3.나간다");
		int input = ScanUtil.nextInt();
		buy : switch (input) {
		case 1:
			if (!gs.inven[0].name.equals("미사용 공간") && !gs.inven[1].name.equals("미사용 공간") && !gs.inven[2].name.equals("미사용 공간") && !gs.inven[3].name.equals("미사용 공간") &&
					!gs.inven[4].name.equals("미사용 공간") && !gs.inven[5].name.equals("미사용 공간") && !gs.inven[6].name.equals("미사용 공간") && !gs.inven[7].name.equals("미사용 공간") &&
					!gs.inven[8].name.equals("미사용 공간") && !gs.inven[9].name.equals("미사용 공간")){
				System.out.println("인벤토리가 가득찼습니다.");
				System.out.println("필요없는 물건을 판매한 뒤, 다시 구입해주세요.");
				store();
				break buy;
			}
			System.out.println("원하시는 상품을 선택해주세요.");
			System.out.println("1." + gs.items[6].name + "\t2." + gs.items[7].name + "\t3." + gs.items[8].name);
			System.out.println("4." + gs.items[9].name + "\t5." + gs.items[10].name + "\t6." + gs.items[11].name);
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				System.out.println(gs.items[6].name + "를 구입하시겠습니까?");
				System.out.println(gs.items[6].name + "의 가격은 " + gs.items[6].price + "골드 입니다.");
				System.out.println("1.예\t2.아니오");
				input = ScanUtil.nextInt();
				if(input == 1){
					if(gs.h.wallet >= gs.items[6].price){
						input += 5;
						buyItem(input);
						gs.h.wallet -= gs.items[6].price;
						System.out.println("구입해주셔서 감사합니다.");
						System.out.println("=========================");
						break buy;
					} else if(gs.h.wallet < gs.items[6].price){
						noMoney = gs.items[6].price - gs.h.wallet;
						System.out.println(noMoney + " 골드가 부족합니다.");
						System.out.println("다음에 다시 이용해주세요.");
						System.out.println("=========================");
						break buy;
					} 
				} else if(input == 2){
					System.out.println("이용해주셔서 감사합니다.");
					System.out.println("=========================");
					break buy;
				}
				break buy;
				
			case 2:
				System.out.println(gs.items[7].name + "를 구입하시겠습니까?");
				System.out.println(gs.items[7].name + "의 가격은 " + gs.items[7].price + "골드 입니다.");
				System.out.println("1.예\t2.아니오");
				input = ScanUtil.nextInt();
				if(input == 1){
					if(gs.h.wallet >= gs.items[7].price){
						input += 6;
						buyItem(input);
						gs.h.wallet -= gs.items[7].price;
						System.out.println("구입해주셔서 감사합니다.");
						System.out.println("=========================");
						break buy;
					} else if(gs.h.wallet < gs.items[7].price){
						noMoney = gs.items[7].price - gs.h.wallet;
						System.out.println(noMoney + " 골드가 부족합니다.");
						System.out.println("다음에 다시 이용해주세요.");
						System.out.println("=========================");
						break buy;
					} 
				} else if(input == 2){
					System.out.println("이용해주셔서 감사합니다.");
					System.out.println("=========================");
					break buy;
				}
				break buy;
				
			case 3:
				System.out.println(gs.items[8].name + "를 구입하시겠습니까?");
				System.out.println(gs.items[8].name + "의 가격은 " + gs.items[8].price + "골드 입니다.");
				System.out.println("1.예\t2.아니오");
				input = ScanUtil.nextInt();
				if(input == 1){
					if(gs.h.wallet >= gs.items[8].price){
						input += 7;
						buyItem(input);
						gs.h.wallet -= gs.items[8].price;
						System.out.println("구입해주셔서 감사합니다.");
						System.out.println("=========================");
						break buy;
					} else if(gs.h.wallet < gs.items[8].price){
						noMoney = gs.items[8].price - gs.h.wallet;
						System.out.println(noMoney + " 골드가 부족합니다.");
						System.out.println("다음에 다시 이용해주세요.");
						System.out.println("=========================");
						break buy;
					} 
				} else if(input == 2){
					System.out.println("이용해주셔서 감사합니다.");
					System.out.println("=========================");
					break buy;
				}
				break buy;
				
			case 4:
				System.out.println(gs.items[9].name + "를 구입하시겠습니까?");
				System.out.println(gs.items[9].name + "의 가격은 " + gs.items[9].price + "골드 입니다.");
				System.out.println("1.예\t2.아니오");
				input = ScanUtil.nextInt();
				if(input == 1){
					if(gs.h.wallet >= gs.items[9].price){
						input += 8;
						buyItem(input);
						gs.h.wallet -= gs.items[9].price;
						System.out.println("구입해주셔서 감사합니다.");
						System.out.println("=========================");
						break buy;
					} else if(gs.h.wallet < gs.items[9].price){
						noMoney = gs.items[9].price - gs.h.wallet;
						System.out.println(noMoney + " 골드가 부족합니다.");
						System.out.println("다음에 다시 이용해주세요.");
						System.out.println("=========================");
						break buy;
					} 
				} else if(input == 2){
					System.out.println("이용해주셔서 감사합니다.");
					System.out.println("=========================");
					break buy;
				}
				break buy;
				
			case 5:
				System.out.println(gs.items[10].name + "를 구입하시겠습니까?");
				System.out.println(gs.items[10].name + "의 가격은 " + gs.items[10].price + "골드 입니다.");
				System.out.println("1.예\t2.아니오");
				input = ScanUtil.nextInt();
				if(input == 1){
					if(gs.h.wallet >= gs.items[10].price){
						input += 9;
						buyItem(input);
						gs.h.wallet -= gs.items[10].price;
						System.out.println("구입해주셔서 감사합니다.");
						System.out.println("=========================");
						break buy;
					} else if(gs.h.wallet < gs.items[10].price){
						noMoney = gs.items[10].price - gs.h.wallet;
						System.out.println(noMoney + " 골드가 부족합니다.");
						System.out.println("다음에 다시 이용해주세요.");
						System.out.println("=========================");
						break buy;
					} 
				} else if(input == 2){
					System.out.println("이용해주셔서 감사합니다.");
					System.out.println("=========================");
					break buy;
				}
				break buy;
				
			case 6:
				System.out.println(gs.items[11].name + "를 구입하시겠습니까?");
				System.out.println(gs.items[11].name + "의 가격은 " + gs.items[11].price + "골드 입니다.");
				System.out.println("1.예\t2.아니오");
				input = ScanUtil.nextInt();
				if(input == 1){
					if(gs.h.wallet >= gs.items[11].price){
						input += 10;
						buyItem(input);
						gs.h.wallet -= gs.items[11].price;
						System.out.println("구입해주셔서 감사합니다.");
						System.out.println("=========================");
						break buy;
					} else if(gs.h.wallet < gs.items[11].price){
						noMoney = gs.items[11].price - gs.h.wallet;
						System.out.println(noMoney + " 골드가 부족합니다.");
						System.out.println("다음에 다시 이용해주세요.");
						System.out.println("=========================");
						break buy;
					} 
				} else if(input == 2){
					System.out.println("이용해주셔서 감사합니다.");
					System.out.println("=========================");
					break buy;
				}
				break buy;
			}	
		case 2:
			System.out.println("┌───────────────────────────────────┐");
			System.out.println("│           인     벤     토     리                     │");
			System.out.println("├───────────────────────────────────┤");
			System.out.println("│ 0번 : " + gs.inven[0].name + "\t  5번 : " + gs.inven[5].name + "\t    │");
			System.out.println("│ 1번 : " + gs.inven[1].name + "\t  6번 : " + gs.inven[6].name + "\t    │");
			System.out.println("│ 2번 : " + gs.inven[2].name + "\t  7번 : " + gs.inven[7].name + "\t    │");
			System.out.println("│ 3번 : " + gs.inven[3].name + "\t  8번 : " + gs.inven[8].name + "\t    │");
			System.out.println("│ 4번 : " + gs.inven[4].name + "\t  9번 : " + gs.inven[9].name + "\t    │");
			System.out.println("└───────────────────────────────────┘");
			System.out.println("판매하실 상품을 말씀해주세요.");
			int input2 = ScanUtil.nextInt();
			if(gs.inven[input2].name.equals("미사용 공간")){
				System.out.println("잘못 선택하셨습니다.");
				store();
				break buy;
			}
			if(gs.inven[input2].price == 0){
				System.out.println("판매불가 아이템입니다.");
				store();
				break buy;
			}
			System.out.println(gs.inven[input2].name + "의 가격은 " + (int)(gs.inven[input2].price * 0.1) + " 골드 입니다.");
			System.out.println(gs.inven[input2].name + "을/를 판매하시겠습니까?");
			System.out.println("1.예\t2.아니오");
			input = ScanUtil.nextInt();
			if(input == 1){
				System.out.println("판매해주셔서 감사합니다.");
				sellItem(input2);
				System.out.println("다음에 또 이용해주시길 바랍니다.");
				store();
			} else if(input == 2){
				System.out.println("이용해주셔서 감사합니다.");
				break;
			}
			
			break buy;
		}
	}
}
