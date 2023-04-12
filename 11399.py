n = int(input())
p = list(map(int, input().split()))

p.sort()
sumN = 0
timeList = []

for i in range(n):
    sumN += p[i]
    timeList.append(sumN)

print(sum(timeList))