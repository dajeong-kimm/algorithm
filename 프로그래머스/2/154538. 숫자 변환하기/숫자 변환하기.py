def solution(x, y, n):
    dp = [10**6]*(y+1)
    dp[x] = 0
    for i in range(x+1,y+1):
        dp[i] = min(dp[i],dp[i-n]+1)
        if i%3 == 0:
            dp[i] = min(dp[i//3]+1,dp[i])
        if i%2==0:
            dp[i] = min(dp[i//2]+1,dp[i])
    if dp[y] == 10**6:
        return -1
    return dp[y]