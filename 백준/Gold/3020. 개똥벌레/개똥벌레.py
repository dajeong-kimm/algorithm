n,h = map(int,input().split())

lines = [0]*h

for i in range(n):
    size = int(input())

    if i%2==1: # 종유석
        lines[h-size] += 1
    else: # 석순
        lines[0] += 1
        lines[size] -= 1

for i in range(1,h):
    lines[i] += lines[i-1]

result = 0
low = min(lines)
for l in lines:
    if l == low:
        result += 1
print(low,result)