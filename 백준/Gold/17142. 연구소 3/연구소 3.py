from collections import deque
import copy
INF = int(1e9)

n,m = map(int,input().split())
space = [list(map(int,input().split())) for _ in range(n)]
answer = INF

def init():
    virus = deque()
    for i in range(n):
        for j in range(n):
            if space[i][j] == 1:
                space[i][j] = "-"
            elif space[i][j] == 2:
                space[i][j] = "*"
                virus.append((i,j))
            else:
                space[i][j] = -1
    return virus

candidate = init()

def bfs(sol):
    dydx = [(0,1),(1,0),(-1,0),(0,-1)]
    visited = [[False]*n for _ in range(n)]
    tmp_space = copy.deepcopy(space)
    queue = copy.deepcopy(sol)
    time = 0

    for x,y in queue:
        visited[x][y] = True
        tmp_space[x][y] = 0
    
    while queue:
        x,y = queue.popleft()

        for dy,dx in dydx:
            nx,ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<n and not visited[nx][ny] and tmp_space[nx][ny] != "-":
                if tmp_space[nx][ny] == -1:
                    tmp_space[nx][ny] = tmp_space[x][y] + 1
                    time = max(time,tmp_space[nx][ny])
                elif tmp_space[nx][ny] == "*":
                    tmp_space[nx][ny] = tmp_space[x][y] + 1
                
                visited[nx][ny] = True
                queue.append((nx,ny))
    for i in range(n):
        for j in range(n):
            if tmp_space[i][j] == -1:
                time=int(1e9)
                return time
    return time

def select_virus(sol,level):
    global answer

    if len(sol) == m:
        answer = min(bfs(sol),answer)
        return
    
    for i in range(level,len(candidate)):
        sol.append(candidate[i])
        select_virus(sol,i+1)
        sol.pop()

select_virus(deque(),0)
if answer == int(1e9):
    print(-1)
else:
    print(answer)