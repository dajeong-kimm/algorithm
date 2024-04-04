n,k = map(int,input().split())

arr = [i for i in range(2,n+1)]
count = 0
num = 0
while arr:
    tmp = arr[0]
    arr.remove(tmp)
    count += 1
    if count==k:
        print(tmp)
        break
    for i in range(2,n//tmp+1):
        if tmp*i in arr:
            arr.remove(tmp*i)
            count += 1
            if count==k:
                print(tmp*i)
                break
