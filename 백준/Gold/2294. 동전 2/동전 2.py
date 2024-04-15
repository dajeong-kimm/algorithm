n,k = map(int,input().split())

li = [int(input()) for _ in range(n)]

dp = [10001]*(k+1)
dp[0] = 0

for num in li:
    for i in range(num,k+1):
        dp[i] = min(dp[i],dp[i-num]+1)

if dp[k] == 10001:
    print(-1)
else:
    print(dp[k])