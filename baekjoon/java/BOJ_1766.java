
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766 {

	private static int[] inDegree;

	public static void main(String[] args) throws Exception{

		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] order = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			order[i] = new ArrayList<>();
		}
		
		inDegree = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			order[a].add(b);
			inDegree[b]++;
		}
		
	
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 1; i < N+1; i++) {
			if (inDegree[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			System.out.print(tmp+" ");
			for (int i = 0; i < order[tmp].size(); i++) {
				int nextNode = order[tmp].get(i);
				if (inDegree[nextNode] > 0) {
					inDegree[nextNode]--;
					if(inDegree[nextNode] == 0) queue.offer(nextNode);
				}
			}
		}
		
		
		
	}

}
