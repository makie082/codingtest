import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라 알고리즘
// : 한 정점에서 시작해 다른 정점들까지 경로 중 최소인 경우를 구하는 알고리즘
// 한 정점에서 출발했을 때 도착점에서 가중치의 최소를 구하는 값!!!
// priority queue 사용
public class Main {
    private static int N;
    private static int M;
    private static ArrayList<Node>[] graph;
    private static int[] dp;
    private static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 지름길의 개수
        M = Integer.parseInt(br.readLine());  // 고속도로의 길이
        StringTokenizer st;

        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int n = 0; n < M; n++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,dis));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        v = new boolean[N+1];
        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dij(start);

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[end]);


    }

    static void dij(int start){
        // 다익스트라는 거리 중에 가장 작은 값을 기준으로 계속 비교해야하므로
        // priority queue를 이용해준다.
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start,0));
        dp[start] =0;

        while(!queue.isEmpty()){
            Node tmp = queue.poll();

            // 방문했는지를 여기서 확인을 해줘야함
            // 두 정점 사이에 경로가 하나 이상인 점을 고려해야 하기 때문에
            if(v[tmp.to]) continue;

            // 방문을 안했다면 여기서 다시 방문 처리해주기
            v[tmp.to] = true;

            for (Node node:graph[tmp.to]) {
                // 현재의 값보다 전에꺼에서 이동하는 값을 비교해서 갱신해줌
                if(dp[node.to] > (dp[tmp.to]+node.cost)){
                    dp[node.to] = dp[tmp.to]+node.cost;
                    queue.offer(new Node(node.to, dp[node.to]));
                }
            }

        }

      // 이렇게 하면 시간초과 뜸 ㅜ ㅜ
       // while(!queue.isEmpty()){
       //      Node tmp = queue.poll();
       //      v[tmp.to] = true;

       //      for (Node node:graph[tmp.to]) {
       //          if(!v[node.to] && dp[node.to] > (dp[tmp.to]+node.cost)){
       //              dp[node.to] = dp[tmp.to]+node.cost;
       //              queue.offer(new Node(node.to, dp[node.to]));
       //          }
       //      }

       //  }

    }

    static class Node implements Comparable<Node>{
        int to;
        int cost;

        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost; // 오름차순 정렬
        }
    }
}
