package algo;

import java.io.*;
import java.util.*;

public class BOJ_4485 {

	private static int N;
	private static int[][] map;
	private static int T;
	private static int INF = 987654321;
	
	static int[] dx = {1,-1,0,0}; // 오른쪽 아래로만 가면 될 거 같은데?
	static int[] dy = {0,0,1,-1};
	private static int[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = 1;
		StringTokenizer st;
		
		while (N!=0) {
			
			map = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = INF;
				}
			}
			
			dij();
			
			System.out.println("Problem "+T+": "+visited[N-1][N-1]);
			T++;
			N = Integer.parseInt(br.readLine());
		}
		
		
		
		
		
		
		
	}
	
	
	static void dij() {
		// 0,0에서 시작함
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(0,0));
		visited[0][0] = map[0][0];
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;
				
				if (visited[x][y]+map[nx][ny] < visited[nx][ny]) {
					visited[nx][ny] = visited[x][y]+map[nx][ny];
					queue.offer(new Point(nx,ny));
				}
				
				
				
			}
		}
		
	}
	
	
	
	static class Point{
		int x,y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
