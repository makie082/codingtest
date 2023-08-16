package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1074 {

	static int N, cnt;
	private static int x;
	private static int y;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		check(x,y,(int)Math.pow(2, N),0);
		
	}
	
	static void check(int r, int c, int size, int cnt) {
		
		if (size == 1) {
			System.out.println(cnt);
			return;
		}
		
		if (r < size/2) { // 1. 2 사분면에 존재
			if( c < size/2) { // 2사분면에 존재
				// 첫번째 칸
				check(r,c, size/2, cnt);
			}else { // 1사분면에 존재
				// 두번째 칸
				check(r,c-size/2, size/2, cnt+(size/2)*(size/2));
			}
			
		}else { // 3.4 사분면에 존재
			if( c < size/2) { // 3사분면에 존재
				// 세번째 칸
				check(r-size/2, c, size/2, cnt+2*(size/2)*(size/2));
			}
			else { // 4사분면에 존재
				// 네번째 칸
				check(r-size/2, c-size/2, size/2, cnt+3*(size/2)*(size/2));
			}
		}
		
		
	}
	
	

}
