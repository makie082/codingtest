package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1260 {

	static int n,m,v;
	static int map[][];
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    v = Integer.parseInt(st.nextToken());
		// 인접행렬
//	    map = new int[n+1][n+1];
//	    
//	    for (int i = 0; i < m; i++) {
//	    	st = new StringTokenizer(br.readLine());
//			int x= Integer.parseInt(st.nextToken());
//			int y= Integer.parseInt(st.nextToken());
//			
//			map[x][y] = 1;
//			map[y][x] = 1;
//		}
	    
	    // 인접리스트
	    arr = new ArrayList[n+1];
	    for (int i = 1; i < n+1; i++) {
			arr[i] = new ArrayList<>();
		}
	    
	    for (int i = 0; i < m; i++) {
	    	st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
	    
	    for (int i = 1; i < n+1; i++) {
			Collections.sort(arr[i]);
		}
	    
	    visited = new boolean[n+1];
	    dfs_list(v);
	    System.out.println();
	    bfs_list(v);
	}
	
	// 인접리스트 
	static void dfs_list(int v) {
		System.out.print(v+" ");
		visited[v] = true;
		
		for (int i = 0; i < arr[v].size(); i++) {
			if (!visited[arr[v].get(i)]) dfs_list(arr[v].get(i));
		}
	}
	
	static void bfs_list(int v) {
		
		visited = new boolean[n+1];
		visited[v] = true;
		Queue<Integer> queue = new ArrayDeque();
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x+" ");
			for (int i = 0; i < arr[x].size(); i++) {
				if (!visited[arr[x].get(i)]) {
					visited[arr[x].get(i)] = true;
					queue.offer(arr[x].get(i));
				}
			}
		}
	}
	
	// 행렬버전 ㅋㅋ
	
	static void dfs_matrix(int v) {
		System.out.print(v+" ");
		visited[v]= true;
		
		for (int j = 1; j < n+1; j++) {
			if (map[v][j] == 1 && !visited[j]) {
				dfs_matrix(j);
			}
		}
	}
	
	
	
	static void bfs_matrix(int v) {
		Queue<Integer> queue = new ArrayDeque();
		visited = new boolean[n+1];
		visited[v] = true;
		queue.offer(v);
		
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x+" ");
			for (int i = 1; i < n+1; i++) {
				if (map[x][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					
				}
			}
		}
		
	}

}
