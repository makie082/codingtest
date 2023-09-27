import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
	
	static int[] floor;
	private static int f;
	private static int s;
	private static int g;
	private static int u;
	private static int d;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Integer.parseInt(st.nextToken()); // 전체 층 수
		s = Integer.parseInt(st.nextToken())-1; // 현재 층
		g = Integer.parseInt(st.nextToken())-1; // 가야할 층
		u = Integer.parseInt(st.nextToken()); // 위로 이동하는 칸 수
		d = Integer.parseInt(st.nextToken()); // 아래로 이동하는 칸 수
		
		
		floor = new int[f];
		visited = new boolean[f];
		Arrays.fill(floor, Integer.MAX_VALUE);
		
		floor[s] = 0;
		bfs(s);
		
		if (floor[g] == Integer.MAX_VALUE) System.out.println("use the stairs"); 
		else System.out.println(floor[g]);
		
		
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			
			int std = queue.poll();
			if (std == g) return;
			
			if (std+u < f && !visited[std+u]) {
				visited[std+u]=true; // 가장 처음 방문해서 넣어준 값이 가장 작은 값이므로 다시 방문해주지 않아도 된다
				queue.offer(std+u);
				floor[std+u] = Math.min(floor[std]+1, floor[std+u]);
			}
			if (std-d > -1 && !visited[std-d]) {
				visited[std-d]=true;
				queue.offer(std-d);
				floor[std-d] = Math.min(floor[std]+1, floor[std-d]);
			}
		}
		
	}
	
	

}
