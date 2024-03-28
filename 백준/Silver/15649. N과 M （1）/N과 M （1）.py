from itertools import permutations
n,m = map(int,input().split())
num = [(i+1) for i in range(n)]
for per in permutations(num,m):
    for p in per:
        print(p,end=" ")
    print()