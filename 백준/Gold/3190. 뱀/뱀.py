from collections import deque

n = int(input())
k = int(input())
maps = [[0]*(n+1) for _ in range(n+1)]

for _ in range(k):
    x,y = map(int,input().split())
    maps[x][y] = 2

info = {}
l = int(input())
for _ in range(l):
    sec,direct = input().split()
    info[int(sec)] = direct

time = 0
dx = [1,0,-1,0]
dy = [0,1,0,-1]
x,y = 1,1
d = 0
snakes = deque([(1,1)])

while True:
    nx,ny = x+dx[d],y+dy[d]

    if nx<=0 or ny<=0 or nx>n or ny>n or (nx,ny) in snakes:
        break

    if maps[ny][nx] != 2:
        a,b = snakes.popleft()
        maps[b][a] = 0
    x,y = nx,ny
    snakes.append((nx,ny))
    time += 1

    if time in info.keys():
        if info[time] == "D":
            d = (d+1)%4
        else:
            d = (d+3)%4

print(time+1)