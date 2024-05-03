def fibo(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    fibo = [0 for _ in range(n+1)]
    fibo[1] = 1
    for i in range(2,n+1):
        fibo[i] = fibo[i-1]+fibo[i-2]
    return fibo[n]

n = int(input())
print(fibo(n))