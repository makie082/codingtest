n = int(input())
board = []

for _ in range(n):
    board.append(list(map(int, input().split())))

min_result = 1e9

def dfs(startX, startY, result):
    global min_result
    
    result += board[startX][startY]
    
    if startX == n-1:
        if min_result > result:
            min_result = result
        return
    
    for v in range(3):
        if v != startY: # 방문 안한거만
            dfs(startX+1, v, result)

    
for i in range(3):
    dfs(0,i,0)

print(min_result)