import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1920 {

	static int N,M;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input); // natural ordering - asc
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int find;
		for (int i = 0; i < M; i++) {
			find = Integer.parseInt(st.nextToken());
			int q = Arrays.binarySearch(input, find);
//			System.out.println(q);
			if (q<0) {
				sb.append("0\n");
			}else {
				sb.append("1\n");
			}
		}
		
		System.out.println(sb);
	}
	
}
