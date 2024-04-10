import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline
n,m,r = map(int,input().split())

visited = [0]*(n+1)
graph = [[] for _ in range(n+1)]
cnt = 1
def dfs(start):
    global cnt
    visited[start] = cnt
    graph[start].sort()
    for g in graph[start]:
        if visited[g] == 0:
            cnt += 1
            dfs(g)

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(r)

for i in range(1,n+1):
    print(visited[i])

