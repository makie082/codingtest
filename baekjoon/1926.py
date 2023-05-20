from collections import deque

n, m= map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]


cnt = 0

dx = [1,-1,0,0]
dy = [0,0,-1,1]
visited = [[0]*m for _ in range(n)]

def bfs(graph, startX, startY):
    global cnt
    cnt += 1
    pic_Size = 1
    visited[startX][startY] = 1
    queue = deque()
    queue.append([startX, startY])

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if 0<=nx<n and 0<=ny<m and graph[nx][ny] == 1:
                if visited[nx][ny] == 0:
                    queue.append([nx,ny])
                    visited[nx][ny] = 1
                    pic_Size += 1

    return pic_Size

maxPic = 0
for a in range(n):
    for b in range(m):
        if graph[a][b] == 1 and visited[a][b] == 0:
            k = bfs(graph,a,b)
            if k>maxPic:
                maxPic = k
print(cnt)
print(maxPic)