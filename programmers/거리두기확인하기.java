import java.io.*;
import java.util.*;

class Solution {
    
    int len;
    int len2;
    int seats;
    int[] dx = {0,0,1,-1}; // +
    int[] dx3 = {1,1,-1,-1}; // x
    int[] dx2 = {0,0,2,-2}; // ++

    int[] dy = {1,-1,0,0};
    int[] dy3 = {-1,1,-1,1};
    int[] dy2 = {2,-2,0,0};
    
    public int[] solution(String[][] places) {
        len = places.length;
        len2 = places[0].length;
        seats = places[0][0].length();
        int[] answer = new int[len];
        // P: 응시자가 앉아있는 자리
        // O: 빈 테이블
        // X: 파티션
        
        for (int r=0; r<len; r++){
             boolean flag = true;
            for (int a=0; a<len2; a++){
               
                
                for (int b=0; b<seats; b++){
                    
                    if (places[r][a].charAt(b) == 'P'){
                        // 응시자마다 확인하는 백트래킹!
                        
                        if (!checkS(r,a,b,places) || !checkX(r,a,b,places)) { // 하나에서 틀리면 넘어가면 됨
                            answer[r] = 0;
                            System.out.println("false");
                            flag = false;
                            break;
                        }
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) answer[r] =1;
        }
        
        
        return answer;
    }
    
    boolean checkS(int r, int x, int y, String[][] places){
        System.out.println(r+"번째에서 x: "+x+", y: "+y);
        
        for (int d=0; d<4; d++){
            
            // +
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if ( nx<0 || nx>len2-1 || ny<0 || ny>seats-1 ) {
                continue;
            }
            if ( places[r][nx].charAt(ny) == 'P' ) { // 주변에 바로 있으면
                System.out.println(nx+","+ny+": person right near by");
                return false;
            }
            
            if ( places[r][nx].charAt(ny) == 'X' ) { // 파티션 넘어서는 확인할 필요 없
                continue; // 그 이상 확인하지 않아도 됨
            }
            
            if ( places[r][nx].charAt(ny) == 'O' ){ // 넘어서도 확인해야함
                if ( nx+dx[d]<0 || nx+dx[d]>len2-1 || ny+dy[d]<0 || ny+dy[d]>seats-1 ) continue;
                if ( places[r][nx+dx[d]].charAt(ny+dy[d]) == 'P'){
                    System.out.println((dx[d]+nx)+","+(dy[d]+ny)+": person near by");
                    return false;
                }
            }
        }
        return true;
    }
        
        
            
        
    boolean checkX(int r, int x, int y, String[][] places){
        System.out.println(r+"번째에서 x: "+x+", y: "+y);
        
        for (int d=0; d<4; d++){
            
            // +
            int nx = x + dx3[d];
            int ny = y + dy3[d];
            
            if ( nx<0 || nx>len2-1 || ny<0 || ny>seats-1 ) {
                continue;
            }
            
            if ( places[r][nx].charAt(ny) == 'P' ) { // 주변에 바로 있으면
                // 양옆에 파티션이 있는지 확인해야함
                if (d==0 && places[r][nx].charAt(ny+1)=='X' && places[r][nx-1].charAt(ny)=='X') continue;
                else if (d==1 && places[r][nx].charAt(ny-1)=='X' && places[r][nx-1].charAt(ny)=='X') continue;
                else if (d==2 && places[r][nx].charAt(ny+1)=='X' && places[r][nx+1].charAt(ny)=='X') continue;
                else if (d==3 && places[r][nx].charAt(ny-1)=='X' && places[r][nx+1].charAt(ny)=='X') continue;
                
                System.out.println("X: "+nx+","+ny+": person right near by");
                return false;
            }
            
        }

        
        
        return true;
        
        
        
    }
    
    class Point{
        int r, x, y;
        
        Point(int r, int x, int y){
            this.r=r;
            this.x=x;
            this.y=y;
        }
    }
    
}
