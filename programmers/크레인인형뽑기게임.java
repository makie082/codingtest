import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack();
        
        for (int i=0; i<moves.length; i++){
            int chooseLine = moves[i]-1;
            
            int depth = board.length; // 행의 길이만큼 확인
            for(int j=0; j<depth; j++){
                if (board[j][chooseLine] != 0){
                    if (!stack.isEmpty() && stack.peek() == board[j][chooseLine]){
                        stack.pop();
                        answer+=2;
                    }else{
                        stack.push(board[j][chooseLine]);
                    }
                    board[j][chooseLine] = 0;
                    break;
                }
            }
            
            
        }
        
        
        return answer;
    }
}
