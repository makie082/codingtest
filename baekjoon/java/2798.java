package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = sc.nextInt();
		}
	
		comb(0,0);
		System.out.println(ans);

	}
	static int[] pick = new int[3];
	static int[] cards;
	static int n,m;
	static int sum;
	static int ans = 0;
	
	
	static void comb(int idx, int start) { // 3개 고르는 조합
		if (idx == 3) {
			sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += pick[i];
			}
			if(sum > m) {
				return;
			}else {
				ans = Math.max(ans, sum);
				return;
			}
		}
		
		
		for (int i = start; i < n; i++) {
//			System.out.println(idx + " " + i);
			pick[idx] = cards[i];
			comb(idx+1, i+1);
		}
	}

}
