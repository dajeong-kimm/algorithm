from collections import deque
m, n = map(int,input().split())
dx, dy = [1,-1,0,0], [0,0,1,-1]
tomato = [list(map(int,input().split())) for _ in range(n)]
queue = deque()
res = 0

for i in range(n):
    for j in range(m):
        if tomato[i][j]==1:
            queue.append([i,j])
while queue:
    x, y = queue.popleft()
    for i in range(4):
        nx, ny = x+dx[i], y+dy[i]
        if 0<=nx<n and 0<=ny<m and tomato[nx][ny]==0:
            tomato[nx][ny] = tomato[x][y] + 1
            queue.append([nx,ny])
            
for i in tomato:
    for j in i:
        if j==0:
            print(-1)
            exit(0)
    res = max(res,max(i))
print(res-1)