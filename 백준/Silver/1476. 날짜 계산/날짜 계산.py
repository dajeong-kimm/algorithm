e, s, m = map(int,input().split())

a,b,c = 0,0,0
year = 0
while True:
    if (a,b,c) == (e,s,m):
        print(year)
        break
    a += 1
    b += 1
    c += 1
    if a>15:
        a = 1
    if b>28:
        b = 1
    if c>19:
        c = 1
    year += 1

