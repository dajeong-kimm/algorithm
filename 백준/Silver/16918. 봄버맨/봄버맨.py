from collections import deque

dx = [-1,0,1,0]
dy = [0,1,0,-1]

queue = deque()

r,c,n = map(int,input().split())

board = [list(input()) for _ in range(r)]

def bfs(queue,board):
    while queue:
        x,y = queue.popleft()
        board[x][y] = '.'
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<r and 0<=ny<c and board[nx][ny] == 'O':
                board[nx][ny] = '.'


def simulate(t):
    global q,board
    if t ==1:
        for i in range(r):
            for j in range(c):
                if board[i][j] == 'O':
                    queue.append((i,j))
    elif t%2==1:
        bfs(queue,board)
        for i in range(r):
            for j in range(c):
                if board[i][j] == 'O':
                    queue.append((i,j))
    else:
        board = [['O']*c for _ in range(r)]


for i in range(1,n+1):
    simulate(i)

for i in board:
    print(''.join(i))
