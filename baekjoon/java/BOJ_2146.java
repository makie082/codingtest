import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
    private static int N;
    private static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    private static int land;
    static int result = Integer.MAX_VALUE;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 바다와 육지를 구분한다
        // 육지 별로 이름을 붙임!
        land = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)  checkLand(i,j);
            }
        }




        // 육지끼리 이어지는 가장 가까운 거리를 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]!=0) {
                    visited = new boolean[N][N];
                    findDist(i,j, map[i][j]);
                }
            }
        }
        System.out.println(result);

    }

    static void findDist(int startX, int startY, int currentLand){
        Queue<newPoint> queue = new ArrayDeque<>();
        queue.offer(new newPoint(startX, startY,0));
        while (!queue.isEmpty()){
            newPoint point = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = point.x + dx[d];
                int ny = point.y + dy[d];

                if (nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;

                // 현재 땅이라 같은 땅 or 이미 지나간 곳 -> 넘어가기
                if (map[nx][ny] == currentLand || visited[nx][ny]) continue;

                if (map[nx][ny] == 0){
                    // 바다일 경우
                    queue.offer(new newPoint(nx,ny, point.cnt+1)); // 쭉쭉 이어서 갑니당
                }else{
                    // 다른 섬에 도착
                    result = Math.min(result, point.cnt); // 결과값 업데이트
                }
                visited[nx][ny] = true;
            }
        }


    }


    static void checkLand(int startX, int startY){
        map[startX][startY]=land;
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startX,startY));

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = point.x + dx[d];
                int ny = point.y + dy[d];

                if (nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;
                if(map[nx][ny]==1){
                    map[nx][ny] = land;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        land++;
    }

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static class newPoint{
        int x, y,cnt;

        newPoint(int x, int y, int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }
}
