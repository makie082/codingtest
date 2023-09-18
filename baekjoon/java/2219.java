import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플루이드워셜
// 모든 정점에서 모든 정점까지의 최소거리를 구할 수 있다!
// 3중 for문을 이용하여 바로 가는 것과, 거쳐가는 것을 비교하여 답을 구할 수 있다
public class Main {
    private static int N;
    private static int M;
    private static int[][] computers;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        computers = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(i==j) computers[i][j] = 0;
                else computers[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            computers[a][b] = c;
            computers[b][a] = c;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    // 범위 설정을 해주어야함 ㅜ ㅜ
                    if(computers[i][k] != Integer.MAX_VALUE && computers[j][i] != Integer.MAX_VALUE) computers[j][k] = Math.min(computers[j][k], computers[j][i] + computers[i][k]);
                }
            }
        }

      // 문제에서 구하라는 값을 너무 이상하게 줘서 플루이드 워셜만 익히고 문제는 별로인듯!
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                cnt += computers[i][j];
            }
            if(min > cnt){
                min = cnt;
                idx = i;
            }

        }

        System.out.println(idx);

    }
}
