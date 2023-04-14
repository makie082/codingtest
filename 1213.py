line = list(input())
lineSet = list(set(line))
lineSet.sort()
cnt= []

for i in range(len(lineSet)):
    cnt.append(line.count(lineSet[i]))

oddCnt = 0
for j in cnt:
    if j%2 == 1:
        oddCnt += 1

if oddCnt > 1:
    print("I'm Sorry Hansoo")
    exit()

result = ""
restword = 0
for alp in range(len(lineSet)):
    for _ in range(cnt[alp]//2):
        result += lineSet[alp]
    #print(cnts//2,"번 적힘")
    if cnt[alp]%2 == 1:
        restword = lineSet[alp]

if restword != 0:
    result += restword

    for r in result[-2::-1]:
        result += r

else:
    for r in result[::-1]:
        result += r

print(result)

