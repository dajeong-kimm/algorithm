d,k = map(int,input().split())

def tiger(a,b):
    cake = [0 for _ in range(d+1)]
    cake[1] = a
    cake[2] = b
    for i in range(3,d+1):
        cake[i] = cake[i-1]+cake[i-2]
    if cake[i]==k:
        return True
    return False

for i in range(1,k+1):
    for j in range(1,k):
        if i<=j and (i+j<=k) and tiger(i,j)==True:
            print(i)
            print(j)
            exit()