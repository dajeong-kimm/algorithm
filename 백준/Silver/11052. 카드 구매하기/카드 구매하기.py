n = int(input())
arr = list(map(int,input().split()))
arr.insert(0,0)
dp = [0]*(1001)

for i in range(1,n+1):
    for j in range(1,i+1):
        dp[i] = max(dp[i],arr[j]+dp[i-j])

print(dp[n])