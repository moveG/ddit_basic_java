package study.study1;

import java.util.ArrayList;

public class score {

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
//선언		
		ArrayList<String> students = new ArrayList<>();
		students.add("이단비");
		students.add("김노을");
		students.add("정현욱");
		students.add("박소현");
		students.add("김수진");
		students.add("이희현");
		students.add("강   건");
		students.add("이민영");
		students.add("하기재");
		students.add("이윤우");
		students.add("김미희");
		students.add("김혜윤");
		students.add("신승철");
		students.add("이광효");
		students.add("김진혁");
		students.add("마창수");
		students.add("양기욱");
		students.add("이동근");
		students.add("석기현");
		students.add("류인성");
		students.add("이미정");
		students.add("임나리");
		students.add("송민섭");
		students.add("김지윤");
		students.add("조명석");
		
		ArrayList<String> subjects = new ArrayList<>();
		subjects.add("국어");
		subjects.add("영어");
		subjects.add("수학");
		subjects.add("사회");
		subjects.add("과학");
		subjects.add("Oracle");
		subjects.add("Java");
		
		ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
		ArrayList<Integer> sums = new ArrayList<>();
		ArrayList<Double> avgs = new ArrayList<>();
		ArrayList<Integer> ranks = new ArrayList<>();
		ArrayList<Integer> subSums = new ArrayList<>();
		ArrayList<Double> subAvgs = new ArrayList<>();
//랜덤 점수
		for(int i = 0; i < students.size(); i++){
			ranks.add(1);
			ArrayList<Integer> score = new ArrayList<>();
			for(int j = 0; j < subjects.size(); j++){
				score.add((int)(Math.random() * 101));
			}
			scores.add(score);
		}
//학생 합계, 평균, 반올림		
		for(int i = 0; i < scores.size(); i++){
			int sum = 0;
			for(int j = 0; j < scores.get(i).size(); j++){
				sum += scores.get(i).get(j);
			}
			sums.add(sum);
			avgs.add(Math.round((double)sum / scores.get(i).size() * 100) / 100.0);
		}
//석차		
		for(int i = 0; i < sums.size(); i++){
			for(int j = 0; j < sums.size(); j++){
				if(sums.get(i) < sums.get(j)){
					ranks.set(i, ranks.get(i) + 1);
				}
			}
		}
//선택 정렬		
		for(int i = 0; i < ranks.size(); i++){
			int min = i;
			for(int j = i + 1; j < ranks.size(); j++){
				if(ranks.get(j) < ranks.get(min)){
					min = j;
				}
			}
		String tempstudents = students.get(i);
		students.set(i, students.get(min));
		students.set(min, tempstudents);
		
		ArrayList<Integer> tempScore = scores.get(i);
		scores.set(i, scores.get(min));
		scores.set(min, tempScore);
		
		int tempSum = sums.get(i);
		sums.set(i, sums.get(min));
		sums.set(min, tempSum);
		
		double tempAvg = avgs.get(i);
		avgs.set(i, avgs.get(min));
		avgs.set(min, tempAvg);
		
		int tempRank = ranks.get(i);
		ranks.set(i, ranks.get(min));
		ranks.set(min,  tempRank);
		}
//과목 합계, 평균
		for(int i = 0; i < subjects.size(); i++){
			int sum = 0;
			for(int j = 0; j < students.size(); j++){
				sum += scores.get(j).get(i);
			}
			subSums.add(sum);
			subAvgs.add(Math.round((double)sum / students.size() * 100) / 100.0);
		}
//출력		
		System.out.print("이름");
		for(int i = 0; i < subjects.size(); i++){
			System.out.print("\t" + subjects.get(i));
		}
		System.out.println("\t합계\t평균\t석차");
		for(int i = 0; i < scores.size(); i++){
			System.out.print(students.get(i));
			ArrayList<Integer> score = scores.get(i);
			for(int j = 0; j < score.size(); j++){
				System.out.print("\t" + score.get(j));
			}
			System.out.println("\t" + sums.get(i) + "\t" + avgs.get(i) + "\t" + ranks.get(i));
		}
		System.out.print("과목합계");
		for(int i = 0; i < subjects.size(); i++){
			System.out.print("\t" + subSums.get(i));
		}
		System.out.println();
		System.out.print("과목평균");
		for(int i = 0; i < subjects.size(); i++){
			System.out.print("\t" + subAvgs.get(i));
		}
	}
}
