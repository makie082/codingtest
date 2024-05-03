import java.io.*;
import java.util.*;

public class BOJ_1261 {

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = str.charAt(m) -'0';
            }
        }

        System.out.println(findPath(N, M, map));


    }

    static int findPath(int N, int M, int[][] map){
        PriorityQueue<Point> pqueue = new PriorityQueue<>();
        pqueue.offer(new Point(0,0,0));

        int[][] dist = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;



        while(!pqueue.isEmpty()){
            Point point = pqueue.poll();
            int x = point.x;
            int y = point.y;
            int cnt = point.cnt;
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || nx>N-1 || ny<0 || ny>M-1) continue;

                if (!visited[nx][ny]){
                    if (map[nx][ny] == 1 && dist[nx][ny] > dist[x][y]+1){ // 벽인 경우
                        dist[nx][ny] = dist[x][y] + 1;
                        pqueue.offer(new Point(nx,ny,dist[nx][ny]));
                    }
                    else if (map[nx][ny] == 0 && dist[nx][ny] > dist[x][y]){ // 벽이 아닌 경우
                        dist[nx][ny] = dist[x][y];
                        pqueue.offer(new Point(nx,ny,dist[nx][ny]));
                    }


                }


            }
        }

        return dist[N-1][M-1];

    }

    static class Point implements Comparable<Point>{
        int x,y,cnt;

        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point point){
            return this.cnt -  point.cnt;
        }
    }


}
