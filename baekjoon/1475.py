n = list(input())

cnt = [0 for _ in range(10)]

for i in n:
    num = int(i)
    if num == 6:
        num = 9
    cnt[num] += 1

if cnt[9] % 2 == 0:
    cnt[9] = cnt[9] // 2
else:
    cnt[9] = cnt[9] // 2 + 1


print(max(cnt))