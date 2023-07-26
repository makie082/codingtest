from collections import deque

n, m = map(int, input().split())

original = deque()
answer = []
for i in range(1, n+1):
    original.append(i)


while len(original) != 0:
    original.rotate(-m+1)
    answer.append(original.popleft())
    #print(original)

print("<", end="")
# for i in range(n):
#     if
#     print(a, end=", ")
print(*answer,sep=", ", end ="")
# print(answer[-1],end ="")
print(">")