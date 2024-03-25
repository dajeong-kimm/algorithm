n = int(input())
if n==1 or n==2:
    print(1)
    exit()
idx = 3
fibo = [1 for _ in range(n+1)]
fibo[0] = 0
while idx<=n:
    fibo[idx] = fibo[idx-1]+fibo[idx-2]
    idx += 1
print(fibo[n])