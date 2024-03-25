from collections import deque
import sys
input = sys.stdin.readline
n, m = map(int,input().split())

board = [list(map(int,input().split())) for _ in range(n)]
dx,dy = [0,0,1,-1],[1,-1,0,0]

def bfs(i,j,visited):
    queue = deque()
    queue.append([i,j])
    visited[i][j] = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<m:
                if board[nx][ny] == 0:
                    visited[x][y] += 1
                if visited[nx][ny] == 0 and board[nx][ny]!=0:
                    queue.append([nx,ny])
                    visited[nx][ny] = 1
answer = 0
while True:
    count = 0
    visited = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if visited[i][j]==0 and board[i][j]!=0:
                bfs(i,j,visited)
                count += 1
    for i in range(n):
        for j in range(m):
            if visited[i][j]:
                board[i][j] -= (visited[i][j]-1)
                if board[i][j]<0:
                    board[i][j] = 0
    answer += 1
    if count == 0:
        print(0)
        exit()
    if count >= 2:
        break

print(answer-1)
