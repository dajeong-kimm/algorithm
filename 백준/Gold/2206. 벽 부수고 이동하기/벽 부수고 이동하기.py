from collections import deque

n,m = map(int,input().split())
graph = []

visited = [[[0]*2 for _ in range(m)] for _ in range(n)]
visited[0][0][0] = 1

for i in range(n):
    graph.append(list(map(int,input())))

def bfs(x,y,z):
    queue = deque()
    queue.append((x,y,z))

    while queue:
        a,b,c = queue.popleft()
        if a==n-1 and b==m-1:
            return visited[a][b][c]
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = a+dx, b+dy
            if 0<=nx<n and 0<=ny<m:
                if graph[nx][ny] == 1 and c == 0:
                    visited[nx][ny][1] = visited[a][b][0] + 1
                    queue.append((nx,ny,1))
                elif graph[nx][ny] == 0 and visited[nx][ny][c] == 0:
                    visited[nx][ny][c] = visited[a][b][c] + 1
                    queue.append((nx,ny,c))
    return -1
    
print(bfs(0,0,0))