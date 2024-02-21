import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9466 {


    private static int T;
    private static int[] arr;
    private static boolean[] visited;
    private static boolean[] meetCycle;
    private static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            visited = new boolean[N];
            meetCycle = new boolean[N];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                arr[n] = Integer.parseInt(st.nextToken())-1;
            }

            for (int n = 0; n < N; n++) {
                dfs(n);
            }

            System.out.println(N-count);
        }
    }

    static void dfs(int start){
        if (meetCycle[start]) return;

        if (visited[start]){ // 재방문 == 이미 방문한 곳을 또 방문 -> 싸이클 형성
            count++; // 사이클을 만든 노드의 개수+1
            meetCycle[start] = true; // 확인한 노드임
        }else{ // 방문을 안했다면
            visited[start] = true; // 방문 처리를 해준다
        }

        dfs(arr[start]); // 내가 가리키는 것이 이어진 곳
        visited[start] = false;
        meetCycle[start] = true; // dfs를 통해서 이미 내랑 연결된 거는 다 확인을 했으므로 내를 다시 확인할 필요가 없다
    }




}
