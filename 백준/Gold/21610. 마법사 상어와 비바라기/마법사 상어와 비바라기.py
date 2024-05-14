n,m = map(int,input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
dir = [list(map(int,input().split())) for _ in range(m)]

cloude = [(n-1,0),(n-1,1),(n-2,0),(n-2,1)]

dy = [0,-1,-1,0,1,1,1,0,-1]
dx = [0,0,-1,-1,-1,0,1,1,1]

def coord(x):
    while x<0 or x>=n:
        if x>=n:
            x -= n
        elif x<0:
            x += n
    return x

def move(a,b):
    new_cloude = []
    for x,y in cloude:
        nx,ny = x+dx[a]*b, y+dy[a]*b
        nx = coord(nx)
        ny = coord(ny)
        new_cloude.append((nx,ny))
    return new_cloude

def rain():
    for x,y in cloude:
        arr[x][y] += 1
    for x,y in cloude:
        tmp = 0
        for dx,dy in ((-1,-1),(-1,1),(1,1),(1,-1)):
            nx,ny = x+dx,y+dy
            if 0<=nx<n and 0<=ny<n:
                if arr[nx][ny] != 0:
                    tmp += 1
        arr[x][y] += tmp

def make_cloude():
    new_cloude = []
    for i in range(n):
        for j in range(n):
            if (i,j) not in cloude:
                if arr[i][j] >= 2:
                    new_cloude.append((i,j))
                    arr[i][j] -= 2
    return new_cloude

for a,b in dir:
    cloude = move(a,b)
    rain()
    cloude = make_cloude()

answer = 0
for a in arr:
    answer += sum(a)
print(answer)
