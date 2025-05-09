def dfs(x,y,number):
    if len(number) == 6:
        if number not in result:
            result.append(number)
        return

    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if 0<=nx<5 and 0<=ny<5:
            dfs(nx,ny,number+board[nx][ny])

board = []
for i in range(5):
    board.append(list(map(str,input().split())))

result = []
for i in range(5):
    for j in range(5):
        dfs(i,j,board[i][j])

print(len(result))