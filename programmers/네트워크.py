def solution(n, computers):
    answer = 0
    com = [0] * n
    
    def dfs(v):
        for i in range(n):
            if computers[v][i] == 1 and com[i] == 0: # 해당 노드와 연결된 것 확인
                com[i] = 1
                print(i,"와 연결돼있음")
                dfs(i)
        
    for j in range(n):
        if com[j] == 0:
            dfs(j)
            answer += 1
    
    return answer