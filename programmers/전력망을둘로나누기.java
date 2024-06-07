import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int lessDiff = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        // 하나씩 끊어가는 맛
        list = new ArrayList[n+1];
       
        
        for(int i=1; i<n+1; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        int wireLen = wires.length;
        
        for(int i=0; i<wireLen; i++){
            // 양 방향으로 걸어준다
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        
        // 하나씩 끊어서 확인해본다
        
        for(int i=0; i<wireLen; i++){
            int n1 = wires[i][0];
            int n2 = wires[i][1];
            
            // 일단 하나씩 끊는다
            list[n1].remove(Integer.valueOf(n2));
            list[n2].remove(Integer.valueOf(n1));
            
            int cnt = 0; // 나눠진 덩어리의 개수
            visited = new boolean[n+1];
            ArrayList<Integer> cntList = new ArrayList<>();
            for(int a=1; a<n+1; a++){
                if (!visited[a]){
                    cntList.add(bfs(a));
                    cnt++;
                }
                if (cnt > 2) break;
            }
            
            if (cnt == 2){
                lessDiff = Math.min(lessDiff, Math.abs(cntList.get(0) - cntList.get(1)));
                
            }
            
            // 끊었던 거 다시 넣어준다
            list[n1].add(n2);
            list[n2].add(n1);
        }

        return lessDiff;
    }
    
    static int bfs(int start){
        int nodeCnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start]=true;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            nodeCnt++;
            
            // 나랑 연결된 거 중에
            for (int i:list[now]){
                if(!visited[i]){ // 아직 방문 안한거 있으면 방문 ㄱ
                    queue.offer(i);
                    visited[i] = true;
                }
            }
            
        }
        
        return nodeCnt;
        
        
    }
    
    
    
    
}
