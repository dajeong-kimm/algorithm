num = list(map(int,input()))
l = len(num)
dp = [0 for _ in range(l+1)]

if num[0] == 0:
    print(0)
else:
    num = [0]+num
    dp[0] = dp[1] = 1
    for i in range(2,l+1):
        if num[i]>0:
            dp[i] += dp[i-1]
        temp = num[i-1]*10+num[i]
        if temp>=10 and temp<=26:
            dp[i] += dp[i-2]
    print(dp[l]%1000000)