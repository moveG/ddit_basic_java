package study;

public class Study_210719_02 {

	public static void main(String[] args) {
//변수
		String[] names = {"이단비", "김노을", "정현욱", "박소현", "김수진",
 				 		  "이희현", "강   건", "이민영", "하기재", "이윤우",
 				 		  "김미희", "김혜윤", "신승철", "이광효", "김진혁",
 				 		  "마창수", "양기욱", "이동근", "석기현", "류인성",
 				 		  "이미정", "임나리", "송민섭", "김지윤", "조명석"};
		Study_210719_01[] arr = new Study_210719_01[names.length];

//랜덤점수
		for (int i = 0; i < arr.length; i++) {
			Study_210719_01 student = new Study_210719_01();

			student.name = names[i];
			student.rank = 1;
			student.kor = (int)(Math.random() * 101);
			student.eng = (int)(Math.random() * 101);
			student.math = (int)(Math.random() * 101);

			arr[i] = student;
		}

//합계, 평균
		for (int i = 0; i < arr.length; i++) {
			arr[i].sum = arr[i].kor + arr[i].eng + arr[i].math;
			arr[i].avg = Math.round(arr[i].sum / 3.0 * 100) / 100.0;
		}

//석차
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i].sum < arr[j].sum) {
					arr[i].rank++;
				}
			}
		}

//정렬(선택정렬)
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].rank < arr[min].rank) {
					min = j;
				}
			}
			Study_210719_01 temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

//출력
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].name + "\t"
		                     + arr[i].kor + "\t"
					         + arr[i].eng + "\t"
		                     + arr[i].math + "\t"
					         + arr[i].sum + "\t"
		                     + arr[i].avg + "\t"
					         + arr[i].rank + "\t");
		}

//과목합계
		int[] sums = new int[3];
		for (int i = 0; i < arr.length; i++) {
			sums[0] += arr[i].kor;
			sums[1] += arr[i].eng;
			sums[2] += arr[i].math;			
		}

		System.out.print("과목합계");
		for (int i = 0; i < sums.length; i++) {
			System.out.print("\t" + sums[i]);
		}
		System.out.println();

//과목평균
		double[] avgs = new double[3];
		System.out.print("과목평균");
		for (int i = 0; i < avgs.length; i++) {
			avgs[i] = Math.round((double)sums[i] / avgs.length * 100) / 100.0;
			System.out.print("\t" + avgs[i]);
		}
		
	}

}
