t = int(input())

for _ in range(t):
    arr = list(map(int,input().split()))
    min_value = int(1e9)
    sum__ = 0
    for i in range(7):
        if arr[i]%2==0:
            sum__ += arr[i]
            min_value = min(min_value,arr[i])
    print(sum__, min_value)