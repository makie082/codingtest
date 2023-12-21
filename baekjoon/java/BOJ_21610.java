import java.util.*;
import java.io.*;

public class BOJ_21610 {

    private static int M,N;
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    private static int[][] map;
    private static int[][] move;
    static ArrayList<Point> cloud; // cloud를 queue로 두어도 편하게 가능

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 격자판 입력
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이동 입력
        move = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            move[i][0] = Integer.parseInt(st.nextToken());
            move[i][1] = Integer.parseInt(st.nextToken());
        }

        // 처음에 구름이 있는 칸 (N-1,1) (N-1,2) (N,1) (N,2)
        cloud = new ArrayList<Point>();
        cloud.add(new Point(N-1,1));
        cloud.add(new Point(N-1,2));
        cloud.add(new Point(N,1));
        cloud.add(new Point(N,2));

        for (int d = 0; d < M; d++) {

//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }


            // 이동
            // 구름이 이동한 곳에 물의 양 +1 해주기
            cloudMove(d);

            // 구름이 있던 곳에 있는 물의 양 + 대각선에 물이 있는 칸의 수
            cloudPlus();

            // 격자에서 물의 양이 2 이상인 모든 칸에 구름이 생기고 물의 양 -2
            // 구름이 사라진 칸 제외
            cloudMake();

//            System.out.println(cloud);
        }

        System.out.println(result());

    }

    // 구름 이동
    static void cloudMove(int d){
        int dir = move[d][0]; // 이동 방향
        int s = move[d][1]; // 이동 거리

        int cloudSize = cloud.size();
        for (int i = 0; i < cloudSize; i++) {
            // 구름 이동
            cloud.get(i).x += dx[dir-1]*s;
            cloud.get(i).y += dy[dir-1]*s;

            // 연결되어 있으므로
            while(cloud.get(i).x <= 0) cloud.get(i).x+=N;
            while(cloud.get(i).x > N) cloud.get(i).x-=N;

            while (cloud.get(i).y <= 0) cloud.get(i).y+=N;
            while (cloud.get(i).y > N) cloud.get(i).y-=N;

            // 구름 이동 완료
            // 구름이 이동한 곳에 물의 양 +1 해주기
//            System.out.println("cloud: " + cloud.get(i).x + "," + cloud.get(i).y);
            map[cloud.get(i).x][cloud.get(i).y]+=1;
        }
//        System.out.println("비내린거 확인!");
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }

    // 구름이 있던 곳에 있는 물의 양 + 대각선에 물이 있는 칸의 수
    static void cloudPlus(){
        int cloudSize = cloud.size();
        int[] checkX = {-1,-1,1,1};
        int[] checkY = {-1,1,-1,1};
        for (int i = 0; i < cloudSize; i++) {
            int cnt = 0;
            // 대각선 확인
            for (int j = 0; j < 4; j++) {
                // 범위 밖인 것은 고려해줄 필요 없음
                if (cloud.get(i).x+checkX[j] < 1 || cloud.get(i).y+checkY[j] < 1 ||
                        cloud.get(i).x+checkX[j] > N || cloud.get(i).y+checkY[j] > N) continue;

                // 대각선 칸에 물이 있다면
                if (map[cloud.get(i).x + checkX[j]][cloud.get(i).y + checkY[j]] > 0) {
                    cnt++;
                }

            }
//            System.out.println(cloud.get(i)+"("+map[cloud.get(i).x][cloud.get(i).y]+")에서 "+cnt+"만큼 더해진다");
            map[cloud.get(i).x][cloud.get(i).y] += cnt;
        }
//        System.out.println("잘 더해진거 확인!");
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }

    // 격자에서 물의 양이 2 이상인 모든 칸에 구름이 생기고 물의 양 -2
    // 구름이 사라진 칸 제외
    static void cloudMake(){
        ArrayList<Point> newCloud = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 물의 양은 2이상이고 구름이 있던 칸이면 안됨
                if (map[i][j] >= 2 && !cloud.contains(new Point(i,j))){
//                    System.out.println(i+","+j+"에서 변화 있음!");
                    map[i][j] -= 2; // 해당 칸의 물이 2만큼 감소
                    newCloud.add(new Point(i,j));
                }
            }
        }
        cloud = new ArrayList<Point>();
        cloud.addAll(newCloud);
//        System.out.println("구름에 따른 양 변 확인!");
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

    }

    static int result(){
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ans += map[i][j];
            }
        }

        return ans;
    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x= x;
            this.y= y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

    }


}
