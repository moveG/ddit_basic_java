package e_oop.score;

public class Score {

	public static void main(String[] args) {
		String[] studentNames = {"이단비", "김노을", "정현욱", "박소현", "김수진",
				  				 "이희현", "강   건", "이민영", "하기재", "이윤우",
				  				 "김미희", "김혜윤", "신승철", "이광효", "김진혁",
				  				 "마창수", "양기욱", "이동근", "석기현", "류인성",
				  				 "이미정", "임나리", "송민섭", "김지윤", "조명석"};
		Student[] students = new Student[studentNames.length];

//랜덤점수
		for (int i = 0; i < students.length; i++) {
			Student student = new Student();
			
			student.name = studentNames[i];
			student.rank = 1;
			student.kor = (int)(Math.random() * 101);
			student.eng = (int)(Math.random() * 101);
			student.math = (int)(Math.random() * 101);
			
			students[i] = student;
		}
		
//합계, 평균
		for (int i = 0; i < students.length; i++) {
			students[i].sum = students[i].kor + students[i].eng + students[i].math;
			students[i].avg = Math.round(students[i].sum / 3.0 * 100) / 100.0;
		}
		
//석차
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i].sum < students[j].sum) {
					students[i].rank++;
				}
			}
		}
		
//정렬 (선택정렬)
		for (int i = 0; i < students.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < students.length; j++) {
				if (students[j].rank < students[min].rank) {
					min = j;
				}
			}
			Student temp = students[i];
			students[i] = students[min];
			students[min] = temp;
		}
		
//출력		
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].name + "\t"
							 + students[i].kor + "\t"
							 + students[i].eng + "\t"
							 + students[i].math + "\t"
							 + students[i].sum + "\t"
							 + students[i].avg + "\t"
							 + students[i].rank);
		}
		
//과목합계
		int[] sums = new int[3];
		for (int i = 0; i < students.length; i++) {
			sums[0] += students[i].kor;
			sums[1] += students[i].eng;
			sums[2] += students[i].math;
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
			avgs[i] = Math.round((double)sums[i] / students.length * 100) / 100.0;
			System.out.print("\t" + avgs[i]);
		}
		
		
////과목합계, 과목평균		
//		int subSumKor = 0;
//		int subSumEng = 0;
//		int subSumMath = 0;
//		double subAvgKor = 0;
//		double subAvgEng = 0;
//		double subAvgMath = 0;
//		
//		for (int i = 0; i < students.length; i++) {
//			subSumKor += students[i].kor;
//			subSumEng += students[i].eng;
//			subSumMath += students[i].math;
//		}
//		subAvgKor = Math.round((double)subSumKor / students.length * 100) / 100.0;	
//		subAvgEng = Math.round((double)subSumEng / students.length * 100) / 100.0;	
//		subAvgMath = Math.round((double)subSumMath / students.length * 100) / 100.0;	
//			
////과목합계, 과목 평균 출력		
//		System.out.print("과목합계\t");
//		System.out.println(subSumKor + "\t" + subSumEng + "\t" + subSumMath + "\t");
//
//		System.out.print("과목평균\t");
//		System.out.println(subAvgKor + "\t" + subAvgEng + "\t" + subAvgMath + "\t");
		
	}

}
