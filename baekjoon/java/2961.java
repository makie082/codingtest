package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2961 {

	static int num;
	static int result;
	static boolean[] selected;
	static int[] sour;
	static int[] bitter;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		sour = new int[num];
		bitter = new int[num];
		selected = new boolean[num];
	
		
		for (int i = 0; i < num; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		result = Math.abs(sour[0]-bitter[0]);
		
		subset(0);

		System.out.println(result);
	}
	
	static int sSum;
	static int bSum;
	static void subset(int cnt) {
		
		
		if (cnt == num) {
			int flag = 0;
//			System.out.println(Arrays.toString(selected));
			for (int j = 0; j < selected.length; j++) {
				if (selected[j]) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) return; // 전체 false인 것은 고려해주면 안됨!
			
			sSum = 1;
			bSum = 0;
			for (int i = 0; i < selected.length; i++) {
				if(selected[i]) {
					sSum *= sour[i];
					bSum += bitter[i];
				}
			}
//			System.out.println("결과값은 " + (sSum - bSum));
			result = Math.min(Math.abs(sSum - bSum), result);
			return;
			
		}
		
		selected[cnt] = true;
		subset(cnt+1);
		selected[cnt] = false;
		subset(cnt+1);

	}

}
