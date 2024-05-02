import java.io.*;
import java.util.*;

class Solution {
    
    static int answer = 0;
    public int solution(int N, int[][] road, int K) {
        
        dij(N, road, K);

        return answer;
    }
    
    static void dij(int N, int[][] road, int K){
        PriorityQueue<Point> pqueue = new PriorityQueue<>();
        
        int[] time = new int[N+1]; // 시간을 저장하는 배열
        
        for(int i=0; i<N+1; i++){
            time[i] = Integer.MAX_VALUE;
        }
        
        time[1] = 0; // 1에서 시작하므로 
        pqueue.offer(new Point(1,0));
        
        while(!pqueue.isEmpty()){
            Point point = pqueue.poll();
            int town = point.idx; // 현재 마을
            int t = point.dist;
            
            // 현재 마을과 이어진 마을들 확인
            for (int n=0; n<road.length; n++){
                if (road[n][0] == town || road[n][1] == town){
                    
                    int nextTown = (road[n][0]==town)?road[n][1]:road[n][0];
                    
                    // 이어진 마을이 가진 시간이 현재 마을 건너서 오는 시간보다 클 경우 갱신
                    if (time[nextTown] > time[town] + road[n][2]){
                        time[nextTown] = time[town] + road[n][2];
                        pqueue.offer(new Point(nextTown, time[nextTown]));
                    }
                }
            }
            
            
        }
        
        
        
        // 시간 안에 도착할 수 있는 마을 수 구하기
        for(int i=1; i<N+1; i++){
            if (time[i] <= K){
                answer++;
            }
        }
        
    }
    
    static class Point implements Comparable<Point>{
        int idx, dist;
        
        Point(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Point point) {
            return this.dist - point.dist;
        }
    }
    
    
}
