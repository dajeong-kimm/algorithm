n, m = map(int,input().split())
r,c,d = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
dir = [(-1,0),(0,1),(1,0),(0,-1)] # 북, 동, 남, 서

visited = [[0]*m for _ in range(n)]

visited[r][c] = 1
cnt = 1

while True:
    flag = 0
    for _ in range(4):
        d = (d+3)%4
        nr, nc = r+dir[d][0], c+dir[d][1]
        if 0<=nr<n and 0<=nc<m and board[nr][nc]==0:
            if visited[nr][nc] == 0:
                visited[nr][nc] = 1
                cnt += 1
                r,c = nr, nc
                flag = 1
                break
    if flag == 0:
        if board[r-dir[d][0]][c-dir[d][1]] == 1:
            print(cnt)
            break
        else:
            r, c = r-dir[d][0], c-dir[d][1]


