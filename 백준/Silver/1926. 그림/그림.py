from collections import deque
n, m = map(int,input().split())

board = [list(map(int,input().split())) for _ in range(n)]
res = []
dx,dy = [0,0,1,-1],[1,-1,0,0]
def bfs(i,j):
    queue = deque()
    queue.append([i,j])
    board[i][j] = 0
    cnt = 1
    
    while queue:
        x,y = queue.popleft()
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if 0<=nx<n and 0<=ny<m and board[nx][ny]==1:
                board[nx][ny]=0
                queue.append([nx,ny])
                cnt += 1

    return cnt


for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            res.append(bfs(i,j))

if not res:
    print(0)
    print(0)
else:
    print(len(res))
    print(max(res))
