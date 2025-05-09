n = int(input())

arr = []
for _ in range(n):
    arr.append(list(map(int,input().split())))

dp = [[0]*(n+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,i+1):
        dp[i][j] = arr[i-1][j-1] + max(dp[i-1][j],dp[i-1][j-1])

print(max(dp[n]))