n = int(input())
cur = 1
for _ in range(n):
    a,b = map(int,input().split())
    if a==cur:
        cur = b
    elif b==cur:
        cur = a

print(cur)