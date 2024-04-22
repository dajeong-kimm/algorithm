import sys
input = sys.stdin.readline
from itertools import combinations
from collections import deque
import copy

dx = [0,-1,0]
dy = [-1,0,1]

# 맨해튼거리 계산
def cal_distance(x1,x2,y1,y2):
    return abs(x1-x2)+abs(y1-y2)

# d거리 안에 있는 가장 가까운 적 찾기
def find_enemy(col):
    queue = deque()
    queue.append((n-1,col))
    while queue:
        x,y = queue.popleft()
        if cal_distance(n,x,col,y)>d:
            return False
        if board[x][y] == 1:
            return (x,y)
        for i in range(3):
            ax = x + dx[i]
            ay = y + dy[i]
            if 0<=ax<n and 0<=ay<m:
                queue.append((ax,ay))

def move_enemy():
    for j in range(m):
        for i in range(n-2,-1,-1):
            board[i+1][j] = board[i][j]
    for i in range(m):
        board[0][i] = 0

def del_enemy():
    cnt = 0
    for i in range(m):
        if board[n-1][i] == 1:
            cnt += 1
    return cnt


n,m,d = map(int,input().split())
maps = [list(map(int,input().split())) for _ in range(n)]
cnt_enemy = 0
answer = 0
for i in range(n):
    for j in range(m):
        if maps[i][j] == 1:
            cnt_enemy += 1

for comb in combinations(list(range(m)),3):
    del_cnt = 0
    curr_enemy = cnt_enemy
    board = copy.deepcopy(maps)
    while curr_enemy>0:
        tmp = set()
        for i in comb:
            enemy_pos = find_enemy(i)
            if enemy_pos:
                tmp.add(enemy_pos)
        
        for x,y in tmp:
            board[x][y] = 0
        
        del_cnt += len(tmp)
        curr_enemy -= len(tmp)
        curr_enemy -= del_enemy()
        move_enemy()
    answer = max(answer,del_cnt)
print(answer)