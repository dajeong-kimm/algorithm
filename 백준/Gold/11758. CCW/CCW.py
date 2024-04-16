x = []
y = []

for _ in range(3):
    a,b = map(int,input().split())
    x.append(a)
    y.append(b)

result = 0

for i in range(2):
    result += x[i]*y[i+1]
result += x[2]*y[0]
for i in range(2):
    result -= x[i+1]*y[i]
result -= x[0]*y[2]

if result>0:
    print(1)
elif result<0:
    print(-1)
else:
    print(0)