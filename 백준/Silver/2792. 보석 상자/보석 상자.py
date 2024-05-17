import math
n,m = map(int,input().split())
arr = [int(input()) for _ in range(m)]
if n == m:
    print(max(arr))
    exit()
start,end = 1, max(arr)
answer = int(1e9)
while start<=end:
    mid = (start+end)//2
    tmp = 0
    for a in arr:
        tmp += math.ceil(a/mid)
    if tmp>n:
        start = mid+1

    else:
        end = mid-1
        answer = min(answer, mid)

print(answer)