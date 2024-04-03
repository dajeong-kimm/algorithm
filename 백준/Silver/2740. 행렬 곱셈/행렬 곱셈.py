n,m = map(int,input().split())
a = [list(map(int,input().split())) for _ in range(n)]

m,k = map(int,input().split())
b = [list(map(int,input().split())) for _ in range(m)]

answer = [[0]*k for _ in range(n)]

for row in range(n):
    for col in range(k):
        e = 0
        for i in range(m):
            e += a[row][i] * b[i][col]
        answer[row][col] = e
for ans in answer:
    print(*ans)