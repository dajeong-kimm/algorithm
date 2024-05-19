t = int(input())

for test_case in range(1,t+1):
    n,k = map(int,input().split())
    bag = [list(map(int,input().split())) for _ in range(n)]
    answer = 0
    dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
    for i in range(1,n+1):
        for j in range(1,k+1):
            weight = bag[i-1][0]
            value = bag[i-1][1]

            if j<weight:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight]+value)
    answer = dp[n][k]
    print(f"#{test_case} {answer}")