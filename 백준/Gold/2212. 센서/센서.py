from itertools import combinations
n = int(input())
k = int(input())
arr = list(map(int,input().split()))

arr.sort()

if k>=n:
    print(0)
    exit()

dist = []
for i in range(1,n):
    dist.append(arr[i]-arr[i-1])

dist.sort(reverse=True)
for _ in range(k-1):
    dist.pop(0)

print(sum(dist))
    