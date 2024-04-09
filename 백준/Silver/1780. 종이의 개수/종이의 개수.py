n = int(input())
paper = [list(map(int,input().split())) for _ in range(n)]
res = []
def cut(x,y,n):
    start = paper[x][y]
    for i in range(x,x+n):
        for j in range(y,y+n):
            if paper[i][j] != start:
                cut(x,y,n//3)
                cut(x,y+n//3,n//3)
                cut(x,y+n//3*2,n//3)
                cut(x+n//3,y,n//3)
                cut(x+n//3,y+n//3,n//3)
                cut(x+n//3,y+n//3*2,n//3)
                cut(x+n//3*2,y,n//3)
                cut(x+n//3*2,y+n//3,n//3)
                cut(x+n//3*2,y+n//3*2,n//3)
                return
    if start == 1:
        res.append(1)
    elif start == -1:
        res.append(-1)
    else:
        res.append(0)
    return

cut(0,0,n)
print(res.count(-1))
print(res.count(0))
print(res.count(1))
