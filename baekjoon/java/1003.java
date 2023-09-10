import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n==0){
                System.out.println("1 0");
                continue;
            }

            else if(n==1){
                System.out.println("0 1");
                continue;
            }
            int[][] dp = new int[n+1][2];
            dp[0][1] = 0;
            dp[0][0] = 1;
            dp[1][0] = 0;
            dp[1][1] = 1;

            for (int j = 2; j < n+1; j++) {
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1] + dp[j-2][1];
            }
            System.out.println(dp[n][0] + " " + dp[n][1]);

        }
    }
    // 0 -> 1 0
    // 1 -> 0 1
    // 2 -> 1 1
    // 3 -> 1 2
    // 4 -> 2 3
}
