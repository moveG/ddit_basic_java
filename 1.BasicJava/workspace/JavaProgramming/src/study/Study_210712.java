package study;

import java.util.Arrays;
import java.util.Scanner;

public class Study_210712 {

	public static void main(String[] args) {
		//반올림
				//avg = Math.round(avg * 10000) / 10000.0;
				//Math.round는 무조건 소수점 첫째자리에서 반올림을 한다.
				//원하는 자리수에서 반올림을 하려면, 원하는 자리수 만큼 곱해준 다음에 반올림 후 다시 같은 수를 나누어준다.
				//Math.round는 int타입이므로 원하는 소수점 결과값을 구하려면, 정수가 아니라 실수로 나누어준다.
				//System.out.println(avg);
		
		//10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.(문제)
		int[] arr = new int [10];
		
		//배열의 모든 인덱스에 1~100 사이의 랜덤한 값을 저장해주세요.(문제)
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		
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
		
		
		int[] shuffle = new int[10];
		for (int i = 0; i < shuffle.length; i++) {
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));
		
		
		//배열의 값을 섞어주세요.(문제)
		for (int i = 0; i < shuffle.length * 10; i++) {
			int random = (int)(Math.random() * shuffle.length);
			int temp = shuffle[0];
			shuffle[0] = shuffle[random];
			shuffle[random] = temp;
		}
		System.out.println(Arrays.toString(shuffle));
		
		//1~10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.(문제)
		int[] no500 = new int[500];
		int[] count = new int[10];
		
		for (int i = 0; i < no500.length; i++) {
			no500[i] = (int)(Math.random() * 10) + 1;
			for (int j = 0; j < count.length; j++) {
				if (no500[i] == j + 1 ) {
					count[j]++;
				}
			}	
		}
		System.out.println(Arrays.toString(count));
		
		//위 문제의 최소값, 최대값, 반복횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.(문제)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("최소값을 입력하세요>");
		int min = Integer.parseInt(sc.nextLine());
		System.out.print("최대값을 입력하세요>");
		int max = Integer.parseInt(sc.nextLine());
		System.out.print("반복횟수를 입력하세요>");
		int size = Integer.parseInt(sc.nextLine());
		
		int[] counts = new int[max - min +1];
		
		for (int i = 0; i < size; ++i) {
			int random = (int)(Math.random() * (max - min +1)) + min;
			counts[random - min]++; //최소값이 나오면 0번 인덱스에 카운트를 해야하므로, random에 min값을 빼준다.
			}
		System.out.println(Arrays.toString(counts));
		
		//기출문제 작년거 풀어보기(먼저) - 기출형식 감잡기 - 어디가 나올찌 예상하고 거기부터 볼 것. 참고문헌은 ncs.go.kr ncs및 학습모듈검색 - 정보통신 - 정보기술 - 정보기술개발
				//comcbt.com 문제 쭉 보기 // 재작년 문제 출제 예정 //출제문제 주변 내용 공부 // 찍는 방법: 각 과목별로 제일 적게 선택한 보기 찍기 //시나공 문제집 //hrd
		
		
		
	}

}
