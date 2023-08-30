package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1010 {
	private static int t;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0 || m == 0) {
				System.out.println(0);
				return;
			}
			int[][] arr = new int[n+1][n+1];
			
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k <= j; k++) {
					if (k == 0 || k == j) arr[j][k] = 1;
					else arr[j][k] = arr[j-1][k-1] + arr[j-1][k];
				}
			}
			
			System.out.println(arr[n][m]);
		}

	}

}
