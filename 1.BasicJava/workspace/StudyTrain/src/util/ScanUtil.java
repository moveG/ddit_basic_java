package util;

import java.util.Scanner;

public class ScanUtil {
	private static Scanner s = new Scanner(System.in);
	//자주 사용되는 메서드는 객체생성을 하지 않기 위해 static을 붙인다.

	public static String nextLine() {
		return s.nextLine();
	}
	//Scanner 변수에 static이 붙어있지 않기 때문에 static메서드(s.)에 컴파일 에러가 발생한다.
	//컴파일 에러를 없애려면 Scanner 앞에도 static을 붙여준다.
	
	public static int nextInt() {
		return Integer.parseInt(s.nextLine());
	}
	
//	public static int nextInt() {
//		int num = 0;
//		while(true){
//			try{
//				num =  Integer.parseInt(s.nextLine());
//			}catch(Exception e){
//				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
//				continue;
//			}
//			break;
//		}
//		return num;
//	}	
		
	public static double nextDouble() {
		return Double.parseDouble(s.nextLine());
	}
	
}