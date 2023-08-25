package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_17281 {

	private static int n,result,ans;
	private static int[] order = new int[10];
	static boolean[] visited = new boolean[10];
	private static int[][] ining;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		ining = new int[n][10];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				ining[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(1);
		System.out.println(ans);
	}
	
	
	
	static void perm(int tgtIdx) {
		if (tgtIdx == 10) {
			if (order[4] == 1) {
				play(); // 1번 선수가 4번 타자일 경우
				ans = Math.max(result, ans);
			}
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			if(!visited[i]) {
				order[tgtIdx] = i;
				visited[i] = true;
				perm(tgtIdx+1);
				visited[i] = false;
			}
		}		
	}
	
	static void play() {
		
		result = 0;
		int o = 1;
		int turn = order[o];
		int outCnt = 0;
		
		
		for (int i = 0; i < n; i++) {
			int one=0;
			int two=0;
			int three=0;
			
			
			while(true) {
				
				if (o == 10) {
					o = 1;
				}
				turn = order[o];
				
				if (ining[i][turn] == 0) outCnt++;
				else if(ining[i][turn] == 1) { // 안타
					if (three>0) {
						three--;
						result++;
					}
					if (two>0) {
						three++;
						two--;
					}
					if (one>0) {
						two++; // 1루 사람이 2루로 이동
						one--; // 1루 사람 빠짐
					}
					
					
					one++; // 타자가 1루로 이동
				}
				else if(ining[i][turn] == 2) { // 2루타
					if (three>0) {
						three--;
						result++;
					}
					if (two>0) {
						two--;
						result++;
					}
					if (one>0) {
						one--;
						three++;
					}
					
					two++;
				}
				else if(ining[i][turn] == 3) { // 3루타
					if (one>0) result++;
					if (two>0) result++;
					if (three>0) result++;
					one = two = three = 0;
					three++;
				}
				else if(ining[i][turn] == 4) { // 홈런
					if (one>0) result++;
					if (two>0) result++;
					if (three>0) result++;
					result++;
					one = two = three = 0;
				}
				o++;
				if (outCnt == 3) { // 아웃 세번이면 다음 이닝 ㄱ
					outCnt = 0;
					break;
				}
				
			}
		}
	}
}
