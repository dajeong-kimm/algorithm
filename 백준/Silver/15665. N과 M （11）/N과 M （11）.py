n,m = map(int,input().split())

arr = sorted(list(map(int,input().split())))

tmp = []
def dfs():
    if len(tmp) == m:
        print(*tmp)
    else:
        remember_me = 0
        for i in range(n):
            if arr[i] != remember_me:
                tmp.append(arr[i])
                remember_me = arr[i]
                dfs()
                tmp.pop()
dfs()