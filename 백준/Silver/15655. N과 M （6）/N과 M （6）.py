q = []
n,m = map(int,input().split())
arr = sorted(list(map(int,input().split())))
def dfs(start):
    if len(q)==m:
        print(*q)
        return
    for i in range(start,len(arr)):
        if not arr[i] in q:
            q.append(arr[i])
            dfs(i+1)
            q.pop()

dfs(0)
