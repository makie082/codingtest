package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_14923 {

	static int n,m,hx,hy,ex,ey;
	static int[][] map;
	static int[][][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());

	    st = new StringTokenizer(br.readLine());
	    hx = Integer.parseInt(st.nextToken());
	    hy = Integer.parseInt(st.nextToken());

	    st = new StringTokenizer(br.readLine());
	    ex = Integer.parseInt(st.nextToken());
	    ey = Integer.parseInt(st.nextToken());
	    
	    map = new int[n][m];
	    visited = new int[n][m][2];
	    for (int i = 0; i < n; i++) {
	    	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    visited[hx-1][hy-1][0]=1;
	    bfs(hx-1,hy-1,0);
	   
	    System.out.println(visited[ex-1][ey-1][1]-1);
	    
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static void bfs(int x, int y, int cnt) { // 출발좌표 x,y, 얼마나 갔는지, 벽 뿌순 개수
		Queue<point> queue = new ArrayDeque<>();
		queue.offer(new point(x,y,cnt));
		
		while (!queue.isEmpty()) {
			point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx<0||nx>n-1||ny<0||ny>m-1) continue;
				if (p.cnt == 0) {
					if (visited[nx][ny][0] == 0) {
						if(map[nx][ny] == 1) { 
							// 벽일 때 + 한 번도 뿌수지 않았다면 일로 이동 가능 ㅋㅋ
//							System.out.print("["+nx+","+ny+"]");
							visited[nx][ny][1] = visited[p.x][p.y][0]+1;
							queue.offer(new point(nx,ny,p.cnt+1));
						}
						else { 
//							System.out.print("["+nx+","+ny+"]");
							visited[nx][ny][0] = visited[p.x][p.y][0]+1;
							queue.offer(new point(nx,ny,p.cnt));
						}
					}
				}
				else {
					if(map[nx][ny] == 0 && visited[nx][ny][1] == 0) { 
//						System.out.print("["+nx+","+ny+"]");
						visited[nx][ny][1] = visited[p.x][p.y][1]+1;
						queue.offer(new point(nx,ny,p.cnt));
					}
				}
				
				
				
				
			}
			
		}
	}
	
	static class point{
		int x,y,cnt;
		
		point(int x, int y,int cnt){
			this.x =x;
			this.y = y;
			this.cnt= cnt;
		}
	}

}
