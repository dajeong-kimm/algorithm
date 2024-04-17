a,b = map(int,input().split())
n = a*b
arr = list(map(int,input().split()))

answer = []
for a in arr:
    answer.append(a-n)

print(*answer)