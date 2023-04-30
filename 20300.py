from collections import deque

n = int(input())
t = list(map(int, input().split()))
t.sort()
t = deque(t)

if len(t) % 2 == 0: # 짝수이면
    bigger = t.pop()
    smaller = t.popleft()
    m = bigger + smaller
    maxM = m

else:
    maxM = t.pop()

while t:
    bigger = t.pop()
    if len(t) == 0:
        m = bigger
        if m > maxM:
            maxM = m
        break
    smaller = t.popleft()
    m = bigger + smaller
    if m > maxM:
        maxM = m


print(maxM)