package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon_1141 {

	private static int n;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		int cnt=0;
		for (int i = 0; i < n; i++) {
			String check = arr[i];
			cnt++;
//			System.out.println(check+"으로 바뀌고 카운트 올라감: "+cnt);
			for (int j = i+1; j < n; j++) {
				if(arr[j].charAt(0) == check.charAt(0)) {
					if(arr[j].startsWith(check)) {
						i = j-1;
						cnt--;
//						System.out.println(arr[j]+"와 "+check+" 같다! => 카운트 빠짐: "+cnt);
						break;
					}else {
//						System.out.println(arr[j]+"일 때 카운트 올라감: "+cnt);
						i = j-1;
						break;
					}
				}else {
					i = j-1;
					break;
				}
				
				
			}
		}
				
		System.out.println(cnt);
	}

}
