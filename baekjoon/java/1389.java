package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1389 {

	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friend = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			friend[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a].add(b);
			friend[b].add(a);
		}
		sums = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			bfs(i);
			sums[i] = sum;
		}
		
		int minidx=0;
		for (int i = 1; i < N+1; i++) {
			if (min > sums[i]) {
				min = sums[i];
				minidx = i;
			}
		}
		System.out.println(minidx);
		
		
	}
	static ArrayList<Integer>[] friend;
	static int sum=0;
	static int[] sums;
	static int min = Integer.MAX_VALUE;
	static void bfs(int person) {
		Queue<Integer> queue = new ArrayDeque();
		queue.offer(person);
		
		int[] selected = new int[N+1];
		while(!queue.isEmpty()) {
			int pick = queue.poll();
			for (int i = 0; i < friend[pick].size(); i++) {
				if (selected[friend[pick].get(i)] == 0) {
					queue.offer(friend[pick].get(i));
					selected[friend[pick].get(i)] = selected[pick]+1;
				}
			}
		}
		
		sum=0;
//		System.out.print(person+"와 연결된 것들의 수: ");
		for (int i = 1; i < N+1; i++) {
//			System.out.print(selected[i]+" ");
			sum+=selected[i];
		}
//		System.out.println("=====>"+sum);
//		System.out.println();
	}

}
