package e_oop.restaurant;

import java.util.Arrays;

public class Boss {

	public static void main(String[] args) {
		Alba alba1 = new Alba();
		
		String[] order1 = alba1.order();
		System.out.println(Arrays.toString(order1));
		System.out.println();
		
		System.out.println("요리를 만드는 중...... 완성!!");
		String[] foods1 = {"완성된 짜장면", "완성된 탕수육"};
		System.out.println();
		
		alba1.serving(foods1);
		System.out.println();
		
		alba1.pay(order1);
		
	}

}