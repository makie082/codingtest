import java.io.*;
import java.util.*;

public class BOJ_11559 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int result = 0;
    static boolean check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        map = new char[12][6];
        for (int n = 0; n < 12; n++) {
            map[n] = br.readLine().toCharArray();
        }

        while(true){
            // 붙어있는 네 개의 색깔 찾기
            visited = new boolean[12][6];
            check = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.'){
                        find4blocks(map[i][j],i,j);
                    }
                }
            }

//            for (int i = 0; i < 12; i++) {
//                for (int j = 0; j < 6; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }

            if (!check) break;
            // 터진 것음 감안하여 중력 방향 이동한다
            gravity();

//            for (int i = 0; i < 12; i++) {
//                for (int j = 0; j < 6; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
            result++;


        }
        System.out.println(result);



    }

    static void gravity(){
        for (int i = 0; i < 6; i++) {
            int cntVacant= 0;
            for (int j = 11; j >= 0 ; j--) {
                if (map[j][i] != '.'){
                    if (cntVacant == 0) continue;
//                    System.out.println(map[j][i]+"가 "+i+","+j+"칸에서 "+cntVacant+"만큼 띄워서 존재");
                    map[j+cntVacant][i] = map[j][i];
                    map[j][i]= '.';
                }else{
                    cntVacant++;
                }
            }
        }
    }
    static void find4blocks(char c, int startX, int startY){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startX, startY));
        visited[startX][startY] = true;
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(startX,startY));

        int cnt = 1;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || nx>11 || ny<0 || ny>5) continue;

                if (map[nx][ny] == c && !visited[nx][ny]){
                    cnt++;
                    list.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx,ny));
                }

            }
        }

        if (cnt >= 4){
            // 4개 이상이면 터트릴 수 있음
            check = true;
            int len = list.size();
            for (int i = 0; i < len; i++) {
                int delX = list.get(i).x;
                int delY = list.get(i).y;
                map[delX][delY] = '.';
            }
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
