import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		bfs(0,0);
	
		
		
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		queue.offer(new int[] {x,y,1});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int r = arr[0];
			int c = arr[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = r+dx[i];
				int ny = c+dy[i];
				int cnt = arr[2];

				if (nx<0||nx>=N||ny<0||ny>=M) continue;
				else {
					if (visited[nx][ny]== false && map[nx][ny] == '1') {
						visited[nx][ny]=true;
						queue.offer(new int[] {nx,ny,++cnt});
						if (nx == N-1 && ny == M-1) {
							System.out.println(cnt);
							return;
						}
					}
				}

			}

		}
		
		
	}
	

}
