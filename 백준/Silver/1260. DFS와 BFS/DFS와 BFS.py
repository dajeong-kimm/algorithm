from collections import deque

n, m, start = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in graph:
    i.sort()

def dfs(start):
    visited[start] = True
    print(start,end=" ")
    for i in graph[start]:
        if not visited[i]:
            dfs(i)
            
def bfs(start):
    q = deque([start])
    visited[start] = True
    while q:
        v = q.popleft()
        print(v,end=" ")
        for i in graph[v]:
            if not visited[i]:
                q.append(i)
                visited[i] = True
visited = [False]*(n+1)
dfs(start)
print()

visited=[False]*(n+1)
bfs(start)