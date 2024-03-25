n = int(input())

for i in range(n,0,-1):
    star = []
    for _ in range(n-i):
        star.append(' ')
    for _ in range(i*2-1):
        star.append('*')
    print(''.join(star))
    