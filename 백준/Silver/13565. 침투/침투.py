import sys
sys.setrecursionlimit(10**6)

n,m = map(int,input().split())

arr = [list(input()) for _ in range(n)]
def dfs(start_x, start_y):
    dx = [0,0,1,-1]
    dy = [-1,1,0,0]
    arr[start_x][start_y] = "y"
    for i in range(4):
        nx,ny = start_x+dx[i], start_y+dy[i]
        if 0<=nx<n and 0<=ny<m:
            if arr[nx][ny] == "0":
                dfs(nx,ny)

for i in range(m):
    if arr[0][i] == "0":
        dfs(0,i)


if "y" in arr[-1]:
    print("YES")
else:
    print("NO")
