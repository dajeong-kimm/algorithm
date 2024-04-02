import sys
input = sys.stdin.readline

t = int(input())
arr = []
for _ in range(t):
    a,b,c,d = map(str,input().split())
    b,c,d = int(b),int(c),int(d)
    arr.append((a,b,c,d))

arr = sorted(arr,key = lambda x:(-x[1],x[2],-x[3],x[0]))

for a in arr:
    print(a[0])