def factorial(n):
    f = [1 for _ in range(n+1)]
    f[1] = 1
    for i in range(2,n+1):
        f[i] = i*f[i-1]
    return f[n]

n,m = map(int,input().split())

answer = 1
for i in range(m):
    answer *= (n-i)

answer //= factorial(m)
print(answer)