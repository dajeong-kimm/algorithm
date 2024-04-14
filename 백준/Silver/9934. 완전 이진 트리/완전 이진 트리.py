import sys
sys.setrecursionlimit(10**6)

n = int(input())
arr = list(map(int,input().split()))
l = len(arr)
answer = [[] for _ in range(n)]

def sol(start,end,n):
    if start == end:
        answer[n].append(arr[start])
        return
    center = (start+end)//2
    answer[n].append(arr[center])
    sol(start,center-1,n+1)
    sol(center+1,end,n+1)

sol(0, l-1, 0)
for a in answer:
    print(*a)
    