n,s = map(int,input().split())

arr = list(map(int,input().split()))

left,right = 0,0
sum_ = 0
min_length = 1e9

while True:
    if sum_>=s:
        min_length = min(min_length,right-left)
        sum_ -= arr[left]
        left += 1
    elif right == n:
        break
    else:
        sum_ += arr[right]
        right += 1
if min_length == 1e9:
    print(0)
else:
    print(min_length)



    