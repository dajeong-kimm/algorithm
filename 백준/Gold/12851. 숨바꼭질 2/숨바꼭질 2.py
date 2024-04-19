from collections import deque

def bfs(n):
    queue = deque()
    queue.append(n)
    visited[n][0] = 0
    visited[n][1] = 1

    while queue:
        x = queue.popleft()
        for i in [x-1,x+1,x*2]:
            if 0<=i<=100000:
                # 처음 방문이라면
                if visited[i][0] == -1:
                    visited[i][0] = visited[x][0] + 1
                    visited[i][1] = visited[x][1]
                    queue.append(i)
                # 처음 방문하는 것이 아니지만 최단 시간이라면?
                elif visited[i][0] == visited[x][0]+1:
                    # 경우의 수 갱신
                    visited[i][1] += visited[x][1]

n,k = map(int,input().split())
visited = [[-1,0] for _ in range(100001)]

bfs(n)
print(visited[k][0])
print(visited[k][1])
