package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		/*
		 * 다차원 배열
		 * - 배열 안에 배열이 저장되어 있는 형태이다.
		 * - 주로 2차원 배열을 많이 사용한다.
		 */
		
		//2차원 배열
		int[][] array2;
		
		//3차원 배열
		int[][][] array3;
		
		int[][] arr = new int[2][3];
		/*
		 * 변수 = 100번지(주소)
		 * 
		 * 100번지
		 * {200번지, 300번지}
		 * 
		 * 200번지
		 * {0, 0, 0}
		 * 
		 * 300번지
		 * {0, 0, 0}
		 * 
		 * - 3개의 값을 저장할 수 있는 배열이 2개 있다.
		 */
		
		int arr2[][] = new int[][]{{1, 2, 3}, {4, 5, 6}};
		//길이 지정 또는 값의 저장 둘 중 하나만 작성해야 한다.
		
		int[] arr3[] = { {1, 2, 3}
					   , {4, 5, 6}
					   , {7, 8, 9} };
		// 반드시 선언과 초기화를 함께 해줘야 한다.
		// 배열에서 보통은 타입 뒤에 대괄호를 붙여준다.				
		
		int[][] arr4 = new int[3][];
		//가변배열: 배열 중 일부만 길이를 정해주는 배열이다.
		//필요한 만큼 그때 그때 만들어서 사용하는 형태이다.
		arr4[0] = new int[3];
		//0번 인덱스는 세개짜리 배열로 정해졌다.
		//사용하려면 그때 그때 초기화를 해주면 된다.
		arr4[1] = new int[5]; 
		arr4[2] = new int[10];
		
		System.out.println(arr[0][1]);
		//정상적으로 출력된다.
		System.out.println(arr[0]);
		//배열의 주소가 출력된다.
		
//		arr[0] = 10; //값을 저장할 수는 없다.
		arr[0] = new int[5]; //배열을 저장해야 한다.
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 100;
		
		System.out.println(arr.length); //1차원 배열의 길이
		System.out.println(arr[0].length); //2차원 배열의 길이

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
		
		int[][] scores = new int[3][5]; //int[학생수][과목수]
		int[] sum = new int[scores.length]; //합계를 저장할 배열
		double[] avg = new double[scores.length]; //평균을 저장할 배열
		//0 ~ 100점 사이의 랜덤한 점수를 scores 배열에 채워넣으시오.
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				scores[i][j] = (int)(Math.random() * 101);
			}
			System.out.println(Arrays.toString(scores[i]));
		}
		//점수의 합계와 평균을 구하시오.
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				sum[i] += scores[i][j];
			}
			avg[i] = (double)sum[i] / scores[i].length;
			System.out.println("합계는 " + sum[i] + ", 평균은 " + avg[i]);
		}
	}

}
