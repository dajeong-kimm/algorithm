from collections import deque
import sys

input = sys.stdin.readline

n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(graph,start):
    num = [0]*(n+1)
    visited = [start]
    queue = deque()
    queue.append(start)
    while queue:
        a = queue.popleft()
        for i in graph[a]:
            if i not in visited:
                num[i] = num[a] + 1
                visited.append(i)
                queue.append(i)
    return sum(num)

answer = []
for i in range(1,n+1):
    answer.append(bfs(graph,i))

print(answer.index(min(answer))+1)