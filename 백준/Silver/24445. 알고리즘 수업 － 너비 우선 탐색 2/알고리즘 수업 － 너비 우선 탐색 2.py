from collections import deque
import sys

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

cnt = 1
def bfs(start):
    global cnt
    queue = deque()
    queue.append(start)
    visited[start] = 1

    while queue:
        x = queue.popleft()
        for g in graph[x]:
            if visited[g] == 0:
                cnt += 1
                visited[g] = cnt
                queue.append(g)

bfs(r)
for i in range(1,n+1):
    print(visited[i])
