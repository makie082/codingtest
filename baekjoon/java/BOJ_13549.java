import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

    private static int[] arr;
    private static int K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);

        bfs(N);

        System.out.println(arr[K]);

    }

    static void bfs(int start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(start,0));
        arr[start] = 0;

        while(!queue.isEmpty()) {
            Node m = queue.poll();
            int move = m.idx;
            int time = m.cost;

            if ( move>=0 && move<=50000 &&arr[move*2] > time) {
                arr[move*2] = time;
                queue.offer(new Node(move*2, arr[move*2]));
            }
            if (move>=1 && move<=100000 && arr[move-1] > 1+time) {
                arr[move-1] = time+1;
                queue.offer(new Node(move-1,arr[move-1]));
            }
            if (move>=0 && move+1<=100000 && arr[move+1] > 1+time) {
                arr[move+1] = time+1;
                queue.offer(new Node(move+1, arr[move+1]));
            }
        }
    }
    static class Node{
        public int idx,cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }



}
