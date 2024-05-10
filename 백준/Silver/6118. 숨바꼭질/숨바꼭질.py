from collections import deque
n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs():
    queue = deque()
    queue.append(1)
    visited = [-1 for _ in range(n+1)]
    visited[1] = 0
    while queue:
        x = queue.popleft()
        for now in graph[x]:
            if visited[now] == -1:
                visited[now] = visited[x]+1
                queue.append(now)
    return visited

answer = bfs()
max_value = max(answer)
print(answer.index(max_value),max_value,answer.count(max_value))