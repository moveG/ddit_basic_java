package g_oop2;

public class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	//get~ : 변수의 값을 읽어옴	
	//set~ : 변수의 값을 저장함
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour < 0){
			this.hour = 0;
		}else if(24 <= hour){
			this.hour = hour % 24;
		}else{
			this.hour = hour;
		}
		
//		if(hour >= 24) {
//			this.hour = 0;
//		}
	}
	
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute < 0){
			this.minute = 0;
		}else if(59 < minute){
			this.minute = minute % 60;
			setHour(hour + 1);
		}else{
			this.minute = minute;
		}
		
//		if(minute > 59) {
//			setHour(hour + 1);
//			this.minute = 0;
//		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second < 0){
			this.second = 0;
		}else if(59 < second){
			this.second = second % 60;
			setMinute(minute + 1);
		}else{
			this.second = second;
		}
		
//		if(second > 59) {
//			setMinute(minute + 1);
//			this.second = 0;
//		}else{
//			this.second = second;
//		}
	}
	String getTime(){
		return hour + ":" + minute + ":" + second;
	}

	void clock(){
		while(true){
			System.out.println(getTime());
			stop(1000);	//시간이 1초(기준이 1/1000초라서)에 한번 씩만 흘러가도록 설정 
			setSecond(second + 1);
		}
	}
	//Thread.sleep(); + Ctrl + 1 + 2번째(surround with try catch)
	private void stop(int interval){ //다른 클래스에서는 사용할 이유가 없으므로 private를 붙여서 숨겨줌
		try {
			Thread.sleep(interval); //파라미터는 1/1000초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
