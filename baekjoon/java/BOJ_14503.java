import java.io.*;
import java.util.*;


public class BOJ_14503 {
	private static int N;
	private static int M;
	private static int[][] map;
	static int[] dx = {-1,0,1,0}; // 시계 방향 (북 동 남 서)
	static int[] dy = {0,1,0,-1}; // 시계 방향
	private static int[][] visited;
	private static int result;
	
	
	public static void main(String[] args) throws Exception {
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int curX = Integer.parseInt(st.nextToken());
		int curY = Integer.parseInt(st.nextToken());
		int curD = Integer.parseInt(st.nextToken()); // 0:북 1:동 2:남 3:서
		
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = map[i][j];
			}
		}
		
		
		bfs(curX, curY, curD);
		
		System.out.println(result);
		
	}
	
	static void bfs(int startX, int startY, int dir) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(startX, startY, dir));
		visited[startX][startY] = 1; // 현재 칸 청소
		result = 1;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x=node.startX;
			int y=node.startY;
			int d=node.dir; // 현재 바라보고 있는 방향
			
			if (visited[x][y] == 0) { // 후진한 칸이 청소하지 않은 칸이면
				visited[x][y] = 1;// 현재 칸 청소 - 청소 표시를 1로 표기
				result++;
			}
						
			// 주변 4칸 반시계 방향으로 확인
			int cnt = 0;
			boolean flag = false;
			while(cnt<4) {
				int nd = (d+7-cnt)%4; // 3210 순서대로 가야함
				int nx = x + dx[nd];
				int ny = y + dy[nd];
				
				// 범위 벗어나거나, 벽이면 넘어감
				if (nx<0||nx>N-1||ny<0||ny>M-1||map[nx][ny]==1) {
					cnt++;
					continue;
				}
				
				if (visited[nx][ny]==0) { // 앞 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
					queue.offer(new Node(nx,ny,nd));
					
					flag = true;
					break;
				}
				
				cnt++;
			}
			
			// 4방에 청소 다 되었다면
			if (!flag) {
				
				// 후진하고 현재 칸 청소
				int nx = x-dx[d];
				int ny = y-dy[d];
				
				// 후진했을 때 벽이면 STOP
				if (nx<0||nx>N-1||ny<0||ny>M-1||map[nx][ny]==1) break;
				
				// 후진 ㄱ
				if (map[nx][ny]==0) queue.offer(new Node(nx,ny,d));
					
			}
			
			
		}
		
		
	}
	
	static class Node{
		int startX, startY, dir;
		
		Node(int startX, int startY, int dir){
			this.startX=startX;
			this.startY=startY;
			this.dir=dir;
		}
		
	}
}
