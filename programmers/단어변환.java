import java.util.*;
import java.io.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        
        // 포함 안되어있으면 바로 return
        boolean flag = false;
        for (int i=0; i<words.length; i++){
            if (words[i].equals(target)) flag = true;
        }
        if (!flag) return 0;
        
        
        boolean[] visited = new boolean[words.length];
        
        // 파고 들어가보기
        dfs(begin, target, 0, words, visited);
        
        return answer;
    }
    
    void dfs(String begin, String target, int depth, String[] words, boolean[] visited){
        
        if (begin.equals(target)){
            answer = Math.min(answer, depth);
            System.out.println();
            return;
        }
        
                
        // 단어를 비교했을 때 다른 알파벳이 하나 있으면 ㄱ
        for (int i=0; i<words.length; i++){
            
            if (visited[i]) continue; // 이미 했던 글자는 안봄
            
            int cnt=0; // 다른 알파벳의 개수
            
            for (int j=0; j<begin.length(); j++){
                if ( begin.charAt(j) != words[i].charAt(j) ) cnt++;
            }
            
            if (cnt == 1){
                // 한 글자만 다른 경우에
                visited[i] = true;
                
                for(int a=0; a<words.length; a++){
                    if (visited[a]) System.out.print(words[a]+" ");
                }
                System.out.println();
                
                
                dfs(words[i], target, depth+1, words, visited);
                visited[i] = false;
            }
            
        }
        
        
        
        
    }
    
    
}
