def dfs(idx,cur):
    global answer
    if cur == k:
        answer += 1
        return
    if cur>k:
        return
    for i in range(idx,n):
        if visited[i] == 0:
            visited[i] = 1
            dfs(i,cur+arr[i])
            visited[i] = 0


t = int(input())

for test_case in range(1,t+1):
    n,k = map(int,input().split())
    arr = list(map(int,input().split()))
    answer = 0
    visited= [0 for _ in range(n)]
    dfs(0,0)
    print(f"#{test_case} {answer}")