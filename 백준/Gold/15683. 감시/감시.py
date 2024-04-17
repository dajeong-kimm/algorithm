from collections import deque
import sys
import copy
input = sys.stdin.readline

n,m = map(int,input().split())
space = [list(map(int,input().split())) for _ in range(n)]

dy = [1,0,-1,0]
dx = [0,1,0,-1]

direction = {
    1:[[0],[1],[2],[3]],
    2:[[0,2],[1,3]],
    3:[[0,1],[1,2],[2,3],[3,0]],
    4:[[0,1,2],[1,2,3],[2,3,0],[3,0,1]],
    5:[[0,1,2,3]]
}

def check(row,col):
    return row<0 or row>=n or col<0 or col>=m

def init():
    obj = deque()
    answer = 0
    for i in range(n):
        for j in range(m):
            if space[i][j] != 6 and space[i][j] !=0:
                obj.append((space[i][j],i,j))
            if space[i][j] == 0:
                answer += 1
    return obj,answer

cctv,answer = init()

def move(y,x,direc,space_copy):
    for d in direc:
        ny,nx = y,x

        while True:
            nx += dx[d]
            ny += dy[d]

            if check(ny,nx) or space_copy[ny][nx] ==6:
                break
            if space_copy[ny][nx] !=0:
                continue
            space_copy[ny][nx] = "#"

def zero_cnt(space_copy):
    global answer
    cnt = 0
    for i in space_copy:
        cnt += i.count(0)
    answer = min(answer,cnt)

def dfs(level,space):
    space_copy = copy.deepcopy(space)

    if level == len(cctv):
        zero_cnt(space_copy)
        return
    
    number,y,x = cctv[level]

    for d in direction[number]:
        move(y,x,d,space_copy)
        dfs(level+1,space_copy)
        space_copy = copy.deepcopy(space)

dfs(0,space)
print(answer)