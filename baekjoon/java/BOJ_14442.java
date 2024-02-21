import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442 {


    private static int N,M,K;
    static int[][][] visited;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][K+1];
        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = str.charAt(m)-'0';
            }
        }

        bfs(0,0);

        int result = Integer.MAX_VALUE;
        for (int k = 0; k < K+1; k++) {
            if (visited[N-1][M-1][k] == 0) continue;
            result = Math.min(visited[N-1][M-1][k],result);
        }

        result = (result == Integer.MAX_VALUE)?-1:result;

        System.out.println(result);

    }

    static void bfs(int startX, int startY){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startX, startY,0));
        visited[startX][startY][0] = 1; // 첫 시작과 끝 점을 다 포함하기

        while(!queue.isEmpty()){

            Point point = queue.poll();
            int x=point.x;
            int y=point.y;
            int k= point.k; // 뿌순 벽의 개수

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 밖일 경우 out
                if (nx<0 || nx>N-1 || ny<0 || ny>M-1) continue;

                if (map[nx][ny] == 0){ // 그냥 지나갈 수 있는 경우
                    if(visited[nx][ny][k] == 0){
                        visited[nx][ny][k] = visited[x][y][k]+1;
                        queue.offer(new Point(nx,ny,k));
                    }
                }else if (map[nx][ny] == 1){
                    // 벽일 경우는 뿌수고 감
                    // 뿌수는 횟수가 뿌술 수 있는 횟수여야 함
                    if (k < K && visited[nx][ny][k+1] == 0) {
                        visited[nx][ny][k+1] = visited[x][y][k]+1;
                        queue.offer(new Point(nx,ny,k+1));
                    }
                }


            }

        }


    }

    static class Point{
        int x, y, k;

        Point(int x, int y, int k){
            this.x=x;
            this.y=y;
            this.k=k;
        }
    }





}
