h,w = map(int,input().split())
arr = list(map(int,input().split()))

left_max = arr[0]
answer = 0
for i in range(1,len(arr)-1):
    left_max = max(arr[:i])
    right_max = max(arr[i+1:])
    tmp = min(left_max,right_max)
    if arr[i]<tmp:
        answer += tmp-arr[i]

print(answer)

