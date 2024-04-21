dr = [-1,1,0,0]
dc = [0,0,-1,1]

n = int(input())
a = [list(map(int,input().split())) for _ in range(n)]
check = [[0]*n for _ in range(n)]

def dfs(r,c):
    if check[r][c]:
        return check[r][c]
    
    check[r][c] = 1
    for d in range(4):
        nr = r+dr[d]
        nc = c+dc[d]
        if not (0<=nr<n and 0<=nc<n):
            continue

        if a[r][c]<a[nr][nc]:
            check[r][c] = max(check[r][c],dfs(nr,nc)+1)
    return check[r][c]

for r in range(n):
    for c in range(n):
        if not check[r][c]:
            dfs(r,c)

max_value = 0
for i in range(n):
    max_value = max(max_value,max(check[i]))
print(max_value)