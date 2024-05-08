s = list(input())
t = list(input())

dp = [[0 for _ in range(len(t))] for _ in range(len(s))]
answer = 0
for i in range(len(s)):
    for j in range(len(t)):
        if s[i]==t[j]:
            if i==0 or j==0:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i-1][j-1]+1
        answer = max(answer,dp[i][j])

print(answer)