from collections import deque
n,m,k = map(int,input().split())
arr = [[0]*m for _ in range(n)]

for _ in range(k):
    a,b = map(int,input().split())
    arr[a-1][b-1] = 1

visited = [[0]*m for _ in range(n)]
def bfs(i,j):
    queue = deque()
    queue.append((i,j))
    visited[i][j] = 1
    cnt = 1
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx = x+dx
            ny = y+dy
            if 0<=nx<n and 0<=ny<m and visited[nx][ny] == 0 and arr[nx][ny]==1:
                visited[nx][ny] = 1
                queue.append((nx,ny))
                cnt += 1
    return cnt

answer = []
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1 and visited[i][j] == 0:
            answer.append(bfs(i,j))
print(max(answer))