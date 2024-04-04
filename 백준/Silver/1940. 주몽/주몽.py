n = int(input())
m = int(input())
arr = list(map(int,input().split()))

arr.sort()
start = 0
end = n-1
count = 0

while start<end:
    if arr[start]+arr[end] == m:
        start += 1
        end -= 1
        count += 1
    elif arr[start]+arr[end]>m:
        end -=1
    else:
        start += 1

print(count)