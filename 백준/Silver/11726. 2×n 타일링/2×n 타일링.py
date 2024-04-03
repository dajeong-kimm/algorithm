n = int(input())

dp = [i for i in range(n+1)]

if n==1 or n==2 or n==3:
    print(n)
else:
    for i in range(4,n+1):
        dp[i] = (dp[i-1]+dp[i-2])%10007
    
    print(dp[n])