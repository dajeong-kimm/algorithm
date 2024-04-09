n,x = map(int,input().split())
arr = list(map(int,input().split()))
sum_ = 0
new_arr = [0]
for a in arr:
    sum_ += a
    new_arr.append(sum_)
if max(arr) == 0:
    print("SAD")
else:
    answer = []
    for i in range(n-x+1):
        tmp = new_arr[i+x] - new_arr[i]
        answer.append(tmp)
    print(max(answer))
    print(answer.count(max(answer)))



