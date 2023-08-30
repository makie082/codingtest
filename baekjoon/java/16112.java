import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		long[] exp = new long[(int)n];
		for (int i = 0; i < n; i++) {
			exp[i] = Long.parseLong(st.nextToken());
		}
		// i번째 퀘스트를 진행하면 ai의 경험치와 i번째 아케인스톤이 주어집니다.
		// i번째 퀘스트의 보상 경험치를 받을 때 활성화되어 있던 아케인스톤에는 ai의 경험치가 추가됩니다.
		// 한 번에 아케인스톤 K개 활성화
		// 지꺼는 지가 못 저장함
		// 남꺼 저장 가능
		// 첫빠따는 가장 작은거 , 그 이후로는 큰 값 순서대로 (여러번 더해질 수 있어서)
		Arrays.sort(exp); // 오름차순으로 정렬
		long result = 0;
		for (int i = 1; i < n; i++) {
			if(i<k) result += exp[i]*i;
			else result += exp[i]*k;
		}
		
		System.out.println(result);
	}

}
