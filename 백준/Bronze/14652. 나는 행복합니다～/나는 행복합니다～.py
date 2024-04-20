n,m,k = map(int,input().split())
num = 0
for i in range(n):
    for j in range(m):
        if num == k:
            print(i,j)
        num += 1