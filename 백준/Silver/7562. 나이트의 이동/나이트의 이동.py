from collections import deque

def bfs():
    dx = [-1, 1, 2, 2, 1, -1, -2, -2]
    dy = [2, 2, 1, -1, -2, -2, -1, 1]
    queue=deque()
    queue.append((start_x, start_y))
    visit[start_x][start_y] = 1

    while queue:
        x,y = queue.popleft()
        if x==end_x and y==end_y:
            return visit[x][y]-1
        for i in range(8):
            nx,ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<n and visit[nx][ny] == 0:
                queue.append((nx,ny))
                visit[nx][ny] = visit[x][y]+1


t = int(input())
for _ in range(t):
    n = int(input())
    start_x, start_y = map(int,input().split())
    end_x, end_y = map(int,input().split())
    visit = [[0]*n for _ in range(n)]
    print(bfs())

