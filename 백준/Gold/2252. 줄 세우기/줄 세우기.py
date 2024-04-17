from collections import deque
n,m = map(int,input().split())

graph = [[] for _ in range(n+1)]
inDegree = [0]*(n+1)
for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    inDegree[b] += 1

queue = deque()

for s in range(1,n+1):
    if inDegree[s] == 0:
        queue.append(s)

ans = []
while queue:
    s = queue.popleft()
    ans.append(s)

    for adj_s in graph[s]:
        inDegree[adj_s] -= 1
        if inDegree[adj_s] == 0:
            queue.append(adj_s)

print(*ans)


