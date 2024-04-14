n = int(input())
card = list(map(int,input().split()))

dp = [0]*(n+1)

dp[1] = card[0]

for i in range(2,n+1):
    dp[i] = card[i-1]
    for j in range(1,i):
        dp[i] = min(dp[i],dp[i-j]+card[j-1])
print(dp[n])