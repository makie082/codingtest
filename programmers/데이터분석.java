import java.io.*;
import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        // ext: 어떤 정보를 기준으로 데이터를 뽑아낼지 - code, date, maximum, remain
        // val_ext: 뽑아낼 정보의 기준값을 나타내는 정수
        // sort_by: 정보를 정렬할 기준이 되는 문자열
        
        int N = data.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int extNum = map.get(ext);
        int sort_byNum = map.get(sort_by);
        
        Arrays.sort(data, (o1,o2) ->{
            return o1[sort_byNum] - o2[sort_byNum];
        });
        
        boolean[] table = new boolean[N];
        int cnt = 0;
        for (int i=0; i<N; i++){
            
            if(data[i][extNum] > val_ext){
                table[i] = false;
            }else{
                table[i] = true;
                cnt++;
            }
            
        }
        
        int[][] answer = new int[cnt][4];
        int idx = 0;
        for (int i=0; i<N; i++){
            if (table[i]) {
                answer[idx][0] = data[i][0];
                answer[idx][1] = data[i][1];
                answer[idx][2] = data[i][2];
                answer[idx][3] = data[i][3];
                idx++;
            }
        }
        
        
        
        return answer;
    }
    
    class Point{
        int a,b,c,d;
        Point(int a, int b, int c, int d){
            this.a=a;
            this.b=b;
            this.c=c;
            this.d=d;
        }
    }
}
