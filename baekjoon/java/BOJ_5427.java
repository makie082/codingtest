import java.util.*;
import java.io.*;

public class BOJ_5427 {

    private static int tc;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            boolean flag = false;

            char[][] graph = new char[C][R];
            int[][] fire = new int[C][R];
            int[][] sg = new int[C][R];
            Queue<Point> fires = new ArrayDeque<>();
            Queue<Point> sgs = new ArrayDeque<>();

            for (int r = 0; r < C; r++) {
                String line = br.readLine();
                for (int c = 0; c < R; c++) {
                    graph[r][c] = line.charAt(c);
                    if (graph[r][c] == '#'){
                        sg[r][c] = -1;
                        fire[r][c] = -1;
                    }else if(graph[r][c] == '@'){
                        sg[r][c] = 1;
                        sgs.offer(new Point(r,c));
                    }else if(graph[r][c] == '*'){
                        fire[r][c] = 1;
                        fires.offer(new Point(r,c));
                    }
                }
            }

            while(!fires.isEmpty()){
                Point cur = fires.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    // 범위 밖으로 벗어나면 안됨
                    if (nx<0||nx>C-1||ny<0||ny>R-1) continue;

                    // 벽이랑 마주하면 못 뚫어
                    // 지나간 곳은 굳이 다시 지나갈 필요 없음
                    if (fire[nx][ny] == -1 || fire[nx][ny]>0) continue;

                    // 아닌 모든 곳 이동 가능
                    fires.offer(new Point(nx,ny));
                    fire[nx][ny] = fire[cur.x][cur.y]+1;
                }
            }

            while(!sgs.isEmpty()){
                Point cur = sgs.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    // 범위 밖으로 넘어가면 된거임
                    if(nx<0||nx>C-1||ny<0||ny>R-1){
                        System.out.println(sg[cur.x][cur.y]);
                        flag = true;
                        break;
                    }

                    // 상근이도 벽을 못뚫어
                    // 자기가 갔던 곳 굳이 다시 갈 필요도 없음
                    if (sg[nx][ny] == -1 || sg[nx][ny] > 0) continue;

                    // 불이 먼저 지나간 곳 또는 동시에 지나갈 곳은 상근이가 이동할 수 없다
                    if (fire[nx][ny] !=0 && fire[nx][ny] <= sg[cur.x][cur.y]+1) continue;
                                            // 갈 곳 <= 원래 있던 곳+1
                    sg[nx][ny] = sg[cur.x][cur.y]+1;
//                    System.out.println(fire[nx][ny]+" and sg's cur pos: "+sg[cur.x][cur.y]);
//                    System.out.println(nx+","+ny+" added!");
                    sgs.offer(new Point(nx,ny));
                }

                if (flag) break;
            }

            System.out.println("fire======");
            for (int r = 0; r < C; r++) {
                for (int c = 0; c < R; c++) {
                    System.out.print(fire[r][c]+" ");
                }
                System.out.println();
            }


            System.out.println("sg======");
            for (int r = 0; r < C; r++) {
                for (int c = 0; c < R; c++) {
                    System.out.print(sg[r][c]+" ");
                }
                System.out.println();
            }
            if (!flag) System.out.println("IMPOSSIBLE");
        }

    }

    static class Point{
        int x,y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }




}
