from collections import deque
import copy

n,m = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(n)]

def count_cheese(arr):
    tmp = 0
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 1:
                tmp += 1
    return tmp

def bfs(i,j,arr):
    queue = deque()
    queue.append((i,j))
    visited[i][j] = 1
    count = 0
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<m and visited[nx][ny] == 0:
                if arr[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append((nx,ny))
                elif arr[nx][ny] == 1:
                    count += 1
                    visited[nx][ny] = 1
                    arr[nx][ny] = 0
    # 없어진 치즈 개수 리턴
    return count

# print(count_cheese(array))
# visited = [[0]*m for _ in range(n)]
# cnt = bfs(0,0,array)
# print(cnt)
# for i in array:
#     print(i)
# visited = [[0]*m for _ in range(n)]
# cnt= bfs(0,0,array)
# print(cnt)
# for i in array:
#     print(i)

time = 0
cur_cheese = count_cheese(array)
if cur_cheese == 0:
    print(0)
    print(0)
    exit()
while True:
    visited = [[0]*m for _ in range(n)]
    cnt = bfs(0,0,array)             
    time += 1
    cur_cheese -= cnt
    if cur_cheese < 1:
        break


print(time)
print(cur_cheese + cnt)



