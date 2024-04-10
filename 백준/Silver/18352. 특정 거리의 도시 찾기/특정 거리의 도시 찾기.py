from collections import deque
n, m , k, x = map(int,input().split())

arr = [[]*(n+1) for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().split())
    arr[a].append(b)

visited = [-1]*(n+1)

def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = 0

    while queue:
        x = queue.popleft()
        for new in arr[x]:
            if visited[new] == -1:
                visited[new] = visited[x]+1
                queue.append(new)

bfs(x)

if visited.count(k) == 0 :
    print(-1)
else:
    for i in range(1,n+1):
        if visited[i] == k:
            print(i)
    
    