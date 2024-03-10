class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage: 기술시전시간, 1초당회복량x, 추가회복량y
        // health: 최대 체력(이거를 넘을 수는 없음)
        // attacks: 공격시간, 피해량
        int maxHealth = health;
        int startAttack = 0;
        
        int seq = 0; // 연속적으로 몇 개인지 카운트하기 위한 변수
        for(int i=1; i<=attacks[attacks.length-1][0]; i++){
            if (attacks[startAttack][0] == i){ // 처음 공격을 당하는 초면
                health -= attacks[startAttack][1];
                startAttack++;
                seq = 0;
                if (health <= 0) return -1;
            }else{
                health += bandage[1];
                seq++; // 연속적으로
                if (seq == bandage[0]){
                    health += bandage[2];
                    seq = 0;
                }
                if (health >= maxHealth) health = maxHealth;
            }
            System.out.println(health);
            
        
        }
        return health;
    }
}
