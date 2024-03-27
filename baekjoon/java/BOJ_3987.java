import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3987 {
    static int N, M, X, Y;
    static int result = 0;
    static char[][] map;
    static int[] dx = {0,1,0,-1}; // 좌, 하, 우, 상
    static int[] dy = {-1,0,1,0};
    static char[] dir = {'L', 'D', 'R', 'U'};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int n = 0; n < N; n++) {
            map[n] = br.readLine().toCharArray();
        }

        st =new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken())-1;
        Y = Integer.parseInt(st.nextToken())-1;


        int idx = 0;
        for (int d = 0; d < 4; d++) {
            // 좌 하 우 상 순서대로 쏴서 결과 알아보기!
            int check = checkTime(d);
//            System.out.println(dir[d]+" 방향일 때 "+check);
            if (check >= result){ // 나온 결과가 크거나 같다면
                idx = d; // idx 갱신
                result = check; // result 값 갱신
            }
        }

        System.out.println(dir[idx]);

        System.out.println((result == Integer.MAX_VALUE)?"Voyager":String.valueOf(result));

    }

    static int checkTime(int d){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(X,Y)); // 첫 시작점;;
        int cnt = 0;
        int[][] visited = new int[N][M];
        visited[X][Y] = d+1;

        while (!queue.isEmpty()){
            Point point = queue.poll();
            cnt++;

            // 한 방향으로만 이동
            int x = point.x + dx[d];
            int y = point.y + dy[d];


            // 범위 벗어나면 걍 끝
            if (x < 0 || x > N-1 || y < 0 || y > M-1) return cnt;

            if (visited[x][y] != d+1){ // 아직 방문하지 않음
                if (map[x][y] == '/'){ // 방향 전환!
                    if (d == 0){ // 좌, 하, 우, 상
                        d = 1;
                    }else if(d == 1){
                        d = 0;
                    }else if(d == 2){
                        d = 3;
                    }else if(d == 3){
                        d = 2;
                    }
                }else if (map[x][y] == '\\'){ // 방향 전환!
                    if (d == 0){
                        d = 3;
                    }else if(d == 1){
                        d = 2;
                    }else if(d == 2){
                        d = 1;
                    }else if(d == 3){
                        d = 0;
                    }
                }else if (map[x][y] == 'C'){ // 블랙홀 만남
                    return cnt;
                }

                queue.offer(new Point(x,y));
                visited[x][y] = d+1;

            }else if (visited[x][y] == d+1){
                // 이미 지났던 방향대로 또 가면 같은 방법으로밖에 못가기 때문에
                // 뱅글뱅글 돌 수 밖에 없다!
                return Integer.MAX_VALUE;
            }

        }

        return cnt;
    }


    static class Point{
        int x,y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



}
