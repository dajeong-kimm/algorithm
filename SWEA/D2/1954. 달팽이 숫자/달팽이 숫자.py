t = int(input())
for test_case in range(1,t+1):
    n = int(input())
    arr = [[0 for _ in range(n)] for _ in range(n)]
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]
    num = 1
    dir = 0
    x,y = 0,0
    arr[0][0] = num
    num += 1
    while num<=n*n:
        nx,ny = x+dx[dir], y+dy[dir]
        if not (0<=nx<n and 0<=ny<n) or arr[nx][ny] != 0:
            nx,ny = x-dx[dir],y-dy[dir]
            dir = (dir+1)%4
            nx,ny = x+dx[dir],y+dy[dir]
        arr[nx][ny] = num
        num += 1
        x,y = nx,ny
    print(f"#{test_case}")
    for a in arr:
        print(*a)
