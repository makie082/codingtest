import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        ArrayList<int[]> yellowRC = new ArrayList<>();
        // 노란색을 먼저 깐다
        // 나누어 떨어지는 모든 경우의 수 구한다
        int max = (int) Math.sqrt(yellow);
        for(int i=1; i<=max; i++){
            if (yellow%i == 0) yellowRC.add(new int[]{i,yellow/i});
        }

        // 노란색의 (가로+1+세로+1)*2 한 값이 갈색의 개수
        max = yellowRC.size();
        int[] answer = new int[2];
        for(int i=0; i<max; i++){
            if (brown/2 == yellowRC.get(i)[0]+yellowRC.get(i)[1]+2){
            
                answer[0] = Math.max(yellowRC.get(i)[0]+2,yellowRC.get(i)[1]+2);
                answer[1] = Math.min(yellowRC.get(i)[0]+2,yellowRC.get(i)[1]+2);
            }
        }
        
        
        return answer;
    }
}
