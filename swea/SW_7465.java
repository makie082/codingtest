
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int T;
	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[][] people = new int[N+1][N+1];
			int[] visited = new int[N+1];
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				people[a][b] = 1;
				people[b][a] = 1;
			}
			
			int cnt = 1;
			for (int i = 1; i < N+1; i++) {
				if (visited[i]==0) {
					Queue<Integer> queue = new ArrayDeque<>();
					queue.add(i);
					visited[i] = cnt;
					
					while (!queue.isEmpty()) {
						int tmp = queue.poll();
						
						for (int a = 1; a < N+1; a++) {
							if (people[tmp][a] == 1 && visited[a]==0) {
								queue.offer(a);
								visited[a]=cnt;
							}
						}
					}
					cnt++;
				}
			}
			
			
			System.out.println("#"+t+" "+(cnt-1));
			
		}
		
		
		
		
		

	}

}
