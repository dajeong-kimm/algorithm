from collections import deque
r,c,k = map(int,input().split())
arr = [list(input()) for _ in range(r)]
answer = []
def dfs(i,j):
    global answer
    if i==0 and j==c-1:
        answer.append(visited[i][j])
        return
    for dx,dy in ((1,0),(0,1),(-1,0),(0,-1)):
        now_x,now_y = i+dx, j+dy
        if 0<=now_x<r and 0<=now_y<c:
            if visited[now_x][now_y] == 0 and arr[now_x][now_y]==".":
                visited[now_x][now_y] = visited[i][j] + 1
                dfs(now_x,now_y)
                visited[now_x][now_y] = 0

visited = [[0 for _ in range(c)] for _ in range(r)]
visited[r-1][0] = 1
dfs(r-1,0)
print(answer.count(k))
    