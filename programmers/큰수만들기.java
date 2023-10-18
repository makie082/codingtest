import java.io.*;
import java.util.*;

class Solution {
    
    int numberLen;
    int resultLen;
    StringBuilder sb = new StringBuilder();
    
    public String solution(String number, int k) {
        
        numberLen = number.length();
        resultLen = numberLen - k;
        
        int depth = 0;
        int from = 0;
        int to = numberLen-resultLen+1;

        while(from < numberLen && depth != resultLen){
            // 처음에 올 수 있는 수 중에서 가장 큰 수가 와야함
            // 0 ~ (길이-k) 사이에 가장 큰 수가 제일 큰 수가 되어야함
            
            // System.out.println(from+"에서 "+to+"이고 남는 숫자의 길이는 "+(numberLen-to));
            int max= 0;
            int idxMax = from;
            
            for (int i=from; i<to; i++){
                if (max < number.charAt(i)-'0'){
                    max = number.charAt(i)-'0';
                    idxMax = i;
                }
            }
            
            sb.append(max);

            depth++;
            from = idxMax+1;
            to = numberLen-(resultLen-depth-1);
            
        }
        
        String answer = String.valueOf(sb);
        return answer;
    }
    
   
}
