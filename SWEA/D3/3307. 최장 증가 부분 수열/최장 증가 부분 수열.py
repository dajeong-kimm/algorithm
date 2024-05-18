t = int(input())

for test_case in range(1,t+1):
    n = int(input())
    arr = list(map(int,input().split()))
    dp = [1 for _ in range(n)]
    for i in range(n):
        for j in range(i):
            if arr[j]<=arr[i]:
                dp[i] = max(dp[i],dp[j]+1)
    answer = max(dp)
    print(f"#{test_case} {answer}")