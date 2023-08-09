package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1861 {

	static int maxNum, n, cnt;
	static int[] dx = {1,-1,0,0}; // 상하좌우 
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
	
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			int ansBlock = n*n+2;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt = 0;
					selected = new int[n*n+1];
					check(i,j);
					if (ans <= cnt) {
						if (ans == cnt) ansBlock = Math.min(map[i][j], ansBlock);
						else {
							ansBlock = map[i][j];
							ans = cnt;
						}
						
					}
				}
			}
			System.out.println("#"+t+" "+ansBlock+" "+ans);
		}

	}
	
	static void check(int i, int j) {
		selected[map[i][j]] = 1;
		cnt++;

		int nx, ny;
		for (int k = 0; k < 4; k++) {
			nx = i+dx[k];
			ny = j+dy[k];
			if (nx<0||ny<0||nx>n-1||ny>n-1) {
				continue;
			}
			else {
				if(selected[map[nx][ny]] == 1) continue;
				else {
					if(map[nx][ny] - map[i][j] == 1 ) {
//						System.out.println(nx+" "+ny+" 지나감요");
						check(nx,ny);
					}
				}
			}
		}
	}

}
