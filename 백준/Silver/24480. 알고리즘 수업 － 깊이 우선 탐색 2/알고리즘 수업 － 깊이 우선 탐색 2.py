import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
n,m,r = map(int,input().split())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)
for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for g in graph:
    g.sort(reverse=True)

cnt = 0
def dfs(start):
    global cnt
    cnt += 1
    visited[start] = cnt
    for g in graph[start]:
        if visited[g]==0:
            dfs(g)
dfs(r)
for i in range(1,n+1):
    print(visited[i])
    

