package study;

import java.util.Arrays;

public class Study_210727 {
	public static void main(String[] args) {
		
	}
}

//class Student {
//	int kor;
//	int eng;
//	int math;
//	int sum;
//	double avg;
//	String name;
//	int rank;
//
//Student st = new Student();
//st.kor = 80;
//st.eng = 90;
//st.math = 100;
//st.sum = st.kor + st.eng + st.math;
//st.avg = (double)st.sum / 3.0;
//st.name = "고길동";
//st.rank = 3;
//System.out.println(st.name);
//System.out.println(st.rank);
//System.out.println(st.sum);
//System.out.println(st.avg);
//}

//class SampleClass {
//	String method1(int a){
//		return a + "을 받아 명령을 수행하고 결과물을 리턴하는 메서드";
//	}
//	void method2(){
//		System.out.println("파라미터도 리턴타입도 없는 메서드");
//
//SampleClass sc = new SampleClass();
//System.out.println(sc.method1(300));
//String returnValue1 = sc.method1(100);
//System.out.println(returnValue1);
//sc.method2();
//	}
//}

//class ClassMaker {
//	String field = "abab";
//	void method1(){
//		System.out.println(field);
//	}
//	String method2(){
//		return field;
//	}
//	void method3(int a){
//		System.out.println(a);
//	}
//	int method4(int a, int b){
//		return a + b;
//ClassMaker cm = new ClassMaker();
//System.out.println(cm.field);
//cm.method1();
//System.out.println(cm.method2());
//String b = cm.method2();
//System.out.println(b);
//cm.method3(3);
//System.out.println(cm.method4(4, 3));
//int cc = cm.method4(4, 3);
//System.out.println(cc);
//	}
//}

//class Calculator {
//	double plus(double a, double b){
//		return a + b;
//	}
//	double minus(double a, double b){
//		return a - b;
//	}
//	double multiply(double a, double b){
//		return a * b;
//	}
//	double divide(double a, double b){
//		return a / b;
//	}
//	double mod(double a, double b){
//		return a % b;
//	}
//
//	Calculator c = new Calculator();
//	double result = c.plus(123456, 654321);
//	System.out.println(result);
//	result = c.multiply(result, 123456);
//	System.out.println(result);
//	result = c.divide(result, 123456);
//	System.out.println(result);
//	result = c.minus(result, 654321);
//	System.out.println(result);
//	result = c.mod(result, 123456);
//	System.out.println((int)result);
//}

//class Saram {
//	String name;
//	int account;
//	void saveMoney(int money){
//		account += money;
//		System.out.println(name + "의 계좌 잔고: " + account);
//	}
//	static int dateAccount;
//	void saveDateMoney(int money){
//		dateAccount += money;
//		System.out.println("데이트 계좌 잔고: " + dateAccount);
//	}
//	
//	Saram s1 = new Saram();
//	Saram s2 = new Saram();
//	s1.name = "철수";
//	s2.name = "영희";
//	s1.saveMoney(10000);
//	s2.saveMoney(20000);
//	s1.saveDateMoney(10000);
//	s2.saveDateMoney(3000);
//	Saram.dateAccount = 0;
//	s1.saveDateMoney(10000);
//}

//class Alba {
//	String[] order(){
//		System.out.println("주문하시겠습니까?");
//		return (new String[] {"짜장면", "짬뽕"});
//	}
//	void serving(String[] foods){
//		System.out.println(Arrays.toString(foods) + " 나왔습니다.");
//		System.out.println("맛점");
//	}
//	void pay(String[] order){
//		System.out.println("돈내");
//	}
//
//	Alba a = new Alba();
//	String[] od = a.order();
//	System.out.println(Arrays.toString(od));
//	String[] f = {"완성짜", "완성짬"};
//	a.serving(f);
//	System.out.println();
//	a.pay(od);
//}

//class VariableInit {
//	int var = 10;
//	static int classVar = 20;
//	{
//		var = 30;
//	}
//	static {
//		classVar = 40;
//	}
//	VariableInit(){
//		var = 35;
//		classVar = 410;
//	}
//	
//	VariableInit v = new VariableInit();
//	System.out.println(v.classVar);
//}

//class Init {
//	int a;
//	int b;
//	int c;
//	Init(int a, int b, int c){
//		a = 1;
//		b = 2;
//		c = 3;
//		
//		this.a = 100;
//		this.b = 100;
//		this.c = 200;
//	System.out.println(a + b + c);
//	System.out.println(this.a + this.b + this.c);		
//	}
//	Init(){
//		this(10, 20, 30);
//	}

//	Init i = new Init();
//	i.a = 10;
//	i.b = 20;
//	i.c = 30;
//
//	Init i2 = new Init();
//	i2.a = 40;
//	i2.b = 50;
//	i2.c = 60;
//}