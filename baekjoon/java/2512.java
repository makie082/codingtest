import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 1;
        int end = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }
        int M = Integer.parseInt(br.readLine());

        while(start <= end){
            int mid = (start+end)/2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i] > mid) sum += mid;
                else sum += arr[i];
            }
            // 내라는 세금보다 많은 경우 -> 세금을 줄인다.
            if (sum > M) end = mid-1;
            // 내라는 세금보다 적은 경우 -> 세금을 높여서 더 최고의 경우의 수를 찾는다.
            // 같더라도 한 번 더 올려서 경우를 확인해야하므로 등호가 포함된다!
            else start = mid+1;
        }
        System.out.println(end); // 최댓값을 구할 때는 end 출력
    }
}
