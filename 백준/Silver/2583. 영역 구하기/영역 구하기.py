from collections import deque

n,m,k = map(int,input().split())
board = [[1]*m for _ in range(n)]
for _ in range(k):
    a,b,c,d = map(int,input().split())
    for i in range(b,d):
        for j in range(a,c):
            board[i][j] = 0

dx,dy = [0,0,1,-1],[1,-1,0,0]
def bfs(i,j):
    queue = deque()
    queue.append((i,j))
    cnt = 1
    board[i][j] = 0

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx,ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<m and board[nx][ny]==1:
                board[nx][ny] = 0
                queue.append((nx,ny))
                cnt += 1
    return cnt
    


res = []
for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            res.append(bfs(i,j))
res.sort()
print(len(res))
for r in res:
    print(r,end=' ')