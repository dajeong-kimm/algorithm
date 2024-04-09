def dfs(start,visited):
    visited[start] = 1
    for g in graph[start]:
        if visited[g] == 0:
            dfs(g,visited)

n,m = map(int,input().split())
graph = [[0] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
answer = 0
for i in range(1,n+1):
    if visited[i] == 0:
        dfs(i,visited)
        answer += 1
print(answer)