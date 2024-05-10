from collections import defaultdict

n,k = map(int,input().split())
arr = list(map(int,input().split()))

answer = 0
start,end = 0,0

numberCount = defaultdict(int)
while end<n:
    if numberCount[arr[end]] >= k:
        numberCount[arr[start]] -= 1
        start += 1
    else:
        numberCount[arr[end]] += 1
        end += 1
        answer = max(answer,end-start)

print(answer)