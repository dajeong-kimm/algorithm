from collections import deque
def bfs(i,j):
    queue = deque()
    queue.append((i,j))
    visited[i][j] = 1
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1),(1,1),(-1,-1),(1,-1),(-1,1)):
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<m:
                if visited[nx][ny] == 0 and arr[nx][ny] == 1:
                    visited[nx][ny] = 1
                    queue.append((nx,ny))
    return

n,m = map(int,input().split())

arr = [list(map(int,input().split())) for _ in range(n)]

visited = [[0 for _ in range(m)] for _ in range(n)]
answer = 0
for i in range(n):
    for j in range(m):
        if visited[i][j] == 0 and arr[i][j] == 1:
            bfs(i,j)
            answer += 1

print(answer)