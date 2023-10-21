import java.io.*;
import java.util.*;


class Solution {

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    int[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        
        int[] answer = new int[2]; // 몇 개의 영역이 있는지, 가장 큰 영역은 몇 칸?
        visited = new int[m][n]; // m행 n열
        
        for (int r=0; r<m; r++){
            for (int c=0; c<n; c++){
                if (picture[r][c]!=0 && visited[r][c]==0){
                    answer[1] = Math.max(answer[1],bfs(r,c,picture,n,m));
                    answer[0]++; // 영역 개수
                }
            }
        }
        
        return answer;
    }
    
    public int bfs(int startX, int startY, int[][] picture, int n, int m){
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(startX, startY));
        int color = picture[startX][startY];
        visited[startX][startY] = color;
        int check=1;
        
        while (!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            
            
            for (int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                
                if (nx<0 || nx>m-1 || ny<0 || ny>n-1) continue;
                
                if (visited[nx][ny] == 0 && picture[nx][ny] == color){
                    queue.offer(new Point(nx,ny));
                    visited[nx][ny] = color;
                    check++;
                }
                
            }
        }
        // System.out.println(color+"에서 "+check+"개 가지고 있다");
        // for(int a=0; a<m; a++){
        //     for (int b=0; b<n; b++){
        //         System.out.print(visited[a][b]+" ");
        //     }
        //     System.out.println();
        // }
        
        return check;
        
    }
    
    class Point{
        int x, y;
        
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
