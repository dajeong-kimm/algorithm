from collections import deque
f, s, g, u, d = map(int, input().split())

floor = [0 for _ in range(f+1)]

def bfs(start):
    queue = deque()
    queue.append(start)
    floor[start]=1
    while queue:
        v = queue.popleft()
        if v == g:
            return floor[v]-1
        for i in (v+u,v-d):
            if 0<i<=f and floor[i]==0:
                queue.append(i)
                floor[i] = floor[v]+1
    return "use the stairs"

print(bfs(s))
