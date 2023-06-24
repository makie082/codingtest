t = int(input())
stair = []

for a in range(t):
    stair.append(int(input()))

dp = [0 for _ in range(t)]

dp[0] = stair[0]

for i in range(1,t):
    if i == 1:
        dp[i] = stair[1] + dp[0]
    elif i==2:
        dp[i] = max(stair[0]+stair[2], stair[1]+stair[2])

    else:
        dp[i] = max(dp[i-2]+stair[i], dp[i-3]+stair[i-1]+stair[i])

print(dp[t-1])