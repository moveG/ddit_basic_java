package j_collection;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * 인터페이스
		 * List: 배열과 유사, 인덱스에 저장값을 불러옴, 인덱스에 순서가 존재, ArrayList를 자주 사용함
		 * Map: 값을 인덱스가 아닌 키에 저장함, 값을 저장할 키는 직접 설정함, 보통 키와 값을 같이 저장함, 순서가 없음, 자주 사용됨
		 * Set: 값을 저장하는데 중복된 값이 저장되지 않음, 사용빈도가 낮음
		 * 
		 * <ArrayList 클래스에 존재하는 메서드>
		 * boolean add(Object obj): 마지막 위치에 객체를 추가한 뒤 성공여부를 반환한다, 자주 사용됨
		 * void add(int index, Object obj): 지정된 위치에 객체를 추가한다, 사용 빈도가 낮음
		 * Object set(int index, Object obj): 지정된 위치에 객체를 저장한 뒤 기존 객체를 반환한다.
		 * Object get(int index): 지정된 위치의 객체를 반환한다.
		 * int size(): 저장된 객체의 수를 반환한다.
		 * Object remove(int index): 지정된 위치의 객체를 제거한 뒤 반환한다.
		 */
		
		ArrayList sample = new ArrayList();
		
		sample.add("abc"); 	// 값을 저장, 타입에 상관없이 저장이 가능함, 순서대로 저장됨(0번 인덱스에 저장됨)
		sample.add(100);	// 값을 저장, 타입에 상관없이 저장이 가능함, 순서대로 저장됨(1번 인덱스에 저장됨)
		
		//제네릭: 저장할 수 있는 타입을 지정해주는 것, <>안에 지정할 타입을 기술한다.
		//제네릭을 지정하지 않으면 넣을 때는 편하나, 꺼낼 때는 타입을 예측하기 힘들다.
		//따라서 제네릭의 사용이 권장된다.
		ArrayList<Integer> list = new ArrayList<>();//new ArrayList<Integer>();라고 해도 되지만, 앞에서 이미 Integer타입을 지정했기 때문에 <>만 사용해도 무방하다.
		list.add(10);
//		list.add("abc");//지정한 타입이 아닌 값을 저장하려면 컴파일 오류가 발생한다.
		list.add(20);
		//add라는 메서드는 리턴 타입이 존재한다.(저장의 성공여부를 반환한다. - true or false)
		System.out.println(list.add(30));
		System.out.println(list);
		
		list.add(1, 40);
		System.out.println(list);//삽입된 값 뒤의 값들은 한칸씩 밀려난다.
		//이미 저장된 범위 안에서만 인덱스를 지정할 수 있다.
//		list.add(5, 33);//저장된 범위를 벗어나서 지정했기 때문에 오류가 발생함
//		System.out.println(list);
		
		/* 
		 *  변수타입 : 클래스
		 *    byte : Byte
		 *   short : Short
		 *     int : Integer
		 *    long : Long
		 *   float : Float
		 *  double : Double
		 *    char : Character
		 * boolean : Boolean
		 * 
		 * 이 둘은 자동으로 형변환된다.
		 */
		Integer before = list.set(2, 50);
		//2번 인덱스에 50을 저장하고, 기존의 값을 반환한다.
		//원래는 new Integer(50)을 넣어야 하지만 자동으로 형변환되므로 int타입 50만 넣어도됨
		System.out.println("before : " + before);//반환된 기존의 값(20)을 출력함
		System.out.println("after : " + list.get(2));//새롭게 저장된 값(50)을 출력함
		System.out.println(list);
		
//		for(int i = 0; i < list.size(); i++){//저장된 객체의 수를 반환한다.
//			System.out.println(i + " : " + list.get(i));//지정된 위치의 객체를 반환한다.
//			list.remove(i);//지정된 위치의 객체를 제거한 뒤 반환한다.
//		}
//		System.out.println(list);
		//다 삭제되지 않은 이유: 삭제되면 사이즈가 줄어들게 되므로 0, 1, 2를 삭제할 동안 size가 3, 2, 1순으로 줄어들게 되므로 2개가 남는다.
		//모두 삭제하려면 뒤에서부터 삭제를 하면 된다.
		for(int i = list.size() - 1; i >= 0; i--){
			System.out.println(i + " : " + list.remove(i));
		}
		System.out.println(list);

		//앞으로 배열대신 ArrayList를 사용하면 됨.
		
		//list에 1~100 사이의 랜덤값을 10개 저장해주세요.(문제)
		for(int i = 0; i < 10; i++){
			list.add((int)(Math.random() * 100) + 1);
		}
		System.out.println(list);
		//list에 저장된 값의 합계와 평균을 구해주세요.
		int sum = 0;
		double avg = 0;
		for(int i = 0; i < list.size(); i++){
			sum += list.get(i);
		}
		avg = (double)sum / list.size();
		System.out.println("합계 : " + sum + " / 평균 : " + avg);
		//list에서 최소값과 최대값을 구해주세요.
		int max = list.get(0);
		int min = list.get(0);
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) > max){
				max = list.get(i);
			}
			if(list.get(i) < min){
				min = list.get(i);
			}
		}
		System.out.println("최대값 : " + max + " / 최소값 : " + min);
		//list를 오름차순으로 정렬해주세요.
		//정렬의 핵심은 set을 사용하는 것이다.
		//버블정렬
//		for(int i = 0; i < list.size() - 1; i++){
//			for(int j = 0; j < list.size() - 1 - i; j++){
//				if(list.get(j) > list.get(j + 1)){
//					int temp = list.get(j);
//					list.set(j, list.get(j + 1));
//					list.set(j + 1, temp);
//				}
//			}
//		}
//		System.out.println(list);
		//선택정렬
//		for(int i = 0; i < list.size() - 1; i++){
//			min = i;
//			for(int j = i + 1; j < list.size(); j++){
//				if(list.get(j) < list.get(min)){
//					min = j;
//				}
//			}
//			int temp = list.get(i);
//			list.set(i, list.get(min));
//			list.set(min, temp);
//		}
//		System.out.println(list);
		//삽입정렬
//		for(int i = 1; i < list.size(); i++){
//			int temp = list.get(i);
//			int j = 0;
//			for(j = i - 1; j >= 0; j--){
//				if(temp < list.get(j)){
//					list.set(j + 1, list.get(j));
//				}else{
//					break;
//				}
//			}
//			list.set(j + 1, temp);
//		}
//		System.out.println(list);

		//2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		
		list= new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list2.add(list);
		
		list = new ArrayList<>();
		list.add(40);
		list.add(50);
		list2.add(list);
		
		System.out.println(list2);
		
		for(int i = 0; i < list2.size(); i++){
			ArrayList<Integer> li = list2.get(i);
			for(int j = 0; j < li.size(); j++){
				System.out.println(li.get(j));
			}
		}
		int num = list2.get(0).get(1);
		System.out.println(num);
		
	}
}
