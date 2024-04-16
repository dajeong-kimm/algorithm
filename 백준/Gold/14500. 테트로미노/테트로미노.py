n,m = map(int,input().split())

arr = [list(map(int,input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

ans = 0
max_val = max(map(max,arr))

def dfs(r,c,idx,total):
    global ans
    if ans>=total+max_val*(3-idx):
        return
    if idx == 3:
        ans = max(ans,total)
        return
    else:
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = r+dx, c+dy
            if 0<=nx<n and 0<=ny<m:
                if visited[nx][ny] == 0:
                    if idx==1:
                        visited[nx][ny] = 1
                        dfs(r,c,idx+1,total+arr[nx][ny])
                        visited[nx][ny] = 0
                    visited[nx][ny] = 1
                    dfs(nx,ny,idx+1,total+arr[nx][ny])
                    visited[nx][ny] = 0

for r in range(n):
    for c in range(m):
        visited[r][c] = 1
        dfs(r,c,0,arr[r][c])
        visited[r][c] = 0
    
print(ans)