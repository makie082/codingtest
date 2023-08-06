package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11660 {

	static int N, M;
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				board[i][j] = -board[i-1][j-1] + board[i-1][j] + board[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println();
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < N+1; i++) {
//			for (int j = 0; j < N+1; j++) {
//				sb.append(board[i][j]).append(" ");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb);
		
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st2.nextToken());
			int startY = Integer.parseInt(st2.nextToken());
			int endX = Integer.parseInt(st2.nextToken());
			int endY = Integer.parseInt(st2.nextToken());
			
			sb2.append(board[endX][endY] + board[startX-1][startY-1] - board[endX][startY-1] - board[startX-1][endY]).append("\n");
		}
		
		System.out.println(sb2);
		
	}

}
