package j_collection;

import java.util.ArrayList;

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
//선언	
		//이름
		ArrayList<String> names = new ArrayList<String>();
		names.add("이단비");
		names.add("김노을");
		names.add("정현욱");
		names.add("박소현");
		names.add("김수진");
		names.add("이희현");
		names.add("강   건");
		names.add("이민영");
		names.add("하기재");
		names.add("김미희");
		names.add("김혜윤");
		names.add("신승철");
		names.add("이광효");
		names.add("김진혁");
		names.add("마창수");
		names.add("양기욱");
		names.add("이동근");
		names.add("석기현");
		names.add("이미정");
		names.add("임나리");
		names.add("류인성");
		names.add("김지윤");
		names.add("조명석");
		//과목
		ArrayList<String> subjects = new ArrayList<String>();
		subjects.add("국어");
		subjects.add("영어");
		subjects.add("수학");
		subjects.add("사회");
		subjects.add("과학");
		subjects.add("Oracle");
		subjects.add("Java");
		//기타
		ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
		ArrayList<Integer> sums = new ArrayList<Integer>();
		ArrayList<Double> avgs = new ArrayList<Double>();
		ArrayList<Integer> subSums = new ArrayList<Integer>();
		ArrayList<Double> subAvgs = new ArrayList<Double>();
		ArrayList<Integer> ranks = new ArrayList<Integer>();
		
//랜덤 점수
		for(int i = 0; i < names.size(); i++){
			ArrayList<Integer> score = new ArrayList<>();
			for(int j = 0; j < subjects.size(); j++){
				score.add((int)(Math.random() * 101));
			}
			scores.add(score);
		}
//		System.out.println(scores);
		
//학생 합계, 평균, 반올림		
		for(int i = 0; i < scores.size(); i++){
			int sum = 0;
			for(int j = 0; j < scores.get(i).size(); j++){
				sum += scores.get(i).get(j);
			}
			sums.add(sum);
			avgs.add(Math.round((double)sum / subjects.size() * 100) / 100.0);
		}
//		System.out.println(sums);
//		System.out.println(avgs);
		
//석차		
		for(int i = 0; i < names.size(); i++){
			ranks.add(1);
		}
		for(int i = 0; i < sums.size(); i++){
			for(int j = 0; j < sums.size(); j++){
				if(sums.get(i) < sums.get(j)){
					ranks.set(i, ranks.get(i) + 1);
				}
			}
		}
//		System.out.println(ranks);
		
//선택 정렬
		for(int i = 0; i < ranks.size(); i++){
			int min = i;
			for(int j = i + 1; j < ranks.size(); j++){
				if(ranks.get(j) < ranks.get(min)){
					min = j;
				}
			}
		String tempstudents = names.get(i);
		names.set(i, names.get(min));
		names.set(min, tempstudents);
		
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
			for(int j = 0; j < names.size(); j++){
				sum += scores.get(j).get(i);
			}
			subSums.add(sum);
			subAvgs.add(Math.round((double)sum / names.size() * 100) / 100.0);
		}
//		System.out.println(subSums);
//		System.out.println(subAvgs);
		
//출력	
		//이름
		System.out.print("이름");
		//과목
		for(int i = 0; i < subjects.size(); i++){
			System.out.print("\t" + subjects.get(i));
		}
		//합계, 평균, 석차
		System.out.println("\t합계\t평균\t석차");
		//이름, 점수, 합계, 평균, 석차
		for(int i = 0; i < scores.size(); i++){
			System.out.print(names.get(i));
			for(int j = 0; j < scores.get(i).size(); j++){
				System.out.print("\t" + scores.get(i).get(j));
			}
			System.out.print("\t" + sums.get(i) + "\t" + avgs.get(i) + "\t" + ranks.get(i));
			System.out.println();
		}
		//과목합계
		System.out.print("과목합계");
		for(int i = 0; i < subjects.size(); i++){
			System.out.print("\t" + subSums.get(i));
		}
		System.out.println();
		//과목평균
		System.out.print("과목평균");
		for(int i = 0; i < subjects.size(); i++){
			System.out.print("\t" + subAvgs.get(i));
		}
		
	}
}
