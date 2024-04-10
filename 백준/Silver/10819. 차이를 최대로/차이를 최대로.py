from itertools import permutations

n = int(input())
arr = list(map(int,input().split()))
answer = []

for per in permutations(arr):
    tmp = []
    for i in range(n-1):
        tmp.append(abs(per[i]-per[i+1]))
    answer.append(sum(tmp))

print(max(answer))
