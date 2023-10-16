import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행의 수
        M = Integer.parseInt(st.nextToken()); // 열의 수

        map = new int[N][M]; // 1: 벽, 0: 이동가능
        visited = new int[N][M][2]; // 이동 거리 표시하는 이차원 배열
                                // 여기에도 벽을 뚫었을 경우/뚫지 않았을 경우를 구분해줘야함!!
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j)-'0';
            }
        }

        bfs(0,0);

        if (visited[N-1][M-1][1]==0 && visited[N-1][M-1][0]==0) System.out.println(-1);
        else {
            if(visited[N-1][M-1][0]!=0 && visited[N-1][M-1][1]!=0) System.out.println(Math.min(visited[N-1][M-1][0],visited[N-1][M-1][1]));
            else if (visited[N-1][M-1][0] == 0) System.out.println(visited[N-1][M-1][1]);
            else if (visited[N-1][M-1][1] == 0) System.out.println(visited[N-1][M-1][0]);
        }


    }

    static void bfs(int startX, int startY){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startX, startY, 1, false));
        visited[startX][startY][0] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int dist = node.d; // 누적 거리 합
            boolean flag = node.flag;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx<0 || nx>N-1 || ny<0 || ny>M-1) continue;

                if (!flag){ // 이때까지 뿌수지 않은 벽
                    if (visited[nx][ny][0]==0){
                        if (map[nx][ny] == 0){
                            queue.offer(new Node(nx,ny,dist+1, flag));
                            visited[nx][ny][0] = dist+1;
                        }
                        else if (map[nx][ny] == 1){ // 아직 벽을 안뿌쉈다면
                            queue.offer(new Node(nx,ny,dist+1,true)); // 뿌쉈다고 표시!!
                            visited[nx][ny][1] = dist+1;
                        }
                    }
                }
                else{ // 이미 벽을 뿌쉈더라면
                    if (visited[nx][ny][1]==0){ // 뿌순 visited 배열 확인
                        if (map[nx][ny] == 0){
                            queue.offer(new Node(nx,ny,dist+1, flag));
                            visited[nx][ny][1] = dist+1;
                        }
                    }
                }



            }

        }


    }

    static class Node{
        int x, y,d;
        boolean flag;

        Node(int x , int y,int d, boolean flag){
            this.x = x;
            this.y = y;
            this.d = d;
            this.flag = flag;
        }
    }



}
