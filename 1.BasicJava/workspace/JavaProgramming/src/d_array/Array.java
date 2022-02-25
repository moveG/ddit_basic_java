package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 * - 인덱스로 값을 구분한다
		 * - 인덱스는 0부터 시작한다.
		 * - 길이를 변경할 수 없다.
		 * - 메모리의 빈 공간에 배열을 만들고, 첫 칸의 주소값을 저장한다.
		 */
		
		int[] array;
		//[]: 배열을 의미한다.
		//int타입의 배열(변수 X)을 저장한다.
		//배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5];
		//배열이 생성되고 그 주소가 저장된다.
		//배열 초기화시 기본값이 저장된다.
		//가장 많이 사용되는 방법이다.
		
		/*
		 * 변수 = 100번지(주소)
		 * 
		 * 100번지
		 * {0, 0, 0, 0, 0}
		 * 배열은 연속적으로 저장된다.
		 */
		
		array = new int[] {1, 2, 3, 4, 5};

//		array = {1, 2, 3, 4, 5}; //컴파일 에러 발생
		int[] array2 = {1, 2, 3, 4, 5};
		//이 방법은변수의 선언과 초기화를 함께 해줘야 한다.

		//배열에 저장된 값을 출력하는 방법
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		
		//배열에 값을 저장하는 방법
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		//for문 사용
		//array.length: 배열의 길이를 가져오는 방법
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (i + 1) * 10;			
		}
		
		//10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.(문제)
		int[] arr = new int [10];
		
		//배열의 모든 인덱스에 1~100 사이의 랜덤한 값을 저장해주세요.(문제)
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
//			System.out.println(arr[i]);
		}
		System.out.println(Arrays.toString(arr));
		//Array.toString(): 배열에 저장된 값을 보여준다.
		//Ctrl + Shift + O를 쳐서, import java.util.Arrays;를 만들어준다.
		
		//배열에 저장된 모든 값의 합계와 평균을 출력하세요.(문제)
		int sum = 0;
		double avg = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		avg = (double)sum / arr.length;
				
		System.out.println("합계는 " + sum + "이고, 평균은 " + avg + "입니다.");
		
		//배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.(문제)
//		int max = arr[0];
//		int min = arr[0];
//		for (int i = 0; i < arr.length; i++) {
//			if (max < arr[i]) {
//				max = arr[i];
//			}
//			if (min > arr[i]) {
//				min = arr[i];
//			} 
//		}
//		System.out.println("최대값은 " + max + "이고, 최소값은 " + min + "입니다.");

//		int[] shuffle = new int[10];
//		for (int i = 0; i < shuffle.length; i++) {
//			shuffle[i] = i + 1;
//		}
//		System.out.println(Arrays.toString(shuffle));
		
		//배열의 값을 섞어주세요.(문제)
//		for (int i = 0; i < shuffle.length * 10; i++) {
//			int random = (int)(Math.random() * shuffle.length);
//			int temp = shuffle[0];
//			shuffle[0] = shuffle[random];
//			shuffle[random] = temp;
//		}
//		System.out.println(Arrays.toString(shuffle));
		
//		for (int i = 0; i < (int)(Math.random() * 100000); i++) {
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
//		int[] five = new int[500];
//						
//		int no1=0;
//		int no2=0;
//		int no3=0;
//		int no4=0;
//		int no5=0;
//		int no6=0;
//		int no7=0;
//		int no8=0;
//		int no9=0;
//		int no10=0;
//		
//		for (int i = 0; i < five.length; i++) {
//			five[i] = (int)(Math.random() * 10) + 1;
//			if (five[i] == 1) {
//				no1++;
//			} else if (five[i] == 2) {
//				no2++;
//			} else if (five[i] == 3) {
//				no3++;
//			} else if (five[i] == 4) {
//				no4++;
//			} else if (five[i] == 5) {
//				no5++;
//			} else if (five[i] == 6) {
//				no6++;
//			} else if (five[i] == 7) {
//				no7++;
//			} else if (five[i] == 8) {
//				no8++;
//			} else if (five[i] == 9) {
//				no9++;
//			} else {
//				no10++;
//			}
//		}
//		System.out.println(Arrays.toString(five));
//		System.out.println("1의 개수는 " + no1 + "개, 2의 개수는 " + no2 + "개, 3의 개수는 " + no3 + "개, 4의 개수는 " + no4 + "개, 5의 개수는 " + no5 + "개");
//		System.out.println("6의 개수는 " + no6 + "개, 7의 개수는 " + no7 + "개, 8의 개수는 " + no8 + "개, 9의 개수는 " + no9 + "개, 10의 개수는 " + no10+ "개");
		
//		int[] no500 = new int[500];
//		int[] count = new int[10];
//		
//		for (int i = 0; i < no500.length; i++) {
//			no500[i] = (int)(Math.random() * 10) + 1;
//			for (int j = 0; j < count.length; j++) {
//				if (no500[i] == j + 1 ) {
//					count[j]++;
//				}
//			}	
//		}
//		System.out.println(Arrays.toString(count));
//		System.out.println("1의 개수는 " + count[0] + "개, 2의 개수는 " + count[1] + "개, 3의 개수는 " + count[2] + "개, 4의 개수는 " + count[3] + "개, 5의 개수는 " + count[4] + "개");
//		System.out.println("6의 개수는 " + count[5] + "개, 7의 개수는 " + count[6] + "개, 8의 개수는 " + count[7] + "개, 9의 개수는 " + count[8] + "개, 10의 개수는 " + count[9] + "개");
		
//		int[] counts = new int[10];
//		
//		for (int i = 0; i < 500; i++) {
//			int random = (int)(Math.random() * 10) + 1;
//			counts[random-1]++;
//		}
//		System.out.println(Arrays.toString(counts));

		//위 문제의 최소값, 최대값, 반복횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.(문제)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("최소값을 입력하세요>");
		int min = Integer.parseInt(sc.nextLine());
		System.out.print("최대값을 입력하세요>");
		int max = Integer.parseInt(sc.nextLine());
		System.out.print("반복횟수를 입력하세요>");
		int size = Integer.parseInt(sc.nextLine());
		
		int[] counts = new int[max - min + 1];
		
		for (int i = 0; i < size; ++i) {
			int random = (int)(Math.random() * (max - min +1)) + min;
			counts[random - min]++; //최소값이 나오면 0번 인덱스에 카운트를 해야하므로, random에 min값을 빼준다.
			}
		System.out.println(Arrays.toString(counts));
		
	}

}
