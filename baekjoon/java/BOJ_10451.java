import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10451 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    private static int cnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }
            visited = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                list[n].add(Integer.parseInt(st.nextToken())-1);
            }

            cnt=0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                cnt++;
                dfs(i);
            }
            System.out.println(cnt);

        }


    }

    static void dfs(int n){
        for (int i = 0; i < list[n].size(); i++) {
            if (visited[list[n].get(i)]) return;
            visited[list[n].get(i)] = true;
            dfs(list[n].get(i));
        }
    }



}
