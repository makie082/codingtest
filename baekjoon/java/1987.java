package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1987 {
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	private static int r;
	private static int c;
	private static char[][] map;
	private static int[] alp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    r = Integer.parseInt(st.nextToken());
	    c = Integer.parseInt(st.nextToken());
	    
	    map = new char[r][c];
	    alp = new int[26];
	    
	    for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
	    
	    dfs(0,0,0);
	    
	    System.out.println(result);
	    
	}
	static int result;
	static void dfs(int x, int y, int cnt) {
		if(alp[map[x][y]-'A'] != 0 ) {
			result = Math.max(result, cnt);
			return;
		}else {
			alp[map[x][y]-'A']++;
					
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0||nx>r-1||ny<0||ny>c-1) continue;
				dfs(nx,ny, cnt+1);
			}
			alp[map[x][y]-'A']--; // 원복!!! 해주어야함
		}
		
		
		
	}
	
	

}
