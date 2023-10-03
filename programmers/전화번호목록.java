import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        Arrays.sort(phone_book);
        boolean answer = true;
        for(int i=0; i<len-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                return answer;
            }
        
        }
        
        return answer;
    }
}
