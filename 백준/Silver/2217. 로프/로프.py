n = int(input())
num = []
for _ in range(n):
    num.append(int(input()))

num.sort()
total = []

for i in range(n):
    total.append(num[i]*(n-i))

print(max(total))    