n, m = map(int, input().split())
r, c, d = map(int, input().split())

graph = [ list(map(int, input().split())) for _ in range(n) ]
dx = [-1, 0, 1, 0] # 북 동 남 서
dy = [0, 1, 0, -1]
cnt = 0

x,y = r,c

while 1:
    flag = 0

    if graph[x][y] != 1: # 현재 칸이 벽이 아닌 경우
        if graph[x][y] == 0:
            graph[x][y] = 2 # 청소한다
            cnt += 1
            #print("[%d,%d]에서 %d번째 청소!" %(x,y,cnt))


        for i in range(4): # 주변 4칸 확인
            # 반시계 방향으로 확인 0432104321
            d = (d+3)%4

            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= ny < m+1 and 0 <= nx < n+1 and graph[nx][ny] == 0: # 바라보는 방향을 기준으로 앞 쪽칸이 청소되지 않은 빈칸
                #print("[%d,%d]에서 [%d,%d]로 바뀜, 방향은 %d" %(x,y,nx,ny,d))
                x, y = nx, ny
                flag = 1 # 주변에 빈 칸이 있었다
                break

    if flag == 0: # 주변에 빈칸이 없을 경우
        # 해당 칸에서 후퇴..
        nx = x - dx[d]
        ny = y - dy[d]
        if 0 <= ny < m+1 and 0 <= nx < n+1:
            if graph[nx][ny] == 1: # 벽일 때만 문제
                print(cnt)
                exit()
            else: # 벽이 아니면 일단 이동
                x = nx
                y = ny
