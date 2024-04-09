import sys
sys.setrecursionlimit(10**6)

def dfs(x,y):
    board[x][y] = 0
    dx = [1,1,-1,-1,1,-1,0,0]
    dy = [0,1,0,1,-1,-1,1,-1]
    for i in range(8):
        nx,ny = x+dx[i], y+dy[i]
        if 0<=nx<h and 0<=ny<w and board[nx][ny] == 1:
            dfs(nx,ny)

while True:
    w,h = map(int,input().split())
    if w == 0 and h == 0:
        break
    else:
        board = []
        for _ in range(h):
            board.append(list(map(int,input().split())))
        answer = 0
        for i in range(h):
            for j in range(w):
                if board[i][j] == 1:
                    dfs(i,j)
                    answer += 1
        # print(f"answer: {answer}")
        print(answer)