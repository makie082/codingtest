from itertools import combinations

def solution(nums):
    answer = 0

    for combi in combinations(nums, 3):
        result = sum(combi)
        flag = 0
        if result == 1:
            break
        if result == 2:
            answer+=1
            break
        for i in range(2, int(result**0.5)+1):
            if result%i == 0: # 나누어떨어지면
                flag = 1
                break # 소수 아님
        if flag == 0:
            #print(combi,"는 소수!")
            answer+= 1
    
    return answer