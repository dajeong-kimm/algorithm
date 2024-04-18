n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]

dp = [[0]*n for _ in range(n)]

for term in range(1,n):
    for start in range(n):
        if start + term == n:
            break

        dp[start][start+term] = int(1e9)

        for t in range(start,start+term):
            dp[start][start+term] = min(dp[start][start+term],dp[start][t]+dp[t+1][start+term]+arr[start][0]*arr[t][1]*arr[start+term][1])

        
print(dp[0][n-1])