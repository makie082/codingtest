class Solution {
    
    static int[] dx = {0,0,1,-1}; // E W S N
    static int[] dy = {1,-1,0,0};
    
    public int[] solution(String[] park, String[] routes) {
        int R = park.length;
        int C = park[1].length();
        
        Point startPoint = null;
        for (int r=0; r<R; r++){
            for (int c=0; c<C; c++){
                if (park[r].charAt(c) == 'S'){
                    // 시작점 찾기
                    startPoint = new Point(r,c);
                    break;
                }
            }
        }
        
        int allRoute = routes.length;
        for (int i=0; i<allRoute; i++){
            
            int x = startPoint.x;
            int y = startPoint.y;
            
            char dir = routes[i].charAt(0);
            int weigh = routes[i].charAt(2) -'0';
            
            int d = 0;
            if (dir == 'E') d = 0;
            else if (dir == 'W') d = 1;
            else if (dir == 'S') d = 2;
            else d = 3;
            
            int nx = x;
            int ny = y;
            
            for (int j=0; j<weigh; j++){
                nx += dx[d];
                ny += dy[d];
                
                if (nx<0 || nx>R-1 || ny<0 || ny>C-1 || park[nx].charAt(ny) == 'X'){
                    // 범위 밖을 벗어난 경우
                    // 경로에서 장애물을 만났을 때
                    nx = x;
                    ny = y;
                    break;
                }
            }
            
            startPoint = new Point(nx, ny);
            
            
        }
        
        System.out.println(startPoint.x + "  "+ startPoint.y);
        
        int[] answer = {startPoint.x, startPoint.y};
        return answer;
    }
    
    static class Point{
        int x, y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
