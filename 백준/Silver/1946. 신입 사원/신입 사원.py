import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    arr = []
    n = int(input())
    for _ in range(n):
        a,b = map(int,input().split())
        arr.append((a,b))
    rank_asc = sorted(arr)
    top = 0
    result = 1

    for i in range(1,len(rank_asc)):
        if rank_asc[i][1]<rank_asc[top][1]:
            top = i
            result += 1
    print(result)