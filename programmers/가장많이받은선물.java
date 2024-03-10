import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        
        // friends: 친구들의 이름
        // gifts: 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열
        
        int cnt = friends.length;
        
        // friends의 이름을 빨리 찾기 위해서 map으로 key:value 값을 지정
        HashMap<String, Integer> dic = new HashMap<>();
        for( int i = 0; i<cnt; i++){
            dic.put(friends[i],i); // friends 별로 해당하는 숫자가 대응된다
        }
        
        int giftlen = gifts.length;
        int[][] check = new int[cnt][cnt]; // 주고 받은 거 확인 용 그래프
        
        for(int i=0; i<giftlen; i++){
            String[] giftnames = gifts[i].split(" ");
            check[dic.get(giftnames[0])][dic.get(giftnames[1])]++;
        }
        
        for(int i=0; i<cnt; i++){
            for(int j=0; j<cnt; j++){
                System.out.print(check[i][j]+" ");
            }
            System.out.println();
        }
        
        int[] jisu = new int[cnt]; // 선물 지수
        for(int i=0; i<cnt; i++){
            // 준 선물: 행의 합
            // 받은 선물: 열의 합
            // 선물 지수:  준 선물 - 받은 선물
            int totalGive = 0;
            int totalGet = 0;
            for(int j=0; j<cnt; j++){
                totalGive += check[i][j];
                totalGet += check[j][i];
            }
            jisu[i] = totalGive - totalGet;
        }
        
        for (int i=0; i<cnt; i++){
            System.out.println(jisu[i]);
        }
        
        int[][] check2 = new int[cnt][cnt];
        for (int i=0; i<cnt; i++){
            for (int j=0; j<cnt; j++){
                if (check[i][j] > check[j][i]){ // 준 게 받은 것보다 많을 때
                    check2[i][j]++;
                }
                else if (check[i][j] == check[j][i]){ // 주고 받은 개수가 같거나 주고 받은 기록이 없다면
                    // 선물 지수가 더 큰 사람이 작은 사람에게 선물 받는다
                    if(jisu[i] > jisu[j]){
                        check2[i][j]=1;
                    }else if(jisu[i] < jisu[j]){
                        check2[j][i]=1;
                    }
                }
            }
        }
        
        int result = 0;
        for(int i=0; i<cnt; i++){
            int answer = 0;
            for (int j=0; j<cnt; j++){
                answer += check2[i][j];
            }
            result = Math.max(answer, result);
        }
        return result; // 다음 달에 가장 많은 선물을 받는 친구가 받을 선물의 수
    }
}
