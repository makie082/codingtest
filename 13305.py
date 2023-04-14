cityNum = int(input())
distance = list(map(int, input().split()))
money = list(map(int, input().split()))

total_distance = sum(distance)
total_money = 0

# 첫 시작이 가장 싸다면
if money[0] == min(money): 
    total_money = total_distance*money[0]

else:
    # 제일 처음에는 다음꺼까지 주유해야함(최소)
    total_money = money[0]*distance[0] 
    presentMoney = money[0]

    for i in range(1,len(money)-1):
        if money[i] > presentMoney:
            total_money += (presentMoney*distance[i])
        else:
            total_money += (money[i]*distance[i])
            presentMoney = money[i]

print(total_money)
        