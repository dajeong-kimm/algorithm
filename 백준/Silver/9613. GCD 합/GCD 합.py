def gcd(a,b):
    if b>a:
        a,b = b,a
    while b>0:
        a,b = b,a%b
    return a

n = int(input())

for _ in range(n):
    answer = 0
    arr = list(map(int,input().split()))
    for i in range(1,len(arr)-1):
        for j in range(i+1,len(arr)):
            answer += gcd(arr[i],arr[j])

    print(answer)