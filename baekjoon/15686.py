import itertools

n, m = map(int,input().split())

graph = [list(map(int, input().split())) for _ in range(n)]

dis = [] # 집과 치킨집 사이의 거리를 묶어둔 리스트

house = []
chickenShop = []

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1: # 집이면
            house.append([i,j])
        if graph[i][j] == 2: # 치킨 집이면
            chickenShop.append([i,j])


checkList = itertools.combinations(chickenShop,m)


result = []

for shops in checkList:
    totalDis = []
    #print(shops,"에서의 치킨거리:")
    for h in house:    
        h_c_dis = []
        for shop in shops:
            dis = abs(shop[0]-h[0]) + abs(shop[1]-h[1])
            h_c_dis.append(dis)
        totalDis.append(min(h_c_dis)) # 한 집을 기준으로 치킨집들 중에 가장 가까운 치킨거리만 남김
    result.append(sum(totalDis))

print(min(result))

