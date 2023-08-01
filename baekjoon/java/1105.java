package baekjoon;

import java.util.Scanner;

public class Baekjoon_1105 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String l = sc.next();
		String r = sc.next();
		int lLen = l.length();
		int cnt = 0;
		
		if (l.length() != r.length()) {
			System.out.println(0);
			return;
		}
		
		// 큰 자리 수부터 계속 8이어야!! 함.ㅋㅋ 아~
		for (int i = 0; i < lLen; i++) {
			if (l.charAt(i) == r.charAt(i)) {	
				if(l.charAt(i) =='8' && r.charAt(i) == '8') {
					cnt++;
				}
			}
			else {
				break;
			}
			
		}
		
		System.out.println(cnt);
		
	}

}
