package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		/*
		 * 거스름돈에 동전의 단위마다 몇 개의 동전이 필요한지 출력해주세요.(문제)
		 * 
		 * 거스름돈: 2860원
		 * 500원: 5개
		 * 100원: 3개
		 * 50원: 1개
		 * 10원: 1개
		 */
//		int money = (int)(Math.random() * 500) * 10;
//		System.out.println("거스름돈: " + money);
//		
//		int[] coin = {500, 100, 50, 10};
//		
//		for (int i = 0; i < coin.length; i++) {
//			int count = money / coin[i];
//			money = money % coin[i];
//			System.out.println(coin[i] + "원: " + count + "개");
//		}
		
		/*
		 * 1~5 사이의 숫자가 발생된 만큼 *을 사용해 그래프를 그려주세요.
		 * 
		 * 1 : *** 3
		 * 2 : **** 4
		 * 3 : ** 2
		 * 4 : ***** 5
		 * 5 : ****** 6
		 */
//		int[] arr = new int[20];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 5) + 1;
//		}
//		System.out.println(Arrays.toString(arr));
//		
//		int[] count = new int[5];
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < count.length; j++) {
//				if (arr[i] == j+1) {
//					count[j]++;
//				}
//			}
//		}
//		
//		for (int i = 0; i < count.length; i++) {
//			System.out.print((i + 1) + " : ");
//			for (int j = 0; j < count[i]; j++) {
//				System.out.print("*");
//			}
//			System.out.println(" " + count[i]);
//		}

//		int[] arr = new int[20];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 5) + 1;
//		}
//		System.out.println(Arrays.toString(arr));
//		
//		int[] counts = new int[5];
//		for (int i = 0; i < arr.length; i++) {
//			counts[arr[i] - 1]++;
//		}
//		
//		for (int i = 0; i < counts.length; i++) {
//			System.out.print(i + 1 + " : ");
//			for (int j = 0; j < counts[i]; j++) {
//				System.out.print("*");
//			}
//			System.out.println(" " + counts[i]);
//		}
		
		/*
		 * 1~5 사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
		 * 
		 * [3, 5, 3, 2, 1, 3, 2, 1, 4, 1]
		 * [3, 5, 2, 1, 4]
		 * 
		 */
//		int[] arr = new int[10];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 5) + 1;
//		}
//		
//		int[] arr = {3, 5, 3, 2, 1, 3, 2, 1, 4, 1};
//		System.out.println(Arrays.toString(arr));
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i + 1; j < arr.length; j++) {
//				if (arr[i] == arr[j]) {
//					arr[j] = 0;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));		
//		
//		int[] temp = new int[5];
//		int count = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] != 0) {
//				temp[count++] = arr[i];
//			}
//		}		
//		int[] result = new int[count];
//		for (int i = 0; i < result.length; i++) {
//			result[i] = temp[i];
//		}
//		System.out.println(Arrays.toString(result));
		
//		int[] arr = new int[10];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 5) + 1;
//		}
//		System.out.println(Arrays.toString(arr));		
//		
//		int[] temp = new int[5];
//		int count = 0;
//		for (int i = 0; i< arr.length; i++) {
//			boolean flag = true;
//			for (int j = 0; j < temp.length; j++) {
//				if (arr[i] == temp[j]) {
//					flag = false;
//				}
//			}
//			if (flag) {
//				temp[count++] = arr[i];
//			}
//		}
//		int[] result = new int[count];
//		for (int i = 0; i < result.length; i++) {
//			result[i] = temp[i];
//		}
//		System.out.println(Arrays.toString(result));
		
	}

}
