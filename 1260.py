from collections import deque

n, m, v = map(int, input().split())

# line = [0]*(n+1)
# graph = []
# for _ in range(n+1):
#     graph.append(line)


graph = [[0]*(n+1) for _ in range(n+1)]

for _ in range(m):
    a,b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1



dfs_visited = [0]*(n+1)
bfs_visited = [0]*(n+1)
bfs_visited[0] = 1
dfs_visited[0] = 1

def bfs(start):
    queue = deque()
    queue.append(start)
    bfs_visited[start] = 1
    
    while queue:
        v = queue.popleft()
        print(v,end = ' ')
        for i in range(n+1):
            if bfs_visited[i] == 0 and graph[v][i] == 1: # 아직 방문 안했고 인접한 것들을 지나가줘야함
                bfs_visited[i] = 1
                queue.append(i)



def dfs(start):
    dfs_visited[start] = 1
    print(start, end=' ')

    for i in range(n+1):
        if graph[start][i] == 1 and dfs_visited[i] == 0: # 연결되어 있으면
            dfs(i)

dfs(v)
print("")
bfs(v)