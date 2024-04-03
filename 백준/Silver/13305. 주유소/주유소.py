n = int(input()) # 도시의 개수

road = list(map(int,input().split()))

liter = list(map(int,input().split()))
liter.pop()
cost = 0

min_value = min(liter)
idx = 0
total_road = 0
while True:
    if liter[idx]==min_value:
        cost += ((sum(road)-total_road)*min_value)
        break
    else:
        cost += road[idx]*liter[idx]
        total_road += road[idx]
        idx += 1
        if idx==n:
            break
print(cost)


