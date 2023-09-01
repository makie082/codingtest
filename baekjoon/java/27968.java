package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_27968 {

	private static long[] candyout;
	private static int n;
	private static int m;
	private static long[] child;
	private static long[] sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		candyout = new long[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			candyout[i] = Long.parseLong(st.nextToken());
		}
		
		child = new long[n];
		for (int i = 0; i < n; i++) {
			child[i] = Long.parseLong(br.readLine());
		}
		
		sum = new long[m];
		sum[0] = candyout[0];
		for (int i = 1; i < m; i++) {
			sum[i] = sum[i-1]+candyout[i];
		}
		
		for (int i = 0; i < n; i++) {
			long childWant = child[i];
			if(childWant > sum[m-1]) {
				System.out.println("Go away!");
				continue;
			}
			
			if (sum[0]>=childWant) {
				System.out.println(1);
				continue;
			}
			
			binarySearch(sum, childWant);
		}
		
	}
	
	
	public static boolean binarySearch(long []arr, long target) {
		int start = 0;
		int end = arr.length-1;
		int mid;
		while(true) {
			mid =  (start + end) / 2;
			
			if(arr[mid] == target) {
				System.out.println(mid+1);
				return true;
			}
			else if (start > end) {
				System.out.println(start+1);
				return true;
			}
			else if(arr[mid] < target) {
				start = mid + 1;
			}
			else if(arr[mid] > target) {
				end = mid - 1;
			}
			
		}
	}

}
