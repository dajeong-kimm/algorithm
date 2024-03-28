from itertools import combinations
n,m = map(int,input().split())
num = [(i+1) for i in range(n)]
for per in combinations(num,m):
    for p in per:
        print(p,end=" ")
    print()