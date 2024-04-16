n,m = map(int,input().split())
# print(ord('A')) 65
# print(ord('Z')) 90
alpha = set()

arr = [list(input()) for _ in range(n)]
ans = 0
def dfs(i,j,cnt):
    global ans
    ans = max(ans,cnt)
    for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
        nx,ny = i+dx,j+dy
        if 0<=nx<n and 0<=ny<m:
            if arr[nx][ny] not in alpha:
                alpha.add(arr[nx][ny])
                dfs(nx,ny,cnt+1)
                alpha.remove(arr[nx][ny])
alpha.add(arr[0][0])              
dfs(0,0,1)
print(ans)
