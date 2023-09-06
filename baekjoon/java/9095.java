import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n+1];
			
			
			if (n == 1) {
				System.out.println(1);
				continue;
			}
			if (n == 2) {
				System.out.println(2);
				continue;
			}
			if (n == 3) {
				System.out.println(4);
				continue;
			}
			arr[0] = 0;
			arr[1] = 1; // 1 (1 0 0)
			arr[2] = 2; // 1+1 2 (1 1 0)
			arr[3] = 4; // 1+1+1 1+2 2+1 3 (1 2 1)
			
			for (int j = 4; j < n+1; j++) {
				arr[j] = (arr[j-1] + arr[j-2] + arr[j-3]);
			}
			
			System.out.println(arr[n]);
			
		}
	}

}
