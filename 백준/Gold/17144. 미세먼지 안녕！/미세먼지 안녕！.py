import copy
n,m,t = map(int,input().split())

air = []
arr = []
for i in range(n):
    tmp = list(map(int,input().split()))
    for j in range(m):
        if tmp[j] == -1:
            air.append(i)
    arr.append(tmp)

def spread():
    new_arr = copy.deepcopy(arr)
    for i in range(n):
        for j in range(m):
            if arr[i][j]>0:
                tmp = arr[i][j]//5
                count = 0
                for dx,dy in ((1,0),(-1,0),(0,1),(0,-1)):
                    nx,ny = i+dx,j+dy
                    if 0<=nx<n and 0<=ny<m and new_arr[nx][ny]!=-1:
                        count += 1
                        new_arr[nx][ny] += tmp
                new_arr[i][j] -= tmp*count
    return new_arr

def wind(a,b):
    new_arr = copy.deepcopy(arr)
    new_arr[a][1] = 0
    for i in range(2,m):
        new_arr[a][i] = arr[a][i-1]
    new_arr[a-1][-1] = arr[a][-1]
    for i in range(a-2,-1,-1):
        new_arr[i][-1] = arr[i+1][-1]
    new_arr[0][-2] = arr[0][-1]
    for i in range(m-3,-1,-1):
        new_arr[0][i] = arr[0][i+1]
    new_arr[1][0] = arr[0][0]
    for i in range(2,a):
        new_arr[i][0] = arr[i-1][0]
    
    new_arr[b][1] = 0
    for i in range(2,m):
        new_arr[b][i] = arr[b][i-1]
    new_arr[b+1][-1] = arr[b][-1]
    for i in range(b+2,n):
        new_arr[i][-1] = arr[i-1][-1]
    new_arr[n-1][-2] = arr[n-1][-1]
    for i in range(m-3,-1,-1):
        new_arr[n-1][i] = arr[n-1][i+1]
    new_arr[n-2][0] = arr[n-1][0]
    for i in range(n-3,b,-1):
        new_arr[i][0] = arr[i+1][0]
    return new_arr

A,B = air
time = 0
while time<t:
    arr = spread()
    arr = wind(A,B)
    time += 1

answer = 0
for i in range(n):
    for j in range(m):
        if arr[i][j]>0:
            answer += arr[i][j]
print(answer)
