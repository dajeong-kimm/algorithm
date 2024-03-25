n = int(input())

for i in range(1,n+1):
    star = []
    for _ in range(n-i):
        star.append(' ')
    for _ in range(i):
        star.append('*')
    print(''.join(star))
for i in range(n-1,0,-1):
    star = []
    for _ in range(n-i):
        star.append(' ')
    for _ in range(i):
        star.append('*')
    print(''.join(star))
    