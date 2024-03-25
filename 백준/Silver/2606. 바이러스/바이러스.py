n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]
visit = [0 for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
    
def dfs(start):
    visit[start] = 1
    for v in graph[start]:
        if visit[v] == 0:
            dfs(v)
dfs(1)            
print(sum(visit)-1)
    