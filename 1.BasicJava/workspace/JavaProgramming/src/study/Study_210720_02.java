package study;

public class Study_210720_02 {

	public static void main(String[] args) {
		Study11 st = new Study11();
		String aa = st.method1(100);
		System.out.println(aa);
		
		st.method2();
		
		st.method3();
		
		st.method4(3);
		
	}

}



class Study11 {
	int field;
	
	String method1(int parameter) {
		return parameter + "을를";
	}	

	void method2() {
		System.out.println("dkdkdkd");
	}	
		
	String fff = "abc";
	
	void method3() {
		System.out.println(fff);
	}
	
	void method4(int a) {
		System.out.println(a);
	}
	
	void method5(int p1) {
		System.out.println(p1);
	}
	
	
}