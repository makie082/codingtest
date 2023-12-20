import java.util.*;
import java.io.*;

public class BOJ_2583 {

    static boolean[][] map;
    static boolean[][] visited;
    static int result = 0;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    private static int M;
    private static int N;

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 행
        N = Integer.parseInt(st.nextToken()); // 열
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        visited = new boolean[M][N];

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int yl = Integer.parseInt(st.nextToken());
            int xl = Integer.parseInt(st.nextToken());
            int yr = Integer.parseInt(st.nextToken());
            int xr = Integer.parseInt(st.nextToken());

            for (int x = xl; x < xr; x++) {
                for (int y = yl; y < yr; y++) {
                    map[x][y]=true;
                }
            }
        }

        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (!map[x][y] && !visited[x][y]){
                    result++;
                    bfs(x,y);
                }
            }
        }

        System.out.println(result);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    static void bfs(int x, int y){
        visited[x][y]= true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x,y));
        int area = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            area++;
            int X = node.x;
            int Y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = X + dx[i];
                int ny = Y + dy[i];

                if (nx<0||nx>=M||ny<0||ny>=N) continue;

                if (!map[nx][ny] && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx,ny));
                }
            }
        }
        list.add(area);
    }

    static public class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
