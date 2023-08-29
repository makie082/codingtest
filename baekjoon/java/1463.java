package baekjoon;

import java.util.Scanner;

public class Baekjoon_1463 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		arr[1] = 0;
		for (int i = 2; i <= n; i++) {
//			System.out.println(i+"일때");
			int tmp = Integer.MAX_VALUE;
			tmp = Math.min(arr[i-1],tmp);
//			System.out.println("1뺀다 ㅋㅋ=>"+arr[i-1]);
			if (i%3 == 0) {
				tmp = Math.min(arr[i/3],tmp);
//				System.out.println("3으로 나누어떨어짐=>"+arr[i/3]);
			}
			if (i%2 == 0) {
				tmp = Math.min(arr[i/2],tmp);
//				System.out.println("2으로 나누어떨어짐=>"+arr[i/2]);
			}
		
				
		
			arr[i] = tmp+1;
//			System.out.println("결국 "+tmp+" 들어감");
		}
		System.out.println(arr[n]);
	}
	

}
