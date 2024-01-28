
import java.util.*;
import java.io.*;

public class BOJ_1600 {

    // 3차원 visited: 조건 하나가 추가되어서 해당 조건마다 다르게 생각해줘야 하기 때매
  
    private static int N;
    private static int[][] map;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int[] dx2 = {-1,-2,-2,-1,1,2,2,1};
    private static int[] dy2 = {-2,-1,1,2,-2,-1,1,2};

    private static int W;
    private static int H;
    private static int[][][] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new int[H][W][N+1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0,0);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N+1; i++) {
            if (visited[H-1][W-1][i] != 0) result = Math.min(result, visited[H-1][W-1][i]);
        }

        System.out.println((result == Integer.MAX_VALUE) ?-1 : result-1);
        
    }

    static void bfs(int startX, int startY){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startX, startY,0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()){
            Point tmp = queue.poll();

            // 그냥 이동
            for (int d = 0; d < 4; d++) {
                int nx = tmp.x + dx[d];
                int ny = tmp.y + dy[d];

                if (nx<0 || nx>H-1 || ny<0 || ny>W-1) continue;

                if (map[nx][ny] == 1 || visited[nx][ny][tmp.cnt] != 0) continue; // 벽으로 막혔으면 넘어가기, 같은 말 이동 수에서 이미 지나갔다면 넘어가기

                visited[nx][ny][tmp.cnt] = visited[tmp.x][tmp.y][tmp.cnt]+1;
                queue.offer(new Point(nx,ny,tmp.cnt));
            }

            // 말 이동
            if (tmp.cnt < N){
                for (int d = 0; d < 8; d++) {
                    int nx = tmp.x + dx2[d];
                    int ny = tmp.y + dy2[d];

                    if (nx<0 || nx>H-1 || ny<0 || ny>W-1) continue;

                    if (map[nx][ny] == 1 || visited[nx][ny][tmp.cnt+1] != 0) continue; // 벽으로 막혔으면 넘어가기, 같은 말 이동 수에서 이미 지나갔다면 넘어가기


                    visited[nx][ny][tmp.cnt+1] = visited[tmp.x][tmp.y][tmp.cnt]+1;
                    queue.offer(new Point(nx,ny,tmp.cnt+1));

                }

            }



        }
    }

    static class Point{
        int x,y,cnt;

        Point(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt; // 말 이동이 몇 번째인지
        }
    }


}
