package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_3061 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		for (int i = 0; i < test_case; i++) {
			int n = sc.nextInt();
			
			int[] ladder = new int[n];
			
			for (int j = 0; j < n; j++) {
				ladder[j] = sc.nextInt()-1;
			}
			
			
			int idx = 0, count = 0, temp = 0;
			for (int j = 0; j < n; j++) { // j를 기준으로 확인: 0 1 2
				
				for (int k = j; k < n; k++) {
					if (j == ladder[k]) {
						idx = k; // 찾아가야 하는 인덱스
					}
				}
				
				
				while( j != ladder[j] ) {
					temp = ladder[idx];
					ladder[idx] = ladder[idx-1];
					ladder[idx-1] = temp;
					
					idx--;
					count++;
				}
				
			}
			System.out.println(count);
		}
		
		
		
	}
}
