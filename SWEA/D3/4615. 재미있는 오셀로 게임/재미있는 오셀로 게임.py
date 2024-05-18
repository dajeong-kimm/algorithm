def place(x,y,color):
    dx = [-1,-1,-1,0,1,1,1,0]
    dy = [-1,0,1,1,1,0,-1,-1]

    for i in range(8):
        d_x = dx[i]
        d_y = dy[i]
        nx,ny = x,y
        change = []
        while True:
            nx += d_x
            ny += d_y
            if not(0<=nx<n and 0<=ny<n):
                break
            else:
                if arr[nx][ny] == 0:
                    break
                elif arr[nx][ny] == color:
                    for c_x,c_y in change:
                        arr[c_x][c_y] = color
                    break
                elif arr[nx][ny] != color:
                    change.append([nx,ny])
    arr[x][y] = color


t = int(input())
for test_case in range(1,t+1):
    n,m = map(int,input().split())
    half = n//2
    arr = [[0 for _ in range(n)] for _ in range(n)]
    arr[half-1][half] = 1
    arr[half][half-1] = 1
    arr[half-1][half-1] = 2
    arr[half][half] = 2

    for _ in range(m):
        x,y,color = map(int,input().split())
        place(x-1,y-1,color)

    b_count,w_count = 0,0
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 1:
                b_count += 1
            elif arr[i][j] == 2:
                w_count += 1
    print(f"#{test_case} {b_count} {w_count}")
