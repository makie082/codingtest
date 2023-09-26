
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {

	static int[] visited;
	
	static int check1, check2,n;

	private static boolean[][] map;
	
	public static void main(String[] args) throws Exception{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		check1 = Integer.parseInt(st.nextToken()); // 나이 더 많음
		check2 = Integer.parseInt(st.nextToken()); // 나이 더 적음
		
		int m = Integer.parseInt(br.readLine());
		
		map = new boolean[n+1][n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 부모
			int y = Integer.parseInt(st.nextToken()); // 자녀
			map[x][y] = true;
			map[y][x] = true;
		}
		
		visited = new int[n+1];
		Arrays.fill(visited, -1);
		bfs(check2);
		System.out.println(visited[check1]);
		
		
	}

	
	static void bfs(int start) {
		 Queue<Integer> queue = new ArrayDeque<>();
		 queue.offer(start);
		 visited[start] = 0;
		 
		 while(!queue.isEmpty()) {
			 int tmp = queue.poll();
			 
			 for (int i = 0; i < n; i++) {
				if(map[tmp][i] && visited[i]==-1) {
					queue.offer(i);
					visited[i] = visited[tmp]+1;
				}
			}
		 }
		 
		 
	}

}
