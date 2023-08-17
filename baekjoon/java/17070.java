package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17070 {

	static int n;
	static int map[][];
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    n = Integer.parseInt(br.readLine()); // 행
	    map = new int[n][n];
	    
	    for (int i = 0; i < n; i++) {
	    	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    
	    dfs(0,0,0,1);
	    System.out.println(ans);
	    
	}
	
	
	static int ans= 0;
	static void dfs(int headX, int headY, int tailX, int tailY) {
		if (tailX == n-1 && tailY == n-1) {
			ans++;
			return;
		}
//		System.out.println(headX+","+headY+","+tailX+","+tailY);
		if (headX == tailX) { // 가로
			if(tailY <= n-2 && map[tailX][tailY+1] == 0) {
				dfs(tailX, tailY, tailX, tailY+1); // 가로로 이동
				if (tailX <= n-2 && map[tailX+1][tailY+1] == 0 && map[tailX+1][tailY] == 0) dfs(tailX, tailY, tailX+1, tailY+1); // 대각선 이동
			}
			
		}
		else if(tailY == headY) { // 세로
			if(tailX <= n-2 && map[tailX+1][tailY] == 0) {
				dfs(tailX, tailY, tailX+1, tailY); // 세로로 이동
				if (tailY <= n-2 && map[tailX][tailY+1] == 0 && map[tailX+1][tailY+1] == 0) dfs(tailX, tailY, tailX+1, tailY+1); // 대각선 이동
			}
			
		}
			
		else if(tailX==headX+1 && tailY == headY+1){ // 대각선
			if(tailY <= n-2 && map[tailX][tailY+1] == 0) dfs(tailX, tailY, tailX, tailY+1); // 가로로 이동
			if(tailX <= n-2 && map[tailX+1][tailY] == 0) {
				dfs(tailX, tailY, tailX+1, tailY); // 세로로 이동
				if (tailY <= n-2 && map[tailX][tailY+1] == 0 && map[tailX+1][tailY+1] == 0) dfs(tailX, tailY, tailX+1, tailY+1); // 대각선 이동
			}

		}
		
		
	}

}
