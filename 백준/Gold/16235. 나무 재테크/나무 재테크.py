from collections import deque
n,m,k = map(int,input().split())

a = [list(map(int,input().split())) for _ in range(n)]

graph = [[5]*n for _ in range(n)]
trees = [[deque() for _ in range(n)] for _ in range(n)]
dead_trees = [[list() for _ in range(n)] for _ in range(n)]

for _ in range(m):
    x,y,z = map(int,input().split())
    trees[x-1][y-1].append(z)

dx = [-1,-1,0,1,1,1,0,-1]
dy = [0,1,1,1,0,-1,-1,-1]

def spring_summer():
    for i in range(n):
        for j in range(n):
            len_ = len(trees[i][j])
            for k in range(len_):
                if graph[i][j]<trees[i][j][k]:
                    for _ in range(k,len_):
                        dead_trees[i][j].append(trees[i][j].pop())
                    break
                else:
                    graph[i][j] -= trees[i][j][k]
                    trees[i][j][k] += 1
    
    for i in range(n):
        for j in range(n):
            while dead_trees[i][j]:
                graph[i][j] += dead_trees[i][j].pop()//2


def fall_winter():
    for i in range(n):
        for j in range(n):
            for k in range(len(trees[i][j])):
                if trees[i][j][k] %5 == 0:
                    for t in range(8):
                        nx = i+dx[t]
                        ny = j+dy[t]
                        if 0<=nx<n and 0<=ny<n:
                            trees[nx][ny].appendleft(1)
            graph[i][j] += a[i][j]


for _ in range(k):
    spring_summer()
    fall_winter()

answer = 0
for i in range(n):
    for j in range(n):
        answer += len(trees[i][j])
print(answer)