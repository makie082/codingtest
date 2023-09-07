import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9461 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 1 1 1 2(1+1) 2 3(1+2) 4(1+3) 5(1+4)
		// 7(5+2) 9(7+2) 
		// 12(9+3)
		// 16(12+4) 
		// 21(16+5)
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			if (n <= 3) {
				System.out.println(1);
				continue;
			}
			else if (n <= 5) {
				System.out.println(2);
				continue;
			}
			
			// 나중에 삼각형의 길이가 엄청 커지기 때문에 long 형 사용해야한다
			long[] arr = new long[n+1];
			
			for (int i = 0; i <= 3; i++) {
				arr[i] = 1;
			}
			arr[5] = 2;
			arr[4] = 2;
			
			for (int i = 6; i <= n; i++) {
				arr[i] = arr[i-5]+arr[i-1];
			}
			
			System.out.println(arr[n]);
		}
		
	}

}
