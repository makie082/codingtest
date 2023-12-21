import java.util.*;
import java.io.*;

public class BOJ_7562 {

    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    static int[][] map;
    private static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc ; t++) {
            // 체스판 한 변의 길이
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 현재 나이트가 있는 칸
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());
            map[curX][curY] = 1;
            // 나이트가 이동하려고 하는 칸
            st = new StringTokenizer(br.readLine());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());

            bfs(curX, curY);
            System.out.println(map[nextX][nextY]-1);
        }

    }

    static void bfs(int curX, int curY){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(curX, curY));

        while(!queue.isEmpty()){
            Point tmp =  queue.poll();
            int x = tmp.x;
            int y = tmp.y;

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx<0||nx>N-1||ny<0||ny>N-1) continue;

                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y]+1;
                    queue.offer(new Point(nx,ny));
                }

            }
        }
    }

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
