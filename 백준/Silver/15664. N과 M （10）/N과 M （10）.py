n,m = map(int,input().split())
arr = sorted(list(map(int,input().split())))

visited = [False]*n

tmp = []
def dfs(start):
    if len(tmp) == m:
        print(*tmp)
        return
    else:
        remember_me = 0
        for i in range(start,n):
            if arr[i] != remember_me and not visited[i]:
                tmp.append(arr[i])
                visited[i] = True
                remember_me = arr[i]
                dfs(i+1)
                visited[i] = False
                tmp.pop()

dfs(0)