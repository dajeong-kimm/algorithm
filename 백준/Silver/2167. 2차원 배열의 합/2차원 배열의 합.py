n,m = map(int,input().split())

arr = [list(map(int,input().split())) for _ in range(n)]

t = int(input())

sum_arr = [[0]*(m+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,m+1):
        sum_arr[i][j] = sum_arr[i-1][j]+sum_arr[i][j-1]+arr[i-1][j-1]-sum_arr[i-1][j-1]

for _ in range(t):
    i,j,x,y = map(int,input().split())
    print(sum_arr[x][y]-sum_arr[x][j-1]-sum_arr[i-1][y]+sum_arr[i-1][j-1])