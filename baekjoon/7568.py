n = int(input())

ids = set()
cnt = 0
for i in range(n):
    newInput = input()
    if newInput == "ENTER":
        cnt+=len(ids)
        ids = set()
        continue
    ids.add(newInput)

cnt+=len(ids)

print(cnt)