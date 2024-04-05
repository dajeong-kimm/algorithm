n,k = map(int,input().split())

arr = list(map(int,input().split()))
arr.sort()

idx = 0
cnt = 0
while True:
    start = arr[idx]
    end = arr[idx]+(k-1)
    cnt += 1
    if end>=arr[-1]:
        break
    else:
        for i in range(idx+1,n):
            if arr[i]<=end:
                idx += 1
            else:
                break
    idx += 1

print(cnt)