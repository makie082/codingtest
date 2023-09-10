import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int K;
    private static int[][] bag;

    // 냅색 문제 !!
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bag = new int[N+1][2];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken()); // 무게
            bag[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        // 무게 기준으로 정렬
        Arrays.sort(bag, (o1,o2) -> o1[0]-o2[0]);

        // for문을 이용해서 무게 늘려가며 확인
        int[][] dp = new int[N+1][K+1]; // 넣을 가방, 가능한 무게

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < K+1; j++) {
                if (j < bag[i][0]) dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-bag[i][0]] + bag[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
