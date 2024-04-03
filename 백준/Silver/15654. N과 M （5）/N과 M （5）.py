from itertools import permutations
n,m = map(int,input().split())
arr = list(map(int,input().split()))

answer = []
for p in permutations(arr,m):
    answer.append(p)

answer.sort()

for ans in answer:
    for a in ans:
        print(a,end=" ")
    print()
