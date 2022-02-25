package study.study2;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요.");
		String str = ScanUtil.nextLine();
		String str2 = "";
		
		int count = 0;
		
		for(int i = str.length() - 1; i >= 0; i--){
			str2 = str.charAt(i) + str2;
			count ++;
			if(count % 3 == 0 && count != str.length()){
				str2 = "," + str2;
			}
		}
		System.out.println(str2);
	}

}
