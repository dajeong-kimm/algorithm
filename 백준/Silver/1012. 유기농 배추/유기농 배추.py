from collections import deque
import sys
input = sys.stdin.readline

def bfs(i,j):
    dx, dy = [0,0,1,-1],[1,-1,0,0]
    queue = deque()
    queue.append((i,j))
    board[i][j] = 0
    
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<m and board[nx][ny]==1:
                board[nx][ny] = 0
                queue.append((nx,ny))

t = int(input())
for _ in range(t):
    m,n,k = map(int,input().split())
    board = [[0]*m for _ in range(n)]
    for _ in range(k):
        x,y = map(int,input().split())
        board[y][x] = 1
    cnt = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == 1:
                bfs(i,j)
                cnt += 1
    print(cnt)


