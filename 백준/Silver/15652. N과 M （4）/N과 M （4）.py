from itertools import combinations_with_replacement
n,m = map(int,input().split())
num = [(i+1) for i in range(n)]

for per in combinations_with_replacement(num,m):
    for p in per:
        print(p,end=" ")
    print()

