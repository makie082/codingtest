import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class BOJ_2146 {

    static int N;
    static int[][] map;
    static int[][] dis;
    static int landNum = 2;
    static int result = Integer.MAX_VALUE;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 땅의 번호 지정하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1){
                    setLandNum(i,j);
                    landNum++;
                }
            }
        }


        // 모든 점들에서 다른 땅을 만날 때까지의 거리 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1){
                    dis = new int[N][N];
                    makeDis(map[i][j], i, j);
                }
            }
        }

        System.out.println(result-1);

    }


    static void makeDis(int landN, int startX, int startY){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startX, startY));
        dis[startX][startY] = 1;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;

                if (dis[nx][ny] == 0  && map[nx][ny] == 0){
                    // 아직 방문하지 못했고, 바다인 경우에만 이동 가능
                    dis[nx][ny] = dis[x][y] + 1;
                    queue.offer(new Point(nx,ny));
                }else if(dis[nx][ny] == 0 && map[nx][ny] != 0 && map[nx][ny] != landN){
                    // 자신의 땅이 아니고, 아직 방문하지 않았고, 다른 땅을 만났을 경우
                    // -> 종료 조건임 !!
                    result = Math.min(result, dis[x][y]); 
                    return;
                }


            }
        }

    }

    static void setLandNum(int startX, int startY){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startX, startY));
        boolean[][] landvisited = new boolean[N][N];
        landvisited[startX][startY] = true;
        map[startX][startY] = landNum;
        
        while(!queue.isEmpty()){
            Point point = queue.poll();

            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;

                if (!landvisited[nx][ny] && map[nx][ny] == 1){
                    map[nx][ny] = landNum;
                    landvisited[nx][ny] = true;
                    queue.offer(new Point(nx,ny));
                }
            }
        }

    }




    static class Point{
        int x,y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }



}
