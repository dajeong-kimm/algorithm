from collections import deque

MAX = 10**5
n,k = map(int,input().split())
dist = [0]*(MAX+1)

def bfs():
    queue = deque()
    queue.append((n,0))
    dist[n] = 1
    while queue:
        x,time = queue.popleft()
        if x==k:
            return time
        for nx in (x+1,x-1,x*2):
            if 0<=nx<=MAX and not dist[nx]:
                queue.append((nx,time+1))
                dist[nx] = 1

print(bfs())