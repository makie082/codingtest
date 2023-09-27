import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// 플루이드워셜 문제를 BFS로 해결
// 시간 복잡도가 많이 줄어듦을 확인할 수 있다
public class SW_1263_2 {

	private static int N;
	private static ArrayList<ArrayList<Integer>> adjList;
	private static int min;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adjList = new ArrayList<>();
		
			for (int i = 0; i < N; i++) {
				adjList.add(new ArrayList<>());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp == 1) adjList.get(i).add(j);
				}
			}
		
			min = Integer.MAX_VALUE;
			// 각 정점(사람) 별로 각자 최단 경로를 찾는다
			for (int i = 0; i < N; i++) {
				bfs(i);
			}
			
			System.out.println("#"+t+" "+min);
		}
	}
	
	static void bfs(int v) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visit = new boolean[N];
		
		visit[v] = true;
		queue.offer(new Node(v,0));
		
		int dist = 0; // 최단 경로를 찾는 변수
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			// node.v로 부터 갈 수 있는 자료구조를 찾기 !
			// adjList.get(node.v)에 갈 수 있는 노드들이 보인다
			for (int V : adjList.get(node.v)) {
				if (visit[V]) continue;
				dist += node.cnt+1;
				if (dist >= min) return; // 가지치기
				
				visit[V] = true;
				queue.offer(new Node(V, node.cnt+1));
			}
		}
		
		min = Math.min(min, dist);
	}
	
	
	static class Node{
		int v, cnt;

		public Node(int v, int cnt) {
			this.v = v;
			this.cnt = cnt;
		}		
	}

}
