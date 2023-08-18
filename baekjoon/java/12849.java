package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_12849_2 {
    static int N, ans, div=1000000007;
    static long[][] map;

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	    N = Integer.parseInt(br.readLine()); // 시간
	    map = new long[N+1][8];
	    map[0][0] = 1;
	    
	    // 정보관 0 전산관 1 미래관 2 신앙관 3 한경직 4 진리관 5 학생회관 6 형공 7
	    
	    for (int n = 0; n < N; n++) {
			map[n+1][0] = (map[n][1]+map[n][2])%div;
			map[n+1][1] = (map[n][0]+map[n][3]+map[n][2])%div;
			map[n+1][2] = (map[n][0]+map[n][1]+map[n][3]+map[n][4])%div;
			map[n+1][3] = (map[n][4]+map[n][1]+map[n][2]+map[n][5])%div;
			map[n+1][5] = (map[n][4]+map[n][3]+map[n][6])%div;
			map[n+1][4] = (map[n][5]+map[n][3]+map[n][2]+map[n][7])%div;
			map[n+1][6] = (map[n][5]+map[n][7])%div;
			map[n+1][7] = (map[n][6]+map[n][4])%div;
		}
	    
	    System.out.println(map[N][0]%div);
	
	}
}
