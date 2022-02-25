package study.study2;

public class Time {
	void clock(){
		while(true){
			System.out.println("시간");
			stop(1000);
			System.out.println("시간");
			stop(900);
			System.out.println("시간");
			stop(800);
			System.out.println("시간");
			stop(700);
			System.out.println("시간");
			stop(600);
			System.out.println("시간");
			stop(500);
			System.out.println("시간");
			stop(400);
			System.out.println("시간");
			stop(300);
			System.out.println("시간");
			stop(200);
		}
	}
	
	private void stop(int interval){
		try {
			Thread.sleep(interval);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Time t = new Time();
		t.clock();
	}

}
