n = int(input())

for i in range(1,n+1):
    star = []
    for j in range(n-i):
        star.append(' ')
    for j in range(i*2-1):
        star.append('*')
    print(''.join(star))
