from collections import deque
n,m = map(int,input().split())

arr = [list(input()) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

def bfs(x,y):
    queue = deque()
    o = 0
    v = 0
    queue.append((x,y))
    while queue:
        a,b = queue.popleft()
        for dx,dy in ((0,0),(0,1),(0,-1),(-1,0),(1,0)):
            nx = a+dx
            ny = b+ dy

            if 0<=nx<n and 0<=ny<m and not visited[nx][ny]:
                if arr[nx][ny] == "#":
                    continue
                elif arr[nx][ny] == 'v':
                    v += 1
                elif arr[nx][ny] == 'o':
                    o += 1
                queue.append((nx,ny))
                visited[nx][ny] = 1
    return o, v

sheep, wolf = 0,0
for i in range(n):
    for j in range(m):
        if not visited[i][j] and arr[i][j] != '#':
            s,w = bfs(i,j)
            if s>w:
                sheep += s
            else:
                wolf += w

print(sheep,wolf)