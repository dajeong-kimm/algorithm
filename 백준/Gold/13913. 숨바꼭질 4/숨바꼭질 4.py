from collections import deque

n,k = map(int,input().split())
visited= [-1 for _ in range(100001)]
move = [0 for _ in range(100001)]

def path(x):
    arr = []
    temp = x
    for _ in range(visited[x]+1):
        arr.append(temp)
        temp = move[temp]
    print(' '.join(map(str, arr[::-1])))

def bfs():
    queue = deque()
    queue.append(n)
    visited[n] = 0
    while queue:
        x= queue.popleft()
        if x==k:
            print(visited[x])
            path(x)
            return x
        for dx in (x+1,x-1,x*2):
            if 0<=dx<=100000 and visited[dx] == -1:
                queue.append(dx)
                visited[dx] = visited[x] + 1
                move[dx] = x
    
    
bfs()