t = int(input())

def dfs(x,cnt):
    global result
    visited[x] = 1
    for i in node[x]:
        if visited[i] == 0:
            visited[i] = 1
            dfs(i,cnt+1)
    visited[x] = 0
    result = max(result,cnt)

for test_case in range(1,t+1):
    n,m = map(int,input().split())
    node = [[] for _ in range(n+1)]
    result = 0
    for i in range(m):
        x,y = map(int,input().split())
        node[x].append(y)
        node[y].append(x)
    
    for i in range(1,n+1):
        visited = [0 for _ in range(n+1)]
        dfs(i,1)
    print(f"#{test_case} {result}")