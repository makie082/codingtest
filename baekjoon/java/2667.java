import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int n,cnt;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][n];
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && !visited[i][j]){
                    bfs(i,j);
                    nums.add(cnt);
                }
            }
        }

        System.out.println(nums.size());
        Collections.sort(nums);
        for (int num:nums) {
            System.out.println(num);
        }



    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static void bfs(int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        cnt = 1;

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];

            for (int l = 0; l < 4; l++) {
                int nx = x + dx[l];
                int ny = y + dy[l];


                if (nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;

                if (map[nx][ny] == '1' && !visited[nx][ny]){
                    queue.offer(new int[] {nx,ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }

        }
    }

}
