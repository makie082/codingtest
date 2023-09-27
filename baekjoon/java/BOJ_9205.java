package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {

	private static int T;
	private static int N;
	private static ArrayList<Point> store;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[1+N];
			store = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Point home = new Point(x,y);
			
			for (int n = 0; n < N+1; n++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				store.add(new Point(x,y));
				
			}
			
			// 1000미터마다 편의점이 있어야함
			// 시작점을 기준으로 온갖 1000미터 마다 편의점 있는지 확인 ㄱ 해야할듯 ?
			bfs(home.x, home.y);
			
			if (visited[N]) System.out.println("happy");
			else System.out.println("sad");
		}
		
		
		
		

	}
	
	static void bfs(int startX, int startY) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(startX, startY));
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.x;
			int y = point.y;
			
			for (int i = 0; i < N+1; i++) {
				if(visited[i]) continue;

				int dis = Math.abs(store.get(i).x-x) + Math.abs(store.get(i).y-y);
				if (dis <= 1000) {
					visited[i] = true;
					queue.offer(new Point(store.get(i).x, store.get(i).y));
				}
			}
		}
		
	}
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
		
	}

}
