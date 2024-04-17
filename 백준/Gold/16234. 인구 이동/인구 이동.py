from collections import deque
import copy
n,l,r = map(int,input().split())

arr = [list(map(int,input().split())) for _ in range(n)]
visit_list = []
def bfs(i,j):
    global visit_list
    queue = deque()
    queue.append((i,j))
    visited[i][j] = 1
    visit_list.append((i,j))
    add_value = arr[i][j]
    cnt = 1
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx = x+dx
            ny = y+dy
            if 0<=nx<n and 0<=ny<n and visited[nx][ny] == 0:
                if l<=abs(arr[nx][ny]-arr[x][y])<=r:
                    visited[nx][ny] = 1
                    add_value += arr[nx][ny]
                    cnt += 1
                    queue.append((nx,ny))
                    visit_list.append((nx,ny))
    return add_value,cnt
# visited = [[0]*n for _ in range(n)]
# print(bfs(0,0))
# print(visit_list)

time = 0
while True:
    visited = [[0]*n for _ in range(n)]
    stored_arr = copy.deepcopy(arr)
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0:
                total_value,count = bfs(i,j)
                tmp = total_value//count
                for x,y in visit_list:
                    arr[x][y] = tmp
                visit_list = []
    if stored_arr == arr:
        break
    time += 1

print(time)