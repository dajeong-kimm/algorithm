n,m,k = map(int,input().split())

def search(n,m):
    dp = [[0]*(m+1) for _ in range(n+1)]

    for i in range(1,n+1):
        for j in range(1,m+1):
            if i==1 and j==1:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
    
    return dp[n][m]

if k:
    n1 = (k-1)//m + 1
    m1 = k - (n1-1)*m

    n2 = n - (n1-1)
    m2 = m - (m1-1)

    rst1 = search(n1,m1)
    rst2 = search(n2,m2)

    print(rst1*rst2)
else:
    print(search(n,m))