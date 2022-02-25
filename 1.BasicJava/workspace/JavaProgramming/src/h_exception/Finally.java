package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Finally {

	public static void main(String[] args) {
		/*
		 * finally
		 * - 필요에 따라 try-catch 뒤에 finally를 추가할 수 있다.
		 * - finally는 예외의 발생여부와 상관없이 가장 마지막에 수행된다.
		 * 
		 * 자동 자원 반환
		 * - try(변수 선언;) {} catch(Exception e) {}
		 * - 사용 후 반환이 필요한 객체를 try의 () 안에서 선언하면 try 블럭 종료시 자동으로 반환된다.
		 */
		
		FileInputStream fis = null; //파일 읽기
		
		try {
			fis = new FileInputStream("d:/file.txt");
			//중간에 catch로 넘어가면 fis.close();는 실행되지 않으므로 반드시 실행할 것은 finally에 넣는 것이 좋다.
//			fis.close(); //사용 후에는 .close를 이용해 자원을 운영체제에 반드시 반납을 해야한다, 반납하지 않으면 계속 메모리를 낭비하게 된다.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//자동 자원 반환
		try(FileOutputStream fos = new FileOutputStream("d:/file.txt")){ //파일 쓰기
			String str = "아무내용이나 써보자...";
			
			byte[] bytes = str.getBytes();
			
			for(int i = 0; i < bytes.length; i++){
				fos.write(bytes[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}