package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1992 {

	static int n;
	static int[][] board;
	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		board = new int[n][n];
		StringTokenizer st;
		String b;
		for (int i = 0; i < n; i++) {
			b = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = b.charAt(j)-'0';
			}
		}
		
		divide(0,0,n);
		
		
	}
	
	static int sum;
	static void divide(int x, int y, int size) {
//		System.out.println(x+" "+y+"에서 "+size);
		if (size == 0) return;
		
		sum = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum += board[x+i][y+j];
			}
		}
		
		if (sum == 0) { // 전부 0인 박스
			System.out.print(0);
			return;
		}else if(sum == size*size) { // 전부 1인 박스
			System.out.print(1);
			return;
		}else {
			System.out.print("(");
			divide(x,y,size/2);
			
			divide(x, y+size/2, size/2);

			divide(x+size/2, y, size/2);

			divide(x+size/2, y+size/2, size/2);
			System.out.print(")");
		}
		
	}

}
