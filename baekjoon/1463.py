n = int(input())

dp = [0 for _ in range(n+1)]

##### 시간 초과 !!!!
# for i in range(2,n+1):
#     check = i
#     while check!=1:
#         dp[i] += 1
#         if check%3 == 0: # 3으로 나누어떨어지면
#             check //= 3
#         elif check%2 == 0:
#             check //= 2
#         else:
#             check -= 1
#     dp[i] = min(dp[i],dp[i-1]+1)

for i in range(2,n+1):
    dp[i] = dp[i-1]+1
    if i%3 == 0: # 3으로 나누어떨어지는거면
        dp[i] = min(dp[i], dp[i//3]+1)
    ### 여기에 elif 해주면 안됨 .. ^^ 걸러지기 때매
    if i%2 == 0: # 2으로 나누어떨어지는거면
        dp[i] = min(dp[i], dp[i//2]+1)


print(dp[n])