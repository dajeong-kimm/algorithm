from collections import deque

n,m = map(int,input().split())
arr = []
for i in range(n):
    tmp = list(map(int,input().split()))
    for j in range(m):
        if tmp[j] == 2:
            goal_x,goal_y = i,j
            break
    arr.append(tmp)

answer = [[0]*m for _ in range(n)]
visited = [[-1]*m for _ in range(n)]

def bfs(i,j):
    queue = deque()
    queue.append((i,j))
    visited[i][j] = 0
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(0,1),(-1,0),(0,-1)):
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<m:
                if visited[nx][ny]==-1 and arr[nx][ny] != 0:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx,ny))
    


for i in range(n):
    for j in range(m):
        if arr[i][j] == 2 and visited[i][j] == -1:
            bfs(i,j)

for i in range(n):
    for j in range(m):
        if arr[i][j] == 0:
            print(0,end=' ')
        else:
            print(visited[i][j],end=' ')
    print()