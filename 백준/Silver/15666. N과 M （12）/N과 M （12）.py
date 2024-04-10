n,m = map(int,input().split())

arr = list(map(int,input().split()))

arr.sort()
tmp = []
visited = [0]*(n)
def dfs(start):
    if len(tmp) == m:
        print(*tmp)
        return
    else:
        remember_me = 0
        for i in range(start,n):
            if remember_me != arr[i]:
                tmp.append(arr[i])
                remember_me = arr[i]
                dfs(i)
                tmp.pop()

dfs(0)