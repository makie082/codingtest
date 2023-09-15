import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int N;
    private static int M;
    private static int K;
    private static int X;
    private static List<Integer>[] graph;
    private static int[] dis;
    private static boolean[] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        graph = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        dis = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            dis[i] = 300000;
        }

        visited = new boolean[N+1];
        bfs(X);

        boolean flag = false;
        for (int i = 0; i < N+1; i++) {
            if(dis[i] == K){
                flag = true;
                System.out.println(i);
            }
        }
        if(!flag) {
            System.out.println(-1);
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        dis[start] = 0;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;
            for (Integer i:graph[tmp]) {
                if(!visited[i]){
                    dis[i] = Math.min(dis[i], dis[tmp]+1);
                    queue.offer(i);
                }
            }
        }
    }
}
