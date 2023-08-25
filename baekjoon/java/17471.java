package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17471 {

	private static int N;
	private static int[] land;
	private static List<Integer>[] connection;
	private static int[] people;
	private static int totalPop;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		people = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < 1+N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		connection = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			connection[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				connection[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 사람 수를 기준으로 나눈 다음에 연결된지 확인
		isSelected = new boolean[N+1];
		subSet(1);
		
		if (minDif == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minDif);
		
		
		
	}
	
	
	static boolean[] isSelected;
	static int minDif = Integer.MAX_VALUE;
	static void subSet(int cnt) {
		if (cnt == N+1) {
			
			int selPop = 0;
			int unSelPop = 0;
			for (int i = 1; i < N+1; i++) {
				if (isSelected[i] == true) selPop += people[i];
				else unSelPop += people[i];
			}
			
			// 차이 값이 더 작아진다면
			if (minDif > Math.abs(unSelPop - selPop)) {
				// 연결되어 있는지 확인!!!!
				visited = new boolean[N+1];
				for (int i = 1; i < N+1; i++) {
					if (isSelected[i]) {
						bfs(i);
						break;
					}
				}
				for (int i = 1; i < N+1; i++) {
					if(!isSelected[i]) {
						bfs2(i);
						break;
					}
				}
				boolean f = true;
				for (int i = 1; i < N+1; i++) {
					if (visited[i] == false) {
						f = false;
						break;
					}
				}
				if (f == true) minDif = Math.abs(unSelPop - selPop);
			}
			return;
		}
		
		isSelected[cnt] = true;
		subSet(cnt+1);
		isSelected[cnt] = false;
		subSet(cnt+1);
	}
	
	
	static boolean[] visited;
	
	static void bfs(int start) { // 선택 된 것들이 연결 되었는지 확인
		Queue<Integer> queue = new ArrayDeque<>();
		visited[start] = true;
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i = 0; i < connection[tmp].size(); i++) {
				if (!visited[connection[tmp].get(i)] && isSelected[connection[tmp].get(i)]) {
					queue.offer(connection[tmp].get(i));
					visited[connection[tmp].get(i)] = true;
				}
			}
			
		}
		
	}
	
	static void bfs2(int start) { // 선택 안된 것들이 연결되었는지 확인
		Queue<Integer> queue = new ArrayDeque<>();
		visited[start] = true;
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i = 0; i < connection[tmp].size(); i++) {
				if (!visited[connection[tmp].get(i)] && !isSelected[connection[tmp].get(i)]) {
					queue.offer(connection[tmp].get(i));
					visited[connection[tmp].get(i)] = true;
				}
			}
			
		}
		
	}

}
