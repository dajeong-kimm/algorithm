n = int(input())
arr = list(map(int,input().split()))

dp = [1 for _ in range(n)]
answer = [[arr[i]] for i in range(n)]
for i in range(1,n):
    for j in range(i):
        if arr[i]>arr[j]:
            if dp[i]<dp[j]+1:
                dp[i] = dp[j]+1
                answer[i] = answer[j]+[arr[i]]

print(max(dp))
idx = dp.index(max(dp))
print(*(answer[idx]))