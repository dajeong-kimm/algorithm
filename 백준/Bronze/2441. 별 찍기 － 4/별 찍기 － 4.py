n = int(input())

for i in range(n):
    str=[]
    for j in range(i):
        str.append(' ')
    for j in range(n-i):
        str.append('*')
    print(''.join(str))