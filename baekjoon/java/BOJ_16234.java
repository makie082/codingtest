package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {

	private static int N;
	private static int L;
	private static int R;
	private static int[][] A;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] visited;
	private static int check;
	

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				A[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		visited = new int[N][N];
		check = 1;
		
		while(true) {
			day++;
			// L R 비교해서 국경성 열기
			// 국경선들끼리 비교하기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (visited[r][c] == 0) {
						bfs(r,c);
						check++;
					}
				}
			}
			
			// 더이상 국가를 합칠 수 없을 때 while 문 밖으로 나감
			// 각자 이어질 수 없을 때 == check 값이 다 다를때
			if(check == N*N+1) break;
			
			// 연합 해체하고 국경선 닫기
			visited = new int[N][N];
			check = 1;
			
		}
		
		System.out.println(day-1);
		
	}
	
	static void bfs(int startX, int startY) {
		
		
		// 국경 열 수 있는지 확인하기
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startX, startY});
		visited[startX][startY] = check;
		int sum = 0;
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			sum += A[x][y];
			cnt++;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx<0 || nx>N-1 || ny<0 || ny>N-1 || visited[nx][ny] != 0) continue;
				
				if (Math.abs(A[x][y] - A[nx][ny]) >= L && Math.abs(A[x][y] - A[nx][ny]) <= R) {
					visited[nx][ny] = visited[x][y];
					queue.offer(new int[] {nx,ny});
				}
			}
			
		}
		
		
		// 열린 국경선에서 인구이동하고 연합
//		System.out.println(check +"인 거의 개수: " +cnt);
		sum /= cnt;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == check) A[i][j] = sum;
			}
		}
		
		
	}

}
