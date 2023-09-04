import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간초과 문제 때문에 StringBuilder 사용해주어야하고 재귀 말고 반복문으로 구성해야함

public class Main {

    private static int T;
    private static int N;
    private static int[] note1;
    private static int M;
    private static int[] note2;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); // 수첩1에 적어둔 정수의 개수
            note1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken()); // 수첩1에 적혀있는 정수들
            }
            Arrays.sort(note1);

            M = Integer.parseInt(br.readLine()); // 수첩2에 적어둔 정수의 개수
            note2 = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int find = Integer.parseInt(st.nextToken());
                int start = 0;
                int end = N-1;
                boolean flag = false;
                while(start <= end){
                    int mid = (start+end)/2;
                    if (note1[mid] == find){
                        sb.append(1+"\n");
                        flag = true;
                        break;
                    }

                    if (note1[mid] > find) end = mid-1;
                    else start = mid+1;
                }
                if(!flag) sb.append(0+"\n");
            }


        }
        System.out.println(sb);
    }


}
