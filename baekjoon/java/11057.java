import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][10]; //0: 길이, 1: 마지막 숫자, 들어가는 값: 마지막 숫자가 가능한 개수

        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }

        
        // 가장 마지막 자리의 수를 기준으로 가능한 수를 arr에 저장
        int ans = 0;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i-1][k];
                }
                // 넣을 때마다 모듈러 계산
                arr[i][j] %= 10007;
            }
        }


        for (int i = 0; i < 10; i++) {
            ans += arr[n][i];
        }

        System.out.println(ans%= 10007);
    }

}
