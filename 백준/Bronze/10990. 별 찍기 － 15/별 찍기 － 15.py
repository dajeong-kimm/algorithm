n = int(input())

if n == 1:
    print('*')
    exit()

s = ""
for _ in range(n-1):
    s += " "
s += '*'
print(s)

for i in range(2,n+1):
    s = ""
    for _ in range(n-i):
        s += " "
    s += "*"
    for _ in range((i-1)*2-1):
        s += " "
    s += "*"
    print(s)
