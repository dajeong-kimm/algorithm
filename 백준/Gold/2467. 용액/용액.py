# 투포인터 사용

n = int(input())
arr = list(map(int,input().split()))

left = 0
right = n-1

ans = abs(arr[left]+arr[right])
ans_left = left
ans_right = right

while left<right:
    tmp = arr[left]+arr[right]

    if abs(tmp)<ans:
        ans_left = left
        ans_right = right
        ans = abs(tmp)

        if ans == 0:
            break
    
    if tmp<0:
        left += 1

    else:
        right -= 1

print(arr[ans_left],arr[ans_right])