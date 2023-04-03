import sys
input = sys.stdin.readline
from collections import deque


n, k = map(int, input().split())
belt = deque(map(int, input().split()))

robot = deque(list([0]*n)) # 로봇이 있는 위치를 1이라고 표시

ans = 0


while belt.count(0) < k:

    belt.rotate(1)
    robot.rotate(1)

    # print("돌려진 벨트: ", belt)
    # print("돌려진 로봇: ", robot)

    robot[-1] = 0 # 가장 마지막 칸인 n번째 칸은 늘 '그 즉시 내린다'

    # 원래 벨트 위에 있던 로봇을 이동
    for i in range(n-2,-1,-1): # 끝에서부터 로봇의 존재를 확인해야 두 번 옮겨지는 문제를 막을 수 있음!!!!(연쇄적인 이동이 있을 수 있기 때문에)
        if robot[i] == 1 and robot[i+1] == 0 and belt[i+1] > 0:
             robot[i+1] = 1
             robot[i] = 0
             belt[i+1] -= 1 # 로봇이 스스로 이동했을 때만 내구성이 -1 됨
        robot[-1] = 0 # 가장 마지막 칸인 n번째 칸은 늘 '그 즉시 내린다'

    #print("이동한 로봇: ", robot)
    #print("이동한 벨트: ",belt)

    # 새로 올리는 위치에 올릴 로봇
    if belt[0] > 0 and robot[0]==0: # 첫 칸의 로봇이 이동 못했을 수도 있기 때문에 첫 칸이 비었을 경우에만 추가 가능능
        belt[0] -= 1
        robot[0] = 1

    robot[-1] = 0 # 가장 마지막 칸인 n번째 칸은 늘 '그 즉시 내린다'
    #print("로봇 추가? ",robot)
    #print("최종 벨트: ", belt, "\n")

    ans += 1


print(ans)