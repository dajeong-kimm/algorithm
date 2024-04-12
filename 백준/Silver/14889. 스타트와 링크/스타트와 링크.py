import sys
input = sys.stdin.readline

def team(a,n):
    global result
    if a == N//2:
        start,link = 0,0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:
                    start += s[i][j]
                elif not visited[i] and not visited[j]:
                    link += s[i][j]
        result = min(result,abs(start-link))
        return
    else:
        for x in range(n,N):
            if visited[x] == 0:
                visited[x] = 1
                team(a+1,x+1)
                visited[x] = 0

N = int(input())
s = [list(map(int,input().split())) for _ in range(N)]
visited = [0]*N
result = float('inf')
team(0,0)
print(result)