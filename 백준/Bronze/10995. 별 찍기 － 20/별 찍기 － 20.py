n = int(input())

for i in range(n):
    star = ['*' for _ in range(n)]
    if i%2==0:
        print(' '.join(star))
    else:
        print(' '+' '.join(star))
    