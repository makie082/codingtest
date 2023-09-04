import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int[] tree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 나무 수
		M = Integer.parseInt(st.nextToken()); // 집으로 가져가려는 나무의 길이
		tree = new int[N];
		
		int end = 0;
		int start = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, tree[i]);
		}
		while(start <= end) {
			int mid = (start + end)/2;
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				if (tree[i] > mid) sum += (tree[i]-mid);
			}

			if (sum >= M) start = mid+1;
			else end = mid-1;
		}
		
		System.out.println(end);
		
		
	}

}
