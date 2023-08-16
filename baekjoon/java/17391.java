import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m;
    static int[][] map;
    static int[] dx = {0,1};
    static int[] dy = {1,0}; // 오른쪽, 아래쪽

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0,0);
        System.out.println(selected[n-1][m-1]);
    }
    static int[][] selected;
    static void bfs(int x, int y){
        Deque<point> deque = new ArrayDeque();
        deque.offer(new point(x,y));
        selected = new int[n][m];
        selected[x][y] = 0;

        while(!deque.isEmpty()){
            point p = deque.poll();
            x = p.x;
            y = p.y;
            int mul = map[x][y];
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < mul+1; j++) {
                    int nx = x + dx[i]*j;
                    int ny = y + dy[i]*j;

                    if (nx>n-1||ny>m-1) continue;
                    if (selected[nx][ny] == 0) {
                        selected[nx][ny] = 1+selected[x][y];
                        deque.offer(new point(nx,ny));
                    }
                }

            }
        }
    }

    static class point{
        int x,y;
        point(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
}
