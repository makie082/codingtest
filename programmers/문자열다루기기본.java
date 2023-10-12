import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() != 4 && s.length() != 6) return false;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) >= 'A' && s.charAt(i)<='Z' || s.charAt(i) >= 'a' && s.charAt(i)<='z') return false;
        }
        
                           
        
        return answer;
    }
}
