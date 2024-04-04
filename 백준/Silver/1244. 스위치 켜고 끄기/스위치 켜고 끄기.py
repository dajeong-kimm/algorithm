n = int(input())
arr = list(map(int,input().split()))
t = int(input())

for _ in range(t):
    a,b = map(int,input().split())
    if a==1:
        for i in range(1,n+1):
            if i%b==0:
                if arr[i-1] == 0:
                    arr[i-1]=1
                else:
                    arr[i-1] = 0
    elif a==2:
        x = 1
        while b-1-x>=0 and b-1+x<n:
            if arr[b-1-x]==arr[b-1+x]:
                x += 1
            else:
                break
        x -= 1
        for i in range(b-1-x,b+x):
            if arr[i] == 0:
                arr[i] = 1
            else:
                arr[i] = 0

for i in range(n):
    print(arr[i],end=" ")
    if i%20 == 19 and i>0:
        print()
        

