import sys

sys.setrecursionlimit(10**6)

n,m = map(int,input().split())
arr = []
visited = [[0]*m for _ in range(n)]
for i in range(n):
    tmp = list(input())
    for j in range(m):
        if tmp[j] == "I":
            start_x, start_y = i,j
    arr.append(tmp)
cnt = 0
def dfs(start_x, start_y):
    global cnt
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    visited[start_x][start_y] = 1
    if arr[start_x][start_y] == "P":
        cnt += 1
    for i in range(4):
        nx,ny = start_x+dx[i], start_y+dy[i]
        if 0<=nx<n and 0<=ny<m and visited[nx][ny] == 0:
            if arr[nx][ny] != "X":
                dfs(nx,ny)

dfs(start_x, start_y)
if cnt:
    print(cnt)
else:
    print("TT")