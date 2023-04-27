n = int(input())
m = int(input())
INF = int(1e9)

graph = [[INF] * (1+n) for _ in range(n+1)]

for _ in range(m):
    a,b,c=map(int, input().split())
    if graph[a][b] == INF:
        graph[a][b] = c
    else:
        graph[a][b] = min(graph[a][b], c)

for i in range(1,n+1):
    for j in range(1,n+1):
        for l in range(1,n+1):
            graph[j][l] = min(graph[j][l], graph[j][i]+graph[i][l])




for i in range(1,n+1):
    for j in range(1,n+1):
        if graph[i][j] == INF:
            print(0, end = ' ')
        elif i == j:
            print(0, end = ' ')
        else:
            print(graph[i][j], end = ' ')
    print()