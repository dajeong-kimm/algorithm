def find_squre(s):
    for i in range(n-s+1):
        for j in range(m-s+1): 
            if numbers[i][j] == numbers[i][j+s-1] == numbers[i+s-1][j] == numbers[i+s-1][j+s-1]:
                return True

    return False
n,m = map(int,input().split())

numbers = [list(map(int,list(input()))) for _ in range(n)]

size = min(n,m)

for k in range(size,0,-1):
    if find_squre(k):
        print(k**2)
        break
