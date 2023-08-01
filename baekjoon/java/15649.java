package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_15649 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		selected = new boolean[n+1];
		tgt = new int[m];
		perm(0);
		
	}
	static int n;
	static int m;
	static int[] tgt;
	static boolean[] selected;

	static void perm(int idx) {
		if (idx == m) {
			for (int a=0; a<m; a++) {
				System.out.print(tgt[a]+ " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = 1; i < n+1; i++) {
			if(selected[i] == true) {
				continue;
			}
			else {
				tgt[idx] = i;
				selected[i] = true;
				perm(idx+1);
				selected[i]= false;
			}
		}
		
	}
	
}
