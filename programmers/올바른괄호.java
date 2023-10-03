import java.util.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            // String에서 하나의 문자 잡아내기 위해서는 charAt() 함수 사용
            if (s.charAt(i) == '('){
               stack.push('(');  // stack 안에 넣어줄 때 push
            }else{
                if (stack.size() > 0) stack.pop();
                else return false;
            }
        }
        
        // stack.isEmpty() 사용해서 true/false 판별해야함
        if (stack.size() > 0) return false;
        return true;
    }
}
