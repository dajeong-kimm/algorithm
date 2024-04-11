from collections import deque
import sys

input = sys.stdin.readline

n,m,r = map(int,input().split())

graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)

for _ in range(m):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

for g in graph:
    g.sort()

def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = 1
    count = 2
    while queue:
        x = queue.popleft()
        for g in graph[x]:
            if visited[g] == 0:
                visited[g] = count
                count += 1
                queue.append(g)

bfs(r)
for i in range(1,n+1):
    print(visited[i])






