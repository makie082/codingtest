import java.util.*;
import java.io.*;

class Solution {
    
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    public int solution(int[][] land) {
        
        // 0: 빈 땅, 1: 석유
        
        // 1. 석유 덩어리를 찾는다.
        // 2. 석유 덩어리를 만나는 열의 범위를 찾는다.
        // 3. 모든 열에서 가장 많은 석유의 값을 찾는다.
        
        int Y = land[0].length;
        int X = land.length;
        
        
        // 1. 석유 덩어리를 찾는다.
        
        return findOil(land,Y,X);
    }
    public int findOil(int[][] land, int Y, int X){
        
        ArrayList<Result> arr = new ArrayList<>();
        boolean[][] visited = new boolean[X][Y];
        for (int i=0; i<X; i++){
            for (int j=0; j<Y; j++){
                if (land[i][j] == 1 && !visited[i][j]){
                    arr.add(bfs(i,j,land,X,Y, visited));
                }
            }
        }
        
        int[] table = new int[Y]; // table: 각 열에서 가질 수 있는 석유 값
        for (int i=0; i<arr.size(); i++){
            int start = arr.get(i).start;
            int end = arr.get(i).end;
            for (int k=start; k<=end; k++) table[k] += arr.get(i).cnt;
        }
        
        int answer = Integer.MIN_VALUE;
        for (int i=0; i<Y; i++){
            System.out.print(table[i]+" ");
            // 3. 모든 열에서 가장 많은 석유의 값을 찾는다.
            answer = Math.max(answer, table[i]);
        }
        
        return answer;
    }
    
    public Result bfs(int i, int j, int[][] land, int X, int Y, boolean[][] visited){
        int cnt = 0;
        // 2. 석유 덩어리를 만나는 열의 범위를 찾는다.
        int startY = Integer.MAX_VALUE;
        int endY = Integer.MIN_VALUE;
        
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i,j));
        visited[i][j] = true;
        
        while(!queue.isEmpty()){
            Point point = queue.poll();
            cnt++;
            startY = Math.min(startY, point.y);
            endY = Math.max(endY, point.y);
            
            for (int d=0; d<4; d++){
                int nx = point.x+dx[d];
                int ny = point.y+dy[d];
                
                if (nx<0 || nx>X-1 || ny<0 || ny>Y-1) continue;
                
                if (visited[nx][ny]) continue;
                
                if (land[nx][ny]==1){
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx,ny));
                }
            }
        }
        
        return new Result(startY, endY, cnt);
    }
    
    
        
    class Result{
        int start, end, cnt;
        
        Result(int start, int end, int cnt){
            this.start = start;
            this.end = end;
            this.cnt = cnt;
        }
    }
    class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}
