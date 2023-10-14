import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<participant.length; i++){
            if (i == participant.length-1){
                return participant[participant.length-1];
            }
            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        
        return "hi";
    }
}
