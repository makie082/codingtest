from collections import deque

n = int(input())
t = int(input())

graph = [[0 for _ in range(n+1)] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]

for _ in range(t):
    a,b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1


# dfs version
def dfs(startX):
    if visited[startX] == 1:
        return
    
    visited[startX] = 1 # 지나갔다고 해주기

    for i in range(n+1):
        if graph[startX][i] == 1:
            dfs(i)

dfs(1)
print(visited.count(1)-1)


# bfs version
def bfs(startX):
    queue = deque()
    queue.append(startX)

    while queue:
        q = queue.popleft()
        for i in graph[q]:
            if i == 1:
                idx = graph[q].index(i)
                if visited[idx] == 0:
                    visited[idx] = 1
                    queue.append(idx)

bfs(1)
print(visited.count(1)-1)