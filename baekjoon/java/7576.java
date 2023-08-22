package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7576 {

	static int[][] map;
	private static boolean[][] visited;
	private static int R;
	private static int C;
	static Queue<int[]> queue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		queue = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) queue.offer(new int[] {i,j});
			}
		}
		
		bfs();
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				else {
					result = Math.max(map[i][j], result);
				}
			}
		}
		
		System.out.println(result-1);
		
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static void bfs() {
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			
			for (int k = 0; k < 4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if (nx<0 || nx>R-1 || ny<0 || ny>C-1) continue;
				if (map[nx][ny] == 0) {
					map[nx][ny] = map[x][y] + 1;
					queue.offer(new int[] {nx,ny});
				}
			}
			
		}
		
	}

	
	
	
}
