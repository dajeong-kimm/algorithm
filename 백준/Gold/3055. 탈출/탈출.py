from collections import deque

r,c = map(int,input().split())
map = [list(input()) for _ in range(r)]

visited = [[-1]*c for _ in range(r)]

dy = [-1,1,0,0]
dx = [0,0,-1,1]

q = deque()

for y in range(r):
    for x in range(c):
        if map[y][x] == "*":
            q.appendleft((y,x))
        elif map[y][x] == "S":
            q.append((y,x))
            visited[y][x] = 0

while q:
    y,x = q.popleft()
    cur = map[y][x]
    for i in range(4):
        ny,nx = y+dy[i],x+dx[i]

        if ny<0 or ny>=r or nx<0 or nx>=c:
            continue
        if visited[ny][nx] != -1:
            continue
        if map[ny][nx] == "*":
            continue
        if map[ny][nx] == "X":
            continue
        if cur == "*" and map[ny][nx] == "D":
            continue

        if cur == "S":
            if map[ny][nx] == "D":
                print(visited[y][x]+1)
                break
            visited[ny][nx] = visited[y][x] + 1
        
        map[ny][nx] = cur
        q.append((ny,nx))
    else:
        continue
    break
else:
    print("KAKTUS")