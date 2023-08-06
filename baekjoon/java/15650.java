package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_15650 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();

		tgt = new int[m];
		
		comb(0,1);
		
	}
	
	static int[] tgt;
	static int n,m;
	static void comb(int idx, int start) {
		if (idx == m) {
			for (int i : tgt) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < n+1; i++) {
			tgt[idx] = i;
			comb(idx+1, i+1);
		}
		

	
		
	}

}
