from collections import deque

n = int(input())
arr = [list(map(int,input().split())) for _ in range(n)]

visited = [[0]*n for _ in range(n)]
visited[0][0] = 1

flag = 0 # 0: 가로, 1: 세로, 2: 대각선
cnt = 0
def dfs(i,j,flag):
    global cnt 
    visited[i][j] = 1
    if i==n-1 and j==n-1:
        cnt += 1
        return
    if flag == 0:
        if 0<=j+1<n and visited[i][j+1] == 0 and arr[i][j+1] == 0:
            visited[i][j+1] = 1
            dfs(i,j+1,0)
            visited[i][j+1] = 0
        if 0<=i+1<n and 0<=j+1<n:
            if arr[i+1][j] == 0 and arr[i][j+1] == 0 and arr[i+1][j+1] == 0:
                if visited[i+1][j+1] == 0:
                    visited[i+1][j+1] = 1
                    dfs(i+1,j+1,2)
                    visited[i+1][j+1] = 0
    elif flag == 1:
        if 0<=i+1<n and visited[i+1][j] == 0 and arr[i+1][j] == 0:
            visited[i+1][j] = 1
            dfs(i+1,j,1)
            visited[i+1][j] = 0
        if 0<=i+1<n and 0<=j+1<n:
            if arr[i+1][j] == 0 and arr[i][j+1] == 0 and arr[i+1][j+1] == 0:
                if visited[i+1][j+1] == 0:
                    visited[i+1][j+1] = 1
                    dfs(i+1,j+1,2)
                    visited[i+1][j+1] = 0
    elif flag == 2:
        if 0<=j+1<n and visited[i][j+1] == 0 and arr[i][j+1] == 0:
            visited[i][j+1] = 1
            dfs(i,j+1,0)
            visited[i][j+1] = 0
        if 0<=i+1<n and visited[i+1][j] == 0 and arr[i+1][j] == 0:
            visited[i+1][j] = 1
            dfs(i+1,j,1)
            visited[i+1][j] = 0
        if 0<=i+1<n and 0<=j+1<n:
            if arr[i+1][j] == 0 and arr[i][j+1] == 0 and arr[i+1][j+1] == 0:
                if visited[i+1][j+1] == 0:
                    visited[i+1][j+1] = 1
                    dfs(i+1,j+1,2)
                    visited[i+1][j+1] = 0
    

dfs(0,1,0)
print(min(1000000,cnt))
        