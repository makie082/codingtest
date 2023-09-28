import java.util.*;
import java.io.*;

public class BOJ_2468 {

    private static int N;
    private static int[][] map;
    private static int[][] tmp;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (max < map[i][j]) max = map[i][j];
            }
        }


        int std = 0;
        // 물에 잠기는 기준을 잡기
        for (int x = 0; x < max; x++) {
            tmp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= x){
                        tmp[i][j] = 1;
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tmp[i][j] == 0){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }

            if (cnt > std) {
                std = cnt;
            }
        }
        System.out.println(std);

    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static void bfs(int startX, int startY){
        tmp[startX][startY] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX,startY});

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;
                if (tmp[nx][ny] == 0){
                    tmp[nx][ny] = 1;
                    queue.offer(new int[]{nx,ny});
                }

            }
        }


    }

}
