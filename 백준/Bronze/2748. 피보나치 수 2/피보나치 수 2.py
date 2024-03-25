n = int(input())
idx = 3
fibo = [0 for _ in range(n+3)]
fibo[1] = 1
fibo[2] = 1
while idx<=n:
    fibo[idx] = fibo[idx-2]+fibo[idx-1]
    idx += 1

print(fibo[n])

    