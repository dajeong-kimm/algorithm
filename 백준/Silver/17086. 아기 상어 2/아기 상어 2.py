from collections import deque

n,m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

d = [(-1,0),(1,0),(0,-1),(0,1),(-1,-1),(1,-1),(-1,1),(1,1)]

q = deque()

def bfs():
    while q:
        x,y = q.popleft()
        for dx,dy in d:
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<m:
                if not graph[nx][ny]:
                    graph[nx][ny] = graph[x][y]+1
                    q.append((nx,ny))

for i in range(n):
    for j in range(m):
        if graph[i][j]:
            q.append((i,j))

bfs()
answer = 0
for g in graph:
    answer = max(answer,max(g))

print(answer-1)