package study;

import java.util.Arrays;
import java.util.Scanner;

public class Study_210713 {

	public static void main(String[] args) {
		//숫자를 입력받아 그 숫자만큼 403호 학생들 중 랜덤으로 출력해주세요.(문제)
				Scanner sc = new Scanner(System.in);
//				이단비, 김노을, 정현욱, 박소현, 김수진,
//				이희현, 강   건, 이민영, 하기재, 이윤우,
//				김미희, 김혜윤, 신승철, 이광효, 김진혁,
//				마창수, 양기욱, 이동근, 석기현, 류인성,
//				이미정, 임나리, 송민섭, 김지윤, 조명석
//			String yn = "y";	
//				
//			while (yn.equals("y")) {
//				System.out.print("원하는 숫자를 입력하세요>");
//				int input = Integer.parseInt(sc.nextLine());
//				String[] student = {"이단비", "김노을", "정현욱", "박소현", "김수진",
//									"이희현", "강   건", "이민영", "하기재", "이윤우",
//									"김미희", "김혜윤", "신승철", "이광효", "김진혁",
//									"마창수", "양기욱", "이동근", "석기현", "류인성",
//									"이미정", "임나리", "송민섭", "김지윤", "조명석"};
//				int[] number = new int[input];
//				for (int i = 0; i < number.length; i++) {
//					number[i] = (int)(Math.random() * 25) +1;
//					for (int j = 0; j < i; j++) {
//						if (number[i] == number[j]) {
//							i--;
//						}
//					}
//				}
//				for (int i = 0; i < number.length; i++) {
//					System.out.print(student[number[i]-1] + ", ");
//				}
//				System.out.println();
//				System.out.print("재입력 하시겠습니까? y/n>");
//				yn = sc.nextLine();
//		  }
//		  System.out.println("출력을 종료하겠습니다.");
		  
		//10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.(문제)
//		int[] arr = new int[10];
		
		//배열의 모든 인덱스에 1~100 사이의 랜덤한 값을 저장해주세요.(문제)
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 100) + 1;
//		}
//		System.out.println(Arrays.toString(arr));
		  
		//배열에 저장된 모든 값의 합계와 평균을 출력하세요.(문제)
//		int sum = 0;
//		double avg = 0;
//		
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//		}
//		
//		avg = ((double)sum / arr.length);
//		
//		System.out.println("합계: " + sum + ", 평균: " + avg);
		
		//배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.(문제)
//		int max = arr[0];
//		int min = arr[0];
//		
//		for (int i = 0; i < arr.length; i++) {
//			if (max < arr[i]) {
//				max = arr[i];
//			}
//			if (min > arr[i]) {
//				min = arr[i];
//			} 
//		}
//		
//		System.out.println("최대값: " + max + ", 최소값: " + min);
		
		//배열의 값을 섞어주세요.(문제)
//		int[] shuffle = new int[10];
//		for (int i = 0; i < shuffle.length; i++) {
//			shuffle[i] = i + 1;
//		}
//		System.out.println(Arrays.toString(shuffle));
//		
//		for (int i = 0; i < shuffle.length * 10; i++) {
//			int random = (int)(Math.random() * shuffle.length);
//			int temp = shuffle[0];
//			shuffle[0] = shuffle[random];
//			shuffle[random] = temp;
//		}
//		System.out.println(Arrays.toString(shuffle));
		
//		for (int i = 0; i < (int)(Math.random() * 10000); i++) {
//			int temp;
//			int r1 = (int)(Math.random() * 10);
//			int r2 = (int)(Math.random() * 10);
//			
//			temp = shuffle[r1];
//			shuffle[r1] = shuffle[r2];
//			shuffle[r2] = temp;
//		}
//		System.out.println(Arrays.toString(shuffle));

		//1~10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.(문제)
//		int[] random = new int[500];
//		int[] count = new int[10];
//		
//		for (int i = 0; i < random.length; i++) {
//			random[i] = (int)(Math.random() * 10) + 1;
//			for (int j = 0; j < count.length; j++) {
//				if (random[i] == j + 1) {
//					count[j]++;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(count));
		
