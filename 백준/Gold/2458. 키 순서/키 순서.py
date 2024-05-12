n,m = map(int,input().split())
height = [[0 for _ in range(n+1)] for _ in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    height[a][b] = 1

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if height[i][j] == 1 or (height[i][k]==1 and height[k][j]==1):
                height[i][j] = 1

answer = 0
for i in range(1,n+1):
    known_height = 0
    for j in range(1,n+1):
        known_height += height[i][j]+height[j][i]
    if known_height == n-1:
        answer += 1
print(answer)