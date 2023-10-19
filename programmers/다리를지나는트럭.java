import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        
        int answer = 0;
        for (int i=0; i<bridge_length; i++){
            queue.offer(0);
        }
        
        int sum = 0;
        int truck = 0;
        while(!queue.isEmpty()){
                
            // 제일 앞에 있는 트럭 나가
            sum -= queue.poll();
            answer++;
            // System.out.println("잘 뺐나요 "+queue);
            
            
            // 뒤에 있는 트럭 들어가
            if (truck < truck_weights.length){
                // System.out.println(truck+"번째 트럭 확인!");
                if (sum+truck_weights[truck] <= weight) {
                    queue.offer(truck_weights[truck]);
                    sum+=truck_weights[truck];
                    // System.out.println(truck+"번째 트럭이 잘 더해졌나요 "+queue);
                    truck++;
                }else{
                    queue.offer(0);
                }
            }
           
        }
        
        
        
        return answer;
    }
}
