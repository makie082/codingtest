import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int M;
    private static int N;
    private static int[][] map;
    static ArrayList<int[]> virus;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    static int max = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new int[] {i,j});
            }
        }

        // 가벽을 세울 수 있는 모든 경우의 수 ㄱ
        dfs(0);

        // 안전 구역 세아리기
        System.out.println(max);

    }


    static void dfs(int x) {

        if (x == 3) {
            // 가벽을 세웠을 때 바이러스 퍼트리기
            bfs();

            return;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈칸인 경우
                    map[i][j] = 1; // 벽을 세움

                    dfs(x+1);
                    map[i][j] = 0; // 원복
                }
            }
        }


    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < virus.size(); i++) {
            queue.offer(virus.get(i));
        }

        int[][] tmpmap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpmap[i][j] = map[i][j];
            }
        }


        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();

            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || nx>N-1 || ny<0 || ny>M-1) continue;
                if (tmpmap[nx][ny] == 0) {
                    tmpmap[nx][ny] = 2;
                    queue.offer(new int[] {nx,ny});
                }
            }

        }


        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tmpmap[i][j] == 0) cnt++;
            }
        }

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(tmpmap[i]));
//		}
//		System.out.println();


        max = Math.max(max, cnt);
//        System.out.println(max);



    }

}
