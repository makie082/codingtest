import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        int workCnt = progresses.length;
        int[] days = new int[workCnt];
        for(int i=0; i<workCnt; i++){
            if ((100-progresses[i])%speeds[i] == 0) days[i] = (100-progresses[i])/speeds[i];
            else days[i] = (100-progresses[i])/speeds[i] + 1;
        }
        
        System.out.println(Arrays.toString(days));
        
        for (int i=0; i<workCnt; i++){
            int cnt = 1;
            System.out.println(days[i]+"를 기준으로");
            
            for (int j=i+1; j<workCnt; j++){
                if (days[i] >= days[j]) {
                    cnt++;
                    // 마지막 값이 포함이 되었을 경우
                    if (j == workCnt-1){
                        i = j;
                        break;
                    }
                }
                else {
                    // 기준점을 다시 돌려줘야함
                    i = j-1;
                    break;
                }
            }
            
            answerList.add(cnt);
        }
        
        System.out.println(answerList);

        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
