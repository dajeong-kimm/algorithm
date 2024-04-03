n,m = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
q = []

def dfs():
    if len(q)==m:
        print(*q)
        return
    for i in range(n):
        q.append(arr[i])
        dfs()
        q.pop()

dfs()