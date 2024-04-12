import sys

input = sys.stdin.readline

n = int(input())
target = input().strip()

str_list = [input().strip() for _ in range(n-1)]
ans = 0

for alpha in str_list:
    if abs(len(alpha)-len(target)) >1 or len(set(target).difference(set(alpha)))>1:
        continue

    for t in target:
        if t in alpha:
            alpha = alpha.replace(t,"",1)
    if len(alpha)<=1:
        ans += 1
print(ans)