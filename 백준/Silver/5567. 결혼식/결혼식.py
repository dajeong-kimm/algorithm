import sys
input = sys.stdin.readline
from collections import deque
n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)

def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = 1
    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if visited[i] == 0:
                queue.append(i)
                visited[i] = visited[x] +1


for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

bfs(1)

result = 0

for i in range(2,n+1):
    if visited[i]<4 and visited[i] != 0:
        result += 1

print(result)