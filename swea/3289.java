package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_3289 {

	// 서로소 집합을 표현하는 1차원 배열
	static int[] parent;
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			makeSet();
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int flag = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(flag == 0) {
					union(a,b);
				}
				else if (flag == 1) {
					if(findSet(b) == findSet(a)) sb.append("1");
					else sb.append("0");
				}
				
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	// 서로소 집합을 표현하는 자료구조 생성 및 초기화
	static void makeSet() {
		parent = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			parent[i] = i; // 자신 == 대표자
		}
	}

	// 소속된 서로소 집합의 대표 원소를 리턴
	static int findSet(int x) {
		// 기저조건
		// value 와 index 같은 조건
		if (parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]); // path compression o
	}
	
	// 두 서로소 집합을 하나로 합친다
	// x의 대표자, y의 대표자를 찾아서 합친다.
	static void union(int x, int y) {
		int px = findSet(x); // x의 최종 대표자 집합
		int py = findSet(y); // y의 최종 대표자 집합
		
		// px == py라는 뜻은 x와 y가 같은 서로소 집합에 속한다
		// 그렇지 않으면 x,y는 서로 다른 서로소 집합에 속한다
		parent[py] = px;
	}
}
