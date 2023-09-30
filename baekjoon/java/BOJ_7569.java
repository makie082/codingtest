import java.util.*;
import java.io.*;

public class Main {
    private static int M;
    private static int N;
    private static int H;
    private static int[][][] box;
    private static Queue<Point> queue;
    private static int[][][] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[M][N][H];
        visited = new int[M][N][H];

        queue = new ArrayDeque<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n <N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[m][n][h] = Integer.parseInt(st.nextToken());
                    if (box[m][n][h] == 1) {
                        queue.offer(new Point(m,n,h));
                        visited[m][n][h] = 1;
                    }
                }
            }
        }

        bfs();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n <N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[m][n][h] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }


        System.out.println(max-1);

    }
    static int max = 0;
    static void bfs(){

        while (!queue.isEmpty()){

            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int z = point.z;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1 || nz < 0 || nz > H-1) continue;

                if (box[nx][ny][nz] == 0 && visited[nx][ny][nz] == 0){
                    queue.offer(new Point(nx,ny,nz));
                    visited[nx][ny][nz] = visited[x][y][z] + 1;
                    box[nx][ny][nz] = 1;
                }
                max = Math.max(max, visited[nx][ny][nz]);

            }

        }

    }

    static int[] dx = {0,0,-1,1,0,0}; // 위 아래 왼쪽 오른쪽 앞 뒤
    static int[] dy = {0,0,0,0,1,-1};
    static int[] dz = {1,-1,0,0,0,0};

    static class Point{
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
