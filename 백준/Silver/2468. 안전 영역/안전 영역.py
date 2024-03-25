from collections import deque
n = int(input())
max_value = 0
board = [list(map(int,input().split())) for _ in range(n)]
dx,dy = [0,0,1,-1], [1,-1,0,0]

for boa in board:
    max_value = max(max_value, max(boa))
def bfs(a,b,h,visited):
    queue=deque()
    queue.append([a,b])
    visited[a][b] = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx,ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if board[nx][ny]>h and visited[nx][ny]==0:
                    queue.append([nx,ny])
                    visited[nx][ny]=1
result = 0
for i in range(max_value):
    cnt = 0
    visited = [[0]*n for _ in range(n)]
    for j in range(n):
        for k in range(n):
            if board[j][k]>i and visited[j][k]==0:
                bfs(j,k,i,visited)
                cnt += 1
    result = max(result,cnt)
print(result)
                
            