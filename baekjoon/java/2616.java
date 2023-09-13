import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int N;
    private static int[] guests;
    private static int canMove;
    private static int[] train;
    private static int[][] dp;
    private static int[] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        guests = new int[N+1];
        sum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            guests[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1]+guests[i];
        }
        canMove = Integer.parseInt(br.readLine());
        // 입력 끝
        dp = new int[4][N+1];

        for (int i = 1; i < 4; i++) {
            for (int j = canMove; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-canMove] + sum[j] - sum[j-canMove]);
            }

        }


        System.out.println(dp[3][N]);





    }
}
