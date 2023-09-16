import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int V,E;
    private static int start;
    private static ArrayList<Node>[] list;
    static boolean[] visited;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        for (int i = 1; i < V+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
        }
        visited = new boolean[V+1];
        dp = new int[V+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dij(start);

        for (int i = 1; i < V+1; i++) {
            if(visited[i]) System.out.println(dp[i]);
            else System.out.println("INF");
        }

    }

    static void dij(int start){
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start,0));
        dp[start] = 0;

        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            int startpoint = tmp.idx;

            if(visited[startpoint]) continue;
            visited[startpoint] = true;

            for (Node node:list[startpoint]) {
                if (dp[node.idx] > dp[startpoint] + node.cost){
                    dp[node.idx] = dp[startpoint] + node.cost;
                    queue.offer(new Node(node.idx, dp[node.idx]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int idx, cost;

        public Node(int idx, int cost){
            this.cost = cost;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
}
