package study;

//public class Study_210728 {
//
//}

//class SampleParent {
//	String var;
//	{
//		var = "초기화 블럭은 안 물려줌";
//	}
//	SampleParent(){
//		var = "생성자도 안 물려줌";
//	}
//	int method(int a, int b){
//		return a + b;
//	}
//}

//class SampleChild extends SampleParent {
//	void childMethod(){
//		System.out.println(var);
//		System.out.println(method(7, 3));
//	}
//	@Override
//	int method(int a, int b){
//		return a* b;
//	}
//	int var;
//	void test(double var){
//		System.out.println(var);
//		System.out.println(this.var);
//		System.out.println(super.var);
//		
//		System.out.println(method(10, 20));
//		System.out.println(super.method(10, 20));
//	}
//	SampleChild(){
//		super();
//	}
//	
//	public static void main(String[] args) {
//		SampleChild sc = new SampleChild();
//		SampleParent sp = new SampleChild();
//		sc = (SampleChild)sp;
//		sp = sc;
//		SampleChild sc2 = (SampleChild)new SampleParent();
//	}
//}

//public abstract class SampleAbstractParent {
//	void method(){
//	}
//	abstract void abstractMethod();
//
//class SampleAbstractChild extends SampleAbstractParent {
//
//	void abstractMethod() {
//	}
//}

//class AccessModifier {
//	public String publicVar = "public : 접근제한이 없음";
//	protected String protectedVar = "protected : 같은 패키지 + 상속 받은 클래스에서 접근 가능";
//	String defaultVar = "default : 같은 패키지에서만 접근 가능";
//	private String privateVar = "private : 클래스 내에서만 접근 가능";
//	public void publicMethod(){
//		System.out.println(publicVar);
//	}
//	protected void protectedVar(){
//		System.out.println(protectedVar);
//	}
//	void defaultMethod(){
//		System.out.println(defaultVar);
//	}
//	private void privateMethod(){
//		System.out.println(privateVar);
//	}
//	
//	public static void main(String[] args) {
//		Time t = new Time();
//		t.setHour(23);
//		t.setMinute(59);
//		t.setSecond(5);
//		System.out.println(t.getTime());
//		
//		t.clock();
//	}
//}

//class AccessTest {
//	public static void main(String[] args) {
//		AccessModifier am = new AccessModifier();
//		System.out.println(am.publicVar);
//		am.publicMethod();
//		System.out.println(am.protectedVar);
//		am.protectedMethod();
//		System.out.println(am.defaultVar);
//		am.defaultMethod();
//		System.out.println(am.privateVar);
//		am.privateMethod();
//	}
//}

//class Time {
//	private int hour;
//	private int minute;
//	private int second;
//
//	public int getHour() {
//		return hour;
//	}
//	public void setHour(int hour) {
//		if(hour < 0){
//			this.hour = 0;
//		}else if(24 >= hour){
//			this.hour = hour % 24;
//		}else{
//			this.hour = hour;
//		}
//	}
//	public int getMinute() {
//		return minute;
//	}
//	public void setMinute(int minute) {
//		if(minute < 0){
//			this.minute = 0;
//		}else if(59 < minute){
//			this.minute = minute % 60;
//			setHour(hour + 1);
//		}else{
//			this.minute = minute;
//		}
//	}
//	public int getSecond() {
//		return second;
//	}
//	public void setSecond(int second) {
//		if(second < 0){
//			this.second = 0;
//		}else if(59 < second){
//			this.second = second % 60;
//			setMinute(minute + 1);
//		}else{
//			this.second = second;
//		}
//	}
//	String getTime(){
//		return hour + ":" + minute + ":" + second;
//	}
//	void clock(){
//		while(true){
//			System.out.println(getTime());
//			stop(1000);
//			setSecond(second + 1);
//		}
//	}
//	private void stop(int interval){
//		try {
//			Thread.sleep(interval);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}

//abstract class Animal {
//	abstract void sound();
//}
//
//class Dog extends Animal {
//	@Override
//	void sound() {
//		System.out.println("멍멍!!");
//	}
//}
//class Cat extends Animal {
//	@Override
//	void sound() {
//		System.out.println("야옹~");
//	}
//}
//class Lion extends Animal {
//	@Override
//	void sound() {
//		System.out.println("어흥!!!");
//	}
//}

//class Store {
//	public static void main(String[] args) {
//		Desktop d1 = new Desktop("삼성 컴퓨터", 10000);
//		Desktop d2 = new Desktop("애플 컴퓨터", 10000);
//		AirCon ac1 = new AirCon("삼성 에어컨", 20000);
//		AirCon ac2 = new AirCon("LG 에어컨", 10000);
//		TV tv1 = new TV("삼성TV", 30000);
//		TV tv2 = new TV("애플TV", 40000);
//		Customer c = new Customer();
//		c.buy(d1);
//		c.buy(d2);
//		c.buy(ac1);
//		c.buy(ac2);
//		c.buy(tv1);
//		c.buy(tv2);
//		c.showItem();
//	}
//}

//class Product {
//	String name;
//	int price;
//	Product(String name, int price){
//		this.name = name;
//		this.price = price;
//	}
//	String getInfo(){
//		return name + "(" + price + "원)";
//	}
//}
//class Desktop extends Product{
//	Desktop(String name, int price) {
//		super(name, price);
//	}
//	void programming(){
//		System.out.println("프로그램을 만듭니다.");
//	}
//}
//class AirCon extends Product {
//	AirCon(String name, int price) {
//		super(name, price);
//	}
//	void setTemperature(){
//		System.out.println("온도를 설정합니다.");
//	}
//}
//class TV extends Product {
//	TV(String name, int price) {
//		super(name, price);
//	}
//	void setChannel(){
//		System.out.println("채널을 변경합니다.");
//	}
//
//}
//class Customer {
//	static int money = 1000000;
//	Product[] item = new Product[10];
//	void buy(Product p){
//		if(money < p.price){
//			System.out.println("잔돈부족");
//			return;
//		}
//		money -= p.price;
//		for(int i = 0; i < item.length; i++){
//			if(item[i] == null){
//				item[i] = p;
//				break;
//			}
//		}
//		System.out.println(p.getInfo() + "를 구매했다.");
//	}
//	void showItem(){
//		System.out.println("========= 장바구니 =========");
//		for(int i = 0; i < item.length; i++){
//			if(item[i] == null){
//				break;
//			}else{
//				System.out.println(item[i].getInfo());
//			}
//		}
//		System.out.println("==========================");
//	}
//}






























