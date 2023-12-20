import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    private static int N;
    private static int BLUE;
    private static int RED;
    private static int GREEN;
    private static int REDANDGREEN;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs(i,j);
                    if (map[i][j] == 'B') BLUE++;
                    if (map[i][j] == 'R') RED++;
                    if (map[i][j] == 'G') GREEN++;
                }

            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs(i,j);
                    if(map[i][j] == 'R') REDANDGREEN++;
                }
            }
        }

        System.out.println((RED+GREEN+BLUE)+" "+(REDANDGREEN+BLUE));
    }

    // 파랑색 구역 확인
    static void bfs(int x, int y){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x,y));
        visited[x][y] = true;
        char c = map[x][y];

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int X = node.x;
            int Y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = X+dx[i];
                int ny = Y+dy[i];

                if (nx<0 || nx>=N || ny<0 || ny>=N) continue;

                if(map[nx][ny]==c && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    queue.offer(new Node(nx,ny));
                }

            }
        }
    }
    static class Node{
        int x, y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



}
// 비효율적으로 색깔 별로 함수 만들어 푼 방법
// import java.util.*;
// import java.io.*;

// public class BOJ_10026 {

//     static char[][] map;
//     static boolean[][] visited;
//     static int[] dx = {0,0,1,-1};
//     static int[] dy = {1,-1,0,0};
//     private static int N;
//     private static int BLUE;
//     private static int RED;
//     private static int GREEN;
//     private static int REDANDGREEN;



//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         N = Integer.parseInt(br.readLine());
//         map = new char[N][N];
//         visited = new boolean[N][N];
//         for (int i = 0; i < N; i++) {
//             map[i] = br.readLine().toCharArray();
//         }

//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < N; j++) {
//                 if(map[i][j]=='B' && !visited[i][j]){
//                     blue(i,j);
//                     BLUE++;
//                 }
//                 if(map[i][j]=='R' && !visited[i][j]){
//                     red(i,j);
//                     RED++;
//                 }
//                 if(map[i][j]=='G' && !visited[i][j]){
//                     green(i,j);
//                     GREEN++;
//                 }

//             }
//         }

//         visited = new boolean[N][N];
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < N; j++) {
//                 if((map[i][j]=='R' || map[i][j]=='G') && !visited[i][j]){
//                     redandgreen(i,j);
//                     REDANDGREEN++;
//                 }
//             }
//         }

//         System.out.println((RED+GREEN+BLUE)+" "+(REDANDGREEN+BLUE));
//     }

//     // 파랑색 구역 확인
//     static void blue(int x, int y){
//         Queue<Node> queue = new ArrayDeque<>();
//         queue.offer(new Node(x,y));
//         visited[x][y] = true;

//         while(!queue.isEmpty()){
//             Node node = queue.poll();
//             int X = node.x;
//             int Y = node.y;

//             for (int i = 0; i < 4; i++) {
//                 int nx = X+dx[i];
//                 int ny = Y+dy[i];

//                 if (nx<0 || nx>=N || ny<0 || ny>=N) continue;

//                 if(map[nx][ny]=='B' && !visited[nx][ny]){
//                     visited[nx][ny]=true;
//                     queue.offer(new Node(nx,ny));
//                 }

//             }
//         }
//     }

//     static void red(int x, int y){
//         Queue<Node> queue = new ArrayDeque<>();
//         queue.offer(new Node(x,y));
//         visited[x][y] = true;

//         while(!queue.isEmpty()){
//             Node node = queue.poll();
//             int X = node.x;
//             int Y = node.y;

//             for (int i = 0; i < 4; i++) {
//                 int nx = X+dx[i];
//                 int ny = Y+dy[i];

//                 if (nx<0 || nx>=N || ny<0 || ny>=N) continue;

//                 if(map[nx][ny]=='R' && !visited[nx][ny]){
//                     visited[nx][ny]=true;
//                     queue.offer(new Node(nx,ny));
//                 }

//             }
//         }
//     }

//     static void green(int x, int y){
//         Queue<Node> queue = new ArrayDeque<>();
//         queue.offer(new Node(x,y));
//         visited[x][y] = true;

//         while(!queue.isEmpty()){
//             Node node = queue.poll();
//             int X = node.x;
//             int Y = node.y;

//             for (int i = 0; i < 4; i++) {
//                 int nx = X+dx[i];
//                 int ny = Y+dy[i];

//                 if (nx<0 || nx>=N || ny<0 || ny>=N) continue;

//                 if(map[nx][ny]=='G' && !visited[nx][ny]){
//                     visited[nx][ny]=true;
//                     queue.offer(new Node(nx,ny));
//                 }

//             }
//         }
//     }

//     static void redandgreen(int x, int y){
//         Queue<Node> queue = new ArrayDeque<>();
//         queue.offer(new Node(x,y));
//         visited[x][y] = true;

//         while(!queue.isEmpty()){
//             Node node = queue.poll();
//             int X = node.x;
//             int Y = node.y;

//             for (int i = 0; i < 4; i++) {
//                 int nx = X+dx[i];
//                 int ny = Y+dy[i];

//                 if (nx<0 || nx>=N || ny<0 || ny>=N) continue;

//                 if((map[nx][ny]=='R' || map[nx][ny]=='G') && !visited[nx][ny]){
//                     visited[nx][ny]=true;
//                     queue.offer(new Node(nx,ny));
//                 }

//             }
//         }
//     }
//     static class Node{
//         int x, y;

//         Node(int x, int y){
//             this.x = x;
//             this.y = y;
//         }
//     }



// }


