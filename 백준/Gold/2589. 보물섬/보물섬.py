from collections import deque
n,m = map(int,input().split())

board = [list(input()) for _ in range(n)]


def bfs(i,j):
    queue = deque()
    queue.append((i,j))
    visited = [[0]*m for _ in range(n)]
    visited[i][j] = 1
    cnt = 0
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = x+dx,y+dy
            if 0<=nx<n and 0<=ny<m and visited[nx][ny] == 0:
                if board[nx][ny] == "L":
                    visited[nx][ny] = visited[x][y] + 1
                    cnt = max(cnt,visited[nx][ny])
                    queue.append((nx,ny))
    return cnt -1

answer = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == "L":
            answer = max(answer,bfs(i,j))

print(answer)

