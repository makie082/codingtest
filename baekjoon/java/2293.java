import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n+1];

        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }



//        더해지는 순서도 고려하는 경우
//        dp[3] = dp[1]+dp[2]라면 1+2 와 2+1을 모두 고려하므로 중복이 된다!
//        int[] dp = new int[k+1];
//        dp[0] = 1;
//        for (int i = 1 ; i < k+1; i++) {
//            for (int j = 0; j < n; j++) {
//                if(i>=coin[j]) dp[i] += dp[i-coin[j]];
//            }
//        }


        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1 ; i < n+1; i++) {
            for (int j = 1; j < k+1; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=coin[i]) dp[i][j] += dp[i][j-coin[i]];
            }
        }
        System.out.println(dp[n][k]);

    }

}
