n = int(input())
if n == 1:
    print("CY")
    exit()
dp = [0]*(n+1)
dp[1] = 1
dp[2] = 0
for i in range(3,n+1):
    if dp[i-3]+dp[i-1] == 0:
        dp[i] = 1

if dp[n] == 0:
    print("SK")
else:
    print("CY")

