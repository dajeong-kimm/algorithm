n = int(input())
graph = [[] for _ in range(n+1)]
visit = [0 for _ in range(n+1)]
a,b = map(int,input().split())
m = int(input())
result = []
for _ in range(m):
    x,y = map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)
def dfs(a,b,cnt):
    cnt += 1
    if a==b:
        result.append(cnt)
    visit[a] = 1
    for v in graph[a]:
        if visit[v]==0:
            visit[v] = 1
            dfs(v,b,cnt)
dfs(a,b,0)
if not result:
    print(-1)
else:
    print(result[0]-1)