import math
n,k = map(int,input().split())

arr = [[0]*2 for _ in range(7)]
answer = 0
for _ in range(n):
    s,y = map(int,input().split())
    arr[y][s] += 1
for i in range(7):
    for j in range(2):
        answer += math.ceil(arr[i][j]/k)

print(answer)