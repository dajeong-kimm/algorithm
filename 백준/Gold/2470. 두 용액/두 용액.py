n = int(input())
arr= list(map(int,input().split()))

arr.sort()
answer = 1e11
start = 0
end = n-1
sol1, sol2 = 0, 0

while start<end:
    tmp = abs(0-(arr[start]+arr[end]))
    if tmp<answer:
        answer = tmp
        sol1 = arr[start]
        sol2 = arr[end]
    if arr[start]+arr[end]>0:
        end -=1
    elif arr[start]+arr[end]<0:
        start += 1
    else:
        break

print(sol1,sol2)
