class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long r1x = (long)Math.pow(r1,2);
        long r2x = (long)Math.pow(r2,2);
        
        // y^2 =  r^2 - x^2
        
        long side = 0;
        
        for (long i=0; i<=r2; i++){
            long y2 = (long) Math.sqrt(r2x - (long)Math.pow(i,2)); // 큰 원에 속하는 모든 점들 중 가장 큰 수
            long y1 = (long) Math.sqrt(r1x - (long)Math.pow(i,2)); // 작은 원에 속하는 모든 점들
            
            // 벽면 확인해야함
            // 작은 원의 테두리에 있는 값 중 정수인 경우는 포함해줘야함
            if (Math.sqrt(r1x-Math.pow(i,2))%1 == 0){
                System.out.println(Math.sqrt(r1x-Math.pow(i,2)));
                side++;
            }
            
            // 큰 원에 있는 점들에서 작은 원에 있는 점들을 소거해줌
            answer += (y2-y1)*4; // 1사분면만 확인했기 때문에
        }
        
        // 테두리 위에 있는 점들을 합해준다
        answer += side*4-4;
        
        return answer;
    }
}
