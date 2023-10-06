import java.util.*;
import java.io.*;

class Solution {
    
    boolean[] visited;
    int answer = 0;
    int[][] realcomputers;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        realcomputers = computers;
        
        for(int i=0; i<n; i++){
            if(!visited[i]) bfs(i,n);    
        }
        
        return answer;
    }
    
    void bfs(int start, int n){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;
            
            for (int i=0; i<n; i++){
                if (realcomputers[tmp][i] == 1 && !visited[i]) {
                    queue.offer(i);
                }
            }
            
        }
        answer++;
    }
    
    
}
