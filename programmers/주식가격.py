def solution(prices):
    answer = []
    
    for i in range(len(prices)):
        ans = 0
        for j in range(i+1, len(prices)):
            ans += 1 # 우선 +1 해주고
            # [1,2,3,2,1]에서 2는 2->3 1초 / 3->2 1초 / 2->1 1초: 총 3초 후에 떨어짐
            # 우선은 자신보다 작은 곳까지 가줘야한다!
            if prices[i] > prices[j]: # 자신보다 작은 것을 만나면 for문 아웃
                break
        answer.append(ans)
            
    return answer