from itertools import permutations
import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(str,input().split()))
num = [i for i in range(10)]
answer = []

for per in permutations(num,n+1):
    is_True = True
    for i in range(n):
        if arr[i]=="<":
            if per[i]>per[i+1]:
                is_True = False
                break
        elif arr[i] == ">":
            if per[i]<per[i+1]:
                is_True = False
                break
    if is_True:
        tmp = ''.join(str(p) for p in per)

        answer.append(tmp)

print(max(answer))
print(min(answer))
    