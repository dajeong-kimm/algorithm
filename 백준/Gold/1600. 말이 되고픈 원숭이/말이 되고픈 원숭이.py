from collections import deque
monkey_dir = [(-1,-2),(-2,-1),(-2,1),(-1,2),(1,-2),(2,-1),(2,1),(1,2)]
directions = [(1,0),(-1,0),(0,1),(0,-1)]
def bfs():
    queue = deque()
    visited = [[[-1]*(k+1) for _ in range(m)] for _ in range(n)]
    visited[0][0][0] = 0
    queue.append((0,0,0))
    while queue:
        x,y,monkey = queue.popleft()
        if x == n-1 and y == m-1:
            return visited[x][y][monkey]
        for dx,dy in directions:
            nx,ny = x+dx,y+dy
            if 0<=nx<n and 0<=ny<m and visited[nx][ny][monkey] == -1 and arr[nx][ny] == 0:
                visited[nx][ny][monkey] = visited[x][y][monkey] + 1
                queue.append((nx,ny,monkey))
        if monkey<k:
            for dx,dy in monkey_dir:
                nx,ny = x+dx, y+dy
                if 0<=nx<n and 0<=ny<m and visited[nx][ny][monkey+1] == -1 and arr[nx][ny] == 0:
                    visited[nx][ny][monkey+1] = visited[x][y][monkey] + 1
                    queue.appendleft((nx,ny,monkey+1))
        
    return -1
k = int(input())
m,n = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]

print(bfs())



