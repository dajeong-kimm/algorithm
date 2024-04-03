t = int(input())

for _ in range(t):
    n = int(input())
    a, b = 1, 0
    for i in range(n):
        a,b = b, a+b
    print(a,b)