package baekjoon;

import java.util.Scanner;

public class Baekjoon_3040 {

	static int[] nan = new int[9];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			nan[i] = sc.nextInt();
		}
			
		com(0, 0);
	}
	
	static boolean[] visited = new boolean[9];
	static void com(int startIdx, int tgtIdx) {
		
	    if(tgtIdx == 2) {
	    	int sum = 0;
	        for (int i = 0; i < 9; i++) {
				if (visited[i] == false) sum += nan[i];
			}
//	        System.out.println(sum);
	        if (sum == 100) {	
	        	for (int i = 0; i < 9; i++) {
	        		if (visited[i] == false) System.out.println(nan[i]);
				}
	        }
	        return;
	    } 

	    for(int i=startIdx; i<9; i++) {
    		visited[i] = true;
	        com(i + 1, tgtIdx+1);
	        visited[i] = false;
	    }
	    
	}

}
