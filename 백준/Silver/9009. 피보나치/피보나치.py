fibo = [0 for _ in range(100)]
fibo[1] = 1
for i in range(2,50):
    fibo[i] = fibo[i-1]+fibo[i-2]
# print(fibo[49])

t = int(input())
for _ in range(t):
    n = int(input())
    answer = []
    while True:
        for i in range(49,0,-1):
            if fibo[i]<=n:
                n -= fibo[i]
                answer.append(fibo[i])
        if n == 0:
            break
    answer.reverse()
    print(*answer)

