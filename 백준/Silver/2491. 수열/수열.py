n = int(input())
arr = list(map(int,input().split()))
dp = [1 for _ in range(n)]
dp1 = [1 for _ in range(n)]

for i in range(1,n):
    if arr[i]>=arr[i-1]:
        dp[i] = max(dp[i],dp[i-1]+1)

for i in range(1,n):
    if arr[i]<=arr[i-1]:
        dp1[i] = max(dp1[i],dp1[i-1]+1)

print(max(max(dp),max(dp1)))