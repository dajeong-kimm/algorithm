n = int(input())

arr = list(map(int,input().split()))

y,m = 0,0

for a in arr:
    y += (a//30+1)*10
    m += (a//60+1)*15

if y<m:
    print(f"Y {y}")
elif y>m:
    print(f"M {m}")
else:
    print(f"Y M {y}")
    