import java.util.*;
import java.io.*;

class Solution {
    String check;
    int[] dh = {0,0,-1,1};
    int[] dw = {1,-1,0,0};
    int H,W,count;
    public int solution(String[][] board, int h, int w) {
        // int answer = 0;
        H = board.length;
        W = board[0].length;
        check = board[h][w];
        System.out.println(check);
        
        bfs(board, h,w);
        return count;
    }
    
    public void bfs(String[][] board, int h, int w){
        
        for(int i=0; i<4; i++){
            int nh = h + dh[i];
            int nw = w + dw[i];

            if (nh<0 || nh>H-1 || nw<0 || nw>W-1) continue;

            if (board[nh][nw].equals(check)) count++;
        }
        
    }
    
}
