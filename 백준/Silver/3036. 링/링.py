def gcd(a,b):
    if b>a:
        a,b = b,a
    while b>0:
        a,b = b,a%b
    return a

n = int(input())
arr = list(map(int,input().split()))
a = arr[0]
for i in range(1,n):
    gcd_ = gcd(a,arr[i])
    print(f"{a//gcd_}/{arr[i]//gcd_}")