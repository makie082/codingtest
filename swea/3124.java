package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Swea_3124{
	static int n;
	static int map[][];
	private static int v;
	private static int e;
	private static Edge[] edgeList;
	private static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int a,b,c;
		
		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}
		
	}
	
	
	static void make() {
		for (int i = 1; i < v+1; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int i) {
		if (parent[i] == i) return i;
		else return parent[i] = find(parent[i]);
	}
	
	static boolean union(int a, int b) {
		if (find(a) == find(b)) return false; // 같은 집합 내에 존재하므로 싸이클을 만든다
		else {
			parent[find(b)] = find(a); // a에 b를 합쳐준다
			return true;
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
	    
	
	    for (int t = 1; t < testCase+1; t++) {
	    	st = new StringTokenizer(br.readLine());
	    	v = Integer.parseInt(st.nextToken());
	    	e = Integer.parseInt(st.nextToken());
	    	
	    	edgeList = new Edge[e];
	    	parent = new int[v+1];
	    	
	    	for (int i = 0; i < e; i++) {
	    		st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Edge(a,b,c);
			}
	    	
	    	Arrays.sort(edgeList);
	    	
	    	make();
	    	
	    	long result = 0;
	    	int count = 0; // 연결된 간선 개수
	    	for (int i = 0; i < e; i++) {
				if (union(edgeList[i].a, edgeList[i].b)) {
					result+=edgeList[i].c;
					if(++count == v) break;
				}
			}
	    	
	    	System.out.println("#"+t+" "+result);
		}

	    
	    
	    
	    
	}
	

}
