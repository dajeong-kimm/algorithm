for _ in range(4):
    # arr = set()
    a,b,c,d,A,B,C,D = map(int,input().split())
    if c<A or C<a or b>D or B>d:
        print('d')
        continue
    elif a==C or A==c:
        if d==B or D==b:
            print('c')
            continue
        else:
            print('b')
            continue
    elif d==B or D==b:
        print('b')
        continue
    else:
        print('a')
        continue



