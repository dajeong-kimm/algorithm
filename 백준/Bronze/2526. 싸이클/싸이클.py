n, p = map(int,input().split())
arr = []
arr.append(n)
idx = 0
while True:
    tmp = (arr[idx]*n)%p
    if tmp in arr:
        answer = idx-arr.index(tmp)+1
        break
    else:
        idx += 1
        arr.append(tmp)

print(answer)