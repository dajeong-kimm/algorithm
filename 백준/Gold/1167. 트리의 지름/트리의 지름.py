# BFS
import sys
from collections import deque
input = sys.stdin.readline

v = int(input())
tree = [[] for _ in range(v+1)]

for _ in range(v):
    line = list(map(int,input().split()))
    cnt_node = line[0]
    idx = 1
    while line[idx] != -1:
        adj_node, adj_cost = line[idx],line[idx+1]
        tree[cnt_node].append((adj_node,adj_cost))
        idx += 2


def bfs(start):
    queue = deque()
    queue.append((start,0))
    visited = [-1]*(v+1)
    visited[start] = 0
    res = [0,0]
    while queue:
        cnt_node,cnt_dist = queue.popleft()

        for adj_node,adj_dist in tree[cnt_node]:
            if visited[adj_node]==-1:
                cal_dist = cnt_dist+adj_dist
                queue.append((adj_node,cal_dist))
                visited[adj_node] = cal_dist

                if res[1]<cal_dist:
                    res[0] = adj_node
                    res[1] = cal_dist
    return res

point, _ = bfs(1)
print(bfs(point)[1])