package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_11724 {

	private static int N;
	private static int M;

	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		
		int cnt = 0;
		visited = new boolean[N+1];
		for (int i = 1; i < N+1; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	static boolean[] visited;
	static void bfs(int i) {
		visited[i] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(i);
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int j = 0; j < arr[tmp].size(); j++) {
				if(!visited[arr[tmp].get(j)]) {
					visited[arr[tmp].get(j)] = true;
					queue.offer(arr[tmp].get(j));
				}
			}
		}
		
	}

}
