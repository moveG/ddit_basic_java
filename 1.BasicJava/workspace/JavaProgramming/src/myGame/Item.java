package myGame;

public class Item {

	String name;		//이름
	int hp;				//체력
	int mp;				//마나
	int att;			//공격력
	int def;			//방어력
	int price;			//가격
	
	
	Item(String name, int hp, int mp, int att, int def, int price){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def = def;
		this.price = price;
	}

}