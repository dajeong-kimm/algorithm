n = int(input())

arr = list(map(int,input().split()))
m = int(input())

start = 0
end = max(arr)

while start<=end:
    mid = (start+end)//2

    tmp = 0
    for a in arr:
        if mid>=a:
            tmp += a
        else:
            tmp += mid
    
    if tmp>m:
        end = mid -1
    else:
        start = mid+1

print(end)