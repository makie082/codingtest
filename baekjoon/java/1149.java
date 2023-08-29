package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1149 {

	private static int n;
	private static int[][] map;
	private static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        map = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[n][3];
        
        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2];
        
        
        for (int i = 1; i < n; i++) {
			dp[i][0] = map[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = map[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = map[i][2]+Math.min(dp[i-1][1], dp[i-1][0]);
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
			if(result>dp[n-1][i]) {
				result = dp[n-1][i];
			}
		}
        System.out.println(result);
        

	}

}
