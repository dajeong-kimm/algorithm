n,m = map(int,input().split())
arr = list(map(int,input().split()))

visited = [False]*n
temp = []

arr.sort()

def dfs():
    if len(temp) == m:
        print(*temp)
        return
    remember_me = 0
    for i in range(n):
        if not visited[i] and remember_me != arr[i]:
            visited[i] = True
            temp.append(arr[i])
            remember_me = arr[i]
            dfs()
            visited[i] = False
            temp.pop()

dfs()
