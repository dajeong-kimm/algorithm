import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(input())
tree = [[] for _ in range(n+1)]

for _ in range(n-1):
    parent,child,weight = map(int,input().split())
    tree[parent].append((child,weight))
    tree[child].append((parent,weight))

def dfs(node,cost):
    for adj_node,adj_w in tree[node]:
        cal_w = cost+adj_w
        if visited[adj_node] == -1:
            visited[adj_node] = cal_w
            dfs(adj_node,cal_w)
    return

visited = [-1]*(n+1)
visited[1] = 0

dfs(1,0)
idx,tmp = 0,0
for i in range(1,len(visited)):
    if visited[i]>tmp:
        tmp = visited[i]
        idx = i

visited = [-1]*(n+1)
visited[idx] = 0
dfs(idx,0)

print(max(visited))