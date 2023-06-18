n, m = map(int, input().split())

graph = [list(input()) for _ in range(m)]
visited = [[0]*n for _ in range(m)]

dx = [0,0,-1,1]
dy = [1,-1,0,0]

def dfs(startX, startY,visited):
    visited[startX][startY] = 1 # 방문했다고 바꿔주기
    global cnt
    cnt += 1
    for i in range(4):
        nx = startX + dx[i]
        ny = startY + dy[i]

        if 0<=nx<m and 0<=ny<n:
            if visited[nx][ny]==0:
                if graph[nx][ny] == graph[startX][startY]: # 그래프 안의 범위이고 해당 값과 같으면
                    dfs(nx,ny,visited)

Wcnt = 0
Bcnt = 0

for x in range(m):
    for y in range(n):
        if visited[x][y] == 0:
            cnt = 0
            dfs(x,y,visited)
            if graph[x][y] == 'W':
                Wcnt += cnt**2
            else:
                Bcnt += cnt**2

print(Wcnt, Bcnt)