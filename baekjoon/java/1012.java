import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int m,n,k,cnt;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int T = 0; T < t; T++) {
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            k = Integer.parseInt(st.nextToken()); // 배추 개수
            map = new int[m][n];


            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]){
                        bfs(i,j);
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static void bfs(int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;

        while(true){
            if (queue.isEmpty()){
                cnt++;
                return;
            }
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];

            for (int l = 0; l < 4; l++) {
                int nx = x + dx[l];
                int ny = y + dy[l];

                if (nx<0 || nx>m-1 || ny<0 || ny>n-1) continue;
                if (map[nx][ny] == 1 && !visited[nx][ny]){
                    queue.offer(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }

        }
    }

}
