import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m, year, part, cnt, nx, ny;
    static int[][] ocean, visited, newocean;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열

        ocean = new int[n][m];
        newocean = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            year++;
            for (int i = 1; i < n-1; i++) {
                for (int j = 1; j < m-1; j++) {
                    cnt = 0; // 사방의 바다 수
                    if (ocean[i][j] != 0){ // 빙산이 있는 곳을 찾기
                        // 사방 확인하고 칸 수만큼 빼주기
//                        System.out.println(i+" "+j+"에서 확인");
                        for (int k = 0; k < 4; k++) {
                            nx = i + dx[k];
                            ny = j + dy[k];
                            if (ocean[nx][ny] == 0) {cnt++; }

                            }
                        ocean[i][j] -= cnt;
                        if (ocean[i][j] <= 0) ocean[i][j] = -3;
//                        System.out.println("인접바다:"+cnt);
                    }
                }
            }

//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(ocean[i]));
//            }
//            System.out.println();

            for (int i = 1; i < n-1; i++) {
                for (int j = 1; j < m-1; j++) {
                    if(ocean[i][j] == -3) ocean[i][j] = 0;
                }
            }





            // 뭉텅이 세아리기
            part = 0;
            visited = new int[n][m];
            for (int i = 1; i < n-1; i++) {
                for (int j = 1; j < m-1; j++) {
                    if(ocean[i][j] != 0 && visited[i][j] == 0){
                        bfs(i,j);
                        part++;
                        if (part > 1) {
                            System.out.println(year);
                            return;
                        }
                    }
                }
            }


            if (part == 0) {
                System.out.println(0);
                break;
            }

        }


    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x,y});
        visited[x][y] = 1;

        while (!queue.isEmpty()){
            int[] arr =  queue.poll();
            int r = arr[0];
            int c = arr[1];
            for (int i = 0; i < 4; i++) {
                nx = r+dx[i];
                ny = c+dy[i];
                if (ocean[nx][ny] != 0 && visited[nx][ny] == 0){
                    queue.offer(new int[] {nx,ny});
                    visited[nx][ny] = 1;
                }
            }
        }
    }
}
