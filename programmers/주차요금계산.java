import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        
        // fees: 주차 요금 [ 기본시간(분) 기본요금(원) 단위시간(분) 단위요금(원) ]
        int stdTime = fees[0];
        int stdMoney = fees[1];
        int unitTime = fees[2];
        int unitMoney = fees[3];
        
        // records: 자동차의 입출차 내역 [ 시각 차량번호 내역 ]
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        
        for(int i=0; i<records.length; i++){
            String[] tmp = records[i].split(" ");
            
            String time = tmp[0];
            String carNum = tmp[1];
            String inout = tmp[2];
            
            if(map.containsKey(carNum)){
                String[] start = map.get(carNum).split(":");
                String[] end = time.split(":");
                
                int hour = Integer.parseInt(end[0])-Integer.parseInt(start[0]);
                int minute = Integer.parseInt(end[1])-Integer.parseInt(start[1]);
                
                map.remove(carNum);
                if (result.containsKey(carNum)) result.put(carNum,result.get(carNum)+hour*60+minute);
                else result.put(carNum,hour*60+minute);
                
            }else{
                map.put(carNum, time);
            }
            
            
        }
        
        if (!map.isEmpty()){
            for ( String key : map.keySet() ){
                String[] tmp = map.get(key).split(":");
                int hour = 23-Integer.parseInt(tmp[0]);
                int minute = 59-Integer.parseInt(tmp[1]);
                if (result.containsKey(key)) result.put(key,result.get(key)+hour*60+minute);
                else result.put(key,hour*60+minute);
            }
        }
        System.out.println(result);
        
        List<String> list = new ArrayList<>(result.keySet()); // hashmap은 순서가 없으므로 list로 변환하여 sorting 해주어야함
        Collections.sort(list);
        
        int[] answer = new int[result.size()];
        for ( int i=0; i<result.size(); i++ ){
            int r = result.get(list.get(i));
            
            if (r <= stdTime){
                answer[i] = stdMoney;
            }else{
                if ( (r-stdTime)%unitTime == 0 ) answer[i] = stdMoney + (r-stdTime)/unitTime*unitMoney;
                else answer[i] = stdMoney + (1+(r-stdTime)/unitTime)*unitMoney;
                
            }
            
        }
        
        return answer;
    }

    
    
    
}
