import sys

n = int(input())
graph = []
for _ in range(n):
    graph.append(list(map(int,input().split())))

dp = [[0]*n for _ in range(n)]
dp[0][0] = 1

for x in range(n):
    for y in range(n):
        if x==y==n-1:
            print(dp[x][y])
            exit(0)
        dist = graph[x][y]
        if x+dist<n:
            dp[x+dist][y] += dp[x][y]
        if y+dist<n:
            dp[x][y+dist] += dp[x][y]
