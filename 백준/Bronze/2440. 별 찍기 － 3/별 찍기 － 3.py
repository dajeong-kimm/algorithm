n = int(input())


for i in range(n,0,-1):
    str = []
    for j in range(i):
        str.append("*")
    print(''.join(str))