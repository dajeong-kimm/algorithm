from collections import deque
n = int(input())
board = []
dx = [0,0,1,-1]
dy = [1,-1,0,0]
for _ in range(n):
    board.append(list(map(int,input())))

def bfs(board,i,j):
    queue = deque()
    queue.append((i,j))
    count = 1
    board[i][j] = 0
    
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<n and board[nx][ny] == 1:
                count += 1
                board[nx][ny] = 0
                queue.append((nx,ny))
    return count

cnt = []
for i in range(n):
    for j in range(n):
        if board[i][j] == 1:
            cnt.append(bfs(board,i,j))
cnt.sort()
print(len(cnt))
for c in cnt:
    print(c)