		//위 문제의 최대값, 최소값, 반복횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.(문제)
//		System.out.print("최대값을 입력하세요>");
//		int max = Integer.parseInt(sc.nextLine());
//		System.out.print("최소값을 입력하세요>");
//		int min = Integer.parseInt(sc.nextLine());
//		System.out.print("반복횟수을 입력하세요>");
//		int size = Integer.parseInt(sc.nextLine());
//		
//		int[] counts = new int[max - min + 1];
//		
//		for (int i = 0; i < size; i++) {
//			int random = (int)(Math.random() * (max - min + 1)) + min;
//				counts[random - min]++;
//		}
//		System.out.println(Arrays.toString(counts));
		
		//석차 구하기: 점수를 비교해 작은 점수의 등수를 증가시키는 방식(문제)
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		//Array.toString(): 배열에 저장된 값을 보여준다.		
				
		int[] rank = new int[arr.length];
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}
		//i는 기준, j는 비교대상		

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
		
		//선택정렬
		/*
		 * 0,1  0,2  0,3  0,4  0,5  0,6  0,7  0,8  0,9
		 * 1,2  1,3  1,4  1,5  1,6  1,7  1,8  1,9
		 * 2,3  2,4  2,5  2,6  2,7  2,8  2,9
		 * 3,4  3,5  3,6  3,7  3,8  3,9
		 * 4,5  4,6  4,7  4,8  4,9
		 * 5,6  5,7  5,8  5,9
		 * 6,7  6,8  6,9
		 * 7,8  7,9
		 * 8,9
		 * 
		 * 작은 값을 만날 때마다 자리를 바꾸는 것이 아니라, 제일 작은 값을 찾은 뒤 마지막으로 자리를 바꾼다.
		 */
//		for (int i = 0; i < arr.length - 1; i++) {
//			int min = i;
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[j] < arr[min]) {
//					min = j;
//				}
//			}
//			int temp = arr[i];
//			arr[i] = arr[min];
//			arr[min] = temp;
//		}
//		System.out.println(Arrays.toString(arr));
		
		//버블정렬
		/*
		 * 0,1  1,2  2,3  3,4  4,5  5,6  6,7  7,8  8,9
		 * 0,1  1,2  2,3  3,4  4,5  5,6  6,7  7,8
		 * 0,1  1,2  2,3  3,4  4,5  5,6  6,7
		 * 0,1  1,2  2,3  3,4  4,5  5,6
		 * 0,1  1,2  2,3  3,4  4,5
		 * 0,1  1,2  2,3  3,4
		 * 0,1  1,2  2,3
		 * 0,1  1,2
		 * 0,1
		 * 
		 * 한 바퀴를 돌고 위치변경이 없으면, 정렬이 끝난 것으로 보고 정지한다.
		 */
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < arr.length - i - 1 ; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
		
		//삽입정렬
		/*
		 * 1,0
		 * 2,1  2,0
		 * 3,2  3,1  3,0
		 * 4,3  4,2  4,1  4,0
		 * 5,4  5,3  5,2  5,1  5,0
		 * 6,5  6,4  6,3  6,2  6,1  6,0
		 * 7,6  7,5  7,4  7,3  7,2  7,1  7,0
		 * 8,7  8,6  8,5  8,4  8,3  8,2  8,1  8,0
		 * 9,8  9,7  9,6  9,5  9,4  9,3  9,2  9,1  9,0
		 * 
		 */
//		for (int i = 1; i < arr.length; i++) {
//			int temp = arr[i];
//			int j = 0;
//			for (j = i - 1; j >= 0; j--) {
//				if (temp < arr[j]) {
//					arr[j + 1] = arr[j];
//				} else {
//					break;
//				}
//			}
//			arr[j + 1] = temp;
//		}
//		System.out.println(Arrays.toString(arr));
		
	}

}
