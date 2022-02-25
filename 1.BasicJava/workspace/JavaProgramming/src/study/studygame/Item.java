package study.studygame;

public class Item {
//변수
	String name;	//이름
	int hp;			//체력
	int mp;			//마나
	int att;		//공격력
	int def;		//방어력
//생성자	
	Item(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def = def;
	}
//메서드(String 타입)	
	String itemInfo(){
		String info = name + " :";
		if(0 < hp) info += " 체력+" + hp;
		if(0 < mp) info += " 마나+" + mp;
		if(0 < att) info += " 공격+" + att;
		if(0 < def) info += " 방어+" + def;
		return info;
	}
}