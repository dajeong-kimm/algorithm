from collections import deque
m,n = map(int,input().split())

arr = [list(map(int,input())) for _ in range(n)]

dist = [[-1]*m for _ in range(n)]

def bfs():
    queue = deque()
    queue.append((0,0))
    dist[0][0] = 0
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<m:
                if dist[nx][ny] == -1:
                    if arr[nx][ny] == 0:
                        dist[nx][ny] = dist[x][y]
                        queue.appendleft((nx,ny))
                    else:
                        dist[nx][ny] = dist[x][y] + 1
                        queue.append((nx,ny))

bfs()
print(dist[n-1][m-1])