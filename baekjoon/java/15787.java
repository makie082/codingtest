package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15787 {

	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		int trainCnt = Integer.parseInt(st.nextToken());
		int orderCnt = Integer.parseInt(st.nextToken());
		
		int[] seat = new int[trainCnt];
		
		for (int i = 0; i < orderCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int ordType = Integer.parseInt(st.nextToken());
			int trainNum = Integer.parseInt(st.nextToken())-1;
			
			if(ordType == 1) {
				int pick = Integer.parseInt(st.nextToken());	
				int change = (int)Math.pow(2, pick-1);
				if ((seat[trainNum] & change) == 0) { // 해당 자리가 비어있으면
					seat[trainNum] = seat[trainNum] | change; // 앉아주기
				}
			}
			else if(ordType == 2) {
				int pick = Integer.parseInt(st.nextToken());
				int change = (int)Math.pow(2, pick-1);
//				System.out.println(seat[trainNum]);
//				System.out.println(change);
				if ((seat[trainNum] & change) == change) { // 해당 자리에 사람이 있으면
					seat[trainNum] = seat[trainNum] - change; // 내리기
				}
			}
			else if(ordType == 3) {
				seat[trainNum] = seat[trainNum] << 1;
				int compareThing = (int)Math.pow(2, 20);
				if ((seat[trainNum] & compareThing) != 0){
					seat[trainNum] = seat[trainNum] & (int)(Math.pow(2, 20)-1);
				}
			}else {
				seat[trainNum] = seat[trainNum] >> 1;
			}
			
			// for (int j = 0; j < trainCnt; j++) {
			// 	System.out.println(String.format("%21s", Integer.toBinaryString(seat[j])).replace(" ", "0") + " ");
			// }
			// System.out.println();
		}
		
		int result = 0;
		boolean flag;
		for (int i = 0; i < trainCnt; i++) {
			flag = true;
			for (int j = 0; j < i; j++) {
				if (seat[i] == seat[j]) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				result++;
			}
		}
		
		System.out.println(result);
		
		

	}

}
