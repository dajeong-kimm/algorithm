from collections import deque

n = int(input())
dist = [[-1]*(n+1) for _ in range(n+1)]
queue = deque()
queue.append((1,0)) # 이모티콘개수, 클립보드 이모티콘 개수
dist[1][0] = 0

while queue:
    s,c = queue.popleft()
    if dist[s][s] == -1:
        dist[s][s] = dist[s][c] + 1
        queue.append((s,s))
    if s+c<=n and dist[s+c][c] == -1:
        dist[s+c][c] = dist[s][c] + 1
        queue.append((s+c,c))
    if s-1>=0 and dist[s-1][c] == -1:
        dist[s-1][c] = dist[s][c] + 1
        queue.append((s-1,c))

answer = -1
for i in range(n+1):
    if dist[n][i] != -1:
        if answer == -1 or answer>dist[n][i]:
            answer = dist[n][i]
print(answer)