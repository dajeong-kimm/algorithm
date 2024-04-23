n,m = map(int,input().split())
a = [0]+list(map(int,input().split()))
c = [0]+list(map(int,input().split()))

dp = [[0 for _ in range(sum(c)+1)] for _ in range(n+1)]
result = sum(c)

for i in range(1,n+1):
    for j in range(sum(c)+1):
        if j>=c[i]:
            dp[i][j] = max(dp[i-1][j],dp[i-1][j-c[i]]+a[i])
        else:
            dp[i][j] = dp[i-1][j]

for i, mem in enumerate(dp[n]):
    if mem>=m:
        print(i)
        break
