import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[] visited;
    static HashSet<Integer> set;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        findNum(numbers, 0, "");
        
        System.out.println(set);

        int result = 0;
        
        for(Integer num:set){
            if(isPrime(num)) result++;
        }
        
        return result;
    }
    
    static void findNum(String numbers, int tgtIdx, String s){
        
        if (tgtIdx == numbers.length()) return;
    
        for (int i=0; i<numbers.length(); i++){
            if (visited[i]) continue;
            set.add(Integer.parseInt(s + numbers.charAt(i)));
            visited[i] = true;
            findNum(numbers, tgtIdx+1, s+numbers.charAt(i));
            visited[i] = false;
        }
    }
    
    
    // 소수 판별 함수
    static boolean isPrime(int n){
        
        if(n==1 || n==0) return false;
        
        for(int i=2; i<=(int) Math.sqrt(n); i++){
            if (n%i == 0) return false;
        }
        return true;
        
        
    }
    
}
