import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1263 {

	private static int N;
	private static int[][] map;
	private static int[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp == 0) {
						
						visited[i][j] = 987654321;
					}
					else visited[i][j] = 1;
				}
			}
		
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i == j) visited[i][j] = 0; // 자기 자신으로 오는 경우는 생각X
						visited[i][j] = Math.min(visited[i][j], visited[i][k] + visited[k][j]);
					}
				}
			}
			
			int ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
				
					sum += visited[i][j];
				}
				ans = Math.min(sum, ans);
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}

}
