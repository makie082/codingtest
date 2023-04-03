import sys
input = sys.stdin.readline

N, M = map(int, input().split())
pokemons = {}

for i in range(N):
    p = input()
    print("p:",list(p))
    pokemons[p] = i+1
    pokemons[i+1] = p

for _ in range(M):
    q = input()
    print("q:",list(q))
    if q.isdigit():
        print(pokemons[int(q)])
    else:
        print(pokemons[q])