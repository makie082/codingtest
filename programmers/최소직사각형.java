class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int min, max;
        int X = 0;
        int Y = 0;
        
        for (int i = 0; i<sizes.length; i++){
            if (sizes[i][0] < sizes[i][1]){
                min = sizes[i][0];
                max = sizes[i][1];
            }else{
                max = sizes[i][0];
                min = sizes[i][1];
            }
            
            X = Math.max(max, X);
            Y = Math.max(min, Y);
        
        }
        answer = X*Y;
        return answer;
    }
}
