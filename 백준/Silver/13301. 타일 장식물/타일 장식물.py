def fibo(n):
    if n == 1:
        return 1
    elif n == 2:
        return 1
    fibo = [1 for _ in range(n+1)]
    for i in range(3,n+1):
        fibo[i] = fibo[i-1]+fibo[i-2]
    return fibo[n]

n = int(input())
answer = (fibo(n+1)+fibo(n))*2
print(answer)