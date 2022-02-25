package study.study1;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	//get~ : 변수의 값을 읽어옮
	//set~ : 변수의 값을 저장함
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour < 0){
			this.hour = 0;
		}else if(23 < hour){
			this.hour = hour % 24;
		}else{
			this.hour = hour;
		}
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute < 0){
			this.minute = 0;
		}else if(59 < minute){
			this.minute = minute % 60;
			setHour(hour + (minute / 60));
		}else{
			this.minute = minute;
		}
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second < 0){
			this.second = 0;
		}else if(59 < second){
			this.second = second % 60;
			setMinute(minute + (second / 60));
		}else{
			this.second = second;
		}
	}
	String getTime(){
		return hour + " : " + minute + " : " + second;
	}
//시간 흐름	
//	void clock(){
//		while(true){
//			System.out.println(getTime());
//			stop(1500);
//			setSecond(second + 1);
//			
//		}	
//	}
	private void stop(int interval){
		try {
			Thread.sleep(interval);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void dd(){
		try {
			Thread.sleep(1200);
			System.out.println("나는");
			Thread.sleep(1200);
			System.out.println("피를");
			Thread.sleep(1200);
			System.out.println("천천히");
			Thread.sleep(1200);
			System.out.println("뚝");
			Thread.sleep(1200);
			System.out.println("뚝");
			Thread.sleep(1200);
			System.out.println("뚝");
			Thread.sleep(1200);
			System.out.println("흘렸다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	String[] dss = new String[] {
			"나는 ", "피를 ", "천천히 ", "뚝 ", "뚝 ", "뚝 ", "흘리고 ", "있었다..."
	};
	void ds(){
		while(true){
			for(int i = 0; i < dss.length; i++){
				System.out.print(dss[i]);
				stop(1200);
			}
			break;
		}
	}
	
}
