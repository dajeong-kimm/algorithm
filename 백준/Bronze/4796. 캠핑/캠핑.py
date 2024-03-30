i = 0
while True:
    i += 1
    l,p,v = map(int,input().split())
    if (l,p,v) == (0,0,0):
        break
    a = (v//p)
    b = (v%p)
    if b>l:
        b = l
    answer = a*l+b
    print(f"Case {i}: {answer}")
    
    