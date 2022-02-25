package study.study2;

public class SampleChild extends SampleParent {
	
	void childMethod(){
		System.out.println(var);
		System.out.println(method(7, 3));
	}
	
	@Override
	int method(int a, int b){
		return a * b;
	}
	
	double var = 3.0;
	
	void test(String var){
		System.out.println(var);
		System.out.println(this.var);
		System.out.println(super.var);
		
		System.out.println(method(3, 5));
		System.out.println(super.method(3, 5));
	}
	
	SampleChild() {
		super();
	}
	
	public static void main(String[] args) {
//		SampleChild sc = new SampleChild();
//		sc.childMethod();
//		sc.method(3, 4);
//		sc.test("안녕");
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild();
		
		sc = (SampleChild)sp;
		
		sp = (SampleParent)sc;

	}

}
