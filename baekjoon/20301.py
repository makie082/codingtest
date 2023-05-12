from collections import deque

n, k, m = map(int, input().split())

erasedArr = []

circle = deque(i+1 for i in range(n))

k = k-1
while 1:
    for _ in range(m):
        if circle:
            flag = 1
            circle.rotate(-k)
            c_rm = circle.popleft()
            erasedArr.append(c_rm)
        else:
            flag = 0
            break
    
    if flag == 0:
        break
    circle.reverse()
    
for n in erasedArr:
    print(n)