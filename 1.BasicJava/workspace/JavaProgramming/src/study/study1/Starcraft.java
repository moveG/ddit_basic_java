package study.study1;

public class Starcraft {

	public static void main(String[] args) {
		Marine marine = new Marine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();
		scv.repair(tank);
		scv.repair(dropship);
		scv.repair(scv);
//		scv.repair(marine);
	}

}

class Unit {
	int hp;
	final int MAX_HP;
	Unit(int hp){
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}

class Marine extends Unit {
	Marine() {
		super(40);
	}
}
class Tank extends Unit implements Repairable {
	Tank(){
		super(150);
	}
}
class Dropship extends Unit implements Repairable {
	Dropship(){
		super(125);
	}
}
class SCV extends Unit implements Repairable {
	SCV(){
		super(60);
	}
	void repair(Repairable r){
		if(r instanceof Unit){//Unit으로 형변환이 가능한지 확인, 가능하면 true이고, 불가능하면 false
			//true라면 if문 안으로 들어와서 실행
			Unit u = (Unit) r;
			while(u.hp < u.MAX_HP){
				u.hp++;
			}
		}
	}
}

interface Repairable {
	//관계가 없던 기계유닛에게 상속을 통해 관계를 만들어줌
}
