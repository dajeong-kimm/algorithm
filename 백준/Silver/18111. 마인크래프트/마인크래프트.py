n,m,b = map(int,input().split())

ground = []
for _ in range(n):
    ground.extend(list(map(int,input().split())))

time = [0 for i in range(257)]

height = 0

for g in range(257):
    block = b
    for i in ground:
        if i<=g:
            time[g] += (g-i)
            block -= (g-i)
        else:
            time[g] += 2*(i-g)
            block += (i-g)
    if block>=0 and time[g]<=time[height]:
        height = g

print(time[height], height)
