from collections import deque
import copy 

n,m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]

def make_wall(count):
    if count == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 0:
                arr[i][j] = 1
                make_wall(count+1)
                arr[i][j] = 0

result = 0
def bfs():
    queue = deque()
    test_map = copy.deepcopy(arr)
    for i in range(n):
        for j in range(m):
            if test_map[i][j] == 2:
                queue.append((i,j))
    while queue:
        x,y = queue.popleft()
        for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
            nx,ny = x+dx,y+dy
            if 0<=nx<n and 0<=ny<m and test_map[nx][ny] == 0:
                test_map[nx][ny] = 2
                queue.append((nx,ny))
    
    global result
    count = 0
    for i in range(n):
        for j in range(m):
            if test_map[i][j] == 0:
                count += 1
    result = max(result,count)


make_wall(0)
print(result)