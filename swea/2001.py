import sys
sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    n, m = map(int, input().split())
    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().split())))
   	
    max_flies = 0
    flies = []
    for i in range(n-m+1):
        for j in range(n-m+1):
            #print("시작점:(%d,%d) => " %(i,j), end = ' ')
            killed_flies = 0
            for a in range(m):
                for b in range(m):
                    killed_flies += graph[i+a][j+b]
            # print(killed_flies)
            flies.append(killed_flies)
            
            if max_flies < killed_flies:
                max_flies = killed_flies
    print("#%d %d" %(test_case, max_flies))     