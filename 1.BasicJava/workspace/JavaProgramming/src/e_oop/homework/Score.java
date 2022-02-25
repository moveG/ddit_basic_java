package e_oop.homework;

public class Score {

	public static void main(String[] args) {
		Student full = new Student();
		
		String[] studentNames = {"이단비", "김노을", "정현욱", "박소현", "김수진",
								 "이희현", "강   건", "이민영", "하기재", "이윤우",
								 "김미희", "김혜윤", "신승철", "이광효", "김진혁",
								 "마창수", "양기욱", "이동근", "석기현", "류인성",
								 "이미정", "임나리", "송민섭", "김지윤", "조명석"};
		Student[] sts = new Student[studentNames.length];
		
		full.random(sts);
		full.sum(sts);
		full.avg(sts);
		full.rank(sts);
//		full.sort(sts);
		full.column(sts);
//		full.sums(sts);
//		full.avgs(sts);
		
//랜덤점수
//		for (int i = 0; i < sts.length; i++) {
//			Student full = new Student();
//
//			full.name = studentNames[i];
//			full.rank = 1;
//			full.kor = (int)(Math.random() * 101);
//			full.eng = (int)(Math.random() * 101);
//			full.math = (int)(Math.random() * 101);
//
//			sts[i] = full;
//		}
		
//합계, 평균
//		for (int i = 0; i < sts.length; i++) {
//			sts[i].sum = sts[i].kor + sts[i].eng + sts[i].math;
//		}
//		for (int i = 0; i < sts.length; i++) {
//			sts[i].avg = Math.round(sts[i].sum / 3.0 * 100) / 100.0;
//		}
		
//석차
//		for (int i = 0; i < sts.length; i++) {
//			for (int j = 0; j < sts.length; j++) {
//				if (sts[i].sum < sts[j].sum) {
//					sts[i].rank++;
//				}
//			}
//		}
				
//정렬 (선택정렬)
		for (int i = 0; i < sts.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < sts.length; j++) {
				if (sts[j].rank < sts[min].rank) {
					min = j;
				}
			}
			Student temp = sts[i];
			sts[i] = sts[min];
			sts[min] = temp;
		}
				
//출력		
//		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");
//		for (int i = 0; i < sts.length; i++) {
//			System.out.println(sts[i].name + "\t"
//							 + sts[i].kor + "\t"
//							 + sts[i].eng + "\t"
//							 + sts[i].math + "\t"
//							 + sts[i].sum + "\t"
//							 + sts[i].avg + "\t"
//							 + sts[i].rank);
//		}

//과목합계
		int[] sums = new int[3];
		for (int i = 0; i < sts.length; i++) {
			sums[0] += sts[i].kor;
			sums[1] += sts[i].eng;
			sums[2] += sts[i].math;
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
			avgs[i] = Math.round((double)sums[i] / sts.length * 100) / 100.0;
			System.out.print("\t" + avgs[i]);
		}
		
	}

}
