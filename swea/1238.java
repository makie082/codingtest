package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1238 {

	private static int n;
	private static int start;
	private static int[] visited;
	static ArrayList<ArrayList<Integer>> adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList<>();
			for (int i = 0; i <= 100; i++) {
				adjList.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList.get(from).add(to);
			}
			
			visited = new int[101];
			bfs(start);
			
			int max = 0;
			int ans = 0;
			for (int i = 100; i > 0; i--) {
				if (max < visited[i]) {
					max = visited[i];
					ans = i;
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}

	}
	
	static void bfs(int start) {
		visited[start] = 1;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int a = queue.poll();
			System.out.println(a);
			for (Integer i : adjList.get(a)) {
				if (visited[i] == 0) {
					queue.offer(i);
					visited[i] = visited[a]+1;
				}
			}
		}
	}

}
