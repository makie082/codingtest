maps = [[0]*100 for _ in range(100)]

for _ in range(4):
    x1,y1,x2,y2 = map(int, input().split())
    for a in range(x1, x2):
        for b in range(y1,y2):
            maps[a][b] = 1

cnt = 0

for j in range(len(maps)):
    cnt += maps[j].count(1)

print(cnt)