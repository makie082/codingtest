package baekjoon;

import java.util.Scanner;

public class Baekjoon_11501 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 0; t < tc; t++) {
			int n = sc.nextInt();
			
			int[] days = new int[n];
			for (int i = 0; i < n; i++) {
				days[i] = sc.nextInt();
			}
			
			// 뒤에서부터 확인!
			int idx = n-1;
      // 64bit로 출력하려면 data type을 long 으로 해야함!
			long sum = 0;
			for (int i = idx-1; i >= 0; i--) {
				//System.out.println(idx+"번째를 기준으로 "+i+"번째와 비교");
				if(days[idx] > days[i]) {
					//System.out.println(days[idx] + "에서 " + days[i] +"빼주자!");
					sum += (days[idx]-days[i]);
				}else{
					//System.out.println(days[idx] + "가 " + days[i] +"보다 작거나 같음요");
					idx = i;
				}
			}
			
			System.out.println(sum);
			
		}

	}

}
