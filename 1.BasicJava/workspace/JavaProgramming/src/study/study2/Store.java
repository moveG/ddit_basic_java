package study.study2;

public class Store {

	public static void main(String[] args) {
		Desktop d1 = new Desktop("삼성", 3000);
		Desktop d2 = new Desktop("LG", 2000);
		Aircon1 ac1 = new Aircon1("삼성 에어컨", 20000);
		Aircon1 ac2 = new Aircon1("LG 에어컨", 20000);
		TV tv1 = new TV("삼성 TV", 30000);
		TV tv2 = new TV("LG TV", 30000);
		
		Customer c = new Customer();
		
		c.buy(ac1);
		c.buy(tv1);
		c.showItem();
	}

}

class Product{
	String name;
	int price;
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	String getInfo(){
		return name + "(" + price + "원)";
	}
}

class Desktop extends Product{
	Desktop(String name, int price){
		super(name, price);
	}
	void programming(){
		System.out.println("프로그램 제작");
	}
	
}

class Aircon1 extends Product{
	Aircon1(String name, int price){
		super(name, price);
	}
	
	void setTemperature(){
		System.out.println("온도를 설정합니다.");
	}
}

class TV extends Product{
	TV(String name, int price){
		super(name, price);
	}
	void setCha(){
		System.out.println("채널 변경");
	}
}

class Customer{
	static int money = 1000000;
	
	Product[] item = new Product[10];
	
	void buy(Product p){
		if(money < p.price){
			System.out.println("잔돈이 부족하다.");
			return;
		}
		
		money -= p.price;
		
		for(int i = 0; i < item.length; i++){
			if(item[i] == null){
				item[i] = p;
				break;
			}
		}
		System.out.println(p.getInfo() + "를 구매했다.");
	}
	
	void showItem(){
		System.out.println("========= 장바구니 =========");
		for(int i = 0; i < item.length; i++){
			if(item[i] == null){
				break;
			} else{
				System.out.println(item[i].getInfo());
			}
			
		}
		System.out.println("==========================");
	}
}
