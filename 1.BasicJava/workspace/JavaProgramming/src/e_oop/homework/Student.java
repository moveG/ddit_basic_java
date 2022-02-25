package e_oop.homework;

public class Student {
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	String name;
	int rank;
	
	String[] studentNames = {"이단비", "김노을", "정현욱", "박소현", "김수진",
							 "이희현", "강   건", "이민영", "하기재", "이윤우",
							 "김미희", "김혜윤", "신승철", "이광효", "김진혁",
							 "마창수", "양기욱", "이동근", "석기현", "류인성",
							 "이미정", "임나리", "송민섭", "김지윤", "조명석"};
	
	int[] sums = new int[3];
	double[] avgs = new double[3];
	
//랜덤점수
	void random (Student[] a) {
		for (int i = 0; i < a.length; i++) {
			Student full = new Student();

			full.name = studentNames[i];
			full.rank = 1;
			full.kor = (int)(Math.random() * 101);
			full.eng = (int)(Math.random() * 101);
			full.math = (int)(Math.random() * 101);

			a[i] = full;
		}
	}
	
//합계
	void sum (Student[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i].sum = a[i].kor + a[i].eng + a[i].math;
		}
	}
	
//평균	
	void avg (Student[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i].avg = Math.round(a[i].sum / 3.0 * 100) / 100.0;
		}
	}	       
		
//정렬	
//	void sort (Student[] a) {
//		for (int i = 0; i < a.length - 1; i++) {
//			int min = i;
//			for (int j = i + 1; j < a.length; j++) {
//				if (a[j].rank < a[min].rank) {
//					min = j;
//				}
//			}
//			Student temp = a[i];
//			a[i] = a[min];
//			a[min] = temp;
//		}
//	}
	
//석차
	void rank (Student[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i].sum < a[j].sum) {
					a[i].rank++;
				}
			}
		}
	}

//출력
	void column (Student[] a) {
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].name + "\t"
							 + a[i].kor + "\t"
							 + a[i].eng + "\t"
							 + a[i].math + "\t"
							 + a[i].sum + "\t"
							 + a[i].avg + "\t"
							 + a[i].rank);
		}
	}
	
//과목합계
//	void sums (Student[] a) {
//		for (int i = 0; i < studentNames.length; i++) {
//			sums[0] += a[i].kor;
//			sums[1] += a[i].eng;
//			sums[2] += a[i].math;
//		}
//		System.out.print("과목합계");
//		for (int i = 0; i < sums.length; i++) {
//			System.out.print("\t" + sums[i]);
//		}
//		System.out.println();
//	}
	
//과목평균	
//	void avgs (Student[] a) {
//		System.out.print("과목평균");
//		for (int i = 0; i < avgs.length; i++) {
//			avgs[i] = Math.round((double)sums[i] / sums.length * 100) / 100.0;
//			System.out.print("\t" + avgs[i]);
//		}
//	}
}
