package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_17406 {

	static int N, M, K;
	static int[][] map;
	static int[][] originalmap;
	private static int[] turns;
	static boolean[] selected;
	static int[][] order;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		originalmap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				originalmap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		turns = new int[K];
		selected = new boolean[K];
		
		order = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			order[i][0] = Integer.parseInt(st.nextToken())-1;
			order[i][1] = Integer.parseInt(st.nextToken())-1;
			order[i][2] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		
		System.out.println(result);
		
		
	}
	
	// 순서 정하기
	static void perm(int tgtIdx) {
		if (tgtIdx == K) {
			map = new int[N][M];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					map[j][j2] = originalmap[j][j2];
				}
			}
			for (int i = 0; i < K; i++) {
				int x = order[turns[i]][0];
				int y = order[turns[i]][1];
				int s = order[turns[i]][2];
				
				int startX = x-s;
				int startY = y-s;
				int endX = x+s;
				int endY = y+s;				
				
				turn(startX, startY, endX, endY);
				
			}
			checkMin();
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(!selected[i]) {
				turns[tgtIdx] = i;
				selected[i] = true;
				perm(tgtIdx+1);
				selected[i] = false;
			}
	
		}
		
		
		
	}
	
	
	
	// 껍데기 씩 확인
	static void turn(int startX, int startY, int endX, int endY) {
		if (startX == endX) return; // 가장 가운데 하나가 남으면
		
		int toVerticalRight =0;
		int toVerticalLeft=0;
		
		// 가로방향 
		for (int j = endY; j > startY; j--) {
			//가장 윗행 열 값 +1
			if(j == endY) toVerticalRight = map[startX][j];
			map[startX][j] = map[startX][j-1];
			// 제일 첫 값을 열에서 넣어줘야함
		}
		for (int j = startY; j < endY; j++) {
			// 가장 아랫 행 열 값 -1
			if (j == startY) toVerticalLeft = map[endX][j];
			map[endX][j] = map[endX][j+1];
		}
		
		// 세로방향
		for (int i = startX; i < endX; i++) {
			// 기징 왼쪽 열 행 값 -1 
			if (i == endX-1) map[endX-1][startY] = toVerticalLeft;
			else map[i][startY] = map[i+1][startY]; 
		}
		for (int i = endX; i > startX; i--) {
			// 기징 오른쪽 열 행 값 +1
			if (i == startX+1) map[startX+1][endY] = toVerticalRight;
			else map[i][endY] = map[i-1][endY]; 
		}
		
		turn(startX+1,startY+1,endX-1,endY-1);
	}
	
	
	
	static int result = Integer.MAX_VALUE;
	static void checkMin() {
		int sum;
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
			}
			result = Math.min(sum, result);
		}
		
		
	}

}
