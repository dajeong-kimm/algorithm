from itertools import combinations
import sys

n = int(input())
arr = []
for i in range(1,n+1):
    for per in combinations([i for i in range(n)],i):
        arr.append(per)

# print(arr)

answer = sys.maxsize
f = []
for _ in range(n):
    s,b = map(int,input().split())
    f.append((s,b))

for i in range(len(arr)):
    ss = 1
    bb = 0
    for a in arr[i]:
        ss *= f[a][0]
        bb += f[a][1]
    answer = min(answer,abs(ss-bb))
    
print(answer)





