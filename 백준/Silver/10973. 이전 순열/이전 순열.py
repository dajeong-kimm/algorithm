n = int(input())
arr = list(map(int,input().split()))

answer = []

if arr==[i for i in range(1,n+1)]:
    print(-1)
    exit()
else:
    for i in range(n-1,-1,-1):
        if arr[i-1]>arr[i]:
            x,y = i-1,i
            for j in range(n-1,0,-1):
                if arr[j]<arr[x]:
                    arr[j],arr[x] = arr[x],arr[j]
                    arr = arr[:i] + sorted(arr[i:],reverse=True)
                    print(*arr)
                    exit()

