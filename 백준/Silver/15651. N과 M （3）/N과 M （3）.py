from itertools import product
n,m = map(int,input().split())
num = [(i+1) for i in range(n)]
for per in product(num,repeat=m):
    for p in per:
        print(p,end=" ")
    print()