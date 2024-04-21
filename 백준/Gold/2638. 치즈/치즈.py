from collections import deque
import copy
n,m = map(int,input().split())

arr = []
for _ in range(n):
    tmp = list(map(int,input().split()))
    arr.append(tmp)

def bfs(i,j):
    new_arr = copy.deepcopy(arr)
    queue = deque()
    queue.append((i,j))
    visited[i][j] = 1
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<m:
                if arr[nx][ny] == 0 and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append((nx,ny))
                elif arr[nx][ny] == 1:
                    if visited[nx][ny] == 0:
                        visited[nx][ny] += 1
                    elif visited[nx][ny] > 0:
                        new_arr[nx][ny] = 0
    return new_arr

time = 0
while True:
    tmp = 0
    for a in arr:
        tmp += sum(a)
    if tmp == 0:
        break
    visited = [[0]*m for _ in range(n)]
    tmp_arr = bfs(0,0)
    arr = copy.deepcopy(tmp_arr)
    # for i in range(n):
    #     for j in range(m):
    #         if arr[i][j] == 0 and visited[i][j] == 0:
    #             tmp_arr = bfs(i,j)
    time += 1
    # print(f"time: {time}")
    # for a in arr:
    #     print(a)

print(time)