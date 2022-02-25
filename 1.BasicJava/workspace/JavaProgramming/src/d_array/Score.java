package d_array;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {
		/*
		 * 403호 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를 0~100점까지 랜덤으로 생성해주시고,
		 * 아래와 같이 출력해주세요.
		 * 
		 * 이름          국어            영어            수학            사회            과학            Oracle   Java     합계             평균                  석차
		 * 홍길동       90       90       90       90       90       90       90       630       90.00       1
		 * 홍길동       90       90       90       90       90       90       90       630       90.00       1
		 * 홍길동       90       90       90       90       90       90       90       630       90.00       1
		 * 홍길동       90       90       90       90       90       90       90       630       90.00       1
		 * 홍길동       90       90       90       90       90       90       90       630       90.00       1
		 * 홍길동       90       90       90       90       90       90       90       630       90.00       1
		 * 과목합계    450      450      450      450      450      450      450
		 * 과목평균    90.00    90.00    90.00    90.00    90.00    90.00    90.00
		 */
		
//기본 변수선언		
		String[] names = {"이단비", "김노을", "정현욱", "박소현", "김수진",
						  "이희현", "강   건", "이민영", "하기재", "이윤우",
						  "김미희", "김혜윤", "신승철", "이광효", "김진혁",
						  "마창수", "양기욱", "이동근", "석기현", "류인성",
						  "이미정", "임나리", "송민섭", "김지윤", "조명석"};
		String[] subjects = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		int[][] score = new int[names.length][subjects.length];

//랜덤 점수		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				score[i][j] = (int)(Math.random() * 101);
			}
		}
		
//학생 합계, 평균, 평균 반올림
		int[] nameSum = new int[score.length];
		double[] nameAvg = new double[score.length];
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				nameSum[i] += score[i][j];
			}
			nameAvg[i] = Math.round((double)nameSum[i] / subjects.length * 100) / 100.0;
		}
		
//과목 합계, 과목 평균
		int[] subSum = new int[subjects.length];
		double[] subAvg = new double[subjects.length];
		for (int i = 0; i < subjects.length; i++) {
			for (int j = 0; j < score.length; j++) {
				subSum[i] += score[j][i];
			}
			subAvg[i] = Math.round((double)subSum[i] / score.length * 100) / 100.0;
		}
		
//랭킹 구현
		int[] rank = new int[score.length];
		for (int i = 0; i < score.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < score.length; j++) {
				if (nameSum[i] < nameSum[j]) {
					rank[i]++;
				}
			}
		}
		
//출력부
		//이름
		System.out.print("이름");
		//과목
		for (int i = 0; i < subjects.length; i++) {
			System.out.print("\t" + subjects[i]);
		}
		//학생합계평균랭킹 목차
		System.out.println("\t합계\t평균\t석차");
		//이름, 점수, 학생합계, 학생평균, 랭킹 삽입
		for(int i = 0; i < score.length; i++) {
			System.out.print(names[i] + "\t");
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println(nameSum[i] + "\t" + nameAvg[i] + "\t" + rank[i]);
		}
		//과목합계 목차
		System.out.print("과목합계\t");
		//과목합계 삽입
		for (int i = 0; i < subSum.length; i++) {
			System.out.print(subSum[i] + "\t");
		}
		System.out.println();
		//과목평균 목차
		System.out.print("과목평균\t");
		//과목평균 삽입
		for (int i = 0; i < subAvg.length; i++) {
			System.out.print(subAvg[i] + "\t");
		}		

//		//석차순으로 정렬(시험에서 출제되지 않음)
//		for(int i = 0; i < nameSum.length - 1; i++){
//			int min = i;
//			for(int j = i + 1; j < nameSum.length; j++){
//				if(nameSum[j] > nameSum[min]){
//					min = j;
//				}
//			}
//			int[] temp = score[i];
//			score[i] = score[min];
//			score[min] = temp;
//			
//			int temp2 = nameSum[i];
//			nameSum[i] = nameSum[min];
//			nameSum[min] = temp2;
//			
//			double temp3 = nameAvg[i];
//			nameAvg[i] = nameAvg[min];
//			nameAvg[min] = temp3;
//			
//			int temp4 = rank[i];
//			rank[i] = rank[min];
//			rank[min] = temp4;
//			
//			String temp5 = names[i];
//			names[i] = names[min];
//			names[min] = temp5;
//		}
//		
//		System.out.print("이름");
//		for(int i = 0; i < subjects.length; i++){
//			System.out.print("\t" + subjects[i]);
//		}
//		System.out.println("\t합계\t평균\t석차");
//		for(int i = 0; i < score.length; i++){
//			System.out.print(names[i] + "\t");
//			for(int j = 0; j < score[i].length; j++){
//				System.out.print(score[i][j] + "\t");
//			}
//			System.out.println(nameSum[i] + "\t" + nameAvg[i] + "\t" + rank[i]);
//		}
//		
//		System.out.print("과목합계\t");
//		for(int i = 0; i < subSum.length; i++){
//			System.out.print(subSum[i] + "\t");
//		}
//		System.out.println();
//		
//		System.out.print("과목평균\t");
//		for(int i = 0; i < subAvg.length; i++){
//			System.out.print(subAvg[i] + "\t");
//		}
		
	}

}
