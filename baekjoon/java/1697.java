package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1697 {

	private static int n;
	private static int k;
	private static boolean[] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());	
		arr = new boolean[100001];
		
		bfs(n);
		
	}
	
	
	static void bfs(int a) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {a, 0});
		arr[a] = true;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			a = tmp[0];
			if(a == k) {
				System.out.println(tmp[1]);
				return;
			}
			
			if(a<100000 && !arr[a+1]) {
				arr[a+1]=true;
				queue.offer(new int[] {a+1,tmp[1]+1});
			}
			if(a<=50000 && !arr[a*2]) {
				arr[a*2]=true;
				queue.offer(new int[] {a*2,tmp[1]+1});
			}
			if(a>0 && a<100001 && !arr[a-1]) {
				arr[a-1]=true;
				queue.offer(new int[] {a-1,tmp[1]+1});
			}
			
			
		}
		
	}

}
