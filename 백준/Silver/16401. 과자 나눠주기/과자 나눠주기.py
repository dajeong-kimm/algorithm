n,m = map(int,input().split())

arr = list(map(int,input().split()))

start = 1
end = max(arr)

while start<=end:
    mid = (start+end)//2
    count = 0
    for a in arr:
        if a>=mid:
            count += (a//mid)
    if count>=n:
        start = mid+1
    else:
        end = mid-1

print(end)