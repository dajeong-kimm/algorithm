from collections import deque
m,n = map(int,input().split())

arr = [list(input()) for _ in range(n)]
visited =[[0]*m for _ in range(n)]

def bfs(i,j,color):
    visited[i][j] = 1
    queue = deque()
    queue.append((i,j))
    cnt = 1
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<m:
                if visited[nx][ny] == 0 and arr[nx][ny] == color:
                    visited[nx][ny] = 1
                    cnt += 1
                    queue.append((nx,ny))
    return cnt

white = 0
blue = 0

for i in range(n):
    for j in range(m):
        if visited[i][j] == 0:
            if arr[i][j] == "W":
                tmp = bfs(i,j,"W")
                white += tmp**2
            else:
                tmp = bfs(i,j,"B")
                blue += tmp**2

print(white,blue)
