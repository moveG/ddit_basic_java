package study.study2;

public class SampleParent {
	String var;
	
	SampleParent(){
		var = "생성자블럭";
	}
	
	{
		var = "초기화블럭";
	}
	
	int method(int a, int b){
		return a + b;
	}
	
}
