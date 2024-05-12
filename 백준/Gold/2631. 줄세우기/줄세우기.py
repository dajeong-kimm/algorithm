n = int(input())
arr = [int(input()) for _ in range(n)]

d = [1]*(n+1)
num = [0]+arr

for i in range(1,n+1):
    for j in range(1,i):
        if num[j]<num[i]:
            d[i] = max(d[i],d[j]+1)

print(n-max(d))