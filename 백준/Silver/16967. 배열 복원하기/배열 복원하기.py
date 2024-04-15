h,w,x,y = map(int,input().split())

arr = [list(map(int,input().split())) for _ in range(h+x)]

answer = [[0]*w for _ in range(h)]

for i in range(h):
    for j in range(w):
        answer[i][j] = arr[i][j]

for i in range(x,h):
    for j in range(y,w):
        answer[i][j] = arr[i][j] - answer[i-x][j-y]

for ans in answer:
    print(*ans)