q = []
n,m = map(int,input().split())
a = list(map(int,input().split()))
a.sort()

def dfs(l):
    if len(q)==m:
        print(' '.join(map(str,q)))
        return
    
    for i in range(l,n):
        q.append(a[i])
        dfs(i)
        q.pop()

dfs(0)