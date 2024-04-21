from collections import deque
n = int(input())

arr = [list(map(int,input().split())) for _ in range(n)]

# 각각의 섬을 2,3,4,5 등으로 숫자를 나눠서 표현
def bfs(i,j,num):
    queue = deque()
    queue.append((i,j))
    arr[i][j] = num
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<n:
                if arr[nx][ny] == 1:
                    arr[nx][ny] = num
                    queue.append((nx,ny))

def bfs_bridge(i,j):
    num = arr[i][j]
    visited = [[0]*n for _ in range(n)]
    visited[i][j] = 1
    queue = deque()
    cnt = 0
    queue.append((i,j))
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<n and visited[nx][ny] == 0:
                if arr[nx][ny] == num:
                    visited[nx][ny] = 1
                    queue.append((nx,ny))
                elif arr[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx,ny))
                elif arr[nx][ny] != num:
                    return visited[x][y]-1
    return float("inf")
            

answer = float("inf")
num = 2
for i in range(n):
    for j in range(n):
        if arr[i][j] == 1:
            bfs(i,j,num)
            num += 1

for i in range(n):
    for j in range(n):
        if arr[i][j] != 0:
            tmp = bfs_bridge(i,j)
            answer = min(answer,tmp)

print(answer)