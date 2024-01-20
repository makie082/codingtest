import java.util.*;
import java.io.*;

public class BOJ_4179 {

    static int R,C;
    static char[][] graph;

    static int[][] fireDist;
    static int[][] jihoonDist;
    static Queue<Point> fires;
    static Queue<Point> jihoons;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        fireDist = new int[R][C];
        jihoonDist = new int[R][C];
        fires = new ArrayDeque<>();
        jihoons = new ArrayDeque<>();

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                graph[r][c] = line.charAt(c);
                if (graph[r][c] == '#'){
                    fireDist[r][c]=-1;
                    jihoonDist[r][c]=-1;
                }else if(graph[r][c] == 'F'){
                    fireDist[r][c]=1;
                    fires.offer(new Point(r,c));
                }else if(graph[r][c] == 'J'){
                    jihoonDist[r][c]=1;
                    jihoons.offer(new Point(r,c));
                }
            }
        }

        // 불이 먼저 이동하고 지후니가 이동
        // 근데 일일이 할 수 없으니, 불이 이동했을 때의 시간과 비교하여 지후니가 이동하도록 해야 한다.
        fireBfs();
        if(jihoonBfs()){
//            check();
            return;
        }else{
//            check();
            System.out.println("IMPOSSIBLE");
        }
        return;
    }

    static void check(){
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(fireDist[r][c]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(jihoonDist[r][c]+" ");
            }
            System.out.println();
        }
    }

    static void fireBfs(){

        while(!fires.isEmpty()){
            Point cur = fires.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                // 영역 밖은 그냥 넘어가기
                if (nx < 0 || nx > R-1 || ny < 0 || ny > C-1) continue;

                // 불은 벽을 뚫지 몬한다.
                // 이미 불이 지나갔으면 다시 확인 안해줘도 된다.
                if (fireDist[nx][ny] == -1 || fireDist[nx][ny]>0) continue;

                // 불이 번진다면 원래 위치의 +1 해준 값이 들어간다.
                fireDist[nx][ny] = fireDist[cur.x][cur.y]+1;
                fires.offer(new Point(nx,ny));
            }
        }
    }

    static boolean jihoonBfs(){

        while (!jihoons.isEmpty()){
            Point cur = jihoons.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                // 영역 밖은 그냥 지후니가 끝난거 !! 이김 !!!!
                if (nx < 0 || nx > R-1 || ny < 0 || ny > C-1){
                    System.out.println(jihoonDist[cur.x][cur.y]);
                    return true;
                }

                // 지후니도 벽을 뚫지 몬한다.
                // 이미 지후니가 지나갔으면 다시 확인 안해줘도 된다.
                // 불이 지나간 자리이거나 같은 시간에 불이 이동한 자리면 못간다.
                if (jihoonDist[nx][ny] == -1 || jihoonDist[nx][ny] > 0) continue;
                if (fireDist[nx][ny]!=0 && fireDist[nx][ny] <= jihoonDist[cur.x][cur.y]+1) continue;

                jihoonDist[nx][ny] = jihoonDist[cur.x][cur.y]+1;
                jihoons.offer(new Point(nx,ny));
            }
        }

        return false;
    }

    static class Point{
        int x,y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}
