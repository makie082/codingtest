import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] visited;
    public int solution(int[][] maps) {
        
        int R = maps.length;
        int C = maps[0].length;
        
        visited = new int[R][C];
        
        bfs(0,0,R,C, maps);
        
        
        if (visited[R-1][C-1] == 0) return -1;
        
        return visited[R-1][C-1];
    }
    
    
    
    static void bfs(int x, int y, int R, int C, int[][] map){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));
        visited[x][y] = 1;
        
        while(!queue.isEmpty()){
            Point point = queue.poll();
            
            for (int d=0; d<4; d++){
                int nx = point.x+dx[d];
                int ny = point.y+dy[d];
                
                if (nx<0 || nx>R-1 || ny<0 || ny>C-1) continue;
                
                if (map[nx][ny] == 1 && visited[nx][ny] == 0){
                    visited[nx][ny] = visited[point.x][point.y]+1;
                    queue.offer(new Point(nx, ny));
                }
                
            }
        }
    }
    
    
    
    static class Point{
        int x, y;
        
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
