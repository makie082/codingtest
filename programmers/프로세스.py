from collections import deque

def solution(priorities, location):
    answer = 0
    
    priorities = deque(priorities)
    ids = [i for i in range(len(priorities))]
    ids = deque(ids)
    print(ids)
    
    while priorities:
        rot = priorities.index(max(priorities))
        priorities.rotate(-rot)
        ids.rotate(-rot)
        priorities.popleft()
        id = ids.popleft()
        answer += 1
        if id == location:
            return answer
    