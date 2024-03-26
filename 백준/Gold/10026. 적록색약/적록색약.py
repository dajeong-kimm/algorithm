from collections import deque

n = int(input())
rgb = [[0]*n for _ in range(n)]
rb = [[0]*n for _ in range(n)]


for i in range(n):
    tmp = list(input())
    for j in range(n):
        if tmp[j] == "R":
            rgb[i][j] = 1
            rb[i][j] = 1
        elif tmp[j] == "G":
            rgb[i][j] = 2
            rb[i][j] = 1
        else:
            rgb[i][j] = 3
            rb[i][j] = 2

dx, dy = [0,0,1,-1], [1,-1,0,0]

def rgb_bfs(i,j,value):
    queue = deque()
    queue.append((i,j))
    rgb[i][j] = 0

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx,ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<n and rgb[nx][ny]==value:
                queue.append((nx,ny))
                rgb[nx][ny] = 0

def rb_bfs(i,j,value):
    queue = deque()
    queue.append((i,j))
    rb[i][j] = 0

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx,ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<n and rb[nx][ny]==value:
                queue.append((nx,ny))
                rb[nx][ny] = 0
rgb_cnt = 0 
rb_cnt = 0
for i in range(n):
    for j in range(n):
        if rgb[i][j] != 0:
            value = rgb[i][j]
            rgb_bfs(i,j,value)
            rgb_cnt += 1
        if rb[i][j] != 0:
            value = rb[i][j]
            rb_bfs(i,j,value)
            rb_cnt += 1
print(rgb_cnt,rb_cnt)