import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        
        // answer에 맞게 문제 수가 있다라는 뜻!
        int quesCnt = answers.length;
        for(int i = 0; i < quesCnt; i++){
            if (answers[i] == one[i%5]) score[0]++;
            if (answers[i] == two[i%8]) score[1]++;
            if (answers[i] == three[i%10]) score[2]++;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        int max = 0;
        for(int i=0; i<3; i++){
            if (max < score[i]){
                max = score[i];
            }
        }
        
        for(int i=0; i<3; i++){
            if (max == score[i]){
                arr.add(i+1);
            }
        }
        
        int[] answer = new int[arr.size()];
        
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);    
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
