package study;

import java.util.Arrays;

public class Study_210717 {

	public static void main(String[] args) {
		//별찍기(사각형)
//		System.out.println("*****");
//		System.out.println("*****");
//		System.out.println("*****");
//		System.out.println();
//
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//별찍기(삼각형)(문제)
//		System.out.println("*");
//		System.out.println("**");
//		System.out.println("***");
//		System.out.println("****");
//		System.out.println("*****");
//		System.out.println();
//				
//		for (int i =0; i < 5; i++) {
//			for (int j =0; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		//별찍기(삼각형)(문제)
//		System.out.println("*****");
//		System.out.println("****");
//		System.out.println("***");
//		System.out.println("**");
//		System.out.println("*");
//		System.out.println();
//		
//		for (int i = 5; i > 0; i--) {
//			for (int j = 0; j < i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		/*
		 * - 석차구하기: 점수를 비교해 작은 점수의 등수를 증가시키는 방식
		 * - 선택정렬: 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 * - 버블정렬: 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 * - 삽입정렬: 두 번째 숫자부터 앞의 숫자들과 비교해서 큰 수는 뒤로 밀고 중간에 삽입하는 방식
		 * 
		 * 오름차순 정렬(작은 수부터 출력)
		 */		
		
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		//석차구하기		
		
//		int[] rank = new int[arr.length];
//		for (int i = 0; i < rank.length; i++) {
//			rank[i] = 1;
//		}
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++ ) {
//				if (arr[i] < arr[j]) {
//					rank[i]++;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(rank));
		
		//선택정렬
		//리스트에서 최소값을 찾아 첫째 자리와 바꾸고, 첫째를 제외한 리스트에서 최소값을 찾아 다시 둘째 자리와 바꾸고, 첫째둘째 자리를 제외한 리스트에서 최소값을 찾아 셋째자리와 바꾸고...
		//첫 칸부터 작은값이 채워지면서 순서가 정렬된다.
		
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
		//첫째 원소와 둘째 원소를 비교해 둘 중 큰값을 뒤로 보내고, 둘째 셋째를 비교해 큰값을 뒤로 보내고, 셋째 넷째를 비교해 큰값을 뒤로 보내고...
		//마지막 칸부터 큰값이 채워지면서 순서가 정렬된다.

//		for (int i = 0; i < arr.length - 1; i++) {
//			for (int j = 0; j < arr.length - 1 - i; j++) {
//				if (arr[j] > arr[j + 1]) {
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
		
//		for (int i = 0; i < arr.length - 1; i++) {
//			boolean flag = true;
//			for (int j = 0; j < arr.length - i - 1; j++) {
//				if (arr[j] > arr[j + 1]) {
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//					flag = false;
//				}
//			}
//			if (flag) {
//				break;
//			}
//		}
//		System.out.println(Arrays.toString(arr));
		
		//삽입정렬
		//둘째칸(타겟칸)부터 시작한다.
		//둘째칸(타겟칸)이 첫째칸보다 작으면 둘의 자리를 바꾼다.
		//셋째칸(타겟칸)이 둘째칸보다 작으면 둘의 자리를 바꾼다. 둘째칸(바뀐 타겟칸)이 첫째칸보다 작으면 둘의 자리를 바꾼다. 둘째칸(바뀐 타겟칸)이 첫째칸보다 크면 자리를 바꾸지 않는다.
		//이것을 반복한다.
		//작은 값이 하나씩 앞으로 보내져, 마지막 과정이 끝나면 전체의 정렬이 끝난다.
		
		//for문은 조건식, 내부문장(if문)수행, 증감식 순으로 반복된다.
		//if문이 false라서 break로 for문을 탈출하면 증감식(j--)이 수행되기 전에 탈출한다.
		//제일 작은 수라서 마지막(j=0)까지 if문이 true라면 if문을 수행하고 증감식(j--)도 수행한다. 그런 다음 for문을 나와 arr[j + 1] = temp;를 수행한다.
		//j가 0일때 마지막으로 증감식(j--)을 수행해 j가 -1이 된 다음 for문을 나왔으므로, 마지막 arr[j + 1]에 0이 아닌 -1을 넣는다.
		//그러면 arr[-1 + 1] = temp; => arr[0] = temp;가 되므로
		//제일 첫칸에 제일 작은 숫자를 넣을 수 있게 된다.
		
		for (int i = 1; i < arr.length; i++) {
		int temp = arr[i];
		int j = 0;
		for (j = i - 1; j >= 0; j--) {
			if (temp < arr[j]) {
				arr[j + 1] = arr[j];
			} else {
				break;
			}
		}
		arr[j + 1] = temp;
	}
	System.out.println(Arrays.toString(arr));
		
		
		
	}

}
