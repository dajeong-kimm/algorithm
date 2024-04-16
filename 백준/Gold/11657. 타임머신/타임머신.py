import sys
input = sys.stdin.readline
inf = sys.maxsize

n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]
dp = [inf]*(n+1)
dp[1] = 0
isPossible = True

def bellmanFord():
    global isPossible

    for repeat in range(n):
        for i in range(1,n+1):
            for n_n,wei in graph[i]:
                if dp[i] != inf and dp[n_n]>dp[i]+wei:
                    dp[n_n] = dp[i]+wei
                    if repeat == n-1:
                        isPossible = False

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append([b,c])

bellmanFord()
if not isPossible:
    print(-1)
else:
    for i in dp[2:]:
        print(i if i!=inf else -1)