n,m,h = map(int,input().split())
arr = [[0]*n for _ in range(h)]
for i in range(m):
    a,b = map(int,input().split())
    arr[a-1][b-1] = 1

def move():
    for i in range(n):
        start_num = i
        for j in range(h):
            if arr[j][start_num] == 1:
                start_num += 1
            elif start_num>0 and arr[j][start_num-1] == 1:
                start_num -=1
        if i != start_num:
            return False
    return True

def dfs(cnt,x):
    global answer
    if answer<=cnt:
        return
    if move():
        answer = min(answer,cnt)
        return
    if cnt == 3:
        return
    for i in range(x,h):
        for j in range(0,n-1):
            if arr[i][j] == 0:
                arr[i][j] = 1
                dfs(cnt+1,i)
                arr[i][j] = 0

answer = 4
dfs(0,0)
if answer>3:
    answer = -1
print(answer)