n = int(input())
arr = list(map(int,input().split()))
arr_sum = []
sum_ = 0
for a in arr:
    sum_ += a
    arr_sum.append(sum_)
    
m = int(input())
for _ in  range(m):
    i,j = map(int,input().split())
    if i==1:
        print(arr_sum[j-1])
    else:
        print(arr_sum[j-1]-arr_sum[i-2])
        