from collections import deque

n, m = map(int, input().split())
rail = deque(list(map(int, input().split())))
robot = deque([0 for _ in range(n)])

ans = 0
while (1):
    ans += 1
    rail.rotate(1)
    robot.pop() # 젤 뒤에꺼 빼기
    robot.appendleft(0) # robot 앞에 넣어주고
    robot[-1] = 0
    

    # 로봇 이동하기
    for i in range(n-2,-1,-1):
        if robot[i] == 1 and robot[i+1] == 0 and rail[i+1] > 0:
            robot[i] = 0
            robot[i+1] = 1
            rail[i+1] -= 1
    robot[-1] = 0

    if (rail[0] > 0):
        rail[0] -= 1 # 첫 칸에 로봇 올려줌
        robot[0] = 1
        
    cnt = 0
    for i in range(2*n):
        if rail[i] == 0:
            cnt+=1
    
    if cnt >= m:
        break
            

print(ans)
