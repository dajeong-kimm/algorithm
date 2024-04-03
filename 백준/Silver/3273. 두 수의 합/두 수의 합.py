n = int(input())

arr = list(map(int,input().split()))
arr.sort()
x = int(input())

cnt = 0
start,end = 0,n-1
while start<end:
    if arr[start]+arr[end]==x:
        cnt += 1
        start += 1
        end -=1
    elif arr[start]+arr[end]>x:
        end -=1
    else:
        start += 1

print(cnt)