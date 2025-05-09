n = int(input())

him = [0] + list(map(int,input().split()))
happy = [0] + list(map(int,input().split()))

dp = [[0]*101 for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,101):
        if him[i]<=j:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-him[i]]+happy[i])
        else:
            dp[i][j] = dp[i-1][j]

print(dp[n][99])
