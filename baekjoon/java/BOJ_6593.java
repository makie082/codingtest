import java.util.*;
import java.io.*;

public class BOJ_6593 {

    static int[] dx = {0,0,1,-1,0,0};
    static int[] dy = {1,-1,0,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    static Queue<Point> sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 층
            int R = Integer.parseInt(st.nextToken()); // 행
            int C = Integer.parseInt(st.nextToken()); // 열


            if (L == 0 && R == 0 && C == 0) break;

            sb= new ArrayDeque<>();
            int[][][] visited = new int[L][R][C];
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < C; c++) {
                        char ch = line.charAt(c);
                        if (ch == 'S'){
                            sb.offer(new Point(l,r,c));
                            visited[l][r][c] = 1;
                        } else if (ch == 'E'){
                            visited[l][r][c] = -1; // 출구
                        } else if (ch == '#'){
                            visited[l][r][c] = -2; // 벽
                        }
                    }

                }
                br.readLine();
            }

            boolean flag = false;
            while(!sb.isEmpty()){
                Point cur = sb.poll();

                for (int d = 0; d < 6; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    int nz = cur.z + dz[d];

                    if (nx<0 || nx>R-1 || ny<0 || ny>C-1 || nz<0 || nz>L-1) continue;

                    if (visited[nz][nx][ny] == -2 || visited[nz][nx][ny]>0) continue; // 벽은 그냥 넘어가
                    else if (visited[nz][nx][ny] == -1){
                        // 출구
                        System.out.println("Escaped in "+ visited[cur.z][cur.x][cur.y] + " minute(s).");
                        flag = true;
                        break;
                    }

                    visited[nz][nx][ny] = visited[cur.z][cur.x][cur.y]+1;
                    sb.offer(new Point(nz,nx,ny));

                }
                if(flag) break;
            }
            if(!flag) System.out.println("Trapped!");


        }

    }


    static class Point{
        int x,y,z;

        Point(int z, int x, int y){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }


}
