package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모든 변수를 long 형으로 변경해주어야 한다
public class BOJ_3020 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
				
		long now = Y*100/X;
		
		if (X==Y || now >= 99) {
			System.out.println(-1);
			return;
		}
		
		long start = 1;
		long end = X;
		
		while (start <= end) {
			long mid = (start+end)/2;
			
			long ans = (mid+Y)*100/(mid+X);
			
			if (ans <= now) start = mid+1;
			else end = mid-1;
		}
		
		System.out.println(start); // 최솟값을 찾아야하므로 start를 출력
	}
	
	

}
