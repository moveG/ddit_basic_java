package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudents {

	public static void main(String[] args) {
		//숫자를 입력받아 그 숫자만큼 403호 학생들 중 랜덤으로 출력해주세요.(문제)
		Scanner sc = new Scanner(System.in);
//		이단비, 김노을, 정현욱, 박소현, 김수진,
//		이희현, 강   건, 이민영, 하기재, 이윤우,
//		김미희, 김혜윤, 신승철, 이광효, 김진혁,
//		마창수, 양기욱, 이동근, 석기현, 류인성,
//		이미정, 임나리, 송민섭, 김지윤, 조명석
		System.out.print("몇 명을 출력할까요?>");
		
		String[] students = {"이단비", "김노을", "정현욱", "박소현", "김수진",
							 "이희현", "강   건", "이민영", "하기재", "이윤우",
							 "김미희", "김혜윤", "신승철", "이광효", "김진혁",
							 "마창수", "양기욱", "이동근", "석기현", "류인성",
							 "이미정", "임나리", "송민섭", "김지윤", "조명석"};

//		int count = Integer.parseInt(sc.nextLine());
//		String[] pick = new String [count];
//		int pickCount= 0;
//		
//		do{
//			int random = (int)(Math.random() * students.length);
//			boolean flag = true;
//			for (int i = 0; i < pick.length; i++) {
//				if(students[random].equals(pick[i])) {
//					flag = false;
//				}
//			}
//			if (flag == true) {
//				pick[pickCount++] = students[random];
//			}
//		} while (pickCount < count);
//		
//		System.out.println(Arrays.toString(pick));
			
//		int input = Integer.parseInt(sc.nextLine());	
//		
//		int[] pick = new int[input];	
//		
//		for (int i = 0; i < pick.length; i++) {
//			pick[i] = (int)(Math.random() * 25) + 1;
//			for (int j = 0; j < i; j++) {
//				if (pick[i] == pick[j]) {
//					i--;
//				}
//			}
//		}
//		for (int i = 0; i < pick.length; i++) {
//			System.out.print(students[pick[i]-1] + " ");
//		}
		
	}

}
