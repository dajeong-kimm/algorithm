n = int(input())

if n==1:
    print("*")
    exit()

for _ in range(n):
    s = ''
    for i in range(n):
        if i%2 == 0:
            s += '*'
        else:
            s += ' '
    print(s)
    s = ''
    for i in range(n):
        if i%2 == 1:
            s += '*'
        else:
            s += ' '  
    print(s)  
        