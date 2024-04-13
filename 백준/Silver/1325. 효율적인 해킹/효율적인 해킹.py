from collections import deque
n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().split())
    graph[b].append(a)

def bfs(start):
    visited = [0 for _ in range(n+1)]
    queue = deque()
    visited[start] = 1
    queue.append(start)
    cnt = 0
    while queue:
        x = queue.popleft()
        for g in graph[x]:
            if visited[g] == 0:
                visited[g] = 1
                queue.append(g)
                cnt += 1
    return cnt

answer = [0]
for i in range(1,n+1):
    tmp = bfs(i)
    answer.append(tmp)

max_value = max(answer)
ans_list = []
for i in range(1,n+1):
    if answer[i] == max_value:
        ans_list.append(i)

print(*ans_list)