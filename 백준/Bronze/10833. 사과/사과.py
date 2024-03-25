n = int(input())

remain = 0

for _ in range(n):
    a, b = map(int,input().split())
    remain += b%a
print(remain)