# from collections import deque
# import sys
# sys.setrecursionlimit(10**6)
# input = sys.stdin.readline

# def get_parent(x):
#     if parent[x] == x:
#         return x
#     parent[x] = get_parent(parent[x])
#     return parent[x]

# def union(a,b):
#     a = get_parent(a)
#     b = get_parent(b)

#     if a<b:
#         parent[b] = a
#     else:
#         parent[a] = b



# def dfs(start,goal,time):
#     global answer

#     # visited를 쓰면 방문하지 않은 곳만 방문하려 하기 때문에
#     # 이 문제와 같이 모든 경로를 끝까지 방문하고
#     # 탐색해야 하는 경우 VISITED를 쓰면 안된다.
#     # visited[start] = 1
#     if start == goal:
#         # print(f"time: {time}")
#         answer = max(answer,time)
#     for g in graph[start]:
#         # if visited[g] == 0:
#         tmp = time + seconds[g]
#         dfs(g,goal,tmp)



# t = int(input())
# for _ in range(t):
#     n,k = map(int,input().split())
#     seconds = [0] + list(map(int,input().split()))
#     parent = [i for i in range(n+1)]
#     graph = [[] for _ in range(n+1)]
#     for _ in range(k):
#         a,b = map(int,input().split())
#         union(a,b)
#         graph[a].append(b)
    
#     goal = int(input())
#     start = get_parent(goal)
#     visited = [0]*(n+1)
#     answer = 0
#     # print(f"start:{start}")
#     dfs(start,goal,seconds[start])
#     # print(f"answer {t}: {answer}")
#     print(answer)
    
from collections import deque

t = int(input())
for _ in range(t):
    n,k = map(int,input().split())
    time = [0]+list(map(int,input().split()))
    seq = [[] for _ in range(n+1)]
    inDegree = [0 for _ in range(n+1)]
    DP = [0 for _ in range(n+1)]

    for _ in range(k):
        a,b = map(int,input().split())
        seq[a].append(b)
        inDegree[b] += 1
    
    queue = deque()
    for i in range(1,n+1):
        if inDegree[i] == 0:
            queue.append(i)
        DP[i] = time[i]
    
    while queue:
        a = queue.popleft()
        for i in seq[a]:
            inDegree[i] -= 1
            DP[i] = max(DP[a]+time[i],DP[i])
            if inDegree[i] == 0:
                queue.append(i)


    ans = int(input())
    print(DP[ans])